/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import DataStore.GenericDirectory;
import DeliveryMan.DeliveryMan;
import Doctor.Doctor;
import Medicine.Medicine;
import Medicine.MedicineDirectory;
import Patient.Patient;
import Pharmacy.Pharmacy;
import java.util.ArrayList;

/**
 *
 * @author Sravya
 */
public class OrderDirectory {
    
    public GenericDirectory<String, Order> orderMap; //map for <String orderID, Order orderDetails>
    private int id; //for Order ID
    
    public OrderDirectory(){
        this.orderMap = new GenericDirectory<>();
        id = 0;
    }
    
    // return the order Id.
    public String addOrder(
            Pharmacy pharmacy, 
            Doctor doctor, 
            Patient patient,
            int quantity, 
            Medicine medicine, 
            int appointmentID){
        
        Order order = new Order(
                pharmacy,
                doctor,
                patient,
                quantity,
                medicine,
                appointmentID);
        String orderId = "Order" + Integer.toString(id);
        orderMap.add(orderId, order);
        order.setOrderId(orderId);
        id += 1;
        return orderId;
    }

    public void deleteOrder(Order order){
        orderMap.remove(Integer.toString(id));
    }
    
    
    
//    public Order getOrderID(String orderUUID){
//        for(int i = 0; i < 15; i = i + 1){
//            if(order.getOrderUUID() == orderUUID){
//                return order;
//            }
//        }
//        return null;
//    }

    public GenericDirectory<String, Order> getOrderMap() {
        return orderMap;
    }
    
    
    public ArrayList<Order> getOrdersByPharmacy(Pharmacy pharmacy) {
        ArrayList<Order> ret_list = new ArrayList<>();
        for (Order order: orderMap.getAllValues()){
            if (order.getPharmacy() == pharmacy){
                ret_list.add(order);
            }
        }
        return ret_list;
    }

    public ArrayList<Order> getOrdersByDelMan(DeliveryMan delMan) {
        ArrayList<Order> ret_list = new ArrayList<>();
        for (Order order: orderMap.getAllValues()){
            if (order.getDeliveryMan()== delMan){
                ret_list.add(order);
            }
        }
        return ret_list;
    }

    public Order findMedicine(Medicine med){
        for(Order order: orderMap.getAllValues()){
            if(order.getMedicine().equals(med)){
                return order;
            }
        }
        return null;
    }
}
