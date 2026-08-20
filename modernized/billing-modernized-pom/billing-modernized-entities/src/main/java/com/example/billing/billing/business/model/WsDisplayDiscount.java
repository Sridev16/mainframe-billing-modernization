package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsDisplayDiscount.
 * 
 * <p>About 'wsDisplayDiscount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDisplayDiscount extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsDisplayDiscount = new Elementary(root,new NumericEditedType("Z,ZZZ,ZZ9.99"));
	
	/**
	 * Instantiate a new WsDisplayDiscount with a default record.
	 * @param configuration the configuration
	 */
	public WsDisplayDiscount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDisplayDiscount bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsDisplayDiscount(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsDisplayDiscount.
	 * @return the wsDisplayDiscount attribute reference
	 */
	public ElementaryRangeReference getWsDisplayDiscountReference() {
		return wsDisplayDiscount.getReference();
	}

	/**
	 * Getter for wsDisplayDiscount attribute.
	 * @return wsDisplayDiscount attribute
	 */
	public String getWsDisplayDiscount() {
		return wsDisplayDiscount.getValue();
	}

	/**
	 * Setter for wsDisplayDiscount attribute.
	 * @param wsDisplayDiscount the new value of wsDisplayDiscount
	 */
	public void setWsDisplayDiscount(String wsDisplayDiscount) {
		this.wsDisplayDiscount.setValue(wsDisplayDiscount);
	}
}
