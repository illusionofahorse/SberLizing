Feature: SberLizing
Background:
  Given user navigates to search website
  When user typed "СберЛизинг" in the search field
  Then user navigated to 'СберЛизинг' website


  @SberLizingTestCase
Scenario: user picking up the car by parameters

  Given user picked up the car by parameters
  When user pressed show all suggestions
  When user chose a car from the list
  Then selected car has the same brand that presented in list




