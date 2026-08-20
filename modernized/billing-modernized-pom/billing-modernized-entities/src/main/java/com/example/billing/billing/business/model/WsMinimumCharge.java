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
 * Data simplifier entity WsMinimumCharge.
 * 
 * <p>About 'wsMinimumCharge' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsMinimumCharge extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsMinimumCharge = new Elementary(root,new ZonedType(5, 2, false),new BigDecimal("25.00"));
	
	/**
	 * Instantiate a new WsMinimumCharge with a default record.
	 * @param configuration the configuration
	 */
	public WsMinimumCharge(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsMinimumCharge bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsMinimumCharge(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsMinimumCharge.
	 * @return the wsMinimumCharge attribute reference
	 */
	public ElementaryRangeReference getWsMinimumChargeReference() {
		return wsMinimumCharge.getReference();
	}

	/**
	 * Getter for wsMinimumCharge attribute.
	 * @return wsMinimumCharge attribute
	 */
	public BigDecimal getWsMinimumCharge() {
		return wsMinimumCharge.getValue();
	}

	/**
	 * Setter for wsMinimumCharge attribute.
	 * @param wsMinimumCharge the new value of wsMinimumCharge
	 */
	public void setWsMinimumCharge(BigDecimal wsMinimumCharge) {
		this.wsMinimumCharge.setValue(wsMinimumCharge);
	}
}
