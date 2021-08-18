/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Personnel.Person;
import Personnel.PersonDetails;
import Utils.ConsoleLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ankur Bywar
 * @author Sravya
 * 
 * A generic directory with key-value pairs. 
 * 
 */



public class GenericDirectory<Key, Value> {
    
    private Map<Key, Value> directory;
    ConsoleLogger log = ConsoleLogger.getLogger();

    public GenericDirectory() {
        this.directory = new HashMap<>();
    }
    
    public void add(Key key, Value value) {
        
        if (key == null) {
            log.error("Key cannot be null");
            return;
        }
        
        if (value == null) {
            log.error("Value cannot be null");
            return;
        }
        
        if (directory.containsKey(key)) {
            log.debug("Directory already "
                    + "contains key: " + key + ". Overwriting with new value.");
        }
        
        directory.put(key, value);
    }
    
    public void remove(Key key) {
        
        if (key == null) {
            log.error("Key is null");
            return;
        }
        
        if (!directory.containsKey(key)) {
            log.debug("Directory does not contain key: " + key);
        }
        directory.remove(key);
    }
    
    public Value get(Key key) {
        
        if (key == null) {
            log.error("Key is null");
            return null;
        }
        
        return directory.get(key);
    }
    
    public List<Value> getAllValues() {
        return new ArrayList<>(directory.values());
    }
    
    public ArrayList<ItemTuple> getAllItems() {
        ArrayList<ItemTuple> a = new ArrayList<>();
        for (Key key: directory.keySet()){
            a.add(new ItemTuple(key, directory.get(key)));
        }
        return a;
    }
}
