/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Ankur Bywar
 */
public class ConsoleLogger {
    
    static ConsoleLogger logger = new ConsoleLogger();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public static ConsoleLogger getLogger() {
        return logger;
    }
    
    public void debug(final String message) {
        System.out.println(message);
    }
    
    public void error(final String message) {
        System.out.println(message);
    }
}
