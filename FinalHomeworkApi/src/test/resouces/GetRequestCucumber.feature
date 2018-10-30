Feature: API testing

  Scenario: The user with role OWNER_ADMIN calls web services in order to access owner controller
    Given I have access to perform GET request with username "geo" and password "test123"
    When  I perform GET request to "/owners"
    Then I will have status code "200"

  Scenario:The user with role VET_ADMIN calls web services in order to access owner controller
    Given I have access to perform GET request with username "geovet" and password "string"
    When  I perform GET request to "/owners"
    Then I will have status code "400"

  Scenario: The user with role VET_ADMIN calls web services in order to access vet controller
    Given I have access to perform GET request with username "geovet" and password "string"
    When  I perform GET request to "/vets"
    Then I will have status code "200"

  Scenario: The user with role OWNER_ADMIN calls web services in order to access vet controller
    Given I have access to perform GET request with username "geo" and password "test123"
    When  I perform GET request to "/vets"
    Then I will have status code "400"


  Scenario: The user with role OWNER_ADMIN wants post a new owner
    Given I have access to perform POST request with username "geo" and password "test123"
    When I perform Post request to "/owners"
    Then I will have status code "201"

  Scenario: The user with role Vet_ADMIN want delete a pettype
    Given I have access to perform Delete request with username "geovet" and password "string"
    When I perform a Delete to "/specialties/{specialtyId} "
    Then I will have status code "204"

  Scenario: The user with role Vet_ADMIN wants put a pettype
    Given I have access to perform Put request with username "geovet" and password "string"
    When I perform a Put to "/pettypes/{petTypeId}"
    Then I will have status code "204"



