package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
private String firstname;
  private String lastname;
  private String phone;
  private String mail;
  private String group;
  private String homephone;
  private String workphone;
  private String allphones;
  private String email2;
  private String email3;
  private String allEmails;
    private String address;

    public String getAllphones() {
        return allphones;
    }

    public ContactData withAllphones(String allphones) {
        this.allphones = allphones;
        return this;
    }

    public ContactData withAddress (String address) {
        this.address = address;
        return this;
    }

  public String getFirstname() {
    return firstname;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData getHomephone() {
    this.homephone =homephone;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public String getWorkphone() {
    this.workphone = workphone;
    return workphone;
  }

  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomePhone() {
    return homephone;
  }

  public String getPhone() {
    return phone;
  }

  public String getMail() {
    return mail;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
        this.id = id;
        return this;

    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
      }
  public ContactData withEmail2(String email2){
       this.email2 = email2;
        return this;
      }
  public ContactData withEmail3(String email3){
        this.email3 = email3;
        return this;
      }

    public String getAllEmails() {
        return allEmails;
      }

    public String getEmail2() {
       return email2;
      }

    public String getEmail3() {
        return email3;
      }
    public String getAddress() {
        return address;
    }
  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
}
