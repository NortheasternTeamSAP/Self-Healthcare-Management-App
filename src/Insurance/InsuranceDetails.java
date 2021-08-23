/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

import Enterprise.Enterprise;
import Enterprise.InsuranceCompanyEnterprise;
import Personnel.Person;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
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
    
    long id;
    long insuranceNumber;
    long groupNumber;
    Enterprise insuranceProvider;
    InsurancePlanDetails planDetails;
    Person patient;
    LocalDate expiryDate;
    LocalDate requestDate;
    
    InsuranceRequestApprovalStatus insuranceRequestApprovalStatus;

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
        this.id = Instant.now().toEpochMilli();
    }

    public long getId() {
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
    
    public boolean generateFileForInsuranceDetails(String filePath) {
        try {
          FileWriter myWriter = new FileWriter(filePath);
          myWriter.write("** Patient Insurance Details **");
          myWriter.write("\n Patient Name: " + this.patient.getPersonDetails().getFullName());
          myWriter.write("\n Patient date of birth: " + this.patient.getPersonDetails().getDob().toString());
          myWriter.write("\n Insurance Company: " + this.insuranceProvider.getEnterpriseName());
          myWriter.write("\n Insurance Group Number: " + this.groupNumber);
          myWriter.write("\n Insurance number: " + this.insuranceNumber);
          myWriter.write("\n Insurance type: Health Insurance");
          myWriter.write("\n Insurance Plan name:" + this.planDetails.planName);
          myWriter.write("\n Insurance Plan details:" + this.planDetails.getDetails());
          myWriter.write("\n Insurance expiry date:" + this.getExpiryDate().toString());
          myWriter.close();
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    
    
}
