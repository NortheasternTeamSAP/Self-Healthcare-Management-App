/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import Counselor.Counselor;
import DataStore.Appointment;
import DataStore.CredentialsManager;
import DataStore.EnterpriseDirectory;
import DataStore.GenericDirectory;
import DataStore.GlobalUserDirectory;
import DataStore.OrganizationDirectory;
import DeliveryMan.DeliveryMan;
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
import Organization.PsychiatristOrganization;
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
import Pharmacy.Pharmacist;
import Pharmacy.PharmacistDirectory;
import Enterprise.PharmacyEnterprise;
import Medicine.Medicine;
import Organization.DeliveryDepartmentOrganization;
import Organization.MedicineInventoryOrganization;
import Pharmacy.PharmacyDirectory;
import Prescription.Dosage;
import Prescription.Prescription;
import Prescription.PrescriptionDirectory;
import Utils.SMSSender;
import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author Sravya
 */
public class EcoSystem {

    public GlobalUserDirectory globalUserDirectory;
    public CredentialsManager credentialsManager;
    public EnterpriseDirectory enterpriseDirectory;
    OrderDirectory orderDirectory;
    MedicineDirectory medicineDirectory;
    DeliveryManDirectory deliveryManDirectory;
    PharmacyDirectory pharmacyDirectory;
    PharmacistDirectory pharmacistDirectory;
    public OrganizationDirectory organizationDirectory;
    PrescriptionDirectory prescriptionDirectory;
    
    
    SMSSender smsHelper;

    // Testing
    public Enterprise healthManagementApp;
    public Enterprise hospital;
    public Enterprise insuranceCompany;
    public Enterprise physicalWellness;
    public Enterprise mentalWellness;
    public Enterprise pharmacy;
 
    public EcoSystem() {
        credentialsManager = new CredentialsManager();
        globalUserDirectory = new GlobalUserDirectory(credentialsManager);
        enterpriseDirectory = new EnterpriseDirectory();
        orderDirectory = new OrderDirectory();
        medicineDirectory = new MedicineDirectory();
        deliveryManDirectory = new DeliveryManDirectory();
        pharmacyDirectory = new PharmacyDirectory();
        pharmacistDirectory = new PharmacistDirectory();
        smsHelper = new SMSSender();
        this.prescriptionDirectory = new PrescriptionDirectory();

        // create new system admin user
        organizationDirectory = new OrganizationDirectory();
 
        exampleCreateEnterpriseOrganizationAndRoles();
        createLocalFolder("/tmp/patient");
        createLocalFolder("/tmp/doctor");
        
    }
    
    private void createLocalFolder(String folder) {
        File directory = new File(folder);
        if (directory.exists()){
            directory.delete();
        }
        directory.mkdir();
    }

    public PharmacyDirectory getPharmacyDirectory() {
        return pharmacyDirectory;
    }
    
    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }
    
    public MedicineDirectory getMedicineDirectory() {
        return medicineDirectory;
    }
    
    public SMSSender getSMSHelper() {
        return this.smsHelper;
    }

    public DeliveryManDirectory getDeliveryManDirectory() {
        return deliveryManDirectory;
    }

    public PharmacistDirectory getPharmacistDirectory() {
        return pharmacistDirectory;
    }
    
    public PrescriptionDirectory getPrescriptionDirectory() {
        return this.prescriptionDirectory;
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
        pharmacy = new PharmacyEnterprise("Bartell Drugs", sampleAddress);
        

        enterpriseDirectory.addEnterprise(healthManagementApp);
        enterpriseDirectory.addEnterprise(hospital);
        enterpriseDirectory.addEnterprise(insuranceCompany);
        enterpriseDirectory.addEnterprise(physicalWellness);
        enterpriseDirectory.addEnterprise(mentalWellness);

        // Create Organizations and all them to enterprise
        Organization adminOrg = new SystemAdminOrganization("System Admin Org", healthManagementApp);
        organizationDirectory.addOrganization(adminOrg);
        healthManagementApp.addOrganization(adminOrg);

        Organization patientOrg = new PatientOrganization("Patient Org", healthManagementApp);
        organizationDirectory.addOrganization(patientOrg);
        healthManagementApp.addOrganization(patientOrg);

        Organization primaryCareOrg = new PrimaryCareOrganization("Virginia Mason Primary Care Unit", hospital);
        organizationDirectory.addOrganization(primaryCareOrg);
        hospital.addOrganization(primaryCareOrg);

        Organization laboratoryOrg = new LaboratoryOrganization("Virginia Mason Lab Tests Unit", hospital);
        organizationDirectory.addOrganization(laboratoryOrg);
        hospital.addOrganization(laboratoryOrg);

        Organization healthInsuranceOrg = new HealthInsuranceDepartmentOrganization("Progressive Health Insurance Department", insuranceCompany);
        organizationDirectory.addOrganization(healthInsuranceOrg);
        insuranceCompany.addOrganization(healthInsuranceOrg);

        Organization nutritionDepartmentOrg = new NutritionDepartmentOrganization("Nutrition Department", physicalWellness);
        organizationDirectory.addOrganization(nutritionDepartmentOrg);
        physicalWellness.addOrganization(nutritionDepartmentOrg);
        
        Organization gymOrg=new GymOrganization("Fitness Trainer Department",physicalWellness);
        organizationDirectory.addOrganization(gymOrg);
        physicalWellness.addOrganization(gymOrg);
        
        Organization phychiatristOrg=new PsychiatristOrganization("Counselor Department",mentalWellness);
        organizationDirectory.addOrganization(phychiatristOrg);
        mentalWellness.addOrganization(phychiatristOrg);
        
        Organization medicineInventoryOrg = new MedicineInventoryOrganization("Medicine Inventory Department", pharmacy);
        organizationDirectory.addOrganization(medicineInventoryOrg);
        pharmacy.addOrganization(medicineInventoryOrg);
        
        Organization deliveryDepartmentOrganization = new DeliveryDepartmentOrganization("Medicine delivery department", pharmacy);
        organizationDirectory.addOrganization(deliveryDepartmentOrganization);
        pharmacy.addOrganization(deliveryDepartmentOrganization);

        // Create roles
        // Admin
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, null ,new UserAccount("sysadmin", "sysadmin") );
        this.globalUserDirectory.createNewUser(sysAdmin);
        adminOrg.addEmployee(sysAdmin);

        // Patient
        Person patient = new Patient("Patient-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), 
                "2132921728", null, new UserAccount("pat1", "pat1"), patientOrg.getOrganizationId(), (PharmacyEnterprise) pharmacy);
        this.globalUserDirectory.createNewUser(patient);
        patientOrg.addEmployee(patient);

        // Doctor
        Person doctor = new Doctor("Dr. Doctor-1", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("doc1", "doc1"), primaryCareOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(doctor);
        primaryCareOrg.addEmployee(doctor);

        // Lab Assistant
        Person labAssistant = new LaboratoryAssistant("Lab Assistant-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null , new UserAccount("labassist1", "labassist1"), laboratoryOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(labAssistant);
        laboratoryOrg.addEmployee(labAssistant);

         // Dietitian
        Person dietitian = new Dietitian("Jim", LocalDate.now(), PersonDetails.Gender.MALE, 
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", new UserAccount("dietitian", "dietitian1"),null, gymOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(dietitian);
        gymOrg.addEmployee(dietitian);
        
         // FitnessTrainer
        Person fitnessTrainer = new FitnessTrainer("jack", LocalDate.now(), PersonDetails.Gender.MALE, new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", 
                new UserAccount("fitnesstrainer", "fitnesstrainer1"),null, gymOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(fitnessTrainer);
        gymOrg.addEmployee(fitnessTrainer);
        
         // Counselor
        Person counselor = new Counselor("zena", LocalDate.now(), PersonDetails.Gender.FEMALE, 
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", 
                new UserAccount("counselor", "counselor1"),null, phychiatristOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(counselor);
        phychiatristOrg.addEmployee(counselor);

        // Insurance provider representative
        Person insuranceRep = new InsuranceProviderRepresentative("Dr. Doctor-1", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("insrep1", "insrep1"), healthInsuranceOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(insuranceRep);
        healthInsuranceOrg.addEmployee(insuranceRep);
        ((InsuranceProviderRepresentative) insuranceRep).setOrganization(healthInsuranceOrg);
        
        // Pharmacist
        Person pharmacist = new Pharmacist("Pharmacist-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), 
                "2132921728", null ,new UserAccount("pharmacist1", "pharmacist1"), medicineInventoryOrg.getOrganizationId());
        this.globalUserDirectory.createNewUser(pharmacist);
        medicineInventoryOrg.addEmployee(pharmacist);
        pharmacistDirectory.addPharmacist((Pharmacist)pharmacist);
        
        // Delivery man
        Person deliveryMan = new DeliveryMan("Delivery-Man-1", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), 
                "2132921728", null ,new UserAccount("dman1", "dman1"), deliveryDepartmentOrganization.getOrganizationId());
        this.globalUserDirectory.createNewUser(deliveryMan);
        deliveryDepartmentOrganization.addEmployee(deliveryMan);
        
        createSampleMedicines();
        addDummyPrescriptions((Patient)patient, (Doctor)doctor);
    }
    
    void createSampleMedicines() {
        medicineDirectory.addMedicine("Med-1", 10, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Med-2", 20, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Med-3", 30, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Med-4", 40, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
    }
    
    void addDummyPrescriptions(Patient patient, Doctor doctor) {
        for (int i = 1; i <= 5; i++) {
            Appointment appointment = new Appointment(patient, "", doctor, LocalDate.now().minusDays(i), 9);
            Prescription prescription = new Prescription(appointment);
            prescription.addMedicine(new Medicine("FirstDummyMed" + i, i, LocalDate.now(), LocalDate.now().plusDays(i)), new Dosage(1, -1, "--", true, true, false, false));
            prescription.addMedicine(new Medicine("SecondDummyMed" + i, i, LocalDate.now(), LocalDate.now().plusDays(i)), new Dosage(1, -1, "--", true, false, true, false));
            prescription.addMedicine(new Medicine("ThirdDummyMed" + i, i, LocalDate.now(), LocalDate.now().plusDays(i)), new Dosage(2, -1, "--", false, false, true, true));
            patient.addPrescription(prescription);
            prescriptionDirectory.addPrescription(appointment.getId(), prescription);
        }
        
    }
}
