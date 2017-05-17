package Utilities

import Pages._
import org.openqa.selenium.WebDriver
/**
  * Created by Anthony Emerson on 5/7/2017.
  */
class PageContainer(webDriver: WebDriver){
  def dressPage()= new DressPage(webDriver)
  def homePage()= new HomePage(webDriver)
  def loginPage()= new LoginPage(webDriver)
  def shoppingCartPage()= new ShoppingCartPage(webDriver)
  def userAcctPage()= new UserAcctPage(webDriver)
  def userInfoPage()= new UserInfoPage(webDriver)
}
