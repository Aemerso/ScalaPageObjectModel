package Pages

import Utilities.User
import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by Anthony Emerson on 5/13/2017.
  */
class UserInfoPage(webDriver: WebDriver) {
  private val _user = new User

  //non-traditional getters used for clarity in testing
  private def mrBtn = webDriver.findElement(By.id("uniform-id_gender1"))
  private def mrsBtn = webDriver.findElement(By.id("uniform-id_gender2"))
  private def firstNameField = webDriver.findElement(By.id("firstname"))
  private def lastNameField = webDriver.findElement(By.id("lastname"))
  private def passwdField = webDriver.findElement(By.id("old_passwd"))

  def updateForm: WebElement = webDriver.findElement(By.id("center_column"))
  def saveBtn: WebElement = webDriver.findElement(By.name("submitIdentity"))
  def confirmationMsg: WebElement = webDriver.findElement(By.cssSelector("p.alert.alert-success"))
  def userAcctBtn: WebElement = webDriver.findElement(By.cssSelector("a[href$='my-account']"))

  def fillForm(userName: String, male: Boolean): Unit = {
    if (male) mrBtn.click()
    else mrsBtn.click()
    this.firstNameField.clear()
    this.firstNameField.sendKeys(userName.substring(0, userName.indexOf(" ")))
    this.lastNameField.clear()
    this.lastNameField.sendKeys(userName.substring(userName.indexOf(" ") + 1))
    this.passwdField.sendKeys(_user.passwd)
  }
}
