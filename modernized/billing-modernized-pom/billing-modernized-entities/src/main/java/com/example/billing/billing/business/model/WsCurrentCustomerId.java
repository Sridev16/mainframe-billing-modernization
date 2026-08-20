package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsCurrentCustomerId.
 * 
 * <p>About 'wsCurrentCustomerId' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCurrentCustomerId extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsCurrentCustomerId = new Elementary(root,new AlphanumericType(10));
	
	/**
	 * Instantiate a new WsCurrentCustomerId with a default record.
	 * @param configuration the configuration
	 */
	public WsCurrentCustomerId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsCurrentCustomerId bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsCurrentCustomerId(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsCurrentCustomerId.
	 * @return the wsCurrentCustomerId attribute reference
	 */
	public ElementaryRangeReference getWsCurrentCustomerIdReference() {
		return wsCurrentCustomerId.getReference();
	}

	/**
	 * Getter for wsCurrentCustomerId attribute.
	 * @return wsCurrentCustomerId attribute
	 */
	public String getWsCurrentCustomerId() {
		return wsCurrentCustomerId.getValue();
	}

	/**
	 * Setter for wsCurrentCustomerId attribute.
	 * @param wsCurrentCustomerId the new value of wsCurrentCustomerId
	 */
	public void setWsCurrentCustomerId(String wsCurrentCustomerId) {
		this.wsCurrentCustomerId.setValue(wsCurrentCustomerId);
	}
}
