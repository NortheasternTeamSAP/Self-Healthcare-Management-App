/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 * @author sravy
 */
public class PersonDetails {
    
    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other")
        ;
        
        private String value;

        private Gender(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }
    
    protected String fullName;
    protected LocalDate dob;
    protected Gender gender;
    protected Address address;


    protected String phoneNumber;
    protected UserAccount userAccount;
    protected Role role;
    private Icon logoImage;
    private int organizationId;
    private String emailId;
    
    public PersonDetails(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount userAccount,
            Role role) {
        this(fullName, dob, gender, address, phoneNumber, userAccount, role, null, -1);
    }
    
    public PersonDetails(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount userAccount,
            Role role,
            Icon logoImage) {
        this(fullName, dob, gender, address, phoneNumber, userAccount, role, logoImage, -1);
    }
    
    public PersonDetails(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount userAccount,
            Role role,
            Icon logoImage,
            int organizationId) {
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userAccount = userAccount;
        this.role = role;
        this.logoImage = logoImage;
        this.organizationId = organizationId;
    }
    
    public PersonDetails(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount userAccount,
            Role role,
            Icon logoImage,
            int organizationId,
            String emailId) {
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userAccount = userAccount;
        this.role = role;
        this.logoImage = logoImage;
        this.organizationId = organizationId;
        this.emailId = emailId;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Role getRole() {
        return role;
    }
    
    public String getId() {
        return userAccount.getUsername();
    } 
    
    // returns age in years upto two 1 decimal
    public double getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.dob, now);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        
        DecimalFormat df = new DecimalFormat("###.#");
        double age = ((years * 365) + (months * 30) + days)/365.0f;
        return Double.parseDouble(df.format(age));
    }
    public Role getPersonType() {
        return Role.INVALID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Icon getLogoImage() {
        return logoImage;
    }

    public String getEmailId() {
        return emailId;
    }
   
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setLogoImage(Icon logoImage) {
        this.logoImage = logoImage;
    }
    
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getOrganizationId() {
        return this.organizationId;
    }
   
}
