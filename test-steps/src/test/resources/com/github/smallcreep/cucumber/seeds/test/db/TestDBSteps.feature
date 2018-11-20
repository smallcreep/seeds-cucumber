@db
Feature: Test DB steps

  Scenario: Test Insert rows
    Given The connection to the master database
    Given There is row in the table public.test:
      | iid | id             | title                        | value              | md5                             |
      | 1   | #Random#Serial | #Random#String#Timestamp#Now | #Random#String(10) | #Encryption#Md5(#Random#String) |
    When There is row in the table public.test:
      | iid | id             | title                                                     | value              | md5                                       |
      | 2   | #Random#Serial | #Scenario#Storage#public.test#iid=1(value)$#Timestamp#Now | #Random#String(10) | #Scenario#Storage#public.test#iid=1(md5)$ |