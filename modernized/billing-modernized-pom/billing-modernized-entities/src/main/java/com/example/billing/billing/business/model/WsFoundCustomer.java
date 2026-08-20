package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import java.util.Arrays;
/**
 * Data simplifier entity WsFoundCustomer.
 * 
 * <p>About 'wsFoundCustomer' field, <br>
 * </p>
 * 
 * <p>About 'customerFound' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsFoundCustomer extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsFoundCustomer = new Elementary(root,new AlphanumericType(1),"N");
	private final ConditionName customerFound = new ConditionName(wsFoundCustomer,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsFoundCustomer with a default record.
	 * @param configuration the configuration
	 */
	public WsFoundCustomer(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsFoundCustomer bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsFoundCustomer(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsFoundCustomer.
	 * @return the wsFoundCustomer attribute reference
	 */
	public ElementaryRangeReference getWsFoundCustomerReference() {
		return wsFoundCustomer.getReference();
	}

	/**
	 * Getter for wsFoundCustomer attribute.
	 * @return wsFoundCustomer attribute
	 */
	public String getWsFoundCustomer() {
		return wsFoundCustomer.getValue();
	}

	/**
	 * Setter for wsFoundCustomer attribute.
	 * @param wsFoundCustomer the new value of wsFoundCustomer
	 */
	public void setWsFoundCustomer(String wsFoundCustomer) {
		this.wsFoundCustomer.setValue(wsFoundCustomer);
	}
	/**
	 * Gets the reference for attribute customerFound.
	 * @return the customerFound attribute reference
	 */
	public ConditionReference getCustomerFoundReference() {
		return wsFoundCustomer.getCondition(customerFound);	
	}

	/**
	 * Getter for customerFound attribute.
	 * @return customerFound attribute
	 */
	public boolean isCustomerFound() {
		return getCustomerFoundReference().getValue();	
	}

	/**
	 * Setter for customerFound attribute.
	 * @param customerFound the new value of customerFound
	 */
	public void setCustomerFound(boolean customerFound) {
		getCustomerFoundReference().setValue(customerFound);	
	}
}
