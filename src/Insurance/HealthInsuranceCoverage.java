/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

/**
 *
 * @author Ankur Bywar
 */
class HealthInsuranceCoverage {
    
    static final int DEFAULT_PRIMARY_CARE_VISIT_COVERAGE = 1000;
    
    private int primaryCareVisitCoverage;

    public HealthInsuranceCoverage(int primaryCareVisitCoverage) {
        this.primaryCareVisitCoverage = primaryCareVisitCoverage;
    }
    
    public HealthInsuranceCoverage() {
        primaryCareVisitCoverage = DEFAULT_PRIMARY_CARE_VISIT_COVERAGE;
    }
    
}
