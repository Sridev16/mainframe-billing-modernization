package com.example.billing.billing.service;

import com.example.billing.billing.business.context.BillingContext;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface BillingProcess.
 * 
 * Defines application services for BillingProcess
 */
public interface BillingProcess {

	/**
	 * Process operation mainProcess.
	 * 
	 * PROGRAM-ID.BILLING.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void mainProcess(final BillingContext ctx, final ExecutionController ctrl);

	/**
	 * Process operation readNextUsage.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void readNextUsage(final BillingContext ctx, final ExecutionController ctrl);

	/**
	 * Process operation findCustomer.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void findCustomer(final BillingContext ctx, final ExecutionController ctrl);

	/**
	 * Process operation calculateBill.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void calculateBill(final BillingContext ctx, final ExecutionController ctrl);

	/**
	 * Process operation generateInvoice.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void generateInvoice(final BillingContext ctx, final ExecutionController ctrl);

}
