Feature: Data Inputs
  @tag
 Scenario Outline: Testing different data inputs

   Given The user has been directed to the details dashboard
   When What is your name <name>
   Then Confirm the name

   Examples:
   |name|
   |Zwivhuya|
   |Lucky   |
   |Khoza   |
