package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

    @Test(enabled = true)
    public void testContactDetails() {
        ContactData contacts = app.helper().all().iterator().next();

        ContactData contactInfoFromEditForm = app.helper().infoFromEditForm(contacts);
        String detailsData = app.helper().infoFromDetailsPage(contacts);

        String cleanEditFormData = mergeContact(CreateFormatted(contactInfoFromEditForm));
        String cleanedDataDetailsForm = cleaned(detailsData);

        System.out.println(cleanEditFormData);
        System.out.println(cleanedDataDetailsForm);
        assertThat(cleanedDataDetailsForm, equalTo(cleanEditFormData));
    }

    private String mergeContact(ContactData data) {
        return cleaned(new StringBuilder()
                .append(data.getName())
                .append(data.getLastname())
                .append(data.getAddress())
                .append(data.getHomePhone())
                .append(data.getWorkphone())
                .append(data.getMail())
                .append(data.getEmail2())
                .append(data.getEmail3())
                .append(data.getAddress())
                .toString());

        /*return Arrays.asList(data.getFirstname(), data.getMiddlename(), data.getLastname(), data.getNickname(), data.getTitle(), data.getCompany(),
                data.getAddress(), data.getHomePhone(), data.getPhone(), data.getWorkphone(), data.getFax(), data.getMail(), data.getEmail2(),
                data.getEmail3(), data.getHomepage(), data.getBirthday(), data.getAnniversary(), data.getSecAddress(), data.getSecHomePhone(), data.getNotes())
                .stream().filter((s) -> s != null && !s.equals("")).map(ContactDetailsTest::cleaned)
                .collect(Collectors.joining());*/
    }

    public static String cleaned(String data) {
        return data.replaceAll("\n", "").replace(" ", "")
                .replace(".", "").replace("-", "");
    }

    public ContactData CreateFormatted(ContactData source) {
        ContactData result = new ContactData();
        if (source.getHomephone() != null && source.getHomePhone().length() > 0) {
            result.withHomephone("H:" + source.getHomephone());
        } else {
            result.withHomephone(source.getHomePhone());
        }
        if (source.getPhone() != null && source.getPhone().length() > 0) {
            result.withPhone("M:" + source.getPhone());
        } else {
            result.withPhone(source.getPhone());
        }
        if (source.getWorkphone() != null && source.getWorkphone().length() > 0) {
            result.withWorkphone("W:" + source.getWorkphone());
        } else {
            result.withWorkphone(source.getWorkphone());
        }
        if (source.getFax() != null && source.getFax().length() > 0) {
            result.withFax("F:" + source.getFax());
        } else {
            result.withFax(source.getFax());
        }
        if (source.getHomepage() != null && source.getHomepage().length() > 0) {
            result.withHomepage("Homepage:" + source.getHomepage());
        } else {
            result.withHomepage(source.getHomepage());
        }
        if (source.getSecHomePhone() != null && source.getSecHomePhone().length() > 0) {
            result.withSecHomePhone("P:" + source.getSecHomePhone());
        } else {
            result.withSecHomePhone(source.getSecHomePhone());
        }
        if (source.getBirthday() != null && source.getBirthday().length() > 0 && !source.getBirthday().equals("--")) {
            result.withBirdhday("Birthday" + source.getBirthday());
        } else {
            result.withBirdhday(source.getBirthday());
        }
        if (source.getAnniversary() != null && source.getAnniversary().length() > 0 && !source.getAnniversary().equals("--")) {
            result.withAnniversary("Anniversary" + source.getAnniversary());
        } else {
            result.withAnniversary(source.getAnniversary());
        }

        result.withMail(source.getMail()).withEmail2(source.getEmail2()).withEmail3(source.getEmail3()).withName(source.getName()).withFirstname(source.getFirstname())
                .withMiddlename(source.getMiddlename()).withLastname(source.getLastname()).withNickname(source.getNickname()).withTitle(source.getTitle())
                .withCompany(source.getCompany()).withAddress(source.getAddress()).withNotes(source.getNotes()).withSecAddress(source.getSecAddress());

        return result;
    }
}