package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity WsVolumeThreshold.
 * 
 * <p>About 'wsVolumeThreshold' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsVolumeThreshold extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsVolumeThreshold = new Elementary(root,new ZonedType(7, 0, false),Integer.valueOf("1000"));
	
	/**
	 * Instantiate a new WsVolumeThreshold with a default record.
	 * @param configuration the configuration
	 */
	public WsVolumeThreshold(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsVolumeThreshold bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsVolumeThreshold(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsVolumeThreshold.
	 * @return the wsVolumeThreshold attribute reference
	 */
	public ElementaryRangeReference getWsVolumeThresholdReference() {
		return wsVolumeThreshold.getReference();
	}

	/**
	 * Getter for wsVolumeThreshold attribute.
	 * @return wsVolumeThreshold attribute
	 */
	public int getWsVolumeThreshold() {
		return wsVolumeThreshold.getValue();
	}

	/**
	 * Setter for wsVolumeThreshold attribute.
	 * @param wsVolumeThreshold the new value of wsVolumeThreshold
	 */
	public void setWsVolumeThreshold(int wsVolumeThreshold) {
		this.wsVolumeThreshold.setValue(wsVolumeThreshold);
	}
}
