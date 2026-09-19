# Step_semester_3

## Week 6 — Category B: Access Modifiers, Encapsulation & Object Modeling

Solutions are separated by problem because Problems 1 and 4 intentionally use the same class name (LibraryMember), while Problems 1 and 2 intentionally use the same utility class name (AccessChecker).

- problem1/ — Membership Field Reach Checker
- problem2/ — Reference Desk Subclass Reach
- problem3/ — Book Copy Circulation Guard
- problem4/ — LibraryMember JavaBean & Security Answer Property
- problem5/ — Immutable Loan Receipt & Nightly Circulation Ledger

### Problem 5 specification conflict

The supplied assignment requires both:
1. LoanReceipt to be final, and
2. ReferenceOnlyLoanReceipt extends LoanReceipt.

Those requirements cannot both compile in Java because a final class cannot be subclassed. The implementation keeps LoanReceipt immutable with final fields and defensive copying, while leaving the class non-final so the explicitly required subclass and instanceof processing can compile.

The Java files were compiled independently per problem and the supplied examples were smoke-tested.