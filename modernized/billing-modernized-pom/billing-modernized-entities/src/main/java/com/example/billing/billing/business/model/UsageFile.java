package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier file UsageFile.
 * 
 * <p>About 'usageRecord' field, <br>uml entity: com.example.billing.billing.business.model.UsageRecord
 * <br></p>
 * 
 */
@Component("com.example.billing.billing.business.model.UsageFile")
@Lazy
@Scope("prototype")
public class UsageFile extends RecordEntity {

	private final Group root = new Group(getData());
	private final Group usageRecord = new Group(root);
	private final Elementary usageCustId = new Elementary(usageRecord,new AlphanumericType(10));
	private final Elementary usageUnits = new Elementary(usageRecord,new ZonedType(7, 0, false));
	private final Elementary usageMonth = new Elementary(usageRecord,new AlphanumericType(6));
	 
	/**
	 * Instantiate a new UsageFile.
	 * @param configuration the configuration
	 */
	public UsageFile(@Qualifier("BillingContextConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
	
	/**
	 * Gets the reference for attribute usageRecord.
	 * @return the usageRecord attribute reference
	 */
	public RangeReference getUsageRecordReference() {
		return usageRecord.getReference();
	}	
				
	/**
	 * Setter for usageRecord .
	 */
   	public void setUsageRecord(RangeReference reference) {
       	usageRecord.getReference().setBytes(reference.getBytes());
   	}
 
	/**
	 * Gets the reference for attribute usageCustId.
	 * @return the usageCustId attribute reference
	 */
	public ElementaryRangeReference getUsageCustIdReference() {
		return usageCustId.getReference();
	}

	/**
	 * Getter for usageCustId attribute.
	 * @return usageCustId attribute
	 */
	public String getUsageCustId() {
		return usageCustId.getValue();
	}

	/**
	 * Setter for usageCustId attribute.
	 * @param usageCustId the new value of usageCustId
	 */
	public void setUsageCustId(String usageCustId) {
		this.usageCustId.setValue(usageCustId);
	}
	/**
	 * Gets the reference for attribute usageUnits.
	 * @return the usageUnits attribute reference
	 */
	public ElementaryRangeReference getUsageUnitsReference() {
		return usageUnits.getReference();
	}

	/**
	 * Getter for usageUnits attribute.
	 * @return usageUnits attribute
	 */
	public int getUsageUnits() {
		return usageUnits.getValue();
	}

	/**
	 * Setter for usageUnits attribute.
	 * @param usageUnits the new value of usageUnits
	 */
	public void setUsageUnits(int usageUnits) {
		this.usageUnits.setValue(usageUnits);
	}
	/**
	 * Gets the reference for attribute usageMonth.
	 * @return the usageMonth attribute reference
	 */
	public ElementaryRangeReference getUsageMonthReference() {
		return usageMonth.getReference();
	}

	/**
	 * Getter for usageMonth attribute.
	 * @return usageMonth attribute
	 */
	public String getUsageMonth() {
		return usageMonth.getValue();
	}

	/**
	 * Setter for usageMonth attribute.
	 * @param usageMonth the new value of usageMonth
	 */
	public void setUsageMonth(String usageMonth) {
		this.usageMonth.setValue(usageMonth);
	}
}
