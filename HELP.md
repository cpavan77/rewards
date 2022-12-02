# Getting Started

1. Open the project in your favorite Tool (IntelliJ or Eclipse)
2. Run the Springboot application. (RetailerRewardsApplication)
3. After making sure the server started fine, access the below REST end point- http://localhost:8080/customer-rewards/10
4. The above endpoint returns rewards summary of last 3 months for the given customer id -> 10
5. The test data for this customer is loaded through data.sql
6. RewardsCalculator.java file is the place where the rewards' calculation occurs, and there is also unit test (
   RewardsCalculatorTest.java) added for it.