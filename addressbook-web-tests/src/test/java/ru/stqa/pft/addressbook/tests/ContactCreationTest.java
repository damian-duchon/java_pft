package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends  TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.helper().list();
    ContactData contactData = new ContactData("Damian2", "Duchon2", "122332255", "dam@gmail.com", "test1");
    app.helper().create(contactData);
    List<ContactData> after = app.helper().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contactData);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
