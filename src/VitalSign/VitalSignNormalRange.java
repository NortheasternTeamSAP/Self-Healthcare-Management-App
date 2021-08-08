/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VitalSign;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Ankur Bywar
 */
public class VitalSignNormalRange {
     HashMap<String , Range> normalBloodPressureMap;
    HashMap<String , Range> normalHeartRateMap;
    HashMap<String , Range> normalRespiratoryRateMap;
    HashMap<String , Range> normalWeightMap;
    
    
    
    public VitalSignNormalRange() {
        normalBloodPressureMap = new HashMap<>();
        normalHeartRateMap = new HashMap<>();
        normalRespiratoryRateMap = new HashMap<>();
        normalWeightMap = new HashMap<>();
        
        
        
        normalHeartRateMap.put("newborn" , new Range(120,50));
        normalHeartRateMap.put("infant" , new Range(80,140));
        normalHeartRateMap.put("toddler" , new Range(80,130));
        normalHeartRateMap.put("preschool" , new Range(80,110));
        normalHeartRateMap.put("school" , new Range(80,120));
        normalHeartRateMap.put("adolescent" , new Range(110,120));
        normalHeartRateMap.put("adult" , new Range(110,120));   
        
        normalBloodPressureMap.put("newborn" , new Range(50,150));
        normalBloodPressureMap.put("infant" , new Range(80,140));
        normalBloodPressureMap.put("toddler" , new Range(80,130));
        normalBloodPressureMap.put("preschool" , new Range(80,110));
        normalBloodPressureMap.put("school" , new Range(80,120));
        normalBloodPressureMap.put("adolescent" , new Range(110,120));
        normalBloodPressureMap.put("adult" , new Range(90,120));
        
        
        
        
        normalRespiratoryRateMap.put("newborn" , new Range(120,50));
        normalRespiratoryRateMap.put("infant" , new Range(80,140));
        normalRespiratoryRateMap.put("toddler" , new Range(80,130));
        normalRespiratoryRateMap.put("preschool" , new Range(80,110));
        normalRespiratoryRateMap.put("school" , new Range(80,120));
        normalRespiratoryRateMap.put("adolescent" , new Range(110,120));
        normalRespiratoryRateMap.put("adult" , new Range(110,120));
        
        
        normalWeightMap.put("newborn" , new Range(4,7));
        normalWeightMap.put("infant" , new Range(9,22));
        normalWeightMap.put("toddler" , new Range(22,31));
        normalWeightMap.put("preschool" , new Range(31,40));
        normalWeightMap.put("school" , new Range(40,109));
        normalWeightMap.put("adolescent" , new Range(109,500));
        normalWeightMap.put("adult" , new Range(109,500));
 
        
        
        
        
    }

    public HashMap<String, Range> getNormalBloodPressureMap() {
        return normalBloodPressureMap;
    }

    public HashMap<String, Range> getNormalHeartRateMap() {
        return normalHeartRateMap;
    }

    public HashMap<String, Range> getNormalRespiratoryRateMap() {
        return normalRespiratoryRateMap;
    }

    public HashMap<String, Range> getNormalWeightMap() {
        return normalWeightMap;
    }
    
    
    public boolean isBloodPressureNormal(Range bloodPressure, Date dob, Date visitDate) {
        Range nornalBPRange = getBloodPressureNormalRange(dob, visitDate);
        if (nornalBPRange == null) {
            System.err.println("Cannot find normal BP range");
            return false;
        }
        double low_low = nornalBPRange.getLow() - 5;
        double Low_high = nornalBPRange.getLow() + 5;
        
        double high_low = nornalBPRange.getHigh() - 5;
        double high_high = nornalBPRange.getHigh() + 5;
        
        if ((bloodPressure.getLow() >= low_low && bloodPressure.getLow() <= Low_high)   || 
                (bloodPressure.getHigh() >= high_low && bloodPressure.getHigh() <= high_high)) {
            return true;
        }
        return false;
    }
    
     public Range getBloodPressureNormalRange(Date dob, Date visitDate) {
        LocalDate localdob = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localvisitDate = visitDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = calculatePatientAgeInMonths(localdob, localvisitDate);
        
        String patientType = getPatientType(age);
        System.err.println("Patient type " + patientType + "    " + dob.toString());
        return normalBloodPressureMap.get(patientType);
     }
    
    
    public int calculatePatientAgeInMonths(Date dob, Date visitDate) {
        LocalDate localdob = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localvisitDate = visitDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return calculatePatientAgeInMonths(localdob, localvisitDate);
    }
    
    public int calculatePatientAgeInMonths(LocalDate dob, LocalDate visitDate) {
        
        // (1) Calculate time period between dob and current date
        Period period = Period.between(dob, visitDate);
        
        // (2) Convert time period into months
        int ageInMonths = (period.getYears() * 12) + period.getMonths();
        // If age is less than 1 month, round the age to 1 month
        if (period.getDays() > 0) {
            ageInMonths++;
        }
        
        // (3) return age in months
        return ageInMonths;
    }
    
    private String getPatientType(int ageInMonths) {
        if (isNewBorn(ageInMonths)) {
            return "newborn";
        } else if (isInfant(ageInMonths)) {
            return "infant";
        } else if (isToddler(ageInMonths)) {
            return "toddler";
        } else if (isPreschool(ageInMonths)) {
            return "preschool";
        } else if (isSchoolAge(ageInMonths)) {
            return "school";
        } else if (isAdolescent(ageInMonths)) {
            return "adolescent";
        } else if (isAdult(ageInMonths)) {
            return "adult";
        }
        return "invalid";
    }
    
    
    private boolean isNewBorn(int ageInMonths) {
        
        // if patient's age is <= 1 month, return true otherwise return false.
        if (ageInMonths == 1) {
            return true;  
        } else {
            return false;
        }
    }
    
    private boolean isInfant(int ageInMonths) {
        
        if (ageInMonths > 1 && ageInMonths <= 12) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isToddler(int ageInMonths) {
        
        if (ageInMonths > 12 && ageInMonths <= 36) {
            return true;
        }
        else {
            return false;
        }
    }
        
    private boolean isPreschool(int ageInMonths) {
        
        if (ageInMonths > 36 && ageInMonths <= 60) {
            return true;
        } else {
            return false;
        }
    }
            
    private boolean isSchoolAge(int ageInMonths) {
        if (ageInMonths > 60 && ageInMonths <= 144) {
            return true;
        } else {
            return false;
        }
    } 
    
    private boolean isAdolescent(int ageInMonths) {
        if (ageInMonths > 144 && ageInMonths <= 240) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isAdult(int ageInMonths) {
        if (ageInMonths > 241) {
            return true;
        } else {
            return false;
        }
    }
    
}
