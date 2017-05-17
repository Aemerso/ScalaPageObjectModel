package Pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by Anthony Emerson on 5/7/2017.
  */
class HomePage(webDriver: WebDriver) {
  //non-traditional getters used for clarity in testing
  def pageTitle: WebElement = return webDriver.findElement(By.cssSelector("#header_logo > a"))
  def loginBtn: WebElement = webDriver.findElement(By.className("login"))
}
