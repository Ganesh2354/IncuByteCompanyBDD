Feature: Compose a new email

  Scenario: Verify the ability to compose a new email in Gmail.
    Given I choose to launch the url
    Then I choose to sign in to gmail
    Then I choose to verify the GMail logo on top left
    And I chose Verify that the Compose button is present and clickable.
    Then I choose to Click on the Compose button and verify that the compose window opens.
    And I choose to Verify that the compose window contains the necessary fields like To
    #Error Handling#
    Then I choose to send an email without entering a recipient.
    And I choose to Verify that an appropriate error message is displayed.
    Then I coose to send an email without entering a subject.
    And Verify that an appropriate error message is displayed when no subject
    #Sending An Email#
    Then I choose to Enter valid email addresses in the To.
    And I choose to Enter a subject in the Subject field.
    And I choose to Enter a message in the Message Body field.
    And I choose to Click on the Send button and verify that the email is sent successfully.
    
    # What I Missed Implementing Here  
    # Then I choose to Try to send an email to an addree containing no @gmail.com
    # Then I choose to Verify that an appropriate error message is displayed
    # Then I choose to Try to send an email without entering a message body.
    # Then I choose to  Verify that an empty message will get sent      
    # Then I choose to send an email to a mail id to which the mail can't be delievered
    # And I choose verify if an email saying email can't be delivered
    
    
