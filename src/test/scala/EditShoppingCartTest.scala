import Utilities.{BuildTest, PageContainer, User}
import org.openqa.selenium.WebDriver
import org.scalatest.{BeforeAndAfterAll, FunSpec}

/**
  * Created by Anthony Emerson on 5/13/2017.
  */
class EditShoppingCartTest extends FunSpec with BeforeAndAfterAll{
  var webDriver: WebDriver = _
  var pageContainer: PageContainer = _
  val test: BuildTest = new BuildTest(webDriver)
  val user: User = new User
  /**
    * This test will go to http://automationpractice.com/index.php
    * Login to the site
    * Verify the shopping cart is empty
    * Then add a dress to the cart
    * Verify the success message is displayed
    * Then return to the cart and remove the dress
    * Verify the shopping cart is empty again
    */
  override def beforeAll() {
    test.build()
    pageContainer = new PageContainer(test.driver)
    //Go to the Login page
    pageContainer.homePage().loginBtn.click()
    //Login
    pageContainer.loginPage().login(user.email, user.passwd)
    //Go to the Shopping Cart
    pageContainer.userAcctPage().shoppingCartBtn.click()
  }
  describe("A test to add and remove an item from the shopping cart") {
    it("A shopping cart should be empty when first visiting the site") {
      assert(pageContainer.shoppingCartPage().emptyCartAlert.getText.contains("empty"))
    }
    it("A user account page should display a link to the Dress category") {
      //Go to the user account page
      pageContainer.shoppingCartPage().userInfoBtn.click()
      assert(pageContainer.userAcctPage().dressesBtn.isDisplayed)
    }
    it("A Dress category button should take the user to a page displaying dresses") {
      //Go to the Dress Page
      pageContainer.userAcctPage().dressesBtn.click()
      assert(pageContainer.dressPage().categoryHeader.getText.contains("Dresses"))
    }
    it("A shopping cart should display a confirmation message when items are added") {
      //Add a dress to the cart
      pageContainer.dressPage().addDressNumber6.click()
      //wait for popup message
      pageContainer.dressPage().waitForPopUp()
      assert(pageContainer.dressPage().addToCartPopUpMessage.getText.contains("" + "successfully added"))
    }
    it("An item in a shopping cart should be removable") {
      //close the pop up
      pageContainer.dressPage().closeAddToCartPopUp.click()
      //go to shopping cart
      pageContainer.dressPage().shoppingCartBtn.click()
      //wait for the shopping cart to populate
      pageContainer.shoppingCartPage().waitForDeleteBtn()
      assert(pageContainer.shoppingCartPage().deleteBtn.isDisplayed)
    }
    it("A shopping cart should be empty when items are deleted") {
      //remove the dress from user shopping cart
      pageContainer.shoppingCartPage().deleteBtn.click()
      //wait for the shopping cart alert to appear
      pageContainer.shoppingCartPage().waitForAlert()
      assert(pageContainer.shoppingCartPage().emptyCartAlert.getText.contains("empty"))
    }
  }
  override def afterAll(){
    //Logout and close the browser
    test.quit(pageContainer)
  }
}