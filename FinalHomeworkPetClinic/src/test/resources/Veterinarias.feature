Feature:
  Scenario: The user introduces a new vet and checks if the new vet has been added
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And The user enters the first name field "NewVetF" in the last name field "NewVetL" and chooses as type "surgery"
    Then The user clicks the Save Vet button
    And The user checks if the new vet "NewVetF NewVetL" has been added

  Scenario: The user edit a new vet and delete
      Given The user accesses the petclinic site
      When The user goes to the page of adding all vets
      And The user clicks on the edit button for "NewVetF NewVetL"
      And The user edit the new vet with "UpdateNewVet", "UpdateNewVet", and "radiology"
      And  The user clicks the Save Vet button for update
      Then The user checks if the new vet "UpdateNewVet UpdateNewVet" has been added
      And The user can click on the delete button for new vet with name "UpdateNewVet UpdateNewVet"


  Scenario: The user checks if an error message appears when a single character is entered in the first name field
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And The user enters the first name field "N" in the last name field "NewVetL" and chooses as type "radiology"
    Then The error message is displayed for first name field

  Scenario:The user checks if an error message appears when a single character is entered in the last name field
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And  The user enters the first name field "NewVetF" in the last name field "N" and chooses as type "radiology"
    Then The error message is displayed for last name field

  Scenario: The user clicks the Save Vet button when the first name field is empty
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And The user enters the first name field "" in the last name field "New" and chooses as type "radiology"
    And The user click on the Save Vet button
    Then The user remains on the add-on page of the new vet because nothing happens

  Scenario: The user clicks the Save Vet button when the last name field is empty
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And The user enters the first name field "NewVetF" in the last name field "" and chooses as type "radiology"
    And The user click on the Save Vet button
    Then The user remains on the add-on page of the new vet because nothing happens

  Scenario: The user clicks the Save Vet button when the type field is empty
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And  The user enters the first name field "NewL" in the last name field "NewF" and chooses as type ""
    And  The user clicks the Save Vet button
    Then The user checks if the new vet "NewL NewF" has been added

  Scenario: The user clicks the save vet button when the fields are all empty
    Given The user accesses the petclinic site
    When The user goes to the page of adding a new vet
    And The user clicks the Save Vet button
    Then The user remains on the add-on page of the new vet because nothing happens





