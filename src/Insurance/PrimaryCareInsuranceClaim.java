/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

import Enterprise.Enterprise;
import Organization.Organization;
import Personnel.Person;
import Utils.IdProvider;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public class PrimaryCareInsuranceClaim {
    
    public enum ClaimStatus {
        PENDING("Pending"),
        DECLINED("Declined"),
        PROCESSED("Processed")
        ;
        
        private String value;
    
        private ClaimStatus(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }
    
    double primaryCareProviderClaimCost;
    double laboratoryTestsClaimCost;
    List<String> laboratoryTestsPerformed;
    String laboratoryName;
    Person doctor;
    Person patient;
    LocalDate insuranceClaimDate;
    long claimId;
    Enterprise insuranceCompany;
    Organization insuranceCompanyOrganization;
    ClaimStatus claimSatus;
    
    double patientResponsibility;
    double insuranceDeductable;

    public PrimaryCareInsuranceClaim(
            double primaryCareProviderClaimCost, 
            double laboratoryTestsClaimCost, 
            List<String> laboratoryTestsPerformed, 
            String laboratoryName, 
            Person doctor, 
            Person patient,
            LocalDate insuranceClaimDate,
            Organization insuranceCompanyOrganization) {
        this.primaryCareProviderClaimCost = primaryCareProviderClaimCost;
        this.laboratoryTestsClaimCost = laboratoryTestsClaimCost;
        this.laboratoryTestsPerformed = laboratoryTestsPerformed;
        this.laboratoryName = laboratoryName;
        this.doctor = doctor;
        this.patient = patient;
        this.insuranceClaimDate = insuranceClaimDate;
        this.insuranceCompanyOrganization = insuranceCompanyOrganization;
        this.claimId = IdProvider.getUUID();
        
        this.claimSatus = ClaimStatus.PENDING;
    }

    public double getPrimaryCareProviderClaimCost() {
        return primaryCareProviderClaimCost;
    }

    public double getLaboratoryTestsClaimCost() {
        return laboratoryTestsClaimCost;
    }

    public List<String> getLaboratoryTestsPerformed() {
        return laboratoryTestsPerformed;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public Person getDoctor() {
        return doctor;
    }

    public Person getPatient() {
        return patient;
    }

    public LocalDate getInsuranceClaimDate() {
        return insuranceClaimDate;
    }

    public long getClaimId() {
        return claimId;
    }

    public Enterprise getInsuranceCompany() {
        return insuranceCompany;
    }

    public Organization getInsuranceCompanyOrganization() {
        return insuranceCompanyOrganization;
    }

    public ClaimStatus getClaimSatus() {
        return claimSatus;
    }
    
    public double getPatientResponsibility() {
        return patientResponsibility;
    }

    public void setPatientResponsibility(double patientResponsibility) {
        this.patientResponsibility = patientResponsibility;
    }

    public double getInsuranceDeductable() {
        return insuranceDeductable;
    }

    public void setInsuranceDeductable(double insuranceDeductable) {
        this.insuranceDeductable = insuranceDeductable;
    }

    public void setClaimSatus(ClaimStatus claimSatus) {
        this.claimSatus = claimSatus;
    }
    
    public double getTotalClaimAmount() {
        return primaryCareProviderClaimCost + laboratoryTestsClaimCost;
    }
}
