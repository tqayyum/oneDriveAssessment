@one-drive-regression @one-drive-login @one-drive-file-upload
Feature: One Drive file upload Feature

  Background:
    Given I am on one drive website homepage

  @one-drive-file-upload-1
  Scenario: Verify that the file did not upload
    When I enter the email address as windsor1drive2018@hotmail.com
    And I enter the password as 1driveTest2018
    And I select Upload option
    And I select Files from the drop down menu
    And I upload a /Users/tqayyum/Desktop/byte.txt file
    Then I verify the following error message Sorry, OneDrive can't upload empty folders or empty files. Please try again.

  @one-drive-file-upload-2
  Scenario: Verify that the file did upload
    When I enter the email address as windsor1drive2018@hotmail.com
    And I enter the password as 1driveTest2018
    And I select Upload option
    And I select Files from the drop down menu
    And I upload a /Users/tqayyum/Desktop/helloworld.txt file
    Then I verify the following success massage Uploaded 1 item to Files

  @one-drive-file-upload-3
  Scenario: Verify metadata matches source file
    When I enter the email address as windsor1drive2018@hotmail.com
    And I enter the password as 1driveTest2018
    And I click on the selected file
    And I click on the info button
    # I am not sure which metadata you want me to pull
    #Then Verify metadata matches source file

  @one-drive-file-upload-4
  Scenario: Verify that the update file does not match the source file
    When I enter the email address as windsor1drive2018@hotmail.com
    And I enter the password as 1driveTest2018
    And I click on the selected file
    And I select Open in Text Editor from the Open drop down menu
    And I enter the follow text, This is a test for one drive!
    And I click on the download link
    Then I verify that/Users/tqayyum/Desktop/helloworld.txt file does not match /Users/tqayyum/Desktop/helloworld.txt.crdownload file

  @one-drive-file-upload-5
  Scenario: Verify that the file is deleted
    When I enter the email address as windsor1drive2018@hotmail.com
    And I enter the password as 1driveTest2018
    And I right-click on the selected file
    And I select delete for the menu option
    Then I verify the delete message Deleted 1 item from Files