package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ContactCreationTest extends  TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().initCreationNewContack();
    app.getContactHelper().fillContact(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com"));
    app.getContactHelper().fillContent();
    app.getContactHelper().returnToHomePage();
  }
}
