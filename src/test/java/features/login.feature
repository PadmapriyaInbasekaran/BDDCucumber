Feature: Verify Login page
@smoke              #conditional Hooks
Scenario Outline: Verify amazon login page with valid credentials

  Given : Open amazon.com
  When : Enter <username>, <password> and click login
  Then : Amazon homepage is visible
  Examples:
    |username  |password |
    |xyz       |12315    |
    |abc       |45895    |

