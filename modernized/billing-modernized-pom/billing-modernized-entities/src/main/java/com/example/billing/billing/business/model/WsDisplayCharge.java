package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsDisplayCharge.
 * 
 * <p>About 'wsDisplayCharge' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDisplayCharge extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsDisplayCharge = new Elementary(root,new NumericEditedType("Z,ZZZ,ZZ9.99"));
	
	/**
	 * Instantiate a new WsDisplayCharge with a default record.
	 * @param configuration the configuration
	 */
	public WsDisplayCharge(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDisplayCharge bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsDisplayCharge(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsDisplayCharge.
	 * @return the wsDisplayCharge attribute reference
	 */
	public ElementaryRangeReference getWsDisplayChargeReference() {
		return wsDisplayCharge.getReference();
	}

	/**
	 * Getter for wsDisplayCharge attribute.
	 * @return wsDisplayCharge attribute
	 */
	public String getWsDisplayCharge() {
		return wsDisplayCharge.getValue();
	}

	/**
	 * Setter for wsDisplayCharge attribute.
	 * @param wsDisplayCharge the new value of wsDisplayCharge
	 */
	public void setWsDisplayCharge(String wsDisplayCharge) {
		this.wsDisplayCharge.setValue(wsDisplayCharge);
	}
}
