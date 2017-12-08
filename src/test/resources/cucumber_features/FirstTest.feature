Feature: Base Schedule Of Long Distance Trains Page
         As a logged in user
         I want to find an information about available trip
         on Base Schedule Of Long Distance Trains Page
         so that I can see information message about trip
Scenario: positive test
          Given the user is on Passengers Main Page
          When he go to Base Schedule Of Long Distance Trains Page
          And he fill out the form with МОСКВА and МИНСК
          And he choose some date
          Then ensure an information message about trip