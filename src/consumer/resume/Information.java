package consumer.resume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public final class Information {
    private java.lang.String firstName;
    private java.lang.String lastName;
    private java.lang.String email;
    private java.lang.String phone;
    private Date birthDate;
    private String sex;

    private List<Language> languages;

    public Information() {
        languages = new ArrayList<>();
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public boolean completed() {
        // Verific daca informatia e completa
        return firstName != null && lastName != null && email != null && phone != null
                && birthDate != null && sex != null;
    }

    @Override
    public java.lang.String toString() {
        return "firstName='" + firstName + '\'' +
                "\n lastName='" + lastName + '\'' +
                "\n email='" + email + '\'' +
                "\n phone='" + phone + '\'' +
                "\n birthDate=" + birthDate +
                "\n sex=" + sex +
                "\n languages=" + languages ;
    }
}
