/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ankur Bywar
 */
public class LaboratoryTest {

    public enum TestType {
        HEMOGLOBIN,
        THYROID,
        VITAMIN_D,
        VITAMIN_B12,
        BLOOD_SUGAR
    }
    
    private Map<TestType, Double> testResults;
    
    public LaboratoryTest() {
        testResults = new HashMap<>();
    }
    
    public Map<TestType, Double> getTestResults() {
        return testResults;
    }
    
    public void add(TestType testType, double value) {
        testResults.put(testType, value);
    }
    
    public Double get(TestType testType) {
        return testResults.get(testType);
    }
}
