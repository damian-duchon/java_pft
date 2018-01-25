package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String name;
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
    private String middlename;
    private String fax;
    private String company;
    private String homepage;
    private String bDay;
    private String bMonth;
    private String bYear;
    private String aDay;
    private String aMonth;
    private String aYear;
    private String anniversary;
    private String birthday;
    private String secAddress;
    private String secHomePhone;
    private String notes;
    private String nickname;
    private String title;

    public String getMiddlename() {
        return middlename;
    }

    public String getCompany() {
        return company;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBDay() {
        return bDay;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public String getSecAddress() {
        return secAddress;
    }

    public String getSecHomePhone() {
        return secHomePhone;
    }

    public String getFax() {
        return fax;
    }

    public String getNotes() {
        return notes;
    }

    public String getBMonth() {
        return bMonth;
    }

    public String getBYear() {
        return bYear;
    }

    public String getADay() {
        return aDay;
    }

    public String getAMonth() {
        return aMonth;
    }

    public String getAYear() {
        return aYear;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }


    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public ContactData withBirdhday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public ContactData withAnniversary(String anniversary) {
        this.anniversary = anniversary;
        return this;
    }

    public ContactData withSecAddress(String secAddress) {
        this.secAddress = secAddress;
        return this;
    }

    public ContactData withSecHomePhone(String secHomePhone) {
        this.secHomePhone = secHomePhone;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withBDay(String bDay) {
        this.bDay = bDay;
        return this;
    }

    public ContactData withBMonth(String bMonth) {
        this.bMonth = bMonth;
        return this;
    }

    public ContactData withBYear(String bYear) {
        this.bYear = bYear;
        return this;
    }

    public ContactData withADay(String aDay) {
        this.aDay = aDay;
        return this;
    }

    public ContactData withAMonth(String aMonth) {
        this.aMonth = aMonth;
        return this;
    }

    public ContactData withAYear(String aYear) {
        this.aYear = aYear;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getAllphones() {
        return allphones;
    }

    public ContactData withAllphones(String allphones) {
        this.allphones = allphones;
        return this;
    }

    public ContactData withAddress(String address) {
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

    public String getHomephone() {
        return this.homephone;
    }

    public ContactData withHomephone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public String getWorkphone() {
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

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
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
}
