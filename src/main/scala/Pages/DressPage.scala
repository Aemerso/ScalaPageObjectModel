package Pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

/**
  * Created by Anthony Emerson on 5/13/2017.
  */
class DressPage(webDriver: WebDriver) {
  //non-traditional getters used for clarity in testing
  private def addToCartPopUp = webDriver.findElement(By.id("layer_cart"))
  def categoryHeader: WebElement = webDriver.findElement(By.cssSelector("span.category-name"))
  def addDressNumber6: WebElement = webDriver.findElement(By.cssSelector("a[href*=" + "'cart&add=1&id_product=6']"))
  def shoppingCartBtn: WebElement = webDriver.findElement(By.cssSelector("a[href$='order']"))
  def addToCartPopUpMessage: WebElement = addToCartPopUp.findElement(By.cssSelector("#layer_cart > div.clearfix >"
    + " div.layer_cart_product.col-xs-12.col-md-6 > h2"))
  def closeAddToCartPopUp: WebElement = addToCartPopUp.findElement(By.cssSelector("span.cross"))
  def waitForPopUp(): Unit = {
    val wait: WebDriverWait = new WebDriverWait(webDriver, 10)
    wait.until(ExpectedConditions.visibilityOf(addToCartPopUp))
  }
}