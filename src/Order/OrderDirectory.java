/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import DataStore.GenericDirectory;
import Doctor.Doctor;
import Medicine.MedicineDirectory;
import Pharmacy.Pharmacy;

/**
 *
 * @author Sravya
 */
public class OrderDirectory {
    
    public static GenericDirectory<String, Order> orderMap; //map for <String orderID, Order orderDetails>
    private int id;
    
    public OrderDirectory(){
        this.orderMap = new GenericDirectory<>();
        id = 0;
    }
    
    public Order addOrder(){
        Order order = new Order();
        OrderDirectory.orderMap.add(Integer.toString(id), order);
        id += 1;
        return order;
    }

    public void deleteOrder(Order order){
        OrderDirectory.orderMap.remove(Integer.toString(id));
    }
    
//    public Order getOrderID(String orderUUID){
//        for(int i = 0; i < 15; i = i + 1){
//            if(order.getOrderUUID() == orderUUID){
//                return order;
//            }
//        }
//        return null;
//    }
    
}
