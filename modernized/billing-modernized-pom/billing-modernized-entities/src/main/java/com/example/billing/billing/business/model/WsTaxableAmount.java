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
 * Data simplifier entity WsTaxableAmount.
 * 
 * <p>About 'wsTaxableAmount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsTaxableAmount extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsTaxableAmount = new Elementary(root,new ZonedType(9, 2, false),new BigDecimal("0"));
	
	/**
	 * Instantiate a new WsTaxableAmount with a default record.
	 * @param configuration the configuration
	 */
	public WsTaxableAmount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsTaxableAmount bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsTaxableAmount(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsTaxableAmount.
	 * @return the wsTaxableAmount attribute reference
	 */
	public ElementaryRangeReference getWsTaxableAmountReference() {
		return wsTaxableAmount.getReference();
	}

	/**
	 * Getter for wsTaxableAmount attribute.
	 * @return wsTaxableAmount attribute
	 */
	public BigDecimal getWsTaxableAmount() {
		return wsTaxableAmount.getValue();
	}

	/**
	 * Setter for wsTaxableAmount attribute.
	 * @param wsTaxableAmount the new value of wsTaxableAmount
	 */
	public void setWsTaxableAmount(BigDecimal wsTaxableAmount) {
		this.wsTaxableAmount.setValue(wsTaxableAmount);
	}
}
