package Utilities

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver

/**
  * Created by Anthony Emerson on 5/7/2017.
  */
object BuildWebDriver {
  private val driverPath = "src/main/resources/"

  def buildChromeDriver: WebDriver = {
    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe")
    new ChromeDriver()
  }
  //create a FirefoxDriver object
  def buildFirefoxDriver: WebDriver = new FirefoxDriver()

}
