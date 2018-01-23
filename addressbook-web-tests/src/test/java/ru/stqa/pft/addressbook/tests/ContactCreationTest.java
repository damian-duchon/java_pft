package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends  TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.helper().all();
    ContactData contactData
            = new ContactData().withName("Damian2").withLastname("Duchon2").withPhone("122332255").withMail("dam@gmail.com").withGroup("test1");
    app.helper().create(contactData);
    Contacts after = app.helper().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contactData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
