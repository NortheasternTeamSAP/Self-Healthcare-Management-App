/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VitalSign;

/**
 *
 * @author Ankur Bywar
 */
public class Range {
     double low;
    double high;

    public Range(double low, double high) {
        this.low = low;
        this.high = high;
    }

    Range() {
        this.low = 0;
        this.high = 0;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }
    
}
