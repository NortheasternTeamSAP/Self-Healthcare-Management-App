/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VitalSign;

import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class VitalSigns {
    private Range bloodPressure;
    
    private LocalDate dateForVitalSigns;
 
    private int heartRate;
    private int respiratoryRate;
    private int weight;
    
    
    
    public VitalSigns() {
        this.respiratoryRate = 0;
        this.heartRate = 0;
        this.bloodPressure = new Range();
        this.weight=0;        
        this.dateForVitalSigns = null;


    }

    public Range getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Range bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public LocalDate getDateForVitalSigns() {
        return dateForVitalSigns;
    }

    public void setDateForVitalSigns(LocalDate dateForVitalSigns) {
        this.dateForVitalSigns = dateForVitalSigns;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    
   
    }
}
