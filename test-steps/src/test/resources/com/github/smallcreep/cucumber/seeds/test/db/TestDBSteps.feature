@db
Feature: Test DB steps

  Scenario: Test Connection
    Given The connection to the master database

  @inprogress
  Scenario: Test Insert rows
    Given The connection to the master database
    When There is row in the table public.test:
      | iid | id              | title                               | value              | md5                             |
      | 1   | #Random#Integer | #Random#String#With(#Timestamp#now) | #Random#String(10) | #Encryption#Md5(#Random#String) |