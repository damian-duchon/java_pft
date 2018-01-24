package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getMail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void fillContent() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void initCreationNewContack() {
        click(By.linkText("add new"));
    }

    public void selectContactToEdit(int index) {
        wd.findElements(By.cssSelector("tr[name='entry']")).get(index).findElement(By.xpath("td[8]")).click();
    }

    private void selectContactById(int index) {

        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row : rows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));

            int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));

            if (index == iD) {

                cells.get(7).findElement(By.cssSelector("img[title=\"Edit\"]")).click();

                return;

            }

        }

    }

    public void toDeleteById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    public void submitContactModificcation() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void deletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void create(ContactData contact) {
        initCreationNewContack();
        fillContactForm(contact, true);
        fillContent();
        returnToHomePage();
    }

    public void modify(ContactData contactData) {
        selectContactById(contactData.getId());
        fillContactForm(contactData, false);
        submitContactModificcation();
        returnToHomePage();

    }

    public void delete(ContactData group) {
        toDeleteById(group.getId());
        deletion();
        acceptAlert();
        returnToHomePage();
    }

    public Contacts  all() {
        Contacts  contacts = new Contacts ();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allphones = cells.get(5).getText();
            String adress = cells.get(3).getText();
            String emails = cells.get(4).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllphones(allphones).withAddress(adress).withAllEmails(emails));
        }
        return contacts;
    }


        public ContactData infoFromEditForm(ContactData contact){
            initContactModificationById(contact.getId());
            String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
            String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
            String home = wd.findElement(By.name("home")).getAttribute("value");
            String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
            String work = wd.findElement(By.name("work")).getAttribute("value");
            String address = wd.findElement(By.name("address")).getAttribute("value");
            String email1 = wd.findElement(By.name("email")).getAttribute("value");
            String email2 = wd.findElement(By.name("email2")).getAttribute("value");
            String email3 = wd.findElement(By.name("email3")).getAttribute("value");
            wd.navigate().back();
            return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname)
                    .withHomephone(home).withPhone(mobile).withWorkphone(work).withAddress(address).withMail(email1).withEmail2(email2).withEmail3(email3);

        }

        private void initContactModificationById ( int id){
            WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
            WebElement row = checkbox.findElement(By.xpath("./../.."));
            List<WebElement> cells = row.findElements(By.tagName("td"));
            cells.get(7).findElement(By.tagName("a")).click();

            //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
            // wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
            //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();

        }

}
