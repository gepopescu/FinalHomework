Feature:
  Scenario:  AddNewOwner
    Given I can navigate to petclinic site
    When  I complete the required fields as firstName "Alin",lastName "Ion", address "TestAd",city "city",telephone "073255556565"
    Then  The Add new button is active and the user press it
    And   The new owner with first name "Alin" and last name "Ion" is present

  Scenario: Error message for the telephone field
    Given I can navigate to petclinic site
    When  I complete the required fields as firstName "Alin",lastName "Ion", address "TestAd",city "city",telephone "AAA"
    Then  The message error is displayed
    And Add New button is inactive

  Scenario: Click on add New button when the fields are empty
    Given I can navigate to petclinic site
    When I navigate in the add new owner page
    Then Add New button is inactive

  Scenario: In the First Name field the user write one character
    Given I can navigate to petclinic site
    When  I complete the required fields as firstName "A",lastName "Ion", address "TestAd",city "city",telephone "073255556565"
    Then The message error is displayed for the First name field
    And Add New button is inactive

  Scenario: In the Last Name field the user write one character
    Given I can navigate to petclinic site
    When  I complete the required fields as firstName "Alin",lastName "I", address "TestAd",city "city",telephone "073255556565"
    Then The message error is displayed for the Last Name name field
    And Add New button is inactive

  Scenario:Add a new owner when one of the fields is empty
    Given I can navigate to petclinic site
    When  I complete the required fields as firstName "",lastName "Ion", address "TestAd",city "city",telephone "073255556565"
    Then Add New button is inactive

  Scenario: Check if the owner has a pet
    Given I can navigate to petclinic site
    When The user go to the all owners page
    And Check if a specific owner "Carlos Estaban" has a pet
    Then Is displayed if the owner "Carlos Estaban" has a pet
