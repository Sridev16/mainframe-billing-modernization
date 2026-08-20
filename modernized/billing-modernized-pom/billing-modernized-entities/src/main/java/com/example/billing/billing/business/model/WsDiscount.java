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
 * Data simplifier entity WsDiscount.
 * 
 * <p>About 'wsDiscount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDiscount extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsDiscount = new Elementary(root,new ZonedType(9, 2, false),new BigDecimal("0"));
	
	/**
	 * Instantiate a new WsDiscount with a default record.
	 * @param configuration the configuration
	 */
	public WsDiscount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDiscount bound to the provided record.
	 * @param configuration the configuration
	 * @param record the existing record to bind
	 */
	public WsDiscount(Configuration configuration, RecordAdaptable record) {
		super(configuration);
		setupRoot(root, record);
	}

	/**
	 * Gets the reference for attribute wsDiscount.
	 * @return the wsDiscount attribute reference
	 */
	public ElementaryRangeReference getWsDiscountReference() {
		return wsDiscount.getReference();
	}

	/**
	 * Getter for wsDiscount attribute.
	 * @return wsDiscount attribute
	 */
	public BigDecimal getWsDiscount() {
		return wsDiscount.getValue();
	}

	/**
	 * Setter for wsDiscount attribute.
	 * @param wsDiscount the new value of wsDiscount
	 */
	public void setWsDiscount(BigDecimal wsDiscount) {
		this.wsDiscount.setValue(wsDiscount);
	}
}
