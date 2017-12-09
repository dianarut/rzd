Feature: Base Schedule Of Long Distance Trains Page
         As a logged in user
         I want to find an information about available trip
         on Base Schedule Of Long Distance Trains Page
         so that I can see information message about trip
# I'll add one more scenario to using of Backgroung had been justified
Background: Given the user is on Passengers Main Page
Scenario Outline: User can search information about available long distance trains
          When he go to Base Schedule Of Long Distance Trains Page
          And he fill out the form with <from> and <to>
          And he choose some date
          Then ensure an information message about trip
Examples:
    |from  |to     |
    |Москва| Минск |
    |Минск | Москва|