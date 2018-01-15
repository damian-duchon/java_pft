package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData ,boolean creation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"),contactData.getPhone());
        type(By.name("email"),contactData.getMail());
        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else{
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

    }

    public void toDelete(int index) {
        wd.findElements(By.cssSelector("tr[name='entry']")).get(index).findElement(By.xpath("td[1]/input")).click();
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
    public void modify( ContactData contactData) {
        selectContactById(contactData.getId());
        fillContactForm(contactData, false);
        submitContactModificcation();
        returnToHomePage();

    }



    public void delete(int index) {
        toDelete(index);
        deletion();
        acceptAlert();
        returnToHomePage();
    }
    public void delete(ContactData group) {
        toDeleteById(group.getId());
        deletion();
        acceptAlert();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements){
            String firstName = element.findElement(By.xpath("td[3]")).getText();
            String lastName = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                       contacts.add(new ContactData().withId(id).withName(firstName).withLastname(lastName));
        }
        return contacts;
    }
    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements){
            String firstName = element.findElement(By.xpath("td[3]")).getText();
            String lastName = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withName(firstName).withLastname(lastName));
        }
        return contacts;
    }


}
