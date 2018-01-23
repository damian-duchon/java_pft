package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {
    
    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.helper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.helper().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getPhone(), equalTo(cleaned(contactInfoFromEditForm.getPhone())));
        assertThat(contact.getWorkphone(), equalTo(cleaned(contactInfoFromEditForm.getWorkphone())));

    }
    public String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
