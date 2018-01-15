package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.helper().list().size() == 0) {
            app.helper().create(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com", "test1"));
        }

    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.helper().list();
        int index = before.size( ) - 1;
        ContactData contactData = new ContactData(before.get(index).getId(), "Damian", "Duchon", "122332255", "dam@gmail.com",null);
        app.helper().modify(index, contactData);
        List<ContactData> after = app.helper().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contactData);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
