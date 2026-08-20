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
 * Data simplifier entity WsFinalAmount.
 * 
 * <p>About 'wsFinalAmount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsFinalAmount extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsFinalAmount = new Elementary(root,new ZonedType(9, 2, false),new BigDecimal("0"));
	
	/**
	 * Instantiate a new WsFinalAmount with a default record.
	 * @param configuration the configuration
	 */
	public WsFinalAmount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsFinalAmount bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsFinalAmount(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsFinalAmount.
	 * @return the wsFinalAmount attribute reference
	 */
	public ElementaryRangeReference getWsFinalAmountReference() {
		return wsFinalAmount.getReference();
	}

	/**
	 * Getter for wsFinalAmount attribute.
	 * @return wsFinalAmount attribute
	 */
	public BigDecimal getWsFinalAmount() {
		return wsFinalAmount.getValue();
	}

	/**
	 * Setter for wsFinalAmount attribute.
	 * @param wsFinalAmount the new value of wsFinalAmount
	 */
	public void setWsFinalAmount(BigDecimal wsFinalAmount) {
		this.wsFinalAmount.setValue(wsFinalAmount);
	}
}
