Feature: Inscriptions budgetaires


  Scenario Outline: Annuler la modification de la configuration des IB sans saisir de modifications
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>
    And user selects tab <tab>
    And user selects sub tab <subTab>
    And user clicks on the link <link>
    Then user clicks on cancel button
    And user verifies the snackbar warning message <message>

    Examples:
      | name                                     | password              | pageTitle | tab    | subTab         | link                                             | message |
      | charafeddine.lakhdar@berger-levrault.com |Mb!vCLSK84W8!!f| Avenir GF | Budget | Plus d'entrées | DeliberationInscriptionBudgetaireFicheFormulaire |Absence de données à annuler|



  Scenario Outline: Annuler la modification de la configuration des IB
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>
    And user selects tab <tab>
    And user selects sub tab <subTab>
    And user clicks on the link <link>
    And user checks the PEC checkbox
    Then user clicks on cancel button
    And user verifies that the PEC checkbox is unchecked

    Examples:
      | name                                     | password              | pageTitle | tab    | subTab         | link                                             | message |
      | charafeddine.lakhdar@berger-levrault.com |Mb!vCLSK84W8!!f| Avenir GF |Budget| Plus d'entrées | DeliberationInscriptionBudgetaireFicheFormulaire |Absence de données à annule|


  Scenario Outline: Créer mandat
    Given I landed on Sign In Page
    When Logged in with username <name> and password <password>
    Then user is in homepage and verify the page title <pageTitle>
    And user selects tab <tab>
    And user selects sub tab <subTab>
    And user clicks on the link <link>
    And user clicks on Create button
    And user enters the signature date <date>

    Examples:
      | name                                     | password        | pageTitle | tab          | subTab         | link                   | date                        |
      | charafeddine.lakhdar@berger-levrault.com | Mb!vCLSK84W8!!f | Avenir GF | Organisation | Plus d'entrées | Mandats de prélèvement |01/01/2017|

