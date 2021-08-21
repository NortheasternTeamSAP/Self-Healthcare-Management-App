/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;
import Insurance.InsuranceDetails;
import Insurance.PrimaryCareInsuranceClaim;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public class HealthInsuranceDepartmentOrganization extends Organization {
    
    List<PrimaryCareInsuranceClaim> pendingMedicalInsuranceClaims;
    List<PrimaryCareInsuranceClaim> processedMedicalInsuranceClaims;
    
    List<InsuranceDetails> pendingnewInsuranceRequests;
    List<InsuranceDetails> processedInsuranceRequests;
    
    public HealthInsuranceDepartmentOrganization(String name, Enterprise enterprise, LocalDate organizationCreationDate) {
        super(name, enterprise, OrganizationType.HEALTH_INSURANCE_DEPARTMENT, organizationCreationDate);
        pendingMedicalInsuranceClaims = new ArrayList<>();
        processedMedicalInsuranceClaims = new ArrayList<>();
        pendingnewInsuranceRequests = new ArrayList<>();
        processedInsuranceRequests = new ArrayList<>();
    }
    
    public void addMedicalInsuranceClaim(PrimaryCareInsuranceClaim claim) {
        pendingMedicalInsuranceClaims.add(claim);
    }
    
    public void processMedicalInsuranceClaim(PrimaryCareInsuranceClaim claim) {
        if (pendingMedicalInsuranceClaims.contains(claim)) {
            pendingMedicalInsuranceClaims.remove(claim);
            processedMedicalInsuranceClaims.add(claim);
        }
    }

    public List<PrimaryCareInsuranceClaim> getPendingMedicalInsuranceClaims() {
        return pendingMedicalInsuranceClaims;
    }

    public List<PrimaryCareInsuranceClaim> getProcessedMedicalInsuranceClaims() {
        return processedMedicalInsuranceClaims;
    }

    public void addInsuranceRequest(InsuranceDetails insuranceDetails) {
        pendingnewInsuranceRequests.add(insuranceDetails);
    } 

    public List<InsuranceDetails> getPendingnewInsuranceRequests() {
        return pendingnewInsuranceRequests;
    }
    
    public List<InsuranceDetails> getProcessedInsuranceRequests() {
        return processedInsuranceRequests;
    }
    
    public void processInsuranceRequest(InsuranceDetails request) {
        if (pendingnewInsuranceRequests.remove(request)) {
            processedInsuranceRequests.add(request);
        }
    }
    
    public InsuranceDetails getUnprocessedInsuranceRequest(int id) {
        for (InsuranceDetails insuranceDetails : pendingnewInsuranceRequests) {
            if (insuranceDetails.getId() == id) {
                return insuranceDetails;
            }
        }
        
        return null;
    }
}
