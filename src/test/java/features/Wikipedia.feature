Feature: Tests wikipedia
    This is a test for the wikipedia page

    Scenario Outline: Test wikipedia in english
    Given I open wikipedia
    When I search <articleName>
    Then I should see <articleTitle> in the title

    Examples:
        | articleName | articleTitle |
        | "France" | "France" |
        | "h2o" | "Properties of water" |