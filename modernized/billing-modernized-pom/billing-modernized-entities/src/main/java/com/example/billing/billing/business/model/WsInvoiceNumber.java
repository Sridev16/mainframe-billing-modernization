package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsInvoiceNumber.
 * 
 * <p>About 'wsInvoiceNumber' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsInvoiceNumber extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsInvoiceNumber = new Elementary(root,new AlphanumericType(30));
	
	/**
	 * Instantiate a new WsInvoiceNumber with a default record.
	 * @param configuration the configuration
	 */
	public WsInvoiceNumber(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsInvoiceNumber bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsInvoiceNumber(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsInvoiceNumber.
	 * @return the wsInvoiceNumber attribute reference
	 */
	public ElementaryRangeReference getWsInvoiceNumberReference() {
		return wsInvoiceNumber.getReference();
	}

	/**
	 * Getter for wsInvoiceNumber attribute.
	 * @return wsInvoiceNumber attribute
	 */
	public String getWsInvoiceNumber() {
		return wsInvoiceNumber.getValue();
	}

	/**
	 * Setter for wsInvoiceNumber attribute.
	 * @param wsInvoiceNumber the new value of wsInvoiceNumber
	 */
	public void setWsInvoiceNumber(String wsInvoiceNumber) {
		this.wsInvoiceNumber.setValue(wsInvoiceNumber);
	}
}
