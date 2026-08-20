package com.example.billing.billing.business.context;
import com.example.billing.billing.business.model.CustomerFile;
import com.example.billing.billing.business.model.InvoiceFile;
import com.example.billing.billing.business.model.UsageFile;
import com.example.billing.billing.business.model.WsBillingMonth;
import com.example.billing.billing.business.model.WsCurrentCustomerId;
import com.example.billing.billing.business.model.WsDiscount;
import com.example.billing.billing.business.model.WsDisplayBalance;
import com.example.billing.billing.business.model.WsDisplayCharge;
import com.example.billing.billing.business.model.WsDisplayDiscount;
import com.example.billing.billing.business.model.WsDisplayTax;
import com.example.billing.billing.business.model.WsDisplayTotal;
import com.example.billing.billing.business.model.WsEndCustomer;
import com.example.billing.billing.business.model.WsEndUsage;
import com.example.billing.billing.business.model.WsFinalAmount;
import com.example.billing.billing.business.model.WsFoundCustomer;
import com.example.billing.billing.business.model.WsInvoiceNumber;
import com.example.billing.billing.business.model.WsMinimumCharge;
import com.example.billing.billing.business.model.WsOutputLine;
import com.example.billing.billing.business.model.WsPremiumDiscountRate;
import com.example.billing.billing.business.model.WsRate;
import com.example.billing.billing.business.model.WsTax;
import com.example.billing.billing.business.model.WsTaxableAmount;
import com.example.billing.billing.business.model.WsUsageCharge;
import com.example.billing.billing.business.model.WsUsageUnits;
import com.example.billing.billing.business.model.WsVolumeDiscountRate;
import com.example.billing.billing.business.model.WsVolumeThreshold;
import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.io.metadata.builder.SequentialFileDescriptionBuilder;
import com.netfective.bluage.gapwalk.rt.io.SequentialFile;
import com.netfective.bluage.gapwalk.rt.jics.context.JicsRuntimeContext;
import com.netfective.bluage.gapwalk.rt.shared.ExecutionContext;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier context BillingContext.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'customerFile' file, <br>uml entity: com.example.billing.billing.business.model.CustomerFile
 * <br></p>
 * 
 * <p>About 'usageFile' file, <br>uml entity: com.example.billing.billing.business.model.UsageFile
 * <br></p>
 * 
 * <p>About 'invoiceFile' file, <br>uml entity: com.example.billing.billing.business.model.InvoiceFile
 * <br></p>
 * 
 * <p>About 'wsCurrentCustomerId' field, <br>uml entity: com.example.billing.billing.business.model.WsCurrentCustomerId
 * <br></p>
 * 
 * <p>About 'wsBillingMonth' field, <br>uml entity: com.example.billing.billing.business.model.WsBillingMonth
 * <br></p>
 * 
 * <p>About 'wsUsageUnits' field, <br>uml entity: com.example.billing.billing.business.model.WsUsageUnits
 * <br></p>
 * 
 * <p>About 'wsRate' field, <br>uml entity: com.example.billing.billing.business.model.WsRate
 * <br></p>
 * 
 * <p>About 'wsUsageCharge' field, <br>uml entity: com.example.billing.billing.business.model.WsUsageCharge
 * <br></p>
 * 
 * <p>About 'wsDiscount' field, <br>uml entity: com.example.billing.billing.business.model.WsDiscount
 * <br></p>
 * 
 * <p>About 'wsTaxableAmount' field, <br>uml entity: com.example.billing.billing.business.model.WsTaxableAmount
 * <br></p>
 * 
 * <p>About 'wsTax' field, <br>uml entity: com.example.billing.billing.business.model.WsTax
 * <br></p>
 * 
 * <p>About 'wsFinalAmount' field, <br>uml entity: com.example.billing.billing.business.model.WsFinalAmount
 * <br></p>
 * 
 * <p>About 'wsMinimumCharge' field, <br>uml entity: com.example.billing.billing.business.model.WsMinimumCharge
 * <br></p>
 * 
 * <p>About 'wsVolumeDiscountRate' field, <br>uml entity: com.example.billing.billing.business.model.WsVolumeDiscountRate
 * <br></p>
 * 
 * <p>About 'wsPremiumDiscountRate' field, <br>uml entity: com.example.billing.billing.business.model.WsPremiumDiscountRate
 * <br></p>
 * 
 * <p>About 'wsVolumeThreshold' field, <br>uml entity: com.example.billing.billing.business.model.WsVolumeThreshold
 * <br></p>
 * 
 * <p>About 'wsEndUsage' field, <br>uml entity: com.example.billing.billing.business.model.WsEndUsage
 * <br></p>
 * 
 * <p>About 'wsEndCustomer' field, <br>uml entity: com.example.billing.billing.business.model.WsEndCustomer
 * <br></p>
 * 
 * <p>About 'wsFoundCustomer' field, <br>uml entity: com.example.billing.billing.business.model.WsFoundCustomer
 * <br></p>
 * 
 * <p>About 'wsInvoiceNumber' field, <br>uml entity: com.example.billing.billing.business.model.WsInvoiceNumber
 * <br></p>
 * 
 * <p>About 'wsOutputLine' field, <br>uml entity: com.example.billing.billing.business.model.WsOutputLine
 * <br></p>
 * 
 * <p>About 'wsDisplayCharge' field, <br>uml entity: com.example.billing.billing.business.model.WsDisplayCharge
 * <br></p>
 * 
 * <p>About 'wsDisplayDiscount' field, <br>uml entity: com.example.billing.billing.business.model.WsDisplayDiscount
 * <br></p>
 * 
 * <p>About 'wsDisplayTax' field, <br>uml entity: com.example.billing.billing.business.model.WsDisplayTax
 * <br></p>
 * 
 * <p>About 'wsDisplayBalance' field, <br>uml entity: com.example.billing.billing.business.model.WsDisplayBalance
 * <br></p>
 * 
 * <p>About 'wsDisplayTotal' field, <br>uml entity: com.example.billing.billing.business.model.WsDisplayTotal
 * <br></p>
 * 
 */
@Component("com.example.billing.billing.business.context.BillingContext")
@Import({
	com.example.billing.billing.business.model.CustomerFile.class
,	com.example.billing.billing.business.model.UsageFile.class
,	com.example.billing.billing.business.model.InvoiceFile.class
})
@Lazy
@Scope("prototype")
public class BillingContext extends JicsRuntimeContext {

	@Autowired
	private CustomerFile customerFile;

	@Autowired
	private UsageFile usageFile;

	@Autowired
	private InvoiceFile invoiceFile;

	private SequentialFile customerFileFile;	

	private SequentialFile usageFileFile;	

	private SequentialFile invoiceFileFile;	
	
	private WsCurrentCustomerId wsCurrentCustomerId;
	private WsBillingMonth wsBillingMonth;
	private WsUsageUnits wsUsageUnits;
	private WsRate wsRate;
	private WsUsageCharge wsUsageCharge;
	private WsDiscount wsDiscount;
	private WsTaxableAmount wsTaxableAmount;
	private WsTax wsTax;
	private WsFinalAmount wsFinalAmount;
	private WsMinimumCharge wsMinimumCharge;
	private WsVolumeDiscountRate wsVolumeDiscountRate;
	private WsPremiumDiscountRate wsPremiumDiscountRate;
	private WsVolumeThreshold wsVolumeThreshold;
	private WsEndUsage wsEndUsage;
	private WsEndCustomer wsEndCustomer;
	private WsFoundCustomer wsFoundCustomer;
	private WsInvoiceNumber wsInvoiceNumber;
	private WsOutputLine wsOutputLine;
	private WsDisplayCharge wsDisplayCharge;
	private WsDisplayDiscount wsDisplayDiscount;
	private WsDisplayTax wsDisplayTax;
	private WsDisplayBalance wsDisplayBalance;
	private WsDisplayTotal wsDisplayTotal;

	private List<RecordEntity> recordEntities;

	/**
	 * Default constructor.
	 * @param configuration the datasimplifier configuration
	 */
	public BillingContext (@Qualifier("BillingContextConfiguration") Configuration configuration) {
		super(configuration);
		initWorking(configuration);
		
		initRecordEntities();
	}
	
	

	/**
	 * Getter for the file customerFile.
	 * @return the customerFile
	 */
	public CustomerFile getCustomerFile() {
		return this.customerFile;
	}
	
	/**
	 * Getter for the file handler customerFileFile.
	 * @param executionContext the execution context
	 * @return the customerFileFile
	 */
	public SequentialFile getCustomerFileHandler(ExecutionContext executionContext) {
		
		if(this.customerFileFile == null){
			this.customerFileFile = executionContext.getFileProvider().getFile(
				"CUSTOMER.dat",
				new SequentialFileDescriptionBuilder()
					.lineSequential()
					.build(),
				getConfiguration(), customerFile);
		}
		return this.customerFileFile;	
	}

	/**
	 * Getter for the file usageFile.
	 * @return the usageFile
	 */
	public UsageFile getUsageFile() {
		return this.usageFile;
	}
	
	/**
	 * Getter for the file handler usageFileFile.
	 * @param executionContext the execution context
	 * @return the usageFileFile
	 */
	public SequentialFile getUsageFileHandler(ExecutionContext executionContext) {
		
		if(this.usageFileFile == null){
			this.usageFileFile = executionContext.getFileProvider().getFile(
				"USAGE.dat",
				new SequentialFileDescriptionBuilder()
					.lineSequential()
					.build(),
				getConfiguration(), usageFile);
		}
		return this.usageFileFile;	
	}

	/**
	 * Getter for the file invoiceFile.
	 * @return the invoiceFile
	 */
	public InvoiceFile getInvoiceFile() {
		return this.invoiceFile;
	}
	
	/**
	 * Getter for the file handler invoiceFileFile.
	 * @param executionContext the execution context
	 * @return the invoiceFileFile
	 */
	public SequentialFile getInvoiceFileHandler(ExecutionContext executionContext) {
		
		if(this.invoiceFileFile == null){
			this.invoiceFileFile = executionContext.getFileProvider().getFile(
				"INVOICE.dat",
				new SequentialFileDescriptionBuilder()
					.lineSequential()
					.build(),
				getConfiguration(), invoiceFile);
		}
		return this.invoiceFileFile;	
	}

	/**
	 * Getter for wsCurrentCustomerId.
	 * @return the wsCurrentCustomerId
	 */
	public WsCurrentCustomerId getWsCurrentCustomerId() {
		return this.wsCurrentCustomerId;
	}

	/**
	 * Setter for wsCurrentCustomerId.
	 * @param reference the new value for wsCurrentCustomerId
	 */
	public void setWsCurrentCustomerId(RangeReference reference) {
		this.wsCurrentCustomerId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsBillingMonth.
	 * @return the wsBillingMonth
	 */
	public WsBillingMonth getWsBillingMonth() {
		return this.wsBillingMonth;
	}

	/**
	 * Setter for wsBillingMonth.
	 * @param reference the new value for wsBillingMonth
	 */
	public void setWsBillingMonth(RangeReference reference) {
		this.wsBillingMonth.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsUsageUnits.
	 * @return the wsUsageUnits
	 */
	public WsUsageUnits getWsUsageUnits() {
		return this.wsUsageUnits;
	}

	/**
	 * Setter for wsUsageUnits.
	 * @param reference the new value for wsUsageUnits
	 */
	public void setWsUsageUnits(RangeReference reference) {
		this.wsUsageUnits.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsRate.
	 * @return the wsRate
	 */
	public WsRate getWsRate() {
		return this.wsRate;
	}

	/**
	 * Setter for wsRate.
	 * @param reference the new value for wsRate
	 */
	public void setWsRate(RangeReference reference) {
		this.wsRate.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsUsageCharge.
	 * @return the wsUsageCharge
	 */
	public WsUsageCharge getWsUsageCharge() {
		return this.wsUsageCharge;
	}

	/**
	 * Setter for wsUsageCharge.
	 * @param reference the new value for wsUsageCharge
	 */
	public void setWsUsageCharge(RangeReference reference) {
		this.wsUsageCharge.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDiscount.
	 * @return the wsDiscount
	 */
	public WsDiscount getWsDiscount() {
		return this.wsDiscount;
	}

	/**
	 * Setter for wsDiscount.
	 * @param reference the new value for wsDiscount
	 */
	public void setWsDiscount(RangeReference reference) {
		this.wsDiscount.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsTaxableAmount.
	 * @return the wsTaxableAmount
	 */
	public WsTaxableAmount getWsTaxableAmount() {
		return this.wsTaxableAmount;
	}

	/**
	 * Setter for wsTaxableAmount.
	 * @param reference the new value for wsTaxableAmount
	 */
	public void setWsTaxableAmount(RangeReference reference) {
		this.wsTaxableAmount.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsTax.
	 * @return the wsTax
	 */
	public WsTax getWsTax() {
		return this.wsTax;
	}

	/**
	 * Setter for wsTax.
	 * @param reference the new value for wsTax
	 */
	public void setWsTax(RangeReference reference) {
		this.wsTax.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsFinalAmount.
	 * @return the wsFinalAmount
	 */
	public WsFinalAmount getWsFinalAmount() {
		return this.wsFinalAmount;
	}

	/**
	 * Setter for wsFinalAmount.
	 * @param reference the new value for wsFinalAmount
	 */
	public void setWsFinalAmount(RangeReference reference) {
		this.wsFinalAmount.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsMinimumCharge.
	 * @return the wsMinimumCharge
	 */
	public WsMinimumCharge getWsMinimumCharge() {
		return this.wsMinimumCharge;
	}

	/**
	 * Setter for wsMinimumCharge.
	 * @param reference the new value for wsMinimumCharge
	 */
	public void setWsMinimumCharge(RangeReference reference) {
		this.wsMinimumCharge.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsVolumeDiscountRate.
	 * @return the wsVolumeDiscountRate
	 */
	public WsVolumeDiscountRate getWsVolumeDiscountRate() {
		return this.wsVolumeDiscountRate;
	}

	/**
	 * Setter for wsVolumeDiscountRate.
	 * @param reference the new value for wsVolumeDiscountRate
	 */
	public void setWsVolumeDiscountRate(RangeReference reference) {
		this.wsVolumeDiscountRate.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsPremiumDiscountRate.
	 * @return the wsPremiumDiscountRate
	 */
	public WsPremiumDiscountRate getWsPremiumDiscountRate() {
		return this.wsPremiumDiscountRate;
	}

	/**
	 * Setter for wsPremiumDiscountRate.
	 * @param reference the new value for wsPremiumDiscountRate
	 */
	public void setWsPremiumDiscountRate(RangeReference reference) {
		this.wsPremiumDiscountRate.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsVolumeThreshold.
	 * @return the wsVolumeThreshold
	 */
	public WsVolumeThreshold getWsVolumeThreshold() {
		return this.wsVolumeThreshold;
	}

	/**
	 * Setter for wsVolumeThreshold.
	 * @param reference the new value for wsVolumeThreshold
	 */
	public void setWsVolumeThreshold(RangeReference reference) {
		this.wsVolumeThreshold.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsEndUsage.
	 * @return the wsEndUsage
	 */
	public WsEndUsage getWsEndUsage() {
		return this.wsEndUsage;
	}

	/**
	 * Setter for wsEndUsage.
	 * @param reference the new value for wsEndUsage
	 */
	public void setWsEndUsage(RangeReference reference) {
		this.wsEndUsage.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsEndCustomer.
	 * @return the wsEndCustomer
	 */
	public WsEndCustomer getWsEndCustomer() {
		return this.wsEndCustomer;
	}

	/**
	 * Setter for wsEndCustomer.
	 * @param reference the new value for wsEndCustomer
	 */
	public void setWsEndCustomer(RangeReference reference) {
		this.wsEndCustomer.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsFoundCustomer.
	 * @return the wsFoundCustomer
	 */
	public WsFoundCustomer getWsFoundCustomer() {
		return this.wsFoundCustomer;
	}

	/**
	 * Setter for wsFoundCustomer.
	 * @param reference the new value for wsFoundCustomer
	 */
	public void setWsFoundCustomer(RangeReference reference) {
		this.wsFoundCustomer.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsInvoiceNumber.
	 * @return the wsInvoiceNumber
	 */
	public WsInvoiceNumber getWsInvoiceNumber() {
		return this.wsInvoiceNumber;
	}

	/**
	 * Setter for wsInvoiceNumber.
	 * @param reference the new value for wsInvoiceNumber
	 */
	public void setWsInvoiceNumber(RangeReference reference) {
		this.wsInvoiceNumber.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsOutputLine.
	 * @return the wsOutputLine
	 */
	public WsOutputLine getWsOutputLine() {
		return this.wsOutputLine;
	}

	/**
	 * Setter for wsOutputLine.
	 * @param reference the new value for wsOutputLine
	 */
	public void setWsOutputLine(RangeReference reference) {
		this.wsOutputLine.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDisplayCharge.
	 * @return the wsDisplayCharge
	 */
	public WsDisplayCharge getWsDisplayCharge() {
		return this.wsDisplayCharge;
	}

	/**
	 * Setter for wsDisplayCharge.
	 * @param reference the new value for wsDisplayCharge
	 */
	public void setWsDisplayCharge(RangeReference reference) {
		this.wsDisplayCharge.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDisplayDiscount.
	 * @return the wsDisplayDiscount
	 */
	public WsDisplayDiscount getWsDisplayDiscount() {
		return this.wsDisplayDiscount;
	}

	/**
	 * Setter for wsDisplayDiscount.
	 * @param reference the new value for wsDisplayDiscount
	 */
	public void setWsDisplayDiscount(RangeReference reference) {
		this.wsDisplayDiscount.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDisplayTax.
	 * @return the wsDisplayTax
	 */
	public WsDisplayTax getWsDisplayTax() {
		return this.wsDisplayTax;
	}

	/**
	 * Setter for wsDisplayTax.
	 * @param reference the new value for wsDisplayTax
	 */
	public void setWsDisplayTax(RangeReference reference) {
		this.wsDisplayTax.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDisplayBalance.
	 * @return the wsDisplayBalance
	 */
	public WsDisplayBalance getWsDisplayBalance() {
		return this.wsDisplayBalance;
	}

	/**
	 * Setter for wsDisplayBalance.
	 * @param reference the new value for wsDisplayBalance
	 */
	public void setWsDisplayBalance(RangeReference reference) {
		this.wsDisplayBalance.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDisplayTotal.
	 * @return the wsDisplayTotal
	 */
	public WsDisplayTotal getWsDisplayTotal() {
		return this.wsDisplayTotal;
	}

	/**
	 * Setter for wsDisplayTotal.
	 * @param reference the new value for wsDisplayTotal
	 */
	public void setWsDisplayTotal(RangeReference reference) {
		this.wsDisplayTotal.setBytes(reference.getBytes());
	}

	@Override 
	public void cleanUp(){
		if(this.customerFileFile !=null && this.customerFileFile.isOpen() && !this.customerFileFile.isShared()) {
			this.customerFileFile.close();
		}
		if(this.customerFileFile !=null && !this.customerFileFile.isShared()){
			this.customerFileFile = null;
		}
		if(this.usageFileFile !=null && this.usageFileFile.isOpen() && !this.usageFileFile.isShared()) {
			this.usageFileFile.close();
		}
		if(this.usageFileFile !=null && !this.usageFileFile.isShared()){
			this.usageFileFile = null;
		}
		if(this.invoiceFileFile !=null && this.invoiceFileFile.isOpen() && !this.invoiceFileFile.isShared()) {
			this.invoiceFileFile.close();
		}
		if(this.invoiceFileFile !=null && !this.invoiceFileFile.isShared()){
			this.invoiceFileFile = null;
		}
	}

	@Override
	protected void doReset() {
		cleanUp();
		this.customerFile.reset();
		this.usageFile.reset();
		this.invoiceFile.reset();
	    // reset the working
		recordEntities.stream().forEach(e -> e.reset());
	}

	
	private void initWorking(Configuration configuration) {
		wsCurrentCustomerId = new WsCurrentCustomerId(configuration);
		wsBillingMonth = new WsBillingMonth(configuration);
		wsUsageUnits = new WsUsageUnits(configuration);
		wsRate = new WsRate(configuration);
		wsUsageCharge = new WsUsageCharge(configuration);
		wsDiscount = new WsDiscount(configuration);
		wsTaxableAmount = new WsTaxableAmount(configuration);
		wsTax = new WsTax(configuration);
		wsFinalAmount = new WsFinalAmount(configuration);
		wsMinimumCharge = new WsMinimumCharge(configuration);
		wsVolumeDiscountRate = new WsVolumeDiscountRate(configuration);
		wsPremiumDiscountRate = new WsPremiumDiscountRate(configuration);
		wsVolumeThreshold = new WsVolumeThreshold(configuration);
		wsEndUsage = new WsEndUsage(configuration);
		wsEndCustomer = new WsEndCustomer(configuration);
		wsFoundCustomer = new WsFoundCustomer(configuration);
		wsInvoiceNumber = new WsInvoiceNumber(configuration);
		wsOutputLine = new WsOutputLine(configuration);
		wsDisplayCharge = new WsDisplayCharge(configuration);
		wsDisplayDiscount = new WsDisplayDiscount(configuration);
		wsDisplayTax = new WsDisplayTax(configuration);
		wsDisplayBalance = new WsDisplayBalance(configuration);
		wsDisplayTotal = new WsDisplayTotal(configuration);
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsCurrentCustomerId, wsBillingMonth, wsUsageUnits, wsRate, wsUsageCharge, wsDiscount, wsTaxableAmount, wsTax, wsFinalAmount, wsMinimumCharge, wsVolumeDiscountRate, wsPremiumDiscountRate, wsVolumeThreshold, wsEndUsage, wsEndCustomer, wsFoundCustomer, wsInvoiceNumber, wsOutputLine, wsDisplayCharge, wsDisplayDiscount, wsDisplayTax, wsDisplayBalance, wsDisplayTotal);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nBillingContext:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		return toSB.toString();
	}

}
