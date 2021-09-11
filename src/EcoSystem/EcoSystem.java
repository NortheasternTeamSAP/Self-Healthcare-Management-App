/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import Counselor.Counselor;
import DataMock.MockDataCreator;
import static DataMock.MockDataCreator.badRating;
import static DataMock.MockDataCreator.getRandomAddress;
import static DataMock.MockDataCreator.goodRating;
import static DataMock.MockDataCreator.poorDocReviews;
import static DataMock.MockDataCreator.positiveDocReviews;
import static DataMock.MockDataCreator.random;
import static DataMock.MockDataCreator.randomNumberSmall;
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
import Personnel.Role;
import static Personnel.Role.DOCTOR;
import Pharmacy.PharmacyDirectory;
import Prescription.Dosage;
import Prescription.Prescription;
import Prescription.PrescriptionDirectory;
import Utils.Rating;
import Utils.SMSSender;
import VitalSign.Range;
import VitalSign.VitalSigns;
import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Enterprise hospital1, hospital2, hospital3;
    public Enterprise insuranceCompany1, insuranceCompany2, insuranceCompany3;
    public Enterprise physicalWellness1, physicalWellness2, physicalWellness3;
    public Enterprise mentalWellness1, mentalWellness2, mentalWellness3;
    public Enterprise pharmacy1, pharmacy2, pharmacy3;
 
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
 
        createEnterpriseOrganizationAndRoles();
        createLocalFolder("/tmp/patient");
        createLocalFolder("/tmp/doctor");
        
    }
    
    public String getSysAdminEmail() {
        SystemAdmin sysAdmin = (SystemAdmin) globalUserDirectory.get("sysadmin");
        return sysAdmin.getPersonDetails().getEmailId();
    }
    
    public String getSysAdmingEmailPassword() {
       SystemAdmin sysAdmin = (SystemAdmin) globalUserDirectory.get("sysadmin");
       return sysAdmin.getEmailPassword();
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

    void createEnterpriseOrganizationAndRoles() {
        // Create Enterprise
        healthManagementApp = new HealthManagementAppEnterprise("Health Management App Company", getRandomAddress(), LocalDate.now().minusDays(10));
        
        hospital1 = new HospitalEnterprise("Virginia Mason Medical Center", getRandomAddress(), LocalDate.now().minusDays(13));
        hospital2 = new HospitalEnterprise("Swedish Medical Center", getRandomAddress(), LocalDate.now().minusDays(8));
        hospital3 = new HospitalEnterprise("Harborview Medical Center", getRandomAddress(), LocalDate.now().minusDays(3));
        
        insuranceCompany1 = new InsuranceCompanyEnterprise("Premera Insurance", getRandomAddress(), LocalDate.now().minusDays(12));
        insuranceCompany2 = new InsuranceCompanyEnterprise("Progressive Insurance", getRandomAddress(), LocalDate.now().minusDays(9));
        insuranceCompany3 = new InsuranceCompanyEnterprise("GEICO Insurance", getRandomAddress(), LocalDate.now().minusDays(4));
        
        physicalWellness1 = new PhysicalWellnessEnterprise("Crossfit Physical Wellness", getRandomAddress(), LocalDate.now().minusDays(11));
        physicalWellness2 = new PhysicalWellnessEnterprise("Peak health and Performance Institute", getRandomAddress(), LocalDate.now().minusDays(10));
        physicalWellness3 = new PhysicalWellnessEnterprise("SolFuel Wellness Institute", getRandomAddress(), LocalDate.now().minusDays(5));
        
        mentalWellness1 = new MentalWellnessEnterprise("Synergy Mental Health Institute", getRandomAddress(), LocalDate.now().minusDays(10));
        mentalWellness2 = new MentalWellnessEnterprise("PEAK Psychological Institute", getRandomAddress(), LocalDate.now().minusDays(11));
        mentalWellness3 = new MentalWellnessEnterprise("Fortitude Mental Health", getRandomAddress(), LocalDate.now().minusDays(6));
                
        pharmacy1 = new PharmacyEnterprise("CVS Pharmacy", getRandomAddress(), LocalDate.now().minusDays(9));
        pharmacy2 = new PharmacyEnterprise("Walgreens Pharmacy", getRandomAddress(), LocalDate.now().minusDays(12));
        pharmacy3 = new PharmacyEnterprise("Bartell Drugs", getRandomAddress(), LocalDate.now().minusDays(7));
        

        enterpriseDirectory.addEnterprise(healthManagementApp);
        
        enterpriseDirectory.addEnterprise(hospital1);
        enterpriseDirectory.addEnterprise(hospital2);
        enterpriseDirectory.addEnterprise(hospital3);
        
        enterpriseDirectory.addEnterprise(insuranceCompany1);
        enterpriseDirectory.addEnterprise(insuranceCompany2);
        enterpriseDirectory.addEnterprise(insuranceCompany3);
        
        enterpriseDirectory.addEnterprise(physicalWellness1);
        enterpriseDirectory.addEnterprise(physicalWellness2);
        enterpriseDirectory.addEnterprise(physicalWellness3);
        
        enterpriseDirectory.addEnterprise(mentalWellness1);
        enterpriseDirectory.addEnterprise(mentalWellness2);
        enterpriseDirectory.addEnterprise(mentalWellness3);
        
        enterpriseDirectory.addEnterprise(pharmacy1);
        enterpriseDirectory.addEnterprise(pharmacy2);
        enterpriseDirectory.addEnterprise(pharmacy3);

        // Create Organizations and all them to enterprise
        Organization adminOrg = new SystemAdminOrganization("System Admin Org", healthManagementApp, LocalDate.now().minusDays(2));
        organizationDirectory.addOrganization(adminOrg);
        healthManagementApp.addOrganization(adminOrg);

        Organization patientOrg = new PatientOrganization("Patient Org", healthManagementApp, LocalDate.now().minusDays(2));
        organizationDirectory.addOrganization(patientOrg);
        healthManagementApp.addOrganization(patientOrg);

        // Add primary care organization
        Organization primaryCareOrg1 = new PrimaryCareOrganization("Virginia Mason Primary Care Unit", hospital1, LocalDate.now().minusDays(2));
        Organization primaryCareOrg2 = new PrimaryCareOrganization("Swedish Primary Care Unit", hospital2, LocalDate.now().minusDays(1));
        Organization primaryCareOrg3 = new PrimaryCareOrganization("Harborview Primary Care Unit", hospital3, LocalDate.now().minusDays(2));

        organizationDirectory.addOrganization(primaryCareOrg1);
        organizationDirectory.addOrganization(primaryCareOrg2);
        organizationDirectory.addOrganization(primaryCareOrg3);
        
        hospital1.addOrganization(primaryCareOrg1);
        hospital2.addOrganization(primaryCareOrg2);
        hospital3.addOrganization(primaryCareOrg3);
        
        // Add lab organization
        Organization laboratoryOrg1 = new LaboratoryOrganization("Virginia Mason Lab Tests Unit", hospital1, LocalDate.now().minusDays(3));
        Organization laboratoryOrg2 = new LaboratoryOrganization("Swedish Primary Lab Tests Unit", hospital2, LocalDate.now().minusDays(3));
        Organization laboratoryOrg3 = new LaboratoryOrganization("Harborview Lab Tests Unit", hospital3, LocalDate.now().minusDays(1));
        
        organizationDirectory.addOrganization(laboratoryOrg1);
        organizationDirectory.addOrganization(laboratoryOrg2);
        organizationDirectory.addOrganization(laboratoryOrg3);
        
        hospital1.addOrganization(laboratoryOrg1);
        hospital2.addOrganization(laboratoryOrg2);
        hospital3.addOrganization(laboratoryOrg3);
        
        // Add health insurance organizations
        Organization healthInsuranceOrg1 = new HealthInsuranceDepartmentOrganization("Premera Health Insurance Department", insuranceCompany1, LocalDate.now().minusDays(2));
        Organization healthInsuranceOrg2 = new HealthInsuranceDepartmentOrganization("Progressive Health Insurance Department", insuranceCompany2, LocalDate.now().minusDays(1));
        Organization healthInsuranceOrg3 = new HealthInsuranceDepartmentOrganization("GEICO Health Insurance Department", insuranceCompany3, LocalDate.now().minusDays(3));
        
        organizationDirectory.addOrganization(healthInsuranceOrg1);
        organizationDirectory.addOrganization(healthInsuranceOrg2);
        organizationDirectory.addOrganization(healthInsuranceOrg3);
        
        insuranceCompany1.addOrganization(healthInsuranceOrg1);
        insuranceCompany2.addOrganization(healthInsuranceOrg2);
        insuranceCompany3.addOrganization(healthInsuranceOrg3);

        // Add nutrition department
        Organization nutritionDepartmentOrg1 = new NutritionDepartmentOrganization("Crossfit Nutrition Department", physicalWellness1, LocalDate.now().minusDays(3));
        Organization nutritionDepartmentOrg2 = new NutritionDepartmentOrganization("Academy of Nutrition", physicalWellness2, LocalDate.now().minusDays(3));
        Organization nutritionDepartmentOrg3 = new NutritionDepartmentOrganization("The Carrot Chefs Nutrition", physicalWellness3, LocalDate.now().minusDays(3));
        
        organizationDirectory.addOrganization(nutritionDepartmentOrg1);
        organizationDirectory.addOrganization(nutritionDepartmentOrg2);
        organizationDirectory.addOrganization(nutritionDepartmentOrg3);
        
        physicalWellness1.addOrganization(nutritionDepartmentOrg1);
        physicalWellness2.addOrganization(nutritionDepartmentOrg2);
        physicalWellness3.addOrganization(nutritionDepartmentOrg3);
        
        // Add gym organization
        Organization gymOrg1=new GymOrganization("Felix Fitness",physicalWellness1, LocalDate.now().minusDays(2));
        Organization gymOrg2=new GymOrganization("Pandora Fitness",physicalWellness2, LocalDate.now().minusDays(2));
        Organization gymOrg3=new GymOrganization("24 Hour Fitness",physicalWellness3, LocalDate.now().minusDays(1));
        
        organizationDirectory.addOrganization(gymOrg1);
        organizationDirectory.addOrganization(gymOrg2);
        organizationDirectory.addOrganization(gymOrg3);
        
        physicalWellness1.addOrganization(gymOrg1);
        physicalWellness2.addOrganization(gymOrg2);
        physicalWellness3.addOrganization(gymOrg3);
        
        Organization phychiatristOrg1=new PsychiatristOrganization("Psychiatric Medicine Associates",mentalWellness1, LocalDate.now().minusDays(1));
        Organization phychiatristOrg2=new PsychiatristOrganization("Martini Psychiatrics",mentalWellness2, LocalDate.now().minusDays(1));
        Organization phychiatristOrg3=new PsychiatristOrganization("Crescent Psychiatry",mentalWellness3, LocalDate.now().minusDays(1));
        
        organizationDirectory.addOrganization(phychiatristOrg1);
        organizationDirectory.addOrganization(phychiatristOrg2);
        organizationDirectory.addOrganization(phychiatristOrg3);
        
        mentalWellness1.addOrganization(phychiatristOrg1);
        mentalWellness2.addOrganization(phychiatristOrg2);
        mentalWellness3.addOrganization(phychiatristOrg3);
        
        Organization medicineInventoryOrg1 = new MedicineInventoryOrganization("CVS Inventory Department", pharmacy1, LocalDate.now().minusDays(1));
        Organization medicineInventoryOrg2 = new MedicineInventoryOrganization("Walgreens Inventory Department", pharmacy2, LocalDate.now().minusDays(2));
        Organization medicineInventoryOrg3 = new MedicineInventoryOrganization("Bartell Inventory Department", pharmacy3, LocalDate.now().minusDays(3));
        
        organizationDirectory.addOrganization(medicineInventoryOrg1);
        organizationDirectory.addOrganization(medicineInventoryOrg2);
        organizationDirectory.addOrganization(medicineInventoryOrg3);
        
        pharmacy1.addOrganization(medicineInventoryOrg1);
        pharmacy2.addOrganization(medicineInventoryOrg2);
        pharmacy3.addOrganization(medicineInventoryOrg3);
        
        Organization deliveryDepartmentOrganization1 = new DeliveryDepartmentOrganization("CVS Medicine delivery department", pharmacy1, LocalDate.now().minusDays(3));
        Organization deliveryDepartmentOrganization2 = new DeliveryDepartmentOrganization("Walgreens Medicine delivery department", pharmacy2, LocalDate.now().minusDays(1));
        Organization deliveryDepartmentOrganization3 = new DeliveryDepartmentOrganization("Bartell Medicine delivery department", pharmacy3, LocalDate.now().minusDays(1));
        
        organizationDirectory.addOrganization(deliveryDepartmentOrganization1);
        organizationDirectory.addOrganization(deliveryDepartmentOrganization2);
        organizationDirectory.addOrganization(deliveryDepartmentOrganization3);
        
        pharmacy1.addOrganization(deliveryDepartmentOrganization1);
        pharmacy2.addOrganization(deliveryDepartmentOrganization2);
        pharmacy3.addOrganization(deliveryDepartmentOrganization3);

        // Create roles
        // Admin
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, null ,new UserAccount("sysadmin", "sysadmin"), -1, "healthspringapp@gmail.com");
        this.globalUserDirectory.createNewUser(sysAdmin);
        adminOrg.addEmployee(sysAdmin);
        
        // Doctor
        Person sampleDoctor = new Doctor("Dr. James", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("doc1", "doc1"), 
                primaryCareOrg1.getOrganizationId());
        this.globalUserDirectory.createNewUser(sampleDoctor);
        primaryCareOrg1.addEmployee(sampleDoctor);

        // Lab Assistant
        Person labAssistant = new LaboratoryAssistant("David", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null , new UserAccount("lab1", "lab1"), 
                laboratoryOrg1.getOrganizationId());
        this.globalUserDirectory.createNewUser(labAssistant);
        laboratoryOrg1.addEmployee(labAssistant);

         // Dietitian
        Person dietitian = new Dietitian("Jim", LocalDate.now(), PersonDetails.Gender.MALE, 
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", new UserAccount("jim", "jim"),null, 
                gymOrg1.getOrganizationId());
        this.globalUserDirectory.createNewUser(dietitian);
        gymOrg1.addEmployee(dietitian);
        
         // FitnessTrainer
        Person fitnessTrainer = new FitnessTrainer("Jack", LocalDate.now(), PersonDetails.Gender.MALE, 
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", 
                new UserAccount("jack", "jack"),null, gymOrg1.getOrganizationId());
        this.globalUserDirectory.createNewUser(fitnessTrainer);
        gymOrg1.addEmployee(fitnessTrainer);
        
         // Counselor
        Person counselor = new Counselor("Zena", LocalDate.now(), PersonDetails.Gender.FEMALE, 
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "1234567890", 
                new UserAccount("zena", "zena"),null, phychiatristOrg1.getOrganizationId(), "zeena@irs.org");
        this.globalUserDirectory.createNewUser(counselor);
        phychiatristOrg1.addEmployee(counselor);

        // Insurance provider representative
        Person insuranceRep = new InsuranceProviderRepresentative("Peter", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("peter", "peter"), 
                healthInsuranceOrg1.getOrganizationId(), "peter@premera.org");
        this.globalUserDirectory.createNewUser(insuranceRep);
        healthInsuranceOrg1.addEmployee(insuranceRep);
        ((InsuranceProviderRepresentative) insuranceRep).setOrganization(healthInsuranceOrg1);
        
        // Pharmacist
        Person pharmacist = new Pharmacist("Adam", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), 
                "2132921728", null ,new UserAccount("adam", "adam"), medicineInventoryOrg1.getOrganizationId());
        this.globalUserDirectory.createNewUser(pharmacist);
        medicineInventoryOrg1.addEmployee(pharmacist);
        pharmacistDirectory.addPharmacist((Pharmacist)pharmacist);
        
        // Delivery man
        Person sampleDeliveryMan = new DeliveryMan("Nathan", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("213 W Adams Blvd", "134", "Seattle", "98108", "WA", "USA"), 
                "2132921728", null ,new UserAccount("nathan", "nathan"), deliveryDepartmentOrganization1.getOrganizationId());
        this.globalUserDirectory.createNewUser(sampleDeliveryMan);
        deliveryDepartmentOrganization1.addEmployee(sampleDeliveryMan);
        


        List<Person> doctors = new ArrayList<>();
        addRandomPerson(doctors, primaryCareOrg1, DOCTOR, PersonDetails.Gender.MALE);
        addRandomPerson(doctors, primaryCareOrg2, DOCTOR, PersonDetails.Gender.MALE);
        addRandomPerson(doctors, primaryCareOrg3, DOCTOR, PersonDetails.Gender.FEMALE);

        List<Person> labAssistants = new ArrayList<>();
        addRandomPerson(labAssistants, laboratoryOrg1, Role.LABASSISTANT, PersonDetails.Gender.MALE);
        addRandomPerson(labAssistants, laboratoryOrg2, Role.LABASSISTANT, PersonDetails.Gender.MALE);
        addRandomPerson(labAssistants, laboratoryOrg3, Role.LABASSISTANT, PersonDetails.Gender.MALE);
        
        List<Person> pharmacists = new ArrayList<>();
        addRandomPerson(pharmacists, 1, medicineInventoryOrg1, Role.PHARMACIST, PersonDetails.Gender.MALE);
        addRandomPerson(pharmacists, 1, medicineInventoryOrg2, Role.PHARMACIST, PersonDetails.Gender.MALE);
        addRandomPerson(pharmacists, 1, medicineInventoryOrg3, Role.PHARMACIST, PersonDetails.Gender.MALE);
        
        List<Person> deliveryMen = new ArrayList<>();
        addRandomPerson(deliveryMen, deliveryDepartmentOrganization1, Role.DELIVERY_MAN, PersonDetails.Gender.MALE);
        addRandomPerson(deliveryMen, deliveryDepartmentOrganization2, Role.DELIVERY_MAN, PersonDetails.Gender.MALE);
        addRandomPerson(deliveryMen, deliveryDepartmentOrganization3, Role.DELIVERY_MAN, PersonDetails.Gender.MALE);
        
        List<Person> insuranceRepresentative = new ArrayList<>();
        addRandomPerson(insuranceRepresentative, 1, healthInsuranceOrg1, Role.INSURANCE_PROVIDER_REP, PersonDetails.Gender.MALE);
        addRandomPerson(insuranceRepresentative, 1, healthInsuranceOrg2, Role.INSURANCE_PROVIDER_REP, PersonDetails.Gender.MALE);
        addRandomPerson(insuranceRepresentative, 1, healthInsuranceOrg3, Role.INSURANCE_PROVIDER_REP, PersonDetails.Gender.MALE);
        
        List<Person> dietitians = new ArrayList<>();
        addRandomPerson(dietitians, nutritionDepartmentOrg1, Role.DIETITIAN, PersonDetails.Gender.MALE);
        addRandomPerson(dietitians, nutritionDepartmentOrg2, Role.DIETITIAN, PersonDetails.Gender.FEMALE);
        addRandomPerson(dietitians, nutritionDepartmentOrg3, Role.DIETITIAN, PersonDetails.Gender.FEMALE);
        
        List<Person> gymTrainers = new ArrayList<>();
        addRandomPerson(gymTrainers, gymOrg1, Role.TRAINER, PersonDetails.Gender.MALE);
        addRandomPerson(gymTrainers, gymOrg2, Role.TRAINER, PersonDetails.Gender.MALE);
        addRandomPerson(gymTrainers, gymOrg3, Role.TRAINER, PersonDetails.Gender.FEMALE);
        
        List<Person> counsellers = new ArrayList<>();
        addRandomPerson(counsellers, phychiatristOrg1, Role.COUNSELOR, PersonDetails.Gender.MALE);
        addRandomPerson(counsellers, phychiatristOrg2, Role.COUNSELOR, PersonDetails.Gender.MALE);
        addRandomPerson(counsellers, phychiatristOrg3, Role.COUNSELOR, PersonDetails.Gender.FEMALE);
        
        // Patient
        Person samplePatient = new Patient("Ankur Bywar", 
                LocalDate.now().minusYears(30), 
                PersonDetails.Gender.FEMALE,
                new Address("906 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), 
                "2067085330", 
                null, 
                new UserAccount("ankur", "ankur"), 
                patientOrg.getOrganizationId(), 
                (PharmacyEnterprise) pharmacy2, 
                "ankurbywar@gmail.com");
        this.globalUserDirectory.createNewUser(samplePatient);
        patientOrg.addEmployee(samplePatient);
        
        mockMedicines();
        addDummyPrescriptions(
                (Patient)samplePatient, 
                (Doctor)doctors.get(MockDataCreator.random.nextInt(deliveryMen.size())), 
                deliveryMen.get(MockDataCreator.random.nextInt(deliveryMen.size())), 
                pharmacy1);
        
        addDummyVitalSigns((Patient)samplePatient);
        addDummyDoctorReviews(doctors);
        addDummyDeliveryManReviews(deliveryMen);
        
        addDummyDoctorReviews(Arrays.asList(sampleDoctor));
        addDummyDeliveryManReviews(Arrays.asList(sampleDeliveryMan));
    }
    
    void addDummyVitalSigns(Patient patient) {
        for (int i = 1; i <= 15; i++) {
            patient.addNewVitalSign(new VitalSigns(new Range(random(80), random(120)), random(70), random(125), random(60, 3), LocalDate.now().minusDays(7 * i)));
        } 
    }
    
    int random(int x) {
        return Math.abs(random.nextInt() % 6) + x;
    }
    
    int random(int x, int factor) {
        return Math.abs(random.nextInt() % factor) + x;
    }
    
    void mockMedicines() {
        medicineDirectory.addMedicine("Vicodin", 10.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Amoxil", 20.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Neurontin", 30.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Glucophage", 40.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Prinivil", 50.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Synthroid", 10.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Amoxil", 20.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Metformin", 30.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Levothyroxine", 40.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
        medicineDirectory.addMedicine("Albuterol", 50.00, LocalDate.now().minusDays(200), LocalDate.now().plusDays(100));
    }
    
    void addDummyPrescriptions(Patient patient, Doctor doctor, Person deliveryMan, Enterprise pharmacy) {
        Map<String, Medicine> meds = medicineDirectory.medicineCatalogMap.getIntermalMap();
        List<Medicine> medList = new ArrayList<>(meds.values());
        
        for (int i = 1; i <= 5; i++) {
            Appointment appointment = new Appointment(patient, "", doctor, LocalDate.now().minusDays(i), 9);
            Prescription prescription = new Prescription(appointment);
            
            prescription.addMedicine(getRandomMedicine(medList), new Dosage(1, -1, "100 mcg", true, true, false, false));
            prescription.addMedicine(getRandomMedicine(medList), new Dosage(1, -1, "50 mcg", true, false, true, false));
            prescription.addMedicine(getRandomMedicine(medList), new Dosage(2, -1, "150 mcg", false, false, true, true));
            patient.addPrescription(prescription);
            prescription.setDeliveryDate(Date.from(Instant.now().minusSeconds(86400 * i)));
            prescription.setDeliveryMan((DeliveryMan)deliveryMan);
            prescription.setDeliveryReviewProvided(true);
            prescription.setPharmacyName(pharmacy.getEnterpriseName());
            prescriptionDirectory.addPrescription(appointment.getId(), prescription);
        }
    }
    
    Medicine getRandomMedicine(List<Medicine> medList) {
        return medList.get(Math.abs(random.nextInt()) % (medList.size() - 1));
    }
    
    void addDummyDoctorReviews(List<Person> doctors) {
        
        for (Person doctor : doctors) {
            for (String review : positiveDocReviews) {
                ((Doctor)doctor).addRating(new Rating(goodRating(), review, LocalDate.now().minusDays(randomNumberSmall())));
            }
        }
        
        for (Person doctor : doctors) {
            for (String review : poorDocReviews) {
                ((Doctor)doctor).addRating(new Rating(badRating(), review, LocalDate.now().minusDays(randomNumberSmall())));
            }
        }
    }
    
    void addDummyDeliveryManReviews(List<Person> doctors) {
        for (Person doctor : doctors) {
            for (String review : positiveDocReviews) {
                ((DeliveryMan)doctor).addRating(new Rating(goodRating(), "Good delivery", LocalDate.now().minusDays(randomNumberSmall())));
            }
        }
        
        for (Person doctor : doctors) {
            for (String review : poorDocReviews) {
                ((DeliveryMan)doctor).addRating(new Rating(badRating(), "The parcel was not securely delivered", LocalDate.now().minusDays(randomNumberSmall())));
            }
        }
    }

    private void addRandomPerson(
            List<Person> personList, 
            Organization org, 
            Role role, 
            PersonDetails.Gender gender) {
        
        for (int i = 1; i <= 3; i++) {
            addRandomPerson(personList, 1, org, role, gender);
        }
    }

    private void addRandomPerson(
            List<Person> personList, 
            int count, 
            Organization org, 
            Role role, 
            PersonDetails.Gender gender) {
        String name = getName(gender);
        Person person = null;
        switch (role) {
            case DOCTOR:
                person = new Doctor("Dr. " + name, getDOB(), gender, getAddress(), "2067085330", null,
                        getUserAccount(name), org.getOrganizationId());
                break;

            case INSURANCE_PROVIDER_REP:
                person = new InsuranceProviderRepresentative(name, getDOB(), gender, getAddress(), "2067085330", null,
                        getUserAccount(name), org.getOrganizationId());
                break;
                
            case DELIVERY_MAN:
                person = new DeliveryMan(name, getDOB(), gender, getAddress(), "2067085330", null,
                        getUserAccount(name), org.getOrganizationId());
                break;
                
            case PHARMACIST:
                person = new Pharmacist(name, getDOB(), gender, getAddress(), "2067085330", null,
                        getUserAccount(name), org.getOrganizationId());
                break;
                
            case DIETITIAN:
                person = new Dietitian(name, getDOB(), gender, getAddress(), "2067085330",
                        getUserAccount(name), null, org.getOrganizationId());
                break;
                
            case TRAINER:
                person = new FitnessTrainer(name, getDOB(), gender, getAddress(), "2067085330",
                        getUserAccount(name), null, org.getOrganizationId());
                break;
                
            case COUNSELOR:
                person = new Counselor(name, getDOB(), gender, getAddress(), "2067085330",
                        getUserAccount(name), null, org.getOrganizationId());
                break;
                
            case LABASSISTANT:
                person = new LaboratoryAssistant(name, getDOB(), gender, getAddress(), "2067085330", null,
                        getUserAccount(name), org.getOrganizationId());
                break;
        }
        
        personList.add(person);
        globalUserDirectory.createNewUser(person);
        
    }
    
    private String getName(PersonDetails.Gender gender) {
        if (gender == PersonDetails.Gender.FEMALE) {
            return MockDataCreator.getRandomFemaleName();
        }
        return MockDataCreator.getRandomMaleName();
    }
    
    private LocalDate getDOB() {
        return LocalDate.now().minusYears(MockDataCreator.randomYearNumber());
    }
    
    private Address getAddress() {
        return MockDataCreator.getRandomAddress();
    }
    
    private UserAccount getUserAccount(String name) {
        String newName = name + Math.abs(random.nextInt());
        return new UserAccount(newName.toLowerCase(), newName.toLowerCase());
    }
}
