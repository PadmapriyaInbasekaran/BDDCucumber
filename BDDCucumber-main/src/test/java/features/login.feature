Feature: Verify Login page
#@smoke              #conditional Hooks
#Scenario Outline: Verify amazon login page with valid credentials

#  Given : Open amazon.com
#  When : Enter <username>, <password> and click login
#  Then : Amazon homepage is visible
#  Examples:
#    |username  |password |
#    |xyz       |12315    |
#    |abc       |45895    |

  Scenario Outline: Verify amazon login page with invalid credentials

    Given : Open amazon.com
    When : Enter <mobileNumber> and click login
    Then : Incorrect phone number message should be visible
    Examples:
      | mobileNumber |
      | 123456789    |

  Scenario: Search for mobiles
    Given : Locate the searchbar
    When : Enter required mobile name in the searchbar
    And : click on search
    Then : Results page should be displayed

  Scenario Outline: Add selected product to cart
    Given : click on link
    And : click on deliver to India
    And : Enter <US Zipcode> in the textBox
    And : Click Apply
    And : click continue
    When : Find add to cart button
    And : click
    And : click on No thanks
    Then : Verify item added to cart
    Examples:
      | US Zipcode |
      | 99950      |


  Scenario: Remove items from cart
    Given : click on the cart icon
    When : click delete under the product
    Then : Verify item removed from cart
