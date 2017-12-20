package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String phone;
  private final String mail;

  public ContactData(String name, String lastname, String phone, String mail) {
    this.name = name;
    this.lastname = lastname;
    this.phone = phone;
    this.mail = mail;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPhone() {
    return phone;
  }

  public String getMail() {
    return mail;
  }
}
