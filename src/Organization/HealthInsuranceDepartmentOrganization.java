/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;
import Insurance.PrimaryCareInsuranceClaim;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public class HealthInsuranceDepartmentOrganization extends Organization {
    
    List<PrimaryCareInsuranceClaim> pendingMedicalInsuranceClaims;
    List<PrimaryCareInsuranceClaim> processedMedicalInsuranceClaims;
    
    public HealthInsuranceDepartmentOrganization(String name, Enterprise enterprise) {
        super(name, enterprise, OrganizationType.HEALTH_INSURANCE_DEPARTMENT);
        pendingMedicalInsuranceClaims = new ArrayList<>();
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
    
    
    
}
