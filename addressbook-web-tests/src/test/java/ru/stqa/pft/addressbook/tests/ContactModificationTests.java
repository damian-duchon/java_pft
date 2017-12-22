package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().selectContactToEdit();
        app.getContactHelper().fillContact(new ContactData("Damian", "Duchon", "122332255", "dam@gmail.com"));
        app.getContactHelper().submitContactModificcation();
        app.getContactHelper().returnToHomePage();
    }
}
