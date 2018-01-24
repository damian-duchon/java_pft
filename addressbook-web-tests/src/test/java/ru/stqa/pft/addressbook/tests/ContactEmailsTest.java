package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        //if (!app.helper().isThereAContact()) {
            app.helper().infoFromEditForm(new ContactData()
                    .withName("Damian").withLastname("Duchon").withAddress("Krakow").withHomephone("+7 (111)").withMail("dam@gmail.com").withGroup("test1"));
        //}
    }

    @Test (enabled = true)
    public void testContactEmails() {
        ContactData contact = app.helper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.helper().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contat) {
        return Arrays.asList(contat.getMail(), contat.getEmail2(), contat.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));

    }
}