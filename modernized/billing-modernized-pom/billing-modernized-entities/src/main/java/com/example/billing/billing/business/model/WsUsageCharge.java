package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
import java.math.BigDecimal;
/**
 * Data simplifier entity WsUsageCharge.
 * 
 * <p>About 'wsUsageCharge' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsUsageCharge extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsUsageCharge = new Elementary(root,new ZonedType(9, 2, false),new BigDecimal("0"));
	
	/**
	 * Instantiate a new WsUsageCharge with a default record.
	 * @param configuration the configuration
	 */
	public WsUsageCharge(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsUsageCharge bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsUsageCharge(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsUsageCharge.
	 * @return the wsUsageCharge attribute reference
	 */
	public ElementaryRangeReference getWsUsageChargeReference() {
		return wsUsageCharge.getReference();
	}

	/**
	 * Getter for wsUsageCharge attribute.
	 * @return wsUsageCharge attribute
	 */
	public BigDecimal getWsUsageCharge() {
		return wsUsageCharge.getValue();
	}

	/**
	 * Setter for wsUsageCharge attribute.
	 * @param wsUsageCharge the new value of wsUsageCharge
	 */
	public void setWsUsageCharge(BigDecimal wsUsageCharge) {
		this.wsUsageCharge.setValue(wsUsageCharge);
	}
}
