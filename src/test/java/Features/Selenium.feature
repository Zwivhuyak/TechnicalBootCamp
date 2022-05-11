Feature: Run Selenium Script in AWS or Local
@selenium
  Scenario Outline: Excute your code

    Given that you have the configuration of the following environment : <Environment>
    When you chose the following browser : <Browser>
    And when you navigate to the following url : <url>
    Then assert the web title <Expected Title>

    Examples:
    |Environment|Browser|url|Expected Title|
    |grid |chrome |https://www.twitter.com/|Twitter. It’s what’s happening / Twitter|
