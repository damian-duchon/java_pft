package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.helper().all().size() == 0) {
            app.helper().create(new ContactData().withName("Damian2").withLastname("Duchon2").withPhone("122332255").withMail("dam@gmail.com").withGroup("test1"));
        }

    }
    @Test
    public void testContactDeletion() {
        Contacts before = app.helper().all();
        ContactData deletedGroup = before.iterator().next();
        app.helper().delete(deletedGroup);
        Contacts after = app.helper().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedGroup)));
    }

}
