package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationMenager;

public class TestBase {

  protected final ApplicationMenager app = new ApplicationMenager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  public void acceptAlert() {
    app.acceptAlert();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}