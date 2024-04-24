#Author: Joseph


   # Background: User launches chrome browser
   #   Given Customer is launching the browser
#@Sanity
 # Scenario: Verify user is able to login
  #  Given customer launches mobile app
Feature: Login
  @validLoginNigeria @sanityNigeriaFlour @joseph @Sanity
  Scenario Outline: To Verify if a user is able to login into the app with valid credentials
    When Enter the UserID and Password "<UserID>""<Password>""<Country>""<login type>"
    Examples:
      | UserID     | Password  | Country | login type |
 #   | 9788490856 | Olam1234$ | Nigeria | valid      |
 # | 9489113660 | Olam1234$ | Nigeria | valid      |
      | 8033654486 | Nigeriacfm@2023 | Nigeria-CFM | valid      |