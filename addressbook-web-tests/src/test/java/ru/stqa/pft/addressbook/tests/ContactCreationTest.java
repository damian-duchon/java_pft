package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTest extends  TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.helper().all();
    ContactData contactData
            = new ContactData().withName("Damian2").withLastname("Duchon2").withPhone("122332255").withMail("dam@gmail.com").withGroup("test1");
    app.helper().create(contactData);
    Set<ContactData> after = app.helper().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    contactData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contactData);
    Assert.assertEquals(before, after);

  }
}
