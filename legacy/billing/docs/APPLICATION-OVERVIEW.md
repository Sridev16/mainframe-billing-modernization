# BILL01 - Legacy Billing Application

## Purpose

BILL01 is a batch-oriented customer billing application.

It reads customer master information and monthly usage transactions,
calculates customer charges, applies discounts and taxes, and produces
an invoice output file.

## Processing Model

The application processes usage records sequentially.

For each usage record:

1. Identify customer.
2. Locate customer in customer master.
3. Validate customer status.
4. Determine usage rate.
5. Calculate usage charge.
6. Apply volume discount.
7. Apply premium customer discount.
8. Apply minimum charge.
9. Calculate tax.
10. Add previous balance.
11. Generate invoice.

## Inputs

### CUSTOMER.dat

Customer master data.

Contains:

- Customer ID
- Customer name
- Customer type
- Customer status
- Tax rate
- Previous balance

### USAGE.dat

Monthly customer usage.

Contains:

- Customer ID
- Usage units
- Billing month

## Output

### INVOICE.dat

Pipe-delimited invoice records.

Contains:

- Invoice number
- Customer ID
- Customer name
- Usage
- Usage charge
- Discount
- Tax
- Previous balance
- Final amount

## Error Conditions

Customer not found:

    ERROR: CUSTOMER NOT FOUND

Inactive customer:

    ERROR: CUSTOMER IS NOT ACTIVE

## Technology

Language:

    COBOL

Processing:

    Batch

Input:

    Sequential files

Output:

    Sequential file

Scheduling:

    JCL