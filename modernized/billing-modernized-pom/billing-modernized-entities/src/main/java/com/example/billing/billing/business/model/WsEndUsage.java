package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import java.util.Arrays;
/**
 * Data simplifier entity WsEndUsage.
 * 
 * <p>About 'wsEndUsage' field, <br>
 * </p>
 * 
 * <p>About 'endOfUsage' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsEndUsage extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsEndUsage = new Elementary(root,new AlphanumericType(1),"N");
	private final ConditionName endOfUsage = new ConditionName(wsEndUsage,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsEndUsage with a default record.
	 * @param configuration the configuration
	 */
	public WsEndUsage(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsEndUsage bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsEndUsage(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsEndUsage.
	 * @return the wsEndUsage attribute reference
	 */
	public ElementaryRangeReference getWsEndUsageReference() {
		return wsEndUsage.getReference();
	}

	/**
	 * Getter for wsEndUsage attribute.
	 * @return wsEndUsage attribute
	 */
	public String getWsEndUsage() {
		return wsEndUsage.getValue();
	}

	/**
	 * Setter for wsEndUsage attribute.
	 * @param wsEndUsage the new value of wsEndUsage
	 */
	public void setWsEndUsage(String wsEndUsage) {
		this.wsEndUsage.setValue(wsEndUsage);
	}
	/**
	 * Gets the reference for attribute endOfUsage.
	 * @return the endOfUsage attribute reference
	 */
	public ConditionReference getEndOfUsageReference() {
		return wsEndUsage.getCondition(endOfUsage);	
	}

	/**
	 * Getter for endOfUsage attribute.
	 * @return endOfUsage attribute
	 */
	public boolean isEndOfUsage() {
		return getEndOfUsageReference().getValue();	
	}

	/**
	 * Setter for endOfUsage attribute.
	 * @param endOfUsage the new value of endOfUsage
	 */
	public void setEndOfUsage(boolean endOfUsage) {
		getEndOfUsageReference().setValue(endOfUsage);	
	}
}
