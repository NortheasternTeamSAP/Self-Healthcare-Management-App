/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

import Enterprise.Enterprise;
import Enterprise.InsuranceCompanyEnterprise;
import Personnel.Person;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class InsuranceDetails {
    
    public enum InsuranceRequestApprovalStatus {
        PENDING,
        APPROVED,
        DECLINED
    }
    
    int id;
    long insuranceNumber;
    long groupNumber;
    Enterprise insuranceProvider;
    InsurancePlanDetails planDetails;
    Person patient;
    LocalDate expiryDate;
    LocalDate requestDate;
    
    InsuranceRequestApprovalStatus insuranceRequestApprovalStatus;
    
    static int count = 1;

    public InsuranceDetails(
            Enterprise insuranceProvider, 
            InsurancePlanDetails planDetails,
            Person patient, 
            InsuranceRequestApprovalStatus insuranceRequestApprovalStatus,
            LocalDate requestDate) {
//        this.insuranceNumber = insuranceNumber;
//        this.groupNumber = groupNumber;
        this.insuranceProvider = insuranceProvider;
        this.planDetails = planDetails;
        this.patient = patient;
        this.insuranceRequestApprovalStatus = insuranceRequestApprovalStatus;
        this.requestDate = requestDate;
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public long getGroupNumber() {
        return groupNumber;
    }

    public Enterprise getInsuranceProvider() {
        return insuranceProvider;
    }

    public InsurancePlanDetails getCoverageDetails() {
        return planDetails;
    }

    public Person getPatient() {
        return patient;
    }

    public InsuranceRequestApprovalStatus getInsuranceRequestApprovalStatus() {
        return insuranceRequestApprovalStatus;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public void setRequestDate(LocalDate date) {
        this.requestDate = date;
    }

    public InsurancePlanDetails getPlanDetails() {
        return planDetails;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setInsuranceRequestApprovalStatus(InsuranceRequestApprovalStatus insuranceRequestApprovalStatus) {
        this.insuranceRequestApprovalStatus = insuranceRequestApprovalStatus;
    }
    
    
    
    
}
