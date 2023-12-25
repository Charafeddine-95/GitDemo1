Feature: Comptes


  Scenario Outline: Search for a key word in the search field
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>
    And user selects tab <tab>
    And user selects sub tab <subTab>
    Then user types the key word in the search field <keyWord>
    And user verifies that key word is present in all results <keyWord>
    Examples:
      | name                                     | password              | pageTitle | tab          | subTab  | keyWord | vertical |
      | charafeddine.lakhdar@berger-levrault.com |Mb!vCLSK84W8!!f| Avenir GF | Organisation | Comptes |GFP| Comptes  |