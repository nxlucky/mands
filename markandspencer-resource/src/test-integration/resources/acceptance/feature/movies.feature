Feature: Marks and spencer online movie store
  as an application I want users to buy movies
  and stream them. For unregistered users, they can
  only view purchased movies for a month

  @wip
  Scenario: Registered user lists all his collection
    Given that a registered user has a userId "barry"
    And the registered user had purchased a total of 10 movies
    When the user lists his movie catalogues
    Then there should be a total of 10 movies in his catalogue

  @wip
  Scenario: Regular user lists all his collection
    Given that a regular user has a cookie value of "cookievalue"
    And the regular user had purchased a total of 10 movies
    When the user lists his movie catalogues
    Then there should be a total of 10 movies in his catalogue
