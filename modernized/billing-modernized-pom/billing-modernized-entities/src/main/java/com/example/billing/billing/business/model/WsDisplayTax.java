package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsDisplayTax.
 * 
 * <p>About 'wsDisplayTax' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDisplayTax extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsDisplayTax = new Elementary(root,new NumericEditedType("Z,ZZZ,ZZ9.99"));
	
	/**
	 * Instantiate a new WsDisplayTax with a default record.
	 * @param configuration the configuration
	 */
	public WsDisplayTax(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDisplayTax bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsDisplayTax(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsDisplayTax.
	 * @return the wsDisplayTax attribute reference
	 */
	public ElementaryRangeReference getWsDisplayTaxReference() {
		return wsDisplayTax.getReference();
	}

	/**
	 * Getter for wsDisplayTax attribute.
	 * @return wsDisplayTax attribute
	 */
	public String getWsDisplayTax() {
		return wsDisplayTax.getValue();
	}

	/**
	 * Setter for wsDisplayTax attribute.
	 * @param wsDisplayTax the new value of wsDisplayTax
	 */
	public void setWsDisplayTax(String wsDisplayTax) {
		this.wsDisplayTax.setValue(wsDisplayTax);
	}
}
