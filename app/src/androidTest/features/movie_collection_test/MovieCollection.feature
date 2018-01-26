Feature: Recycler View is showing

  Scenario: you can see the cardView listing popular movies
    Given I wait for the "MovieCollectionActivity" screen to appear
    Then I should see "Home"

  Scenario: you can go to MovieDescription clicking a item on the list
    Given  I wait for the "MovieCollectionActivity" screen to appear
    When I press view with id "movie"
    Then I should see "Trailer list"