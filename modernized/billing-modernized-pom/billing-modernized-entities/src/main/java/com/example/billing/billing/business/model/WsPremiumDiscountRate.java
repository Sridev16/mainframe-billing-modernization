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
 * Data simplifier entity WsPremiumDiscountRate.
 * 
 * <p>About 'wsPremiumDiscountRate' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsPremiumDiscountRate extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsPremiumDiscountRate = new Elementary(root,new ZonedType(0, 2, false),new BigDecimal("0.05"));
	
	/**
	 * Instantiate a new WsPremiumDiscountRate with a default record.
	 * @param configuration the configuration
	 */
	public WsPremiumDiscountRate(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsPremiumDiscountRate bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsPremiumDiscountRate(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsPremiumDiscountRate.
	 * @return the wsPremiumDiscountRate attribute reference
	 */
	public ElementaryRangeReference getWsPremiumDiscountRateReference() {
		return wsPremiumDiscountRate.getReference();
	}

	/**
	 * Getter for wsPremiumDiscountRate attribute.
	 * @return wsPremiumDiscountRate attribute
	 */
	public BigDecimal getWsPremiumDiscountRate() {
		return wsPremiumDiscountRate.getValue();
	}

	/**
	 * Setter for wsPremiumDiscountRate attribute.
	 * @param wsPremiumDiscountRate the new value of wsPremiumDiscountRate
	 */
	public void setWsPremiumDiscountRate(BigDecimal wsPremiumDiscountRate) {
		this.wsPremiumDiscountRate.setValue(wsPremiumDiscountRate);
	}
}
