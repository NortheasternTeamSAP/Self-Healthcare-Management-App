/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

/**
 *
 * @author mrs.katey
 */
public class InsurancePlanDetails {
    String planName;
    int monthly;
    int deductible;
    String otherDetails;

    public InsurancePlanDetails(String planName, int monthly, int deductible, String otherDetails) {
        this.planName = planName;
        this.monthly = monthly;
        this.deductible = deductible;
        this.otherDetails = otherDetails;
    }

    public int getMonthly() {
        return monthly;
    }

    public int getDeductible() {
        return deductible;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public String getPlanName() {
        return planName;
    }
    
    public String getFormattedDetails() {
        return "Monthly: " + monthly + "$, \n" +
                "Deductible: " + deductible + "$, \n" +
                "Other details: " + otherDetails;
    }
    
    public String getDetails() {
        return "Monthly: " + monthly + "$, " +
                "Deductible: " + deductible + "$, " +
                "Other details: " + otherDetails;
    }
        
}
