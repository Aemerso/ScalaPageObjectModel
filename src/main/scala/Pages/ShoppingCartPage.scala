package Pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

/**
  * Created by Anthony Emerson on 5/13/2017.
  */
class ShoppingCartPage(webDriver: WebDriver) {
  //non-traditional getters used for clarity in testing
  def emptyCartAlert: WebElement = webDriver.findElement(By.cssSelector("p.alert.alert-warning"))
  def userInfoBtn: WebElement = webDriver.findElement(By.cssSelector("a[href$='identity']"))
  def deleteBtn: WebElement = webDriver.findElement(By.cssSelector("a.cart_quantity_delete"))

  def waitForDeleteBtn(): Unit = {
    val wait: WebDriverWait = new WebDriverWait(webDriver, 10)
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.icon-trash")))
  }
  def waitForAlert(): Unit = {
    val wait: WebDriverWait = new WebDriverWait(webDriver, 10)
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("p.alert.alert-" +
      "warning"), "empty"))
  }
}