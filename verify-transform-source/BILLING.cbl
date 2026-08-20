       IDENTIFICATION DIVISION.
       PROGRAM-ID. BILLING.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.

           SELECT CUSTOMER-FILE
               ASSIGN TO "CUSTOMER.dat"
               ORGANIZATION IS LINE SEQUENTIAL.

           SELECT USAGE-FILE
               ASSIGN TO "USAGE.dat"
               ORGANIZATION IS LINE SEQUENTIAL.

           SELECT INVOICE-FILE
               ASSIGN TO "INVOICE.dat"
               ORGANIZATION IS LINE SEQUENTIAL.

       DATA DIVISION.

       FILE SECTION.

       FD  CUSTOMER-FILE.
       01  CUSTOMER-RECORD.
           05  CUST-ID
               PIC X(10).
           05  CUST-NAME
               PIC X(30).
           05  CUST-TYPE
               PIC X(10).
           05  CUST-STATUS
               PIC X(8).
           05  CUST-TAX-RATE
               PIC 9V999.
           05  CUST-PREV-BALANCE
               PIC 9(7)V99.

       FD  USAGE-FILE.
       01  USAGE-RECORD.
           05  USAGE-CUST-ID
               PIC X(10).
           05  USAGE-UNITS
               PIC 9(7).
           05  USAGE-MONTH
               PIC X(6).

       FD  INVOICE-FILE.
       01  INVOICE-RECORD
           PIC X(180).

       WORKING-STORAGE SECTION.

       01  WS-CURRENT-CUSTOMER-ID
           PIC X(10).

       01  WS-BILLING-MONTH
           PIC X(6).

       01  WS-USAGE-UNITS
           PIC 9(7)
           VALUE ZERO.

       01  WS-RATE
           PIC 9V99
           VALUE ZERO.

       01  WS-USAGE-CHARGE
           PIC 9(9)V99
           VALUE ZERO.

       01  WS-DISCOUNT
           PIC 9(9)V99
           VALUE ZERO.

       01  WS-TAXABLE-AMOUNT
           PIC 9(9)V99
           VALUE ZERO.

       01  WS-TAX
           PIC 9(9)V99
           VALUE ZERO.

       01  WS-FINAL-AMOUNT
           PIC 9(9)V99
           VALUE ZERO.

       01  WS-MINIMUM-CHARGE
           PIC 9(5)V99
           VALUE 25.00.

       01  WS-VOLUME-DISCOUNT-RATE
           PIC V99
           VALUE 0.10.

       01  WS-PREMIUM-DISCOUNT-RATE
           PIC V99
           VALUE 0.05.

       01  WS-VOLUME-THRESHOLD
           PIC 9(7)
           VALUE 1000.

       01  WS-END-USAGE
           PIC X
           VALUE "N".

           88  END-OF-USAGE
               VALUE "Y".

       01  WS-END-CUSTOMER
           PIC X
           VALUE "N".

           88  END-OF-CUSTOMER
               VALUE "Y".

       01  WS-FOUND-CUSTOMER
           PIC X
           VALUE "N".

           88  CUSTOMER-FOUND
               VALUE "Y".

       01  WS-INVOICE-NUMBER
           PIC X(30).

       01  WS-OUTPUT-LINE
           PIC X(180).

       01  WS-DISPLAY-CHARGE
           PIC Z,ZZZ,ZZ9.99.

       01  WS-DISPLAY-DISCOUNT
           PIC Z,ZZZ,ZZ9.99.

       01  WS-DISPLAY-TAX
           PIC Z,ZZZ,ZZ9.99.

       01  WS-DISPLAY-BALANCE
           PIC Z,ZZZ,ZZ9.99.

       01  WS-DISPLAY-TOTAL
           PIC Z,ZZZ,ZZ9.99.


       PROCEDURE DIVISION.

       MAIN-PROCESS.

           OPEN INPUT CUSTOMER-FILE
                INPUT USAGE-FILE
                OUTPUT INVOICE-FILE

           PERFORM READ-NEXT-USAGE

           PERFORM UNTIL END-OF-USAGE

               MOVE "N"
                   TO WS-FOUND-CUSTOMER

               PERFORM FIND-CUSTOMER

               IF CUSTOMER-FOUND

                   IF CUST-STATUS = "ACTIVE"

                       PERFORM CALCULATE-BILL

                       PERFORM GENERATE-INVOICE

                   ELSE

                       DISPLAY
                           "ERROR: CUSTOMER IS NOT ACTIVE - "
                           WS-CURRENT-CUSTOMER-ID

                   END-IF

               ELSE

                   DISPLAY
                       "ERROR: CUSTOMER NOT FOUND - "
                       WS-CURRENT-CUSTOMER-ID

               END-IF

               PERFORM READ-NEXT-USAGE

           END-PERFORM

           CLOSE CUSTOMER-FILE
                 USAGE-FILE
                 INVOICE-FILE

           DISPLAY "----------------------------------------"
           DISPLAY "BILL01 BILLING PROCESS COMPLETE"
           DISPLAY "----------------------------------------"

           STOP RUN.


       READ-NEXT-USAGE.

           READ USAGE-FILE

               AT END

                   SET END-OF-USAGE
                       TO TRUE

               NOT AT END

                   MOVE USAGE-CUST-ID
                       TO WS-CURRENT-CUSTOMER-ID

                   MOVE USAGE-UNITS
                       TO WS-USAGE-UNITS

                   MOVE USAGE-MONTH
                       TO WS-BILLING-MONTH

           END-READ.


       FIND-CUSTOMER.

           MOVE "N"
               TO WS-END-CUSTOMER

           CLOSE CUSTOMER-FILE

           OPEN INPUT CUSTOMER-FILE

           PERFORM UNTIL CUSTOMER-FOUND
               OR END-OF-CUSTOMER

               READ CUSTOMER-FILE

                   AT END

                       SET END-OF-CUSTOMER
                           TO TRUE

                   NOT AT END

                       IF CUST-ID =
                          WS-CURRENT-CUSTOMER-ID

                           SET CUSTOMER-FOUND
                               TO TRUE

                       END-IF

               END-READ

           END-PERFORM.


       CALCULATE-BILL.

           MOVE ZERO
               TO WS-RATE
                  WS-USAGE-CHARGE
                  WS-DISCOUNT
                  WS-TAXABLE-AMOUNT
                  WS-TAX
                  WS-FINAL-AMOUNT


      *    BILLING RULE 1
      *    Usage <= 500: $0.50 per unit

           EVALUATE TRUE

               WHEN WS-USAGE-UNITS <= 500

                   MOVE 0.50
                       TO WS-RATE


      *    BILLING RULE 2
      *    Usage 501-1000: $0.45 per unit

               WHEN WS-USAGE-UNITS <= 1000

                   MOVE 0.45
                       TO WS-RATE


      *    BILLING RULE 3
      *    Usage > 1000: $0.40 per unit

               WHEN OTHER

                   MOVE 0.40
                       TO WS-RATE

           END-EVALUATE


      *    Calculate basic usage charge

           COMPUTE WS-USAGE-CHARGE =
               WS-USAGE-UNITS * WS-RATE


      *    BILLING RULE 4
      *    Usage above 1000 receives 10% discount

           IF WS-USAGE-UNITS > WS-VOLUME-THRESHOLD

               COMPUTE WS-DISCOUNT =
                   WS-USAGE-CHARGE *
                   WS-VOLUME-DISCOUNT-RATE

           END-IF


      *    BILLING RULE 5
      *    Premium customers receive additional 5% discount

           IF CUST-TYPE = "PREMIUM"

               COMPUTE WS-DISCOUNT =
                   WS-DISCOUNT +
                   (WS-USAGE-CHARGE *
                    WS-PREMIUM-DISCOUNT-RATE)

           END-IF


      *    BILLING RULE 6
      *    Minimum taxable amount is $25

           IF WS-USAGE-CHARGE - WS-DISCOUNT
              < WS-MINIMUM-CHARGE

               MOVE WS-MINIMUM-CHARGE
                   TO WS-TAXABLE-AMOUNT

           ELSE

               COMPUTE WS-TAXABLE-AMOUNT =
                   WS-USAGE-CHARGE -
                   WS-DISCOUNT

           END-IF


      *    BILLING RULE 7
      *    Apply customer tax rate

           COMPUTE WS-TAX =
               WS-TAXABLE-AMOUNT *
               CUST-TAX-RATE


      *    BILLING RULE 8
      *    Add previous balance

           COMPUTE WS-FINAL-AMOUNT =
               WS-TAXABLE-AMOUNT +
               WS-TAX +
               CUST-PREV-BALANCE.


       GENERATE-INVOICE.

           MOVE SPACES
               TO WS-INVOICE-NUMBER
                  WS-OUTPUT-LINE


      *    Build invoice number

           STRING
               WS-BILLING-MONTH
               DELIMITED BY SIZE
               "-"
               CUST-ID
               DELIMITED BY SIZE
               INTO WS-INVOICE-NUMBER

           END-STRING


      *    Format monetary values for output

           MOVE WS-USAGE-CHARGE
               TO WS-DISPLAY-CHARGE

           MOVE WS-DISCOUNT
               TO WS-DISPLAY-DISCOUNT

           MOVE WS-TAX
               TO WS-DISPLAY-TAX

           MOVE CUST-PREV-BALANCE
               TO WS-DISPLAY-BALANCE

           MOVE WS-FINAL-AMOUNT
               TO WS-DISPLAY-TOTAL


      *    Create pipe-delimited invoice record

           STRING
               WS-INVOICE-NUMBER
               DELIMITED BY SIZE

               "|"

               CUST-ID
               DELIMITED BY SIZE

               "|"

               CUST-NAME
               DELIMITED BY SIZE

               "|"

               WS-USAGE-UNITS
               DELIMITED BY SIZE

               "|"

               WS-DISPLAY-CHARGE
               DELIMITED BY SIZE

               "|"

               WS-DISPLAY-DISCOUNT
               DELIMITED BY SIZE

               "|"

               WS-DISPLAY-TAX
               DELIMITED BY SIZE

               "|"

               WS-DISPLAY-BALANCE
               DELIMITED BY SIZE

               "|"

               WS-DISPLAY-TOTAL
               DELIMITED BY SIZE

               INTO WS-OUTPUT-LINE

           END-STRING


           WRITE INVOICE-RECORD
               FROM WS-OUTPUT-LINE


           DISPLAY
               "INVOICE GENERATED: "
               WS-INVOICE-NUMBER.
