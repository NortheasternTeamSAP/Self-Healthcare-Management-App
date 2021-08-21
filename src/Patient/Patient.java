/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import Counselor.CounsellingNote;
import Counselor.Counselor;
import Counselor.CounselorAppointment;
import DataStore.Appointment;
import Dietitian.DietPlan;
import Dietitian.Dietitian;
import Dietitian.DietitianAppointment;
import FitnessTrainer.FitnessPlan;
import FitnessTrainer.FitnessTrainer;
import FitnessTrainer.FitnessTrainerAppointment;
import Insurance.InsuranceDetails;
import Laboratory.LaboratoryTestReport;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import Enterprise.PharmacyEnterprise;
import Prescription.Prescription;
import Utils.Rating;
import VitalSign.VitalSignNormalRange;
import VitalSign.VitalSigns;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 */
public class Patient implements Person {

    private PersonDetails patientDetails;
    private ArrayList<DietPlan> dietplans;
    private ArrayList<DietitianAppointment> dietitianAppointments;
    private ArrayList<FitnessPlan> fitnessPlans;
    private ArrayList<FitnessTrainerAppointment> fitnessTrainerAppointments;
    private ArrayList<CounsellingNote> counsellingNotes;
    private ArrayList<CounselorAppointment> counselorAppointments;
    private Map<LocalDate, VitalSigns> vitalSignsHistory;
    private VitalSigns mostRecentVitalSigns;
    private VitalSignNormalRange vitalSignNormalRange;
    private ArrayList<Appointment> doctorAppointments;
    private ArrayList<Appointment> doctorAppointmentsHistory;
    private ArrayList<LaboratoryTestReport> labTestReports;
    private PharmacyEnterprise preferredPharmacy;
    private InsuranceDetails insuranceDetails;
    private ArrayList<Prescription> prescriptionsList;
    
    
   
    
    public Patient(
                String fullName, 
                LocalDate dob, 
                Gender gender, 
                Address address, 
                String phoneNumber, 
                Icon logoImage,
                UserAccount account,
                int organizationId,
                PharmacyEnterprise preferredPharmacy
            ) {

        patientDetails = new PersonDetails(
                                    fullName, 
                                    dob, 
                                    gender, 
                                    address, 
                                    phoneNumber, 
                                    account, 
                                    Role.PATIENT, 
                                    logoImage, 
                                    organizationId
                                );
        dietplans = new ArrayList<DietPlan>();
        dietitianAppointments = new ArrayList<DietitianAppointment> ();
        fitnessPlans=new ArrayList<FitnessPlan>();
        fitnessTrainerAppointments=new ArrayList<FitnessTrainerAppointment>();
        counsellingNotes=new ArrayList<CounsellingNote>();
        counselorAppointments=new ArrayList<CounselorAppointment>();
        this.vitalSignsHistory = new HashMap<>();
        this.mostRecentVitalSigns = null;
        this.vitalSignNormalRange = null;
        this.doctorAppointments = new ArrayList<>();
        this.doctorAppointmentsHistory = new ArrayList<>();
        this.labTestReports = new ArrayList<>();
        this.preferredPharmacy = preferredPharmacy;
        this.prescriptionsList = new ArrayList<Prescription>();
        this.insuranceDetails = null;
    }
    
    public Patient(
                String fullName, 
                LocalDate dob, 
                Gender gender, 
                Address address, 
                String phoneNumber, 
                Icon logoImage,
                UserAccount account,
                int organizationId,
                PharmacyEnterprise preferredPharmacy,
                String emailId
            ) {

        patientDetails = new PersonDetails(
                                    fullName, 
                                    dob, 
                                    gender, 
                                    address, 
                                    phoneNumber, 
                                    account, 
                                    Role.PATIENT, 
                                    logoImage, 
                                    organizationId,
                                    emailId);
        dietplans = new ArrayList<DietPlan>();
        dietitianAppointments = new ArrayList<DietitianAppointment> ();
        fitnessPlans=new ArrayList<FitnessPlan>();
        fitnessTrainerAppointments=new ArrayList<FitnessTrainerAppointment>();
        counsellingNotes=new ArrayList<CounsellingNote>();
        counselorAppointments=new ArrayList<CounselorAppointment>();
        this.vitalSignsHistory = new HashMap<>();
        this.mostRecentVitalSigns = null;
        this.vitalSignNormalRange = null;
        this.doctorAppointments = new ArrayList<>();
        this.doctorAppointmentsHistory = new ArrayList<>();
        this.labTestReports = new ArrayList<>();
        this.preferredPharmacy = preferredPharmacy;
        this.prescriptionsList = new ArrayList<Prescription>();
        this.insuranceDetails = null;
    }
    

    
    
//    public Patient(
//            String fullName, 
//            LocalDate dob, 
//            Gender gender, 
//            Address address, 
//            String phoneNumber,
//            Icon logoImage,
//            UserAccount account,
//            int organizationId, 
//            Pharmacy preferredPharmacy) {
//        
//        patientDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.PATIENT, logoImage, organizationId);
//        dietplans = new ArrayList<DietPlan>();
//        dietitianAppointments = new ArrayList<DietitianAppointment> ();
//        fitnessPlans=new ArrayList<FitnessPlan>();
//        fitnessTrainerAppointments=new ArrayList<FitnessTrainerAppointment>();
//        counsellingNotes=new ArrayList<CounsellingNote>();
//        counselorAppointments=new ArrayList<CounselorAppointment>();
//        this.vitalSignsHistory = new HashMap<>();
//        this.mostRecentVitalSigns = null;
//        this.vitalSignNormalRange = null;
//        this.doctorAppointments = new ArrayList<>();
//        this.doctorAppointmentsHistory = new ArrayList<>();
//        this.labTestReports = new ArrayList<>();
//        this.preferredPharmacy = preferredPharmacy;
//    }
    
    @Override
    public PersonDetails getPersonDetails() {
        return patientDetails;
    }
    @Override
    public UserAccount getUserAccount() {
        return patientDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return patientDetails.getRole();
    }

    public boolean scheduleDietitianAppointment(Dietitian dietitian, LocalDate date, int timeHours,String restriction,String medication,String cheifcomplaint)
    {
        if (!dietitian.isDietitianAvailable(date, timeHours))
        {
            return false;
        }
        DietitianAppointment appointment = dietitian.scheduleAppointment(date, this, timeHours,restriction,medication,cheifcomplaint);
        if (appointment != null)
        {
          
            dietitianAppointments.add(appointment);
            return true;
        }
        return false;
    }
   
    public void addDietplan(DietPlan dp){
        dietplans.add(dp);
    }

    public ArrayList<DietPlan> getDietplans() {
        return dietplans;
    }

    public ArrayList<DietitianAppointment> getDietitianAppointments() {
        return dietitianAppointments;
    }
       
   public boolean scheduleFitnessAppointment(FitnessTrainer fitnessTrainer, LocalDate date, int timeHours,String restriction,String medication,String cheifcomplaint )
    {
        if (!fitnessTrainer.isFitnessTrainerAvailable(date, timeHours))
        {
            return false;
        }        
        FitnessTrainerAppointment appointment = fitnessTrainer.scheduleAppointment(date, this, timeHours,restriction,medication,cheifcomplaint);
        if (appointment != null)
        {
            fitnessTrainerAppointments.add(appointment);
           
            return true;
        }
        return false;
    }
    
    public void addFitnessPlan(FitnessPlan fp){
        fitnessPlans.add(fp);
    }

    public ArrayList<FitnessPlan> getFitnessPlans() {
        return fitnessPlans;
    }

    public ArrayList<FitnessTrainerAppointment> getFitnessTrainerAppointments() {
        return fitnessTrainerAppointments;
    }
    
     public boolean scheduleCounselorAppointment(Counselor counselor, LocalDate date, int timeHours,String restriction,String medication,String cheifcomplaint)
    {
        if (!counselor.isCounselorAvailable(date, timeHours))
        {
            return false;
        }           
        CounselorAppointment appointment = counselor.scheduleAppointment(date, this, timeHours,restriction,medication,cheifcomplaint);
        if (appointment != null)
        {
            counselorAppointments.add(appointment);
            return true;
        }
        return false;
    }
    
    public void addCounsellingNotes(CounsellingNote cn){
        counsellingNotes.add(cn);
    }

    public ArrayList<CounsellingNote> getCounsellingNotes() {
        return counsellingNotes;
    }

    public ArrayList<CounselorAppointment> getCounselorAppointments() {
        return counselorAppointments;
    }
    
    public PersonDetails getPatientDetails() {
        return patientDetails;
    }

    public List<VitalSigns> getVitalSignsHistory() {
        return new ArrayList<>(this.vitalSignsHistory.values());
    }

    public void addNewVitalSign(VitalSigns vs) {
        if (vs != null) {
            this.vitalSignsHistory.put(vs.getDateForVitalSigns(), vs);
            if (this.mostRecentVitalSigns == null) {
                this.mostRecentVitalSigns = vs;
            } else {
                if (this.mostRecentVitalSigns.getDateForVitalSigns().isBefore(vs.getDateForVitalSigns())) {
                    this.mostRecentVitalSigns = vs;
                }
            }
        } else {
            throw new RuntimeException("Trying to add a null VitalSign to vitalSignsHistory");
        }
    }
    
    public VitalSigns getMostRecentVitalSigns() {
        return this.mostRecentVitalSigns;
    }

    public void addDoctorAppointment(Appointment apt) {
        doctorAppointments.add(apt);
    }
    
    public void completeDoctorAppointment(Appointment apt) {
        if (this.doctorAppointments.remove(apt)) {
            this.doctorAppointmentsHistory.add(apt);
        }
    }
    
    public List<Appointment> getDoctorAppointmentsHistory() {
        return this.doctorAppointmentsHistory;
    }
    
    public List<Appointment> getUpcomingDoctorAppointments() {
        return this.doctorAppointments;
    }
    
    public InsuranceDetails getInsuranceDetails() {
        return insuranceDetails;
    }

    public void setInsuranceDetails(InsuranceDetails insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    @Override
    public String toString() {
        return "" + patientDetails.getFullName() ;
    }
    
    public void setPreferredPharmacy(PharmacyEnterprise preferredPharmacy) {
        this.preferredPharmacy = preferredPharmacy;
    }

    public PharmacyEnterprise getPreferredPharmacy() {
        return preferredPharmacy;
    }
    
    public int getOrganizationId() {
        return getPersonDetails().getOrganizationId();
    }

    public ArrayList<Prescription> getPrescriptionsList() {
        return prescriptionsList;
    }

    public void addPrescription(Prescription prescription) {
        
        boolean prescriptionFound = false;
        for (Prescription p : this.prescriptionsList) {
            if (p.getAppointment().getId()== prescription.getAppointment().getId()) {
                // A prescription already exists for with the same appointment id. 
                // This means the delivery man has delivered prescrption for the same appointment in split orders
                // In this case, just merge the prescriptions
                p.mergePrescription(prescription);
                prescriptionFound = true;
            }
        }
        
        if (!prescriptionFound) {
            // Add a new prescription in the list and sort the list by prescription date 
            this.prescriptionsList.add(prescription);
            Collections.sort(this.prescriptionsList);
        }
    }
    
    public Prescription getLatestMedicinePrescription() {
        return this.prescriptionsList.isEmpty() ? null : this.prescriptionsList.get(0); // return 1st element since the prescriptionsList is sorted
    }

    @Override
    public void updateDetails(PersonDetails newPatientDetails) {
        this.patientDetails = newPatientDetails;
    }

    @Override
    public void addRating(Rating rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rating> getAllRatings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
