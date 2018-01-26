Feature: Movie description is Showing

  @display_movie_collection
  Scenario: Description is displayed
    Given I wait for the "MovieDescriptionActivity" screen to appear
    Then I should see "Trailer list"

  @display_movie_collection
  Scenario: go back to movie collection
    Given I wait for the "MovieDescriptionActivity" screen to appear
    When I go back
    Then I should see "Home"
