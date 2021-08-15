/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import Counselor.Counselor;
import DataStore.CredentialsManager;
import DataStore.EnterpriseDirectory;
import DataStore.GlobalUserDirectory;
import Dietitian.Dietitian;
import Doctor.Doctor;
import Enterprise.Enterprise;
import Enterprise.HealthManagementAppEnterprise;
import Enterprise.HospitalEnterprise;
import Enterprise.InsuranceCompanyEnterprise;
import Enterprise.MentalWellnessEnterprise;
import Enterprise.PhysicalWellnessEnterprise;
import FitnessTrainer.FitnessTrainer;
import Insurance.InsuranceProviderRepresentative;
import Laboratory.LaboratoryAssistant;
import Organization.GymOrganization;
import Organization.HealthInsuranceDepartmentOrganization;
import Organization.LaboratoryOrganization;
import Organization.NutritionDepartmentOrganization;
import Organization.Organization;
import Organization.PatientOrganization;
import Organization.PrimaryCareOrganization;
import Organization.SystemAdminOrganization;
import DeliveryMan.DeliveryManDirectory;
import Medicine.MedicineDirectory;
import Order.OrderDirectory;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.SystemAdmin;
import Personnel.UserAccount;
import Pharmacy.Pharmacy;
import Pharmacy.PharmacyDirectory;
import java.time.LocalDate;

/**
 *
 * @author Sravya
 */
public class EcoSystem {

    public GlobalUserDirectory globalUserDirectory;
    public CredentialsManager credentialsManager;
    public EnterpriseDirectory enterpriseDirectory;
    DietitianDirectory dietitianDirectory;
    FitnessTrainerDirectory fitnessTrainerDirectory;
    CounselorDirectory counselorDirectory;
    OrderDirectory orderDirectory;
    MedicineDirectory medicineDirectory;
    DeliveryManDirectory deliveryManDirectory;
    PharmacyDirectory pharmacyDirectory;

    public EcoSystem() {
        credentialsManager = new CredentialsManager();
        globalUserDirectory = new GlobalUserDirectory(credentialsManager);
        enterpriseDirectory = new EnterpriseDirectory();
        dietitianDirectory=new DietitianDirectory();
        fitnessTrainerDirectory=new FitnessTrainerDirectory();
        counselorDirectory= new CounselorDirectory();
        orderDirectory = new OrderDirectory();
        medicineDirectory = new MedicineDirectory();
        deliveryManDirectory = new DeliveryManDirectory();
        pharmacyDirectory = new PharmacyDirectory();

        // create new system admin user
        UserAccount sysAdminUserAccount = new UserAccount("sysadmin", "sysadmin");
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, sysAdminUserAccount);
        globalUserDirectory.createNewUser(sysAdmin);
    }

    public PharmacyDirectory getPharmacyDirectory() {
        return pharmacyDirectory;
    }

    public CounselorDirectory getCounselorDirectory() {
        return counselorDirectory;
    }

        exampleCreateEnterpriseOrganizationAndRoles();
    }

    public FitnessTrainerDirectory getFitnessTrainerDirectory() {
        return fitnessTrainerDirectory;
    }
    
    
    
    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }
    
    public MedicineDirectory getMedicineDirectory() {
        return medicineDirectory;
    }

    public DeliveryManDirectory getDeliveryManDirectory() {
        return deliveryManDirectory;
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
        physicalWellness = new PhysicalWellnessEnterprise("Physical Wellness Institute", sampleAddress);
        mentalWellness = new MentalWellnessEnterprise("Synergy Mental Health  Institute", sampleAddress);
        

        enterpriseDirectory.addEnterprise(healthManagementApp);
        enterpriseDirectory.addEnterprise(hospital);
        enterpriseDirectory.addEnterprise(insuranceCompany);
        enterpriseDirectory.addEnterprise(physicalWellness);
        enterpriseDirectory.addEnterprise(mentalWellness);

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

        Organization nutritionDepartmentOrg = new NutritionDepartmentOrganization("Nutrition Department", physicalWellness);
        physicalWellness.addOrganization(nutritionDepartmentOrg);
        
        Organization gymOrg=new GymOrganization("Fitness Trainer Department",physicalWellness);
        physicalWellness.addOrganization(gymOrg);
        
        Organization phychiatristOrg=new GymOrganization("Counselor Department",mentalWellness);
        mentalWellness.addOrganization(phychiatristOrg);

        // Create roles
        // Admin
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, null ,new UserAccount("sysadmin", "sysadmin") );
        this.globalUserDirectory.createNewUser(sysAdmin);
        adminOrg.addEmployee(sysAdmin);

        // Patient
        Person patient = new Patient("Patient-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", new UserAccount("pat1", "pat1"), new Pharmacy("testoahr", "earth", new Pharmacist()));
        this.globalUserDirectory.createNewUser(patient);
        patientOrg.addEmployee(patient);

        // Doctor
        Person doctor = new Doctor("Dr. Doctor-1", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("doc1", "doc1"));
        this.globalUserDirectory.createNewUser(doctor);
        primaryCareOrg.addEmployee(doctor);

        // Lab Assistant
        Person labAssistant = new LaboratoryAssistant("Lab Assistant-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null , new UserAccount("labassist1", "labassist1"));
        this.globalUserDirectory.createNewUser(labAssistant);
        laboratoryOrg.addEmployee(labAssistant);

        // Dietitian
        Person dietitian = new Dietitian("Jan", LocalDate.now(), PersonDetails.Gender.FEMALE, new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", new UserAccount("dietitian", "dietitian1"));
        this.globalUserDirectory.createNewUser(dietitian);
        nutritionDepartmentOrg.addEmployee(dietitian);
        
         // FitnessTrainer
        Person fitnessTrainer = new FitnessTrainer("Jim", LocalDate.now(), PersonDetails.Gender.MALE, new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", new UserAccount("fitnesstrainer", "fitnesstrainer1"));
        this.globalUserDirectory.createNewUser(fitnessTrainer);
        gymOrg.addEmployee(fitnessTrainer);
        
         // Counselor
        Person counselor = new Counselor("zena", LocalDate.now(), PersonDetails.Gender.FEMALE, new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", new UserAccount("counselor", "counselor1"));
        this.globalUserDirectory.createNewUser(counselor);
        phychiatristOrg.addEmployee(counselor);

        // Insurance provider representative
        Person insuranceRep = new InsuranceProviderRepresentative("Dr. Doctor-1", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("insrep1", "insrep1"));
        this.globalUserDirectory.createNewUser(insuranceRep);
        healthInsuranceOrg.addEmployee(insuranceRep);
        ((InsuranceProviderRepresentative) insuranceRep).setOrganization(healthInsuranceOrg);
    }

}
