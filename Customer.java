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
 * abstract class that contains the functions
 */
public class Customer {
    protected static int custCount=0;
    protected String id;
    protected String name;
    protected String email;
    protected ArrayList<String> supplements = new ArrayList<String>();
    protected Boolean membership = false;
    
    //Paying customers
    protected String paymentMethod;
    protected String accountNo;
    protected ArrayList<String> associates = new ArrayList<String>();

    public Customer(String id,String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }
    
    /**
     * Create customer ID
     */
    protected String createID()
    {
        return"Customer("+(custCount++)+")";
    }
    
    /**
     * @return returns cust id
     * 
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * @return returns cust name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return returns cust email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * @return returns array list of supplements
     * 
     */
    public ArrayList<String> getSupplements()
    {
        return supplements;
    }
    /**
     * @param id supplement id
     * @return returns 1 when added 0 if id alr exists
     * 
     */
    public void addSupplement(String id)
    {
        if(!supplements.contains(id))
            supplements.add(id);
    }   
    /**
     * @returns boolean on membership type
     */
    public Boolean hasMembership()
    {
        if(id!="")
        {
            return true;
        }
        return false;
    }
    
    
    
    //Paying Customer methods
    
    /**
     * Defines customer's payment method
     * @param method credit or debit payment type
     * 
     */
    public void setPaymentMethod(String method)
    {
        paymentMethod=method;
    }
    /**
     * @returns customer's preferred payment method
     */
    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    
    /**
     * @param number customer's account number
     */
    public void setAccountNo(String number)
    {
        accountNo=number;
    }
    /**
     * @return get method for customer account number
     */
    public String getAccountNo()
    {
        return accountNo;   
    }
    /**
     * @param id ID of associate customer
     * @returns 1 if successfully added else 0 if existing
     */
    public int addAssociate(String id)
    {
        if(associates.contains(id))
        {
            return 0;
        }
        associates.add(id);
        return 1;
    }
    /**
     * @return return id of associates in a list
     */
    public ArrayList<String> getAssociates()
    {
        return associates;
    }
}
