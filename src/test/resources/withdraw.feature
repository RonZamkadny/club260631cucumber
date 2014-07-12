Feature: Withdraw
  Scenario: Withdraw money from User's account should subtract money from User's current balance
    Given у пользователя изначально нет денег на счете
    When будет зачислено £12.7
    Then вывести со счета £12.7
    Then баланс должен стать £0.0
