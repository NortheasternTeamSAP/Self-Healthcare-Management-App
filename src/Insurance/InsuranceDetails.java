/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

import Enterprise.InsuranceCompanyEnterprise;
import Personnel.Person;

/**
 *
 * @author Ankur Bywar
 */
public class InsuranceDetails {
    
    public enum InsuranceType {
        HEALTH,
        INVALID;
    }
    
    long insuranceNumber;
    InsuranceCompanyEnterprise insuranceProvider;
    InsuranceType insuranceType;
    HealthInsuranceCoverage coverageDetails;
    Person patient;
}
