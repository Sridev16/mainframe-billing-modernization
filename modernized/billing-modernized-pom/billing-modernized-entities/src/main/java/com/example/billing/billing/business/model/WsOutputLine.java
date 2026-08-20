package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsOutputLine.
 * 
 * <p>About 'wsOutputLine' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsOutputLine extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsOutputLine = new Elementary(root,new AlphanumericType(180));
	
	/**
	 * Instantiate a new WsOutputLine with a default record.
	 * @param configuration the configuration
	 */
	public WsOutputLine(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsOutputLine bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsOutputLine(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsOutputLine.
	 * @return the wsOutputLine attribute reference
	 */
	public ElementaryRangeReference getWsOutputLineReference() {
		return wsOutputLine.getReference();
	}

	/**
	 * Getter for wsOutputLine attribute.
	 * @return wsOutputLine attribute
	 */
	public String getWsOutputLine() {
		return wsOutputLine.getValue();
	}

	/**
	 * Setter for wsOutputLine attribute.
	 * @param wsOutputLine the new value of wsOutputLine
	 */
	public void setWsOutputLine(String wsOutputLine) {
		this.wsOutputLine.setValue(wsOutputLine);
	}
}
