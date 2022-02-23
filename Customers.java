/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schwork.question2;
import java.util.ArrayList;
/**
 *
 * @author Liew Zi Hao
 * Customer instances and info
 */
public class Customers {
    private ArrayList<Customer>all;
    
    /**
     * Constructor
     */
    public Customers()
    {
        all=new ArrayList<Customer>();
    }
    
    /**
     * Customer details
     * @param id customer's id
     * @param name customer's name
     * @param email customer's email
     * @param supplements list of supplement id
     * @param membership type of customer paying or associate
     * @param paymentMethod payment method used by the customer
     * @param accountNo account number
     * @param purchaseCustID id of purchasing customer
     */
    
    public void add(String id,String name,String email,ArrayList<String>supplements,Boolean membership,
            String paymentMethod,String accountNo,String purchaseCustID)
    {
        if(membership)
        {
            Customer newCust= new Customer(id,name,email);
            newCust.setPaymentMethod(paymentMethod);
            newCust.setAccountNo(accountNo);
            
            for(int i=0;i<supplements.size();i++)
            {
                newCust.addSupplement(supplements.get(i));
            }
            all.add(newCust);
        }
        else
        {
            Customer newAssociateCust= new Customer(id,name,email);
            for(int i=0; i<supplements.size();i++)
            {
                newAssociateCust.addSupplement(supplements.get(i));
            }
            ArrayList<Customer> matchingID=getCustomerByID(purchaseCustID);
            if(matchingID.size()>0)
            {
                Customer purchasingCust=(Customer)matchingID.get(0);
                purchasingCust.addAssociate(newAssociateCust.getID());
                
            }
            all.add(newAssociateCust);
        }
    }
    
    /**
     * Add an associate customer instance to records
     * @param associate associate customers instances
     */
    public void addAssociate(Customer associate)
    {
        all.add(associate);
    }
    
    /**
     * Add a purchasing customer instance to records
     * @param membership membership instance
     */
    public void addMembership(Customer membership)
    {
        all.add(membership);
    }
    
    /**
     * Removes a customer id
     * @param id ID of customer
     * @return returns 1 if successfully removed else 0
     */
    
    public int removeCustomer(String id)
    {
        for (int i=0;i<all.size();i++)
        {
            Customer customer= all.get(i);
            if(id.equals(customer.getID()))
            {
                //an associate member; remove from paying customer's associates
                if(customer.hasMembership()) //just remove customer by id ignore the wholse associate shit
                {
                    String purchaseCustID=getAssociatePayer(id);
                    ArrayList<Customer> matchingID=getCustomerByID(purchaseCustID);
                    
                    if(matchingID.size()>0)
                    {
                        Customer purchaseCust=(Customer)matchingID.get(0);
                        ArrayList<String> associates= purchaseCust.getAssociates();
                        int associateIndex=associates.indexOf(id);
                        
                        if(associateIndex>-1)
                        {
                            associates.remove(associateIndex);
                        }
                    }
                    
                }
                all.remove(1);
                return 1;
            }
        }
        return 0;
    }
    
    

    /**
     * Check if customer is a member
     * @param id customer id
     * @return returns true if customer is member
     */
    public Boolean hasMembership(String id)
    {

        return false;
    }
    
    /**
     * Get a customer instance via ID
     * @param id ID of the customer
     * @return returns an array of customer that match the id
     * 
     */
    public ArrayList<Customer> getCustomerByID(String id)
    {
        ArrayList<Customer>matchingID=new ArrayList<Customer>();
        for(int i=0;i<all.size();i++)
        {
            if(id.equals(all.get(i).getID()))
            {
                matchingID.add(all.get(i));
            }
        }
        return matchingID;
    }
    /**
     * Merge the array lists
     */
    public ArrayList<Customer>getAll(){
        return all;
    }
    
    /** Checks if the selected customer is member or associate
     * @param id is customer id
     * @return returns true if customer is member else false
     */
    public Boolean isValidCustomer(String id)
    {
        Customer customer;
        for (int i=0;i<all.size();i++)
        {
            customer=all.get(i);
            if(id.equals(customer.getID())&&customer.hasMembership())
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get ID of customer who is paying for the associate
     * @param associateID ID of associate
     * @return Customer ID if a match is found, else empty
     */
    private String getAssociatePayer(String associateID)
    {
        String matchingID="";
        for(int i=0; i<all.size();i++)
        {
            if(all.get(i).hasMembership())
            {
                Customer customer=(Customer)all.get(i);
                ArrayList<String>associates=customer.getAssociates();
                if(associates.indexOf(associateID)>-1)
                {
                    return customer.getID();
                }
            }
        }
        return matchingID;
    }
}
