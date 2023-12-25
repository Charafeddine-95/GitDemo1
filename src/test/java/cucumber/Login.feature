Feature: Login

  Scenario Outline: login to the application
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>

    Examples:
      | name  | password | pageTitle                          |
      | charafeddine.lakhdar@berger-levrault.com |Mb!vCLSK84W8!!f| Avenir GF |

  Scenario Outline: login to the application with incorrect credentials
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then login fails and the error message is displayed <errorMessage>


    Examples:
      | name  | password | errorMessage                                 |
      | wingt | wingt    | Nom d'utilisateur ou mot de passe non valide |

  Scenario Outline: select tab
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>
    And user selects tab <tab>
    And user selects sub tab <subTab>
   # And user selects the second sub tab <subTab2>
    #And user chooses the vertical <vertical>

    Examples:
      | name  | password | pageTitle                          | tab           | subTab   | subTab2      | vertical |
      | charafeddine.lakhdar@berger-levrault.com | 5DOvOw5q486RSxyhFweN_    | Avenir GF | Organisation | Comptes | Organisation | Comptes |

  Scenario Outline: Filter
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>
    And user selects tab <tab>
    And user chooses the vertical <vertical>
    And user enters the id in the corporate filter <corporateId>
    And user clicks on search button
    Then verify the result <corporateId>
    Examples:
      | name  | password | pageTitle                          | tab           | vertical | corporateId |
      | wingt | wingt    | BL.página de Selección de Terceros | Mantenimiento | SicalWeb | 107         |
