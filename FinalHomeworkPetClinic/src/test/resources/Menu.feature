Feature: Add new Owners page
  Scenario: The users can access the menu in the PetClinic site
    Given I go on the PetClinic site
    When The user click on the Home button if var is one or click on the springTab if var is zero , var= "0"
    Then The home page is displayed

  Scenario: The user press the Owners button
    Given I go on the PetClinic site
    When  The user click on the Owners button
    Then A dropdown list appears for owners

  Scenario: The user press the veterinarians button
    Given I go on the PetClinic site
    When  The user click on the Veterinarians button
    Then A dropdown list appears for veterinarians

  Scenario: The user press the petclinic button
    Given I go on the PetClinic site
    When The user click on the Pet Types button
    Then The pet type page is displayed

  Scenario: The user press the specialities button
    Given I go on the PetClinic site
    When  The user click on the Specialities button
    Then  The Specialities page is displayed




