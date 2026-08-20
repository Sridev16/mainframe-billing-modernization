package com.example.billing.billing.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier file InvoiceFile.
 * 
 * <p>About 'invoiceRecord' field, <br>uml entity: com.example.billing.billing.business.model.InvoiceRecord
 * <br></p>
 * 
 */
@Component("com.example.billing.billing.business.model.InvoiceFile")
@Lazy
@Scope("prototype")
public class InvoiceFile extends RecordEntity {

	private final Group root = new Group(getData());
	private final Elementary invoiceRecord = new Elementary(root,new AlphanumericType(180));
	 
	/**
	 * Instantiate a new InvoiceFile.
	 * @param configuration the configuration
	 */
	public InvoiceFile(@Qualifier("BillingContextConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
 
	/**
	 * Gets the reference for attribute invoiceRecord.
	 * @return the invoiceRecord attribute reference
	 */
	public ElementaryRangeReference getInvoiceRecordReference() {
		return invoiceRecord.getReference();
	}

	/**
	 * Getter for invoiceRecord attribute.
	 * @return invoiceRecord attribute
	 */
	public String getInvoiceRecord() {
		return invoiceRecord.getValue();
	}

	/**
	 * Setter for invoiceRecord attribute.
	 * @param invoiceRecord the new value of invoiceRecord
	 */
	public void setInvoiceRecord(String invoiceRecord) {
		this.invoiceRecord.setValue(invoiceRecord);
	}
}
