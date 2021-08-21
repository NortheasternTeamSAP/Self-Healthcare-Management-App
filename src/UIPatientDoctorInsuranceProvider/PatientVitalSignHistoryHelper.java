/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import Utils.GraphPlotterUtils;
import VitalSign.VitalSigns;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mrs.katey
 */
public class PatientVitalSignHistoryHelper {
    
    public DefaultCategoryDataset createPatientVitalsSignsDefaultCategoryDataSet(GraphPlotterUtils graphPlotterUtils, List<VitalSigns> vitalSignsHistory) {
        Map<LocalDate, Double> lowBloodPressureVitalSignMap = new TreeMap<>();
        Map<LocalDate, Double> highBloodPressureVitalSignMap = new TreeMap<>();
        Map<LocalDate, Double> heartRateVitalSignMap = new TreeMap<>();
        Map<LocalDate, Double> respiratoryRateVitalSignMap = new TreeMap<>();
        Map<LocalDate, Double> weightVitalSignMap = new TreeMap<>();
        for (VitalSigns vs : vitalSignsHistory) {
            lowBloodPressureVitalSignMap.put(vs.getDateForVitalSigns(), vs.getBloodPressure().getLow());
            highBloodPressureVitalSignMap.put(vs.getDateForVitalSigns(), vs.getBloodPressure().getHigh());
            heartRateVitalSignMap.put(vs.getDateForVitalSigns(), vs.getHeartRate() * 1.0);
            respiratoryRateVitalSignMap.put(vs.getDateForVitalSigns(), vs.getRespiratoryRate() * 1.0);
            weightVitalSignMap.put(vs.getDateForVitalSigns(), vs.getWeight() * 1.0);
        }

       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       graphPlotterUtils.addToDataSet(lowBloodPressureVitalSignMap, "LowBP", dataset);
       graphPlotterUtils.addToDataSet(highBloodPressureVitalSignMap, "HighBP", dataset);
       graphPlotterUtils.addToDataSet(heartRateVitalSignMap, "HeartRate", dataset);
       graphPlotterUtils.addToDataSet(respiratoryRateVitalSignMap, "RespiratoryRate", dataset);
       graphPlotterUtils.addToDataSet(weightVitalSignMap, "Weight", dataset);
       
       return dataset;
    }
    
}
