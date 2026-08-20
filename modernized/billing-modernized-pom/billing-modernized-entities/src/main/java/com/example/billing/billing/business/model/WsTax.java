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
 * Data simplifier entity WsTax.
 * 
 * <p>About 'wsTax' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsTax extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsTax = new Elementary(root,new ZonedType(9, 2, false),new BigDecimal("0"));
	
	/**
	 * Instantiate a new WsTax with a default record.
	 * @param configuration the configuration
	 */
	public WsTax(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsTax bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsTax(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsTax.
	 * @return the wsTax attribute reference
	 */
	public ElementaryRangeReference getWsTaxReference() {
		return wsTax.getReference();
	}

	/**
	 * Getter for wsTax attribute.
	 * @return wsTax attribute
	 */
	public BigDecimal getWsTax() {
		return wsTax.getValue();
	}

	/**
	 * Setter for wsTax attribute.
	 * @param wsTax the new value of wsTax
	 */
	public void setWsTax(BigDecimal wsTax) {
		this.wsTax.setValue(wsTax);
	}
}
