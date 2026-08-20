# Legacy Billing - Business Rules

## BR-001 - Customer Validation

A customer must exist in the customer master file.

If the customer does not exist, the billing transaction is rejected.

---

## BR-002 - Customer Status

Only ACTIVE customers can be billed.

INACTIVE customers are rejected.

---

## BR-003 - Usage Rate - Tier 1

For usage of 500 units or less:

Rate = $0.50 per unit.

---

## BR-004 - Usage Rate - Tier 2

For usage between 501 and 1,000 units:

Rate = $0.45 per unit.

---

## BR-005 - Usage Rate - Tier 3

For usage greater than 1,000 units:

Rate = $0.40 per unit.

---

## BR-006 - Volume Discount

Customers using more than 1,000 units receive a 10% discount on usage charges.

---

## BR-007 - Premium Customer Discount

PREMIUM customers receive an additional 5% discount.

---

## BR-008 - Minimum Charge

The taxable amount cannot be less than $25.

---

## BR-009 - Customer Tax

Tax is calculated using the customer's tax rate.

---

## BR-010 - Previous Balance

The customer's previous balance is added to the current billing amount.

---

## BR-011 - Final Invoice Amount

Final amount:

    Taxable Amount
    + Tax
    + Previous Balance

---

## BR-012 - Invoice Number

Invoice number is constructed as:

    BILLING-MONTH + "-" + CUSTOMER-ID

Example:

    202608-C10001