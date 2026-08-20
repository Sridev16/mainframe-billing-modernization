
package com.example.billing.billing.service.impl;

import com.example.billing.billing.business.context.BillingContext;
import com.example.billing.billing.service.BillingProcess;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.datasimplifier.utils.NumberUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.io.OpenMode;
import com.netfective.bluage.gapwalk.rt.io.SequentialFile;
import com.netfective.bluage.gapwalk.runtime.statements.StringConcatenationBuilder;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class BillingProcessImpl
 * 
 * Defines application services for BillingProcess
 * @see BillingProcess
 */
@Service("com.example.billing.billing.service.BillingProcess")
@Lazy

public class BillingProcessImpl implements BillingProcess {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BillingProcessImpl.class);


	/**
	 * Process operation mainProcess.
	 * 
	 * PROGRAM-ID.BILLING.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainProcess(final BillingContext ctx, final ExecutionController ctrl) {
		SequentialFile customerFile = ctx.getCustomerFileHandler(ctrl.getExecutionContext()); 
		SequentialFile invoiceFile = ctx.getInvoiceFileHandler(ctrl.getExecutionContext()); 
		SequentialFile usageFile = ctx.getUsageFileHandler(ctrl.getExecutionContext()); 
		customerFile.open(OpenMode.INPUT);
		usageFile.open(OpenMode.INPUT);
		invoiceFile.open(OpenMode.OUTPUT);
		readNextUsage(ctx, ctrl);
		while (!(ctx.getWsEndUsage().isEndOfUsage())) {
			ctx.getWsFoundCustomer().setWsFoundCustomer("N");
			findCustomer(ctx, ctrl);
			if (ctx.getWsFoundCustomer().isCustomerFound()) {
				if (DataUtils.compare(ctx.getCustomerFile().getCustStatusReference(), "ACTIVE") == 0) {
					calculateBill(ctx, ctrl);
					generateInvoice(ctx, ctrl);
				} else {
					DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "ERROR: CUSTOMER IS NOT ACTIVE - " , ctx.getWsCurrentCustomerId().getWsCurrentCustomerId());
				}
			} else {
				DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "ERROR: CUSTOMER NOT FOUND - " , ctx.getWsCurrentCustomerId().getWsCurrentCustomerId());
			}
			readNextUsage(ctx, ctrl);
		}
		customerFile.close();
		usageFile.close();
		invoiceFile.close();
		DisplayUtils.display(ctx, ctrl, LOGGER, "----------------------------------------");
		DisplayUtils.display(ctx, ctrl, LOGGER, "BILL01 BILLING PROCESS COMPLETE");
		DisplayUtils.display(ctx, ctrl, LOGGER, "----------------------------------------");
		ctrl.stopRunUnit();
	}

	/**
	 * Process operation readNextUsage.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void readNextUsage(final BillingContext ctx, final ExecutionController ctrl) {
		boolean eof = false; 
		SequentialFile usageFile = ctx.getUsageFileHandler(ctrl.getExecutionContext()); 
		usageFile.read();
		eof = usageFile.isAtEnd();
		if (eof) {
			ctx.getWsEndUsage().setEndOfUsage(true);
		} else {
			ctx.getWsCurrentCustomerId().getWsCurrentCustomerIdReference().setValue(ctx.getUsageFile().getUsageCustIdReference());
			ctx.getWsUsageUnits().setWsUsageUnits(ctx.getUsageFile().getUsageUnits());
			ctx.getWsBillingMonth().getWsBillingMonthReference().setValue(ctx.getUsageFile().getUsageMonthReference());
		}
	}

	/**
	 * Process operation findCustomer.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void findCustomer(final BillingContext ctx, final ExecutionController ctrl) {
		SequentialFile customerFile = ctx.getCustomerFileHandler(ctrl.getExecutionContext()); 
		boolean eof = false; 
		ctx.getWsEndCustomer().setWsEndCustomer("N");
		customerFile.close();
		customerFile.open(OpenMode.INPUT);
		while (!(ctx.getWsFoundCustomer().isCustomerFound() || ctx.getWsEndCustomer().isEndOfCustomer())) {
			customerFile.read();
			eof = customerFile.isAtEnd();
			if (eof) {
				ctx.getWsEndCustomer().setEndOfCustomer(true);
			} else {
				if (DataUtils.compare(ctx.getCustomerFile().getCustIdReference(), ctx.getWsCurrentCustomerId().getWsCurrentCustomerIdReference()) == 0) {
					ctx.getWsFoundCustomer().setCustomerFound(true);
				} 
			}
		}
	}

	/**
	 * Process operation calculateBill.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void calculateBill(final BillingContext ctx, final ExecutionController ctrl) {
		DataUtils.setToZeroes(ctx.getWsRate().getWsRateReference());
		DataUtils.setToZeroes(ctx.getWsUsageCharge().getWsUsageChargeReference());
		DataUtils.setToZeroes(ctx.getWsDiscount().getWsDiscountReference());
		DataUtils.setToZeroes(ctx.getWsTaxableAmount().getWsTaxableAmountReference());
		DataUtils.setToZeroes(ctx.getWsTax().getWsTaxReference());
		DataUtils.setToZeroes(ctx.getWsFinalAmount().getWsFinalAmountReference());
		if (NumberUtils.le(ctx.getWsUsageUnits().getWsUsageUnitsReference(), 500)) {
			ctx.getWsRate().setWsRate(BigDecimal.valueOf(0.50));
		} else if (NumberUtils.le(ctx.getWsUsageUnits().getWsUsageUnitsReference(), 1000)) {
			ctx.getWsRate().setWsRate(BigDecimal.valueOf(0.45));
		} else {
			ctx.getWsRate().setWsRate(BigDecimal.valueOf(0.40));
		}
		ctx.getWsUsageCharge().setWsUsageCharge(new BigDecimal(ctx.getWsUsageUnits().getWsUsageUnits()).multiply(ctx.getWsRate().getWsRate()));
		if (NumberUtils.gt(ctx.getWsUsageUnits().getWsUsageUnitsReference(), ctx.getWsVolumeThreshold().getWsVolumeThresholdReference())) {
			ctx.getWsDiscount().setWsDiscount(ctx.getWsUsageCharge().getWsUsageCharge().multiply(ctx.getWsVolumeDiscountRate().getWsVolumeDiscountRate()));
		} 
		if (DataUtils.compare(ctx.getCustomerFile().getCustTypeReference(), "PREMIUM") == 0) {
			ctx.getWsDiscount().setWsDiscount(ctx.getWsDiscount().getWsDiscount().add(ctx.getWsUsageCharge().getWsUsageCharge().multiply(ctx.getWsPremiumDiscountRate().getWsPremiumDiscountRate())));
		} 
		if (NumberUtils.lt(ctx.getWsUsageCharge().getWsUsageCharge().subtract(ctx.getWsDiscount().getWsDiscount()), ctx.getWsMinimumCharge().getWsMinimumChargeReference())) {
			ctx.getWsTaxableAmount().setWsTaxableAmount(ctx.getWsMinimumCharge().getWsMinimumCharge());
		} else {
			ctx.getWsTaxableAmount().setWsTaxableAmount(ctx.getWsUsageCharge().getWsUsageCharge().subtract(ctx.getWsDiscount().getWsDiscount()));
		}
		ctx.getWsTax().setWsTax(ctx.getWsTaxableAmount().getWsTaxableAmount().multiply(ctx.getCustomerFile().getCustTaxRate()));
		ctx.getWsFinalAmount().setWsFinalAmount(ctx.getWsTaxableAmount().getWsTaxableAmount().add(ctx.getWsTax().getWsTax()).add(ctx.getCustomerFile().getCustPrevBalance()));
	}

	/**
	 * Process operation generateInvoice.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void generateInvoice(final BillingContext ctx, final ExecutionController ctrl) {
		SequentialFile invoiceFile = ctx.getInvoiceFileHandler(ctrl.getExecutionContext()); 
		DataUtils.setToBlank(ctx.getWsInvoiceNumber().getWsInvoiceNumberReference());
		DataUtils.setToBlank(ctx.getWsOutputLine().getWsOutputLineReference());
		StringConcatenationBuilder.newInstance(ctx.getWsInvoiceNumber().getWsInvoiceNumberReference())
			.addDelimitedBySize(ctx.getWsBillingMonth().getWsBillingMonthReference().getBytes())
			.addDelimitedBySize("-")
			.addDelimitedBySize(ctx.getCustomerFile().getCustIdReference().getBytes())
			.end();
		ctx.getWsDisplayCharge().getWsDisplayChargeReference().setValue(ctx.getWsUsageCharge().getWsUsageCharge());
		ctx.getWsDisplayDiscount().getWsDisplayDiscountReference().setValue(ctx.getWsDiscount().getWsDiscount());
		ctx.getWsDisplayTax().getWsDisplayTaxReference().setValue(ctx.getWsTax().getWsTax());
		ctx.getWsDisplayBalance().getWsDisplayBalanceReference().setValue(ctx.getCustomerFile().getCustPrevBalance());
		ctx.getWsDisplayTotal().getWsDisplayTotalReference().setValue(ctx.getWsFinalAmount().getWsFinalAmount());
		StringConcatenationBuilder.newInstance(ctx.getWsOutputLine().getWsOutputLineReference())
			.addDelimitedBySize(ctx.getWsInvoiceNumber().getWsInvoiceNumberReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getCustomerFile().getCustIdReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getCustomerFile().getCustNameReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getWsUsageUnits().getWsUsageUnitsReference().getValue(String.class))
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getWsDisplayCharge().getWsDisplayChargeReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getWsDisplayDiscount().getWsDisplayDiscountReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getWsDisplayTax().getWsDisplayTaxReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getWsDisplayBalance().getWsDisplayBalanceReference().getBytes())
			.addDelimitedBySize("|")
			.addDelimitedBySize(ctx.getWsDisplayTotal().getWsDisplayTotalReference().getBytes())
			.end();
		ctx.getInvoiceFile().getInvoiceRecordReference().setValue(ctx.getWsOutputLine().getWsOutputLineReference());
		invoiceFile.write(ctx.getInvoiceFile().getInvoiceRecordReference());
		DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "INVOICE GENERATED: " , ctx.getWsInvoiceNumber().getWsInvoiceNumber());
	}

}
