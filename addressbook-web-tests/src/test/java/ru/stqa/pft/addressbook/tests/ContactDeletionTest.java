package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.helper().list().size() == 0) {
            app.helper().create(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com", "test1"));
        }

    }
    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.helper().list();
        int index = before.size() - 1;
        app.helper().delete(index);
        List<ContactData> after = app.helper().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
