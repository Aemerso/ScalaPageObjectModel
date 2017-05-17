import Utilities.{BuildTest, PageContainer, User}
import org.openqa.selenium.WebDriver
import org.scalatest.{BeforeAndAfterAll, FunSpec}

/**
  * Created by Anthony Emerson on 5/7/2017.
  */

class ChangeUserNameTest extends FunSpec with BeforeAndAfterAll {
  var webDriver: WebDriver = _
  var pageContainer: PageContainer = _

  val test: BuildTest = new BuildTest(webDriver)
  val user: User = new User

  /**
    * This test will go to http://automationpractice.com/index.php
    * Verify home page title as My Store
    * Go to sign in page
    * Login to application
    * Verify the correct username
    * Then change the username and verify the change
    */
  override def beforeAll() {
    test.build()
    pageContainer = new PageContainer(test.driver)
  }

  describe("A Test to change the User Name") {
    it("A Home page should have the correct title") {
      assert(pageContainer.homePage().pageTitle.getAttribute("title") == "My Store")
    }
    it("A sign-in page should have a login form") {
      //go to the login page
      pageContainer.homePage().loginBtn.click()
      assert(pageContainer.loginPage().loginForm.isDisplayed)
    }
    it("A user account page should display the correct user name") {
      //login to the user account
      pageContainer.loginPage().login(user.email, user.passwd)
      assert(pageContainer.userAcctPage().activeUser.getText == user.name)
    }
    it("A User information Page should display the user's information") {
      //Go to the user Information Page
      pageContainer.userAcctPage().userInfoBtn.click()
      assert(pageContainer.userInfoPage().updateForm.isDisplayed)
    }
    it("A confirmation message should be displayed when changes are made to the user's information") {
      //Change the user's information
      pageContainer.userInfoPage().fillForm(user.name2, male = false)
      //Save the changes
      pageContainer.userInfoPage().saveBtn.click()
      assert(pageContainer.userInfoPage().confirmationMsg.isDisplayed)
    }
    it("A user account page should reflect recent changes and display the correct user name") {
      //Return to the User Account Page
      pageContainer.userInfoPage().userAcctBtn.click()
      assert(pageContainer.userAcctPage().activeUser.getText == user.name2)
    }
  }

  override def afterAll() {
    //Return user information to the default
    test.resetUser(pageContainer, user.name)
    //Logout and close the browser
    test.quit(pageContainer)
  }
}