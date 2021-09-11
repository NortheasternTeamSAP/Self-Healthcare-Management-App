/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataMock;

import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Enterprise.HealthManagementAppEnterprise;
import Personnel.Address;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mrs.katey
 */
public class MockDataCreator {
    public static Random random = new Random();
    
    public static int randomYearNumber() {
        return Math.abs(random.nextInt()) % 10 + 40;
    }
    
    public static int randomNumberSmall() {
        return Math.abs(random.nextInt()) % 10 + 1;
    }
    
    public static int goodRating() {
        return Math.abs(random.nextInt()) % 3 + 3;
    }
    
    public static int badRating() {
        return Math.abs(random.nextInt()) % 3 + 1;
    }
    
    public static List<String> positiveDocReviews = Arrays.asList(
            "The services that I receive is excellent. \nThe staff are friendly and ensure that I am properly informed about my health and care. \nI would have no qualms in recommending them to friendly and friends",
            "Doctor did a great job with my first ever health exam. \nThey explained everything to me in a very clear manner. \nThey was also kind and friendly. \nAll of the staff was great – they were helpful, patient and helped with my insurance",
            "Great medical office, wonderful and warm experience from start to finish. Appreciate doctor taking time to go over the diagnosis clearly and treatment options. Was referred over by my general doctor and can see why. Highly recommended.",
            "Knowledgeable, sensitive, informative… \nI immediately felt at ease – and felt confident in my receiving expert medical care. \nStaff was great, too. Walked away, very impressed w. the overall experience. \nHIGHLY recommend"
    );
    
    public static List<String> poorDocReviews = Arrays.asList(
            "Not that great service. \nThe staff was rude.",
            "The doctor did not arrive in time and I had to wait for an hour",
            "The doctor cancelled my appointment twice without prior notice.\nVery unreliable primary care."
    );
    
    static List<Address> randomAddress = Arrays.asList(
            new Address("1232 Harrison St", "201", "Seattle", "98109", "WA", "USA"),
            new Address("906 Dexter Ane N", "122", "Seattle", "98117", "WA", "USA"),
            new Address("720 Thomas Ave", "444", "Seattle", "98178", "WA", "USA"),
            new Address("111 Boren Ave E", "26", "Seattle", "98980", "WA", "USA"),
            new Address("117 20th Ave E", "82", "Seattle", "98453", "WA", "USA"),
            new Address("949 Adams Blvd", "114", "Seattle", "98109", "WA", "USA"),
            new Address("172 32nd NE St", "783", "Seattle", "98453", "WA", "USA"),
            new Address("5 Sierra Dr", "663", "Seattle", "98117", "WA", "USA"),
            new Address("8815 Marvon Street", "545", "Seattle", "98453", "WA", "USA"),
            new Address("8705 Thatcher St", "289", "Seattle", "98117", "WA", "USA"),
            new Address("624 Saxton Lane", "114", "Seattle", "98117", "WA", "USA"),
            new Address("7 Philmont St", "989", "Seattle", "98117", "WA", "USA"),
            new Address("56 East Warren Ave", "101", "Seattle", "98117", "WA", "USA"),
            new Address("2426 Knox 1000 Rd E", "202", "Seattle", "98453", "WA", "USA"),
            new Address("113 Lasalle St", "443", "Seattle", "98109", "WA", "USA"),
            new Address("307 Toledo St", "212", "Seattle", "98453", "WA", "USA"),
            new Address("625 Napoleon St", "332", "Seattle", "98109", "WA", "USA"),
            new Address("722 Parker Dr", "221", "Seattle", "98453", "WA", "USA"),
            new Address("4304 Franklin Rd", "333", "Seattle", "98109", "WA", "USA")
    );
            
    
    static List<String> maleNames = Arrays.asList(
            "Aaron",
            "Abraham",
            "Agustin",
            "Damian",
            "Dee",
            "David",
            "Davis",
            "Herbert",
            "Hilton",
            "Hong",
            "Lee",
            "Lucio",
            "Luke",
            "Richard",
            "Ronald",
            "Ross",
            "Ralph",
            "Rocky",
            "Tom",
            "Terrance",
            "Tyson",
            "Tim",
            "Thomas",
            "Shane",
            "Stan",
            "Samuel",
            "Sid",
            "Sean"
        );
    
    static List<String> femaleNames = Arrays.asList(
            "Allie",
            "April",
            "Amanda",
            "Ashlee",
            "Anika",
            "Camie",
            "Cindy",
            "Daisy",
            "Dee",
            "Hailey",
            "Helen",
            "Liza",
            "Leena",
            "Nancy",
            "Norah",
            "Rose",
            "Rikki",
            "Roma",
            "Tom",
            "Terresa",
            "Tiara",
            "Tim",
            "Thomas",
            "Sharan",
            "Sindy",
            "Sophia",
            "Sarah",
            "Scarlet"
        );
    
    public static String getRandomMaleName() {
        return maleNames.get(Math.abs(random.nextInt()) % maleNames.size());
    }
    
    public static String getRandomFemaleName() {
        return femaleNames.get(Math.abs(random.nextInt()) % femaleNames.size());
    }
    
    public static Address getRandomAddress() {
        return randomAddress.get(Math.abs(random.nextInt()) % randomAddress.size());
    }
}
