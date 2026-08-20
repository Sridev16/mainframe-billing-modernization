package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier file CustomerFile.
 * 
 * <p>About 'customerRecord' field, <br>uml entity: com.example.billing.billing.business.model.CustomerRecord
 * <br></p>
 * 
 */
@Component("com.example.billing.billing.business.model.CustomerFile")
@Lazy
@Scope("prototype")
public class CustomerFile extends RecordEntity {

	private final Group root = new Group(getData());
	private final Group customerRecord = new Group(root);
	private final Elementary custId = new Elementary(customerRecord,new AlphanumericType(10));
	private final Elementary custName = new Elementary(customerRecord,new AlphanumericType(30));
	private final Elementary custType = new Elementary(customerRecord,new AlphanumericType(10));
	private final Elementary custStatus = new Elementary(customerRecord,new AlphanumericType(8));
	private final Elementary custTaxRate = new Elementary(customerRecord,new ZonedType(1, 3, false));
	private final Elementary custPrevBalance = new Elementary(customerRecord,new ZonedType(7, 2, false));
	 
	/**
	 * Instantiate a new CustomerFile.
	 * @param configuration the configuration
	 */
	public CustomerFile(@Qualifier("BillingContextConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
	
	/**
	 * Gets the reference for attribute customerRecord.
	 * @return the customerRecord attribute reference
	 */
	public RangeReference getCustomerRecordReference() {
		return customerRecord.getReference();
	}	
				
	/**
	 * Setter for customerRecord .
	 */
   	public void setCustomerRecord(RangeReference reference) {
       	customerRecord.getReference().setBytes(reference.getBytes());
   	}
 
	/**
	 * Gets the reference for attribute custId.
	 * @return the custId attribute reference
	 */
	public ElementaryRangeReference getCustIdReference() {
		return custId.getReference();
	}

	/**
	 * Getter for custId attribute.
	 * @return custId attribute
	 */
	public String getCustId() {
		return custId.getValue();
	}

	/**
	 * Setter for custId attribute.
	 * @param custId the new value of custId
	 */
	public void setCustId(String custId) {
		this.custId.setValue(custId);
	}
	/**
	 * Gets the reference for attribute custName.
	 * @return the custName attribute reference
	 */
	public ElementaryRangeReference getCustNameReference() {
		return custName.getReference();
	}

	/**
	 * Getter for custName attribute.
	 * @return custName attribute
	 */
	public String getCustName() {
		return custName.getValue();
	}

	/**
	 * Setter for custName attribute.
	 * @param custName the new value of custName
	 */
	public void setCustName(String custName) {
		this.custName.setValue(custName);
	}
	/**
	 * Gets the reference for attribute custType.
	 * @return the custType attribute reference
	 */
	public ElementaryRangeReference getCustTypeReference() {
		return custType.getReference();
	}

	/**
	 * Getter for custType attribute.
	 * @return custType attribute
	 */
	public String getCustType() {
		return custType.getValue();
	}

	/**
	 * Setter for custType attribute.
	 * @param custType the new value of custType
	 */
	public void setCustType(String custType) {
		this.custType.setValue(custType);
	}
	/**
	 * Gets the reference for attribute custStatus.
	 * @return the custStatus attribute reference
	 */
	public ElementaryRangeReference getCustStatusReference() {
		return custStatus.getReference();
	}

	/**
	 * Getter for custStatus attribute.
	 * @return custStatus attribute
	 */
	public String getCustStatus() {
		return custStatus.getValue();
	}

	/**
	 * Setter for custStatus attribute.
	 * @param custStatus the new value of custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus.setValue(custStatus);
	}
	/**
	 * Gets the reference for attribute custTaxRate.
	 * @return the custTaxRate attribute reference
	 */
	public ElementaryRangeReference getCustTaxRateReference() {
		return custTaxRate.getReference();
	}

	/**
	 * Getter for custTaxRate attribute.
	 * @return custTaxRate attribute
	 */
	public BigDecimal getCustTaxRate() {
		return custTaxRate.getValue();
	}

	/**
	 * Setter for custTaxRate attribute.
	 * @param custTaxRate the new value of custTaxRate
	 */
	public void setCustTaxRate(BigDecimal custTaxRate) {
		this.custTaxRate.setValue(custTaxRate);
	}
	/**
	 * Gets the reference for attribute custPrevBalance.
	 * @return the custPrevBalance attribute reference
	 */
	public ElementaryRangeReference getCustPrevBalanceReference() {
		return custPrevBalance.getReference();
	}

	/**
	 * Getter for custPrevBalance attribute.
	 * @return custPrevBalance attribute
	 */
	public BigDecimal getCustPrevBalance() {
		return custPrevBalance.getValue();
	}

	/**
	 * Setter for custPrevBalance attribute.
	 * @param custPrevBalance the new value of custPrevBalance
	 */
	public void setCustPrevBalance(BigDecimal custPrevBalance) {
		this.custPrevBalance.setValue(custPrevBalance);
	}
}
