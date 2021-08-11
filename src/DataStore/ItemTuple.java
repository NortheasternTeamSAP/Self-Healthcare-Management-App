/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

/**
 *
 * @author sravy
 */
public class ItemTuple{
    Object key;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    Object value;
    
    public ItemTuple(Object key, Object value){
        this.key = key;
        this.value = value;
    }
}