# Billing Modernization - Target Architecture

## Objective

Modernize the legacy BILL01 billing application into a cloud-native
application while preserving existing business behavior.

## Proposed Target

API:

Spring Boot REST API

Business Logic:

Java service layer

Customer Data:

Amazon Aurora PostgreSQL

Usage Data:

Amazon Aurora PostgreSQL

Invoice Storage:

Amazon S3

Compute:

Amazon ECS / AWS Fargate

Observability:

Amazon CloudWatch

Security:

AWS IAM

Secrets:

AWS Secrets Manager

CI/CD:

AWS CodePipeline / CodeBuild

## Proposed Services

### Customer Service

Responsibilities:

- Customer lookup
- Customer status
- Customer type
- Tax information
- Previous balance

### Billing Service

Responsibilities:

- Usage calculation
- Rate calculation
- Discount calculation
- Tax calculation
- Final invoice calculation

### Invoice Service

Responsibilities:

- Invoice generation
- Invoice persistence
- Invoice retrieval

## Modernization Principle

Business behavior must remain functionally equivalent to the legacy
application unless explicitly approved as a business change.

## Migration Strategy

1. Understand legacy application.
2. Extract business rules.
3. Identify dependencies.
4. Define service boundaries.
5. Generate target requirements.
6. Generate target implementation.
7. Execute regression tests.
8. Compare legacy and modernized results.
9. Deploy to AWS.