#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: SoundCloud play/pause song

  @PlaySong
  Scenario: Verify that a song can be either paused or playing in SoundCloud
    Given I launch ChromeDriver
    When I open the SoundCloud song URL
    And I click the pause_play button
    Then I verify if the song is either paused or playing
    Then I close the browser
