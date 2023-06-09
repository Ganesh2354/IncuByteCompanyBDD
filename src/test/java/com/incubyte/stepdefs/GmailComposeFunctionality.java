package com.incubyte.stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.incubyte.utils.Constants;
import com.incubyte.utils.SeleniumWaits;
import com.incubyte.utils.TakesScreenShot;
import com.incubyte.utils.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailComposeFunctionality {
	
	// Please run the feature file as Cucumber Feature
	
	
	WebDriver driver;
	
	@Given("I choose to launch the url")
	public void i_choose_to_launch_the_url() {
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://mail.google.com/");
		   TakesScreenShot.getScreenshot(driver, "Gmail Login page");
		   try {
		   Thread.sleep(30000);
		   }catch(Exception e)
		   {
			   System.out.println(e.getMessage());
		   }
		   
	}

	@Then("I choose to sign in to gmail")
	public void i_choose_to_sign_in_to_gmail() {
		System.out.println("I am manually logging in");
		//To complete the execution I am logging in with my acc.
		TakesScreenShot.getScreenshot(driver, "manual login");;
	}

	@Then("I choose to verify the GMail logo on top left")
	public void i_choose_to_verify_the_g_mail_logo_on_top_left() {
		try {
			
			WebElement gmailLogo=SeleniumWaits.waitForVisibiltyOfElement(driver, Constants.gmailLogoImg);
			boolean logodisplayed=gmailLogo.isDisplayed();
			Assert.assertTrue("Gmail Logo is located but not displayed.", logodisplayed);
			TakesScreenShot.getScreenshot(driver, "Passed-i_choose_to_verify_the_g_mail_logo_on_top_left");
			
		}catch(Exception e)
		{
			
			System.out.println("Gmail Logo is not visible. Exception - "+e.getMessage());
			TakesScreenShot.getScreenshot(driver, "Failed-i_choose_to_verify_the_g_mail_logo_on_top_left");
			
		}
	}

	@Then("I chose Verify that the Compose button is present and clickable.")
	public void i_chose_verify_that_the_compose_button_is_present_and_clickable() {
		WebElement composeBtn=SeleniumWaits.waitForElementToBeClickable(driver, Constants.composeButton);
		if(composeBtn.isDisplayed() && composeBtn.isEnabled())
		{
			System.out.println("Compose button is verified");
			TakesScreenShot.getScreenshot(driver, "Pass-Compose button verification");
		}else {
			Assert.fail("Compose button is either not displayed or not enable");
			TakesScreenShot.getScreenshot(driver, "Fail-Compose button verification");
		}
		
	}

	@Then("I choose to Click on the Compose button and verify that the compose window opens.")
	public void i_choose_to_click_on_the_compose_button_and_verify_that_the_compose_window_opens() {
		WebElement composeBtn=SeleniumWaits.waitForElementToBeClickable(driver, Constants.composeButton);
		composeBtn.click();
		WebElement newMessageHeader=SeleniumWaits.waitForVisibiltyOfElement(driver, Constants.newMessagePopupHdr);
		boolean flag=newMessageHeader.isDisplayed();
		if(flag==false)
		{
			TakesScreenShot.getScreenshot(driver, "Fail-New Message Header");
		}
		Assert.assertTrue("New Message Header popup is not displayed.",flag);
		TakesScreenShot.getScreenshot(driver, "Pass-New Message Header");
		
	}

	@Then("I choose to Verify that the compose window contains the necessary fields like To, Cc, Bcc, Subject, and Message Body")
	public void i_choose_to_verify_that_the_compose_window_contains_the_necessary_fields_like_to_cc_bcc_subject_and_message_body() {
//		List<WebElement> toTxtField=SeleniumWaits.waitForVisibiltyOfAllElement(driver, Constants.toField);
		boolean toFiledValue=Utilities.areElementDisplayed(driver, Constants.toField);
		boolean ccFiledValue=Utilities.areElementDisplayed(driver, Constants.ccField);
		boolean bccFiledValue=Utilities.areElementDisplayed(driver, Constants.bccField);
		
		if(toFiledValue==true && ccFiledValue==true && bccFiledValue==true)
		{
			System.out.println("All necessary field are present");
			TakesScreenShot.getScreenshot(driver, "All necessary fields");
		}else {
			Assert.fail();
		}	
	}

	@Then("I choose to send an email without entering a recipient.")
	public void i_choose_to_send_an_email_without_entering_a_recipient() {
		Utilities.areElementDisplayed(driver, Constants.sendBtn);
		System.out.println("clicked on send");
	}

	@Then("I choose to Verify that an appropriate error message is displayed.")
	public void i_choose_to_verify_that_an_appropriate_error_message_is_displayed() {
		WebElement errorPopUp=SeleniumWaits.waitForElementPresent(driver, Constants.errorPopup);
		Assert.assertTrue("Error popup not displayed", errorPopUp.isDisplayed());
		TakesScreenShot.getScreenshot(driver, "Empty Recepient");
		WebElement errorPopUpOkBtn=SeleniumWaits.waitForElementPresent(driver, Constants.errorPopupOkBtn);
		errorPopUpOkBtn.click();
	}

	@Then("I coose to send an email without entering a subject.")
	public void i_coose_to_send_an_email_without_entering_a_subject() {
		Utilities.areElementDisplayed(driver, Constants.sendBtn);
		System.out.println("clicked on send with empty subject");
	}

	@Then("Verify that an appropriate error message is displayed when no subject")
	public void verify_that_an_appropriate_error_message_is_displayed_when_no_subject() {
		Alert alert=driver.switchTo().alert();
		String alertmsg="Send this message without a subject or text in the body?";
		String actAlrtMsg=alert.getText();
		Assert.assertTrue("Expected Message is:"+alertmsg+" but actual is : "+actAlrtMsg, false);
		TakesScreenShot.getScreenshot(driver, "Empty Empty Subject");
		alert.dismiss();
		
	}

	@Then("I choose to Enter valid email addresses in the To")
	public void i_choose_to_enter_valid_email_addresses_in_the_to() {
		Utilities.clickFromListOfElementsAndSendValue(driver, Constants.toTxtField, "ganeshdandekar54@gmail.com");
		System.out.println("Recipient Email entered");
		TakesScreenShot.getScreenshot(driver, "Recipient Email entered");
	}

	@Then("I choose to Enter a subject in the Subject field.")
	public void i_choose_to_enter_a_subject_in_the_subject_field() {
		Utilities.clickFromListOfElementsAndSendValue(driver, Constants.subjectTxtField, "Incubyte Deliverables:1");
		System.out.println("Subject line is entered");
		TakesScreenShot.getScreenshot(driver, "Subject line entered");
	}

	@Then("I choose to Enter a message in the Message Body field.")
	public void i_choose_to_enter_a_message_in_the_message_body_field() {
		Utilities.clickFromListOfElementsAndSendValue(driver, Constants.msgBodyField, "Automation QA test for Incubyte");
		System.out.println("Message is entered in the Message Body field.");
		TakesScreenShot.getScreenshot(driver, "Messge entered");
	}

	@Then("I choose to Click on the Send button and verify that the email is sent successfully.")
	public void i_choose_to_click_on_the_send_button_and_verify_that_the_email_is_sent_successfully() {
		Utilities.areElementDisplayed(driver, Constants.sendBtn);
		System.out.println("clicked on send");
		TakesScreenShot.getScreenshot(driver, "Message send");
		try {
			Thread.sleep(10000);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
