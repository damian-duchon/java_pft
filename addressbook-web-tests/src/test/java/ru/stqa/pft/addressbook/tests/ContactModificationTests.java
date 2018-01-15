package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.helper().list().size() == 0) {
            app.helper().create(new ContactData().withName("Damian2").withLastname("Duchon2").withPhone("122332255").withMail("dam@gmail.com").withGroup("test1"));
        }

    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.helper().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contactData = new ContactData()
                .withId(modifiedContact.getId()).withName("Damian").withLastname("Duchon").withPhone ("122332255").withMail( "dam@gmail.com");
        app.helper().modify(contactData);
        Set<ContactData> after = app.helper().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contactData);
        Assert.assertEquals(before, after);
    }


}
