package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.helper().all().size() == 0) {
            app.helper().create(new ContactData().withName("Damian2").withLastname("Duchon2").withPhone("122332255").withMail("dam@gmail.com").withGroup("test1"));
        }

    }

    @Test(enabled = false)
    public void testContactModification() {
        Contacts before = app.helper().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contactData = new ContactData()
                .withId(modifiedContact.getId()).withName("Damian").withLastname("Duchon").withPhone ("122332255").withMail( "dam@gmail.com");
        app.helper().modify(contactData);
        Contacts after = app.helper().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contactData) ));
    }


}
