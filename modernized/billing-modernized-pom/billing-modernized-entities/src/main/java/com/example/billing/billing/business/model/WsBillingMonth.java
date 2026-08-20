package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsBillingMonth.
 * 
 * <p>About 'wsBillingMonth' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsBillingMonth extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsBillingMonth = new Elementary(root,new AlphanumericType(6));
	
	/**
	 * Instantiate a new WsBillingMonth with a default record.
	 * @param configuration the configuration
	 */
	public WsBillingMonth(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsBillingMonth bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsBillingMonth(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsBillingMonth.
	 * @return the wsBillingMonth attribute reference
	 */
	public ElementaryRangeReference getWsBillingMonthReference() {
		return wsBillingMonth.getReference();
	}

	/**
	 * Getter for wsBillingMonth attribute.
	 * @return wsBillingMonth attribute
	 */
	public String getWsBillingMonth() {
		return wsBillingMonth.getValue();
	}

	/**
	 * Setter for wsBillingMonth attribute.
	 * @param wsBillingMonth the new value of wsBillingMonth
	 */
	public void setWsBillingMonth(String wsBillingMonth) {
		this.wsBillingMonth.setValue(wsBillingMonth);
	}
}
