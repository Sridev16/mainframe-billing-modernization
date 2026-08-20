package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsDisplayBalance.
 * 
 * <p>About 'wsDisplayBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDisplayBalance extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsDisplayBalance = new Elementary(root,new NumericEditedType("Z,ZZZ,ZZ9.99"));
	
	/**
	 * Instantiate a new WsDisplayBalance with a default record.
	 * @param configuration the configuration
	 */
	public WsDisplayBalance(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDisplayBalance bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsDisplayBalance(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsDisplayBalance.
	 * @return the wsDisplayBalance attribute reference
	 */
	public ElementaryRangeReference getWsDisplayBalanceReference() {
		return wsDisplayBalance.getReference();
	}

	/**
	 * Getter for wsDisplayBalance attribute.
	 * @return wsDisplayBalance attribute
	 */
	public String getWsDisplayBalance() {
		return wsDisplayBalance.getValue();
	}

	/**
	 * Setter for wsDisplayBalance attribute.
	 * @param wsDisplayBalance the new value of wsDisplayBalance
	 */
	public void setWsDisplayBalance(String wsDisplayBalance) {
		this.wsDisplayBalance.setValue(wsDisplayBalance);
	}
}
