package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {

    @Test(enabled = true)
    public void testContactAdress() {
        ContactData contact = app.helper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.helper().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));

    }

    private String cleaned(String address) {
        return address.replaceAll("\\s", "");
    }
}