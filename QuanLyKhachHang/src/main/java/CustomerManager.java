import model.Customer;

import java.util.ArrayList;

public class CustomerManager {
   static ArrayList<Customer> customers = new ArrayList<>();
     static{
         customers.add(new Customer(1 , "a" , "1-1-2004" , "HN"));
         customers.add(new Customer(2 , "b" , "1-1-2004" , "HN"));
         customers.add(new Customer(3 , "c" , "1-1-2004" , "HN"));
         customers.add(new Customer(4 , "d" , "1-1-2004" , "HN"));
     }

    public ArrayList<Customer> show(){
        return customers ;
    }



}
