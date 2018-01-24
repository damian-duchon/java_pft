package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        //if (!app.helper().isThereAContact()) {
            app.helper().infoFromEditForm(new ContactData()
                    .withName("Damian").withLastname("Duchon").withAddress("krakow").withHomephone("+7 (111)").withMail("dam@gmail.com").withGroup("test1"));
        //}
    }

    @Test (enabled = true)
    public void testContactAdress() {
        ContactData contact = app.helper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.helper().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));

    }

    private String cleaned(String address) {
        return address.replaceAll("\\s","");
    }
}