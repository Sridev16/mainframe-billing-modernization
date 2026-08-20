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
 * Data simplifier entity WsRate.
 * 
 * <p>About 'wsRate' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsRate extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsRate = new Elementary(root,new ZonedType(1, 2, false),new BigDecimal("0"));
	
	/**
	 * Instantiate a new WsRate with a default record.
	 * @param configuration the configuration
	 */
	public WsRate(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsRate bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsRate(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsRate.
	 * @return the wsRate attribute reference
	 */
	public ElementaryRangeReference getWsRateReference() {
		return wsRate.getReference();
	}

	/**
	 * Getter for wsRate attribute.
	 * @return wsRate attribute
	 */
	public BigDecimal getWsRate() {
		return wsRate.getValue();
	}

	/**
	 * Setter for wsRate attribute.
	 * @param wsRate the new value of wsRate
	 */
	public void setWsRate(BigDecimal wsRate) {
		this.wsRate.setValue(wsRate);
	}
}
