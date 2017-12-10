Feature: tabs on Passengers Main Page

  Background:
    Given the user is on Passengers Main Page

  Scenario: User can search information about available long distance train
    When he fill the form with dates
      |МОСКВА| МИНСК |14|
    And he fill out the form with <from> and <to>
    And he choose some date
    Then ensure an information message about trip

  Scenario Outline: User can search information about available long distance train
    When he go to Base Schedule Of Long Distance Train Page
    And he fill out the form with <from> and <to>
    And he choose some date
    Then ensure an information message about trip
    Examples:
      |from  |to     |
      |МОСКВА| МИНСК |

