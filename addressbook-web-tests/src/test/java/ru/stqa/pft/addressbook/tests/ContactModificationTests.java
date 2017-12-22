package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com", "test1"));
        }
        app.getContactHelper().selectContactToEdit();
        app.getContactHelper().fillContactForm(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com",null), false);
        app.getContactHelper().submitContactModificcation();
        app.getContactHelper().returnToHomePage();
    }
}
