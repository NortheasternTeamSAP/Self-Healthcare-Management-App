/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import Counselor.CounselorDirectory;
import DataStore.CredentialsManager;
import DataStore.GlobalUserDirectory;
import Dietitian.DietitianDirectory;
import Doctor.Doctor;
import Enterprise.Enterprise;
import Enterprise.HealthManagementAppEnterprise;
import Enterprise.HospitalEnterprise;
import Enterprise.InsuranceCompanyEnterprise;
import FitnessTrainer.FitnessTrainerDirectory;
import Insurance.InsuranceProviderRepresentative;
import Laboratory.LaboratoryAssistant;
import Organization.HealthInsuranceDepartmentOrganization;
import Organization.LaboratoryOrganization;
import Organization.Organization;
import Organization.PatientOrganization;
import Organization.PrimaryCareOrganization;
import Organization.SystemAdminOrganization;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.SystemAdmin;
import Personnel.UserAccount;
import java.time.LocalDate;

/**
 *
 * @author Sravya
 */
public class EcoSystem {
    public GlobalUserDirectory globalUserDirectory;
    public CredentialsManager credentialsManager;
    DietitianDirectory dietitianDirectory;
    FitnessTrainerDirectory fitnessTrainerDirectory;
    CounselorDirectory counselorDirectory;
    
    
    // Testing
    public Enterprise healthManagementApp;
    public Enterprise hospital;
    public Enterprise insuranceCompany;
    
    public EcoSystem() {
        credentialsManager = new CredentialsManager();
        globalUserDirectory = new GlobalUserDirectory(credentialsManager);
        dietitianDirectory=new DietitianDirectory();
        fitnessTrainerDirectory=new FitnessTrainerDirectory();
        counselorDirectory= new CounselorDirectory();
        
//        // create new system admin user
//        UserAccount sysAdminUserAccount = new UserAccount("sysadmin", "sysadmin");
//        Person sysAdmin = new SystemAdmin(null, null, null, null, null, sysAdminUserAccount);
//        globalUserDirectory.createNewUser(sysAdmin);
        
        exampleCreateEnterpriseOrganizationAndRoles();
    }

    public CounselorDirectory getCounselorDirectory() {
        return counselorDirectory;
    }

    public DietitianDirectory getDietitianDirectory() {
        return dietitianDirectory;
    }

    public FitnessTrainerDirectory getFitnessTrainerDirectory() {
        return fitnessTrainerDirectory;
    }
    
    
    
    void example() {
        // How to get a user from globalUserDirectory
        Person person = globalUserDirectory.get("sysadmin");
        switch (person.getRole()) {
            case SYSTEM_ADMIN:
                SystemAdmin sysadmin = (SystemAdmin) person;
                // go to system admin workflow
                break;
            case PATIENT:
                Patient patient = (Patient) person;
                // go to patient workflow
                break;
            default:
                ;
        }
    }
    
    void exampleCreateEnterpriseOrganizationAndRoles() {
        Address sampleAddress = new Address("Street", "Building", "City", "Zip", "State", "Country");
        
        // Create Enterprise
        healthManagementApp = new HealthManagementAppEnterprise("Health Management App Company", sampleAddress);
        hospital = new HospitalEnterprise("Virginia Mason", sampleAddress);
        insuranceCompany = new InsuranceCompanyEnterprise("Progressive Insurance", sampleAddress);
        
        // Create Organizations and all them to enterprise
        Organization adminOrg = new SystemAdminOrganization("System Admin Org", healthManagementApp);
        healthManagementApp.addOrganization(adminOrg);
        
        Organization patientOrg = new PatientOrganization("Patient Org", healthManagementApp);
        healthManagementApp.addOrganization(patientOrg);
        
        Organization primaryCareOrg = new PrimaryCareOrganization("Virginia Mason Primary Care Unit", hospital);
        hospital.addOrganization(primaryCareOrg);

        Organization laboratoryOrg = new LaboratoryOrganization("Virginia Mason Lab Tests Unit", hospital);
        hospital.addOrganization(laboratoryOrg);
        
        Organization healthInsuranceOrg = new HealthInsuranceDepartmentOrganization("Progressive Health Insurance Department", insuranceCompany);
        insuranceCompany.addOrganization(healthInsuranceOrg);
        
        // Create roles
        // Admin
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, new UserAccount("sysadmin", "sysadmin"));
        this.globalUserDirectory.createNewUser(sysAdmin);
        adminOrg.addEmployee(sysAdmin);
        
        // Patient
        Person patient = new Patient("Patient-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", new UserAccount("pat1", "pat1"));
        this.globalUserDirectory.createNewUser(patient);
        patientOrg.addEmployee(patient);
        
        // Doctor
        Person doctor = new Doctor("Dr. Doctor-1", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", new UserAccount("doc1", "doc1"));
        this.globalUserDirectory.createNewUser(doctor);
        primaryCareOrg.addEmployee(doctor);
        
        // Lab Assistant
        Person labAssistant = new LaboratoryAssistant("Lab Assistant-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", new UserAccount("labassist1", "labassist1"));
        this.globalUserDirectory.createNewUser(labAssistant);
        laboratoryOrg.addEmployee(labAssistant);
        
        // Insurance provider representative
        Person insuranceRep = new InsuranceProviderRepresentative("Dr. Doctor-1", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", new UserAccount("insrep1", "insrep1"));
        this.globalUserDirectory.createNewUser(insuranceRep);
        healthInsuranceOrg.addEmployee(insuranceRep);
    }
    
}
