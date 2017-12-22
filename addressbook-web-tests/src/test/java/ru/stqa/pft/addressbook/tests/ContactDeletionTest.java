package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationMenager;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com", "test1"));
        }
        app.getContactHelper().selectContactToDelete();
        app.getContactHelper().deletion();
        app.acceptAlert();
    }
}
