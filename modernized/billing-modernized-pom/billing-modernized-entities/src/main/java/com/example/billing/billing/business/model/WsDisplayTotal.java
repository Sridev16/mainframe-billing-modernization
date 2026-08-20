package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsDisplayTotal.
 * 
 * <p>About 'wsDisplayTotal' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDisplayTotal extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsDisplayTotal = new Elementary(root,new NumericEditedType("Z,ZZZ,ZZ9.99"));
	
	/**
	 * Instantiate a new WsDisplayTotal with a default record.
	 * @param configuration the configuration
	 */
	public WsDisplayTotal(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDisplayTotal bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsDisplayTotal(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsDisplayTotal.
	 * @return the wsDisplayTotal attribute reference
	 */
	public ElementaryRangeReference getWsDisplayTotalReference() {
		return wsDisplayTotal.getReference();
	}

	/**
	 * Getter for wsDisplayTotal attribute.
	 * @return wsDisplayTotal attribute
	 */
	public String getWsDisplayTotal() {
		return wsDisplayTotal.getValue();
	}

	/**
	 * Setter for wsDisplayTotal attribute.
	 * @param wsDisplayTotal the new value of wsDisplayTotal
	 */
	public void setWsDisplayTotal(String wsDisplayTotal) {
		this.wsDisplayTotal.setValue(wsDisplayTotal);
	}
}
