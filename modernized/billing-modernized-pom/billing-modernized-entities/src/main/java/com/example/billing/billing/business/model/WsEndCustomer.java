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
 * Data simplifier entity WsEndCustomer.
 * 
 * <p>About 'wsEndCustomer' field, <br>
 * </p>
 * 
 * <p>About 'endOfCustomer' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsEndCustomer extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsEndCustomer = new Elementary(root,new AlphanumericType(1),"N");
	private final ConditionName endOfCustomer = new ConditionName(wsEndCustomer,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsEndCustomer with a default record.
	 * @param configuration the configuration
	 */
	public WsEndCustomer(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsEndCustomer bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsEndCustomer(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsEndCustomer.
	 * @return the wsEndCustomer attribute reference
	 */
	public ElementaryRangeReference getWsEndCustomerReference() {
		return wsEndCustomer.getReference();
	}

	/**
	 * Getter for wsEndCustomer attribute.
	 * @return wsEndCustomer attribute
	 */
	public String getWsEndCustomer() {
		return wsEndCustomer.getValue();
	}

	/**
	 * Setter for wsEndCustomer attribute.
	 * @param wsEndCustomer the new value of wsEndCustomer
	 */
	public void setWsEndCustomer(String wsEndCustomer) {
		this.wsEndCustomer.setValue(wsEndCustomer);
	}
	/**
	 * Gets the reference for attribute endOfCustomer.
	 * @return the endOfCustomer attribute reference
	 */
	public ConditionReference getEndOfCustomerReference() {
		return wsEndCustomer.getCondition(endOfCustomer);	
	}

	/**
	 * Getter for endOfCustomer attribute.
	 * @return endOfCustomer attribute
	 */
	public boolean isEndOfCustomer() {
		return getEndOfCustomerReference().getValue();	
	}

	/**
	 * Setter for endOfCustomer attribute.
	 * @param endOfCustomer the new value of endOfCustomer
	 */
	public void setEndOfCustomer(boolean endOfCustomer) {
		getEndOfCustomerReference().setValue(endOfCustomer);	
	}
}
