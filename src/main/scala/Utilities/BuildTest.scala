package Utilities

import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebDriver

/**
  * Created by Anthony Emerson on 5/7/2017.
  */
class BuildTest(webDriver: WebDriver) {
  private val website = "http://automationpractice.com/index.php"
  var driver: WebDriver = webDriver
  def build(): Unit = {
    //Use this method when using the Firefox browser
    //driver = buildWebDriver.buildFirefoxDriver

    //Use this method when using the Chrome browser
    driver = BuildWebDriver.buildChromeDriver

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.get(website)
  }

  //cleans up test data and reverts to original values
  def resetUser(pages: PageContainer, user: String): Unit = {
    pages.userAcctPage().userInfoBtn.click()
    pages.userInfoPage().fillForm(user, male = true)
    pages.userInfoPage().saveBtn.click()
  }
  //logs out and closes the browser
  def quit(pages: PageContainer): Unit = {
    pages.userAcctPage().logoutBtn.click()
    driver.close()
  }
}