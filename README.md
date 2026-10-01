# Step_semester_3

## Week 6 — Category B: OOP and Polymorphism

Solutions are separated by problem because Problems 1–5 intentionally reuse class names such as GymMember and PremiumMember.

- problem6/problem1/ — Gym Membership Foundation & Batch Trial Sign-up Validator
- problem6/problem2/ — Three Tiers of Gym Membership
- problem6/problem3/ — Premium Loyalty Discount & Late-Fee Ledger
- problem6/problem4/ — Monthly Attendance Announcer
- problem6/problem5/ — Membership Numbers, Referral Codes & Weekly Check-in Settlement

### Coverage

- Single, multilevel and hierarchical inheritance
- Method overriding, @Override and super
- Runtime polymorphism
- instanceof and safe downcasting
- Exception handling and constructor validation
- Defensive copying for late-fee history
- Method overloading with code reuse
- Static counter and final membership numbers
- Character-based referral-code validation
- Null-safe batch processing and weekly check-ins

The five problems were reviewed independently against the assignment requirements and supplied examples.

## Week 7 — Category B: Abstraction & Interfaces

- problem7/problem1/ — Morning Wake-Up Circuit (Ringable interface)
- problem7/problem2/ — Gallery Description Cards (abstract ArtPiece)
- problem7/problem3/ — Backyard Toolshed Routine (multilevel abstraction)
- problem7/problem4/ — Digital Classroom Setup (abstract class + overloaded interface methods)
- problem7/problem5/ — Skyline Delivery Fleet (abstract Drone + Trackable interface)

### Week 7 specification note

Problem 3 requires GardenTool.use() to be abstract while also requiring CuttingTool.use() to call super.use(). In Java, an abstract method cannot be invoked with super.use(). The implementation therefore uses a private base-message helper in CuttingTool so the required output and inheritance structure remain usable and compilable, while Pruner reuses CuttingTool.use() through super.use().

## Week 8 — Category B: Coding Assignment

- problem8/problem1/ — Hostel Laundry Queue
- problem8/problem2/ — Assignment Submission Portal
- problem8/problem3/ — Campus Premiere Ticket Counter
- problem8/problem4/ — FitZone Membership Desk
- problem8/problem5/ — Campus Notice Broadcaster

The solutions use interfaces/abstract classes for extensible rules, encapsulate state changes inside domain classes, and follow the sample workflows and constraints in the Week 8 assignment.

## Week 4 Practice Problems

- problem4/practice1/ — Library Book Cataloguing
- problem4/practice2/ — Payroll Batch Bonus Round
- problem4/practice3/ — Late Fees — Skip the On-Time Accounts
- problem4/practice4/ — One-Time College Setup, Many Students
- problem4/practice5/ — Account Batch Payments
