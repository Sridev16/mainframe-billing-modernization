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
 * Data simplifier entity WsVolumeDiscountRate.
 * 
 * <p>About 'wsVolumeDiscountRate' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsVolumeDiscountRate extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsVolumeDiscountRate = new Elementary(root,new ZonedType(0, 2, false),new BigDecimal("0.10"));
	
	/**
	 * Instantiate a new WsVolumeDiscountRate with a default record.
	 * @param configuration the configuration
	 */
	public WsVolumeDiscountRate(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsVolumeDiscountRate bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsVolumeDiscountRate(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsVolumeDiscountRate.
	 * @return the wsVolumeDiscountRate attribute reference
	 */
	public ElementaryRangeReference getWsVolumeDiscountRateReference() {
		return wsVolumeDiscountRate.getReference();
	}

	/**
	 * Getter for wsVolumeDiscountRate attribute.
	 * @return wsVolumeDiscountRate attribute
	 */
	public BigDecimal getWsVolumeDiscountRate() {
		return wsVolumeDiscountRate.getValue();
	}

	/**
	 * Setter for wsVolumeDiscountRate attribute.
	 * @param wsVolumeDiscountRate the new value of wsVolumeDiscountRate
	 */
	public void setWsVolumeDiscountRate(BigDecimal wsVolumeDiscountRate) {
		this.wsVolumeDiscountRate.setValue(wsVolumeDiscountRate);
	}
}
