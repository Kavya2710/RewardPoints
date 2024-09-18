Retailer offers a reward program to its customers, awarding points base on each recorded purchase. Need to calculate the points earned for each month and total 

The code is written on Springboot framework with MVC architecture 

RewardSystemApplication.java : the entry point of teh SpringBoot application 
RewardController.java : Controller to get rewars and calculate rewar points 
Entities: 
Customer.java- represents customer entity 
CustomerTransaction.java- represents customer transaction 
entity RewardPoints.java- represents a reward entity 
Repositories: 
CustomerTransactionRepository.java-Repository for customer transaction 
RewardPointsRepository.java- Repository for reward point oprations 
Services: RewardService.java- Contains bussiness logic for calculating reward points 
Exception Handling: 
GlobalExceptionHandler.java- Handles exception globally 
ApiError.java- Represents the sturcture of error responses 
Configuration: Application.properties- Configuration details for Springboot application 
Tests: RewardSystemApplicationTests.java- Unit test cases for reward calculation logic
