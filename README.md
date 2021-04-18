# Chootay-Arsalan
A management system for a bike/spare-parts shop built using microservices architecture.

# Project Description
Chootay Bikes is a new bike shop located in suburb of Islamabad, not far from Bara-Kahu. It has been open for only two months, and business is growing steadily. Chootay, the shop's owner, has been conducting his daily
business on paper. He records sales on preprinted forms, maintains employee and vendor information on sheets of paper (storing them in manila folders), and writes information about his regular customers on index cards. As
a result, chootay spends a lot of time maintaining all this data. He owns a computer but uses it mainly to play games, write letters, and visit various golf sites. The only business-related task he performs on the computer is
keeping track of the bike shop's inventory using a spreadsheet program.
You have been hired as a consultant for the project. You need to design the database along with system to manage the business. Following information need to be stored in the system:
1. Manage various accounts with access levels.
a. Chootay admin account with all rights.
b. Salesperson account for entering sales data into the system during transaction.
c. Accounts manager for managing accounts and generating sales – purchases report.
d. Mechanic account to add details of bike that came for repair to generate repair report from system.
2. Store all inventory information into the system, i.e., Bikes records, spare parts records along with inventory
status and cost of purchases.
3. Store sales transaction information into the system.
4. Store bikes repair reports into the system along with bill for repair.
5. Add customer information during sales.
6. Store customer address to share discount details in future.

# Operations
1. Add new account with speci􀁏ed group role. (Made possible by Admin Authentication Service)
2. Inventory management for bikes and spare parts (all CRUD operations).
3. Add repair report into the system along with cost. (Refer to Repair Report Service)
4. Generate daily and monthly sales report. (Functionality in Sales service)

# Technologies
a. Spring Boot
b. Sprint Security.
c. Java SDK 1.8.
