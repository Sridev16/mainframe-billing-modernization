# Mainframe Billing Modernization POC

## Stage 1 - Legacy Baseline

This project is a deliberately small but realistic COBOL billing application created to demonstrate an AWS Transform modernization proposal.

### Application

**BILL01 - Customer Monthly Billing**

### Technology

- COBOL
- JCL
- Sequential files
- Batch processing

### Directory structure

```text
legacy/billing/
  BILLING.cbl
  BILLING.cpy
  BILLING.jcl
  CUSTOMER.dat
  USAGE.dat

docs/
  application-overview.md
  business-rules.md
  modernization-objectives.md

tests/
  test-cases.csv
```

## Stage 1 objective

Establish a clean legacy baseline before introducing AWS Transform.

The source intentionally contains business rules inside procedural COBOL logic. This is important for the later AWS Transform demonstration.

## Sample input

The included usage file contains:

- active standard customer
- active premium customers
- inactive customer
- low-usage customer
- unknown customer

## Expected POC flow

```text
COBOL + JCL + data
        |
        v
AWS Transform
        |
        +--> application analysis
        +--> business functions
        +--> business rules
        +--> requirements
        |
        v
Modern target implementation
        |
        v
Functional comparison
```

## Important

This is synthetic demonstration code. It is not production billing software and should not be used for real financial processing.

## Next stage

Stage 2 will introduce AWS Transform and use this legacy application as the input workload.
