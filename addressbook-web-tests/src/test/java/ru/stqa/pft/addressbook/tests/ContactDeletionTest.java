package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.helper().list().size() == 0) {
            app.helper().create(new ContactData().withName("Damian2").withLastname("Duchon2").withPhone("122332255").withMail("dam@gmail.com").withGroup("test1"));
        }

    }
    @Test
    public void testContactDeletion() {
        Set<ContactData> before = app.helper().all();
        ContactData deletedGroup = before.iterator().next();
        app.helper().delete(deletedGroup);
        Set<ContactData> after = app.helper().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }


}
