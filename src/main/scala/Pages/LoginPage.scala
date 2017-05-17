package Pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by Anthony Emerson on 5/7/2017.
  */
class LoginPage(webDriver: WebDriver) {
  //non-traditional getters used for clarity in testing
  def loginForm: WebElement= webDriver.findElement(By.id("login_form"))
  def userEmail: WebElement= webDriver.findElement(By.name("email"))
  def userPasswd: WebElement = webDriver.findElement(By.name("passwd"))
  def submitBtn: WebElement = webDriver.findElement(By.name("SubmitLogin"))

  def login(email: String, passwd: String): Unit = {
    userEmail.sendKeys(email)
    userPasswd.sendKeys(passwd)
    submitBtn.click()
  }
}
