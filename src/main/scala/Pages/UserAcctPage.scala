package Pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by Anthony Emerson on 5/7/2017.
  */
class UserAcctPage(webDriver: WebDriver) {
  //non-traditional getters used for clarity in testing
  def activeUser: WebElement = webDriver.findElement(By.cssSelector("div.header_user_info"))
  def userInfoBtn: WebElement = {webDriver.findElement(By.cssSelector("a[href$='identity']"))}
  def logoutBtn: WebElement = {webDriver.findElement(By.cssSelector("a.logout"))}
  def dressesBtn: WebElement = {webDriver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"))}
  def shoppingCartBtn: WebElement = {webDriver.findElement(By.cssSelector("a[href$='order']"))}
}
