Feature: One

  Scenario Outline: Hello world
    Given I kill thread if <value> is more than 20

    Examples:
      | value |
      | 10    |
      | 15    |
      | 22    |
      | 30    |
      | 44    |
      | 565   |
