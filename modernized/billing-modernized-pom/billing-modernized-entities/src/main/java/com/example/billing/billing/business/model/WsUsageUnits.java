package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity WsUsageUnits.
 * 
 * <p>About 'wsUsageUnits' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsUsageUnits extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsUsageUnits = new Elementary(root,new ZonedType(7, 0, false),Integer.valueOf("0"));
	
	/**
	 * Instantiate a new WsUsageUnits with a default record.
	 * @param configuration the configuration
	 */
	public WsUsageUnits(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsUsageUnits bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsUsageUnits(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsUsageUnits.
	 * @return the wsUsageUnits attribute reference
	 */
	public ElementaryRangeReference getWsUsageUnitsReference() {
		return wsUsageUnits.getReference();
	}

	/**
	 * Getter for wsUsageUnits attribute.
	 * @return wsUsageUnits attribute
	 */
	public int getWsUsageUnits() {
		return wsUsageUnits.getValue();
	}

	/**
	 * Setter for wsUsageUnits attribute.
	 * @param wsUsageUnits the new value of wsUsageUnits
	 */
	public void setWsUsageUnits(int wsUsageUnits) {
		this.wsUsageUnits.setValue(wsUsageUnits);
	}
}
