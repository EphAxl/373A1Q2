/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schwork.question2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Liew Zi Hao
 */
public class Subscriber {
    private char userInput;
    private Boolean runSystem;
    private Scanner scanner;
    private Customers customers;
    private Magazine magazine;
    
    
    
    /**
     * Hard coded supplements
     */
    private void createSupplements()
    {
        magazine.addSupplement("Reader Supplement",3.5);
        magazine.addSupplement("Vitamin'supplement", 3.6);
        magazine.addSupplement("Health Supplement",2.5);
        magazine.addSupplement("Life support",4.8);
    }
    /**
     * Hard code customers
     */
    private void createCustomers()
    {
        Customer associateCust1=new Customer("001", "Joe","JoeStar@joemail.com");
        Customer associateCust2=new Customer("002","Darth","DarthVader@deathstar.com");
        Customer associateCust3=new Customer("003", "Lloyd","LloydVi@Vivi.com");
        Customer payingCust4=new Customer("004","Guo Ba","GuoB@gmail.com");
        Customer payingCust5=new Customer("005","Liu Feng","Liu@gmail.com");
        
        associateCust1.addSupplement("Supplement(1)");
        associateCust2.addSupplement("Supplement(0)");
        associateCust3.addSupplement("Supplement(2)");
        payingCust4.addSupplement("Supplement(3)");
        payingCust5.addSupplement("Supplement(4)");
        associateCust1.addSupplement("Supplement(1)");
        associateCust2.addSupplement("Supplement(2)");
        associateCust3.addSupplement("Supplement(0)");
        payingCust5.addSupplement("Supplement(3)");
        payingCust4.addSupplement("Supplement(2)");
        
        payingCust4.setPaymentMethod("Credit Card");
        payingCust5.setPaymentMethod("Debit Card");
        payingCust4.setAccountNo("001-002-003");
        payingCust5.setAccountNo("007-999-007");
        payingCust4.addAssociate(associateCust1.getID());
        payingCust5.addAssociate(associateCust2.getID());
        payingCust4.addAssociate(associateCust3.getID());
        
        customers.addAssociate(associateCust1);
        customers.addAssociate(associateCust2);
        customers.addAssociate(associateCust3);
        customers.addMembership(payingCust4);
        customers.addMembership(payingCust5);
    }
    /**
     * Option 1 Display list of supplements
     */
    private void listSupplements()
    {
        ArrayList<Supplement>supplements=magazine.getSupplements();
        Supplement supplement;
        
        for(int i=0;i<supplements.size();i++)
        {
            supplement=supplements.get(i);
            System.out.printf("|%-8s|%-40s|\n","ID", supplement.getID());
            System.out.printf("|%-8s|%-40s|\n","name", supplement.getName());
            System.out.printf("|%-8s|%-40.2f|\n","ID", supplement.getCost());
        }
    }
    
    /**
     * Option2 list of customers
     */
    private void listCustomers()
    {
        Customer customer;
        ArrayList<Customer>all=customers.getAll();
        ArrayList<String>supplements;
        for(int i=0;i<all.size();i++)
        {
            customer=all.get(i);
            supplements=customer.getSupplements();
            System.out.printf("|%-16s|%-32s|\n","ID", customer.getID());
            System.out.printf("|%-16s|%-32s|\n","Name", customer.getName());
            System.out.printf("|%-16s|%-32s|\n","Email", customer.getEmail());
            System.out.printf("|%-16s|%-32s|\n","Supplements", supplements.size()>0?supplements:"none");
            
            if(customer.hasMembership())
            {
                Customer purchasingCust=(Customer) customer;
                ArrayList<String>associates=purchasingCust.getAssociates();
                System.out.printf("|%-16s|%-32s|\n","Payment Method", purchasingCust.getPaymentMethod());
                System.out.printf("|%-16s|%-32s|\n","Account Number", purchasingCust.getAccountNo());
                System.out.printf("|%-16s|%-32s|\n","Associates", associates.size()>0?associates:"none");
            }
        }
    }
    /**
     * Option 3 Display weekly email
     */
    private void showWeeklyEmails()
    {
        ArrayList<Customer>all=customers.getAll();
        for(int i=0;i<all.size();i++)
        {
            Customer customer=all.get(i);
            String supplementMessage="No Supplements";
            
            ArrayList<String> supplementID=customer.getSupplements();
            if(supplementID.size()>0)
            {
                for(int j=0;j<supplementID.size();j++)
                {
                    if(j==0)
                    {
                        supplementMessage=magazine.getSupplementName(supplementID.get(j));
                        
                    }
                    else
                    {
                        supplementMessage+=", ";
                        supplementMessage+=magazine.getSupplementName(supplementID.get(j));
                    }
                }
            }
            System.out.printf("Email:%-65s \n",customer.getEmail());
            System.out.printf("Hi %-70s \n",customer.getName()+",");
            System.out.printf("Your WeeklySubscription is ready\n");
            System.out.printf("Supplements:%-36s \n\n",supplementMessage);
        }
    }
    
    /**
     * Option 4 monthly bills
     */
    private void showMonthlyEmails()
    {
        Customer customer;
        ArrayList<Customer>all=customers.getAll();
        for(int i=0;i<all.size();i++)
        {
            customer=all.get(i);
            if(true)
            {
                Customer purchasingCust=(Customer) customer;
                double customerCost=getCustomerCost(purchasingCust.getID());
                ArrayList<String> associates=purchasingCust.getAssociates();
                ArrayList<String> supplements=purchasingCust.getSupplements();
                System.out.printf("| %-20s | %-37s | \n", "Monthly bills for",String.format("%s <%s>", purchasingCust.getName(),
                        purchasingCust.getEmail()));
                System.out.printf("| %-20s | %-37s | \n", "Payment Method",purchasingCust.getPaymentMethod());
                System.out.printf("| %-20s | %-37s | \n", "Account Number",purchasingCust.getAccountNo());
                System.out.printf("| %-20s | %-37s | \n", "Itemized Costs","Subscription" );
                System.out.printf("| %-20s | %-32s %4.2f | \n", "","-Magazine",magazine.getCost());
                for(int k=0;k<supplements.size();k++)
                {
                    System.out.printf("|%-22s|-%-34s%4.2f|\n","","",0.0);
                    magazine.getSupplementName(supplements.get(k));
                    magazine.getSupplementCost(supplements.get(k));
                }
                for(int j=0;j<associates.size();j++)
                {
                    Customer associate=(Customer)customers.getCustomerByID(associates.get(j)).get(0);
                    supplements=associate.getSupplements();
                    
                    System.out.printf("|%-22s|%-39s|\n","",associate.getName());
                    System.out.printf("|%-22s|%-35s%4.2f|\n","","-Magazine ",magazine.getCost());
                    
                    for(int m=0 ;m<supplements.size();m++)
                    {
                        System.out.printf("|%-22s|-%34s%4.2f|\n",magazine.getSupplementName(supplements.get(m)),"",
                                magazine.getSupplementCost(supplements.get(m)));
                    }
                    
                   System.out.printf("|%-22s|%-39.2f|\n","Grand total",customerCost);         
                }
                
            }
        }
    }
    
    /**
     * option 5 scans for new customer
     */
    private void promptAddCustomer()
    {
        {
        String id="";
        String membership="";
        String paymentOption="";
        String name="";
        String email="";
        String paymentMethod="";
        String accountNo="";
        String existingCustomerID="";
        String supplementID;
        ArrayList<String>supplements= new ArrayList<String>();
        while (id.isEmpty())
        {
            System.out.println("Customer ID");
            id=scanner.nextLine();
        }
        
        while (name.isEmpty())
        {
            System.out.println("Customer name:");
            name=scanner.nextLine();
        }
        while (email.isEmpty())
        {
            System.out.println("Customer email:");
            email=scanner.nextLine();
        }
        while(!membership.equals("y")&&!membership.equals("n"))
        {
            System.out.println("Are you a member? (y/n)");
            membership=scanner.nextLine();
        }
        
        //depending on whether customer is member or associate
        if(membership.equals("y"))
        {
            while(!paymentOption.equals("0")&& !paymentOption.equals("1"))
                    {
                        System.out.println("Select Customer's preferred payment method:");
                        System.out.println("0.Credit");
                        System.out.println("1.Debit");
                        System.out.println("Enter 0 or 1: ");
                        paymentOption=scanner.nextLine();
                    }
            if(paymentOption.equals("0"))
            {
                paymentMethod="Credit";
            }
            else
            {
                paymentMethod="Debit";
            }
            while (accountNo.isEmpty())
            {
                System.out.println("Customer's Payment Number:");
                accountNo=scanner.nextLine();
            }
                
        }
        else
        {
            while(true)
            {
                System.out.println("ID of existing paying customer:\n");
                existingCustomerID=scanner.nextLine();
                if(customers.isValidCustomer(existingCustomerID))
                {
                    break;
                }
                else
                {
                    System.out.printf("\"%s\"is not a valid paying customerID.\n", existingCustomerID);
                }
            }
        }
        //select supplements that customer is scribed to
        while(true)
        {
            System.out.printf("Enter a supplementID or enter to skip\n");
            System.out.printf("Supplement(0)-Reader Supplement\n");
            System.out.printf("Supplement(1)-Vitamin'supplement\n");
            System.out.printf("Supplement(2)-Health Supplement\n");
            System.out.printf("Supplement(3)-Life support\n");
            supplementID=scanner.nextLine();
            if(supplementID.equals(""))
            {
                break;
            }
            else
            {
                if(magazine.hasSupplement(supplementID))
                {
                    System.out.printf("**\"%s\"added.\n",supplementID);
                    supplements.add(supplementID);
                    
                }
                else
                {
                    System.out.printf("\"%s\"is not a valid supplement.\n",supplementID);
                }
            }
        }
        customers.add(id,name,email,supplements,membership.equals("y"),paymentMethod,accountNo,existingCustomerID);
        }
        
        
        System.out.println("Customer record added");
        System.out.println("Press Enter to continue");
        
    }
    /**
     * option 6
     */
    private void promptRemoveCustomer()
    {
        System.out.println("Enter Customer ID:");
        String customerID=scanner.nextLine();
        if(customers.removeCustomer(customerID)==1)
        {
            System.out.format("**Customer\"%s\"removed\n",customerID);
        }
        else
        {
             System.out.format("**Customer\"%s\"record not found,no record removed\n",customerID);
        }
        
    }
    

    
    
    
    /**
     * option 7
     * 
     */
    private void exitSystem()
    {
        System.out.println("Exiting System");
        System.exit(0);
    }
    private void promptContinue()
    {
        System.out.print("Type the text end to exit or continue by pressing enter");
        if(scanner.nextLine().equals("end"))
        {
            exitSystem();
        }
            
    }
    
    /**
     * prompt main menu
     */
    private void promptMainOptions()
    {
        while(runSystem)
        {
            System.out.printf("Welcome to the magazine management system");
            System.out.println("Please select one of the following options:");
            System.out.println("1.List available supplements");
            System.out.println("2.List of customers");
            System.out.println("3.Weekly email for all customers:");
            System.out.println("4.Monthly email for paying customers");
            System.out.println("5.Add a new customer");
            System.out.println("6.Remove an existing customer");
            System.out.println("7.Exit the programme");
            System.out.println("----------------------------------------------");
            System.out.println("Your selection:");
            userInput=scanner.next().charAt(0);
            runOption(userInput);
            
                    
        }
    }
    
    /**
     * carries out task according to user's selection
     * @param {char} option
     */
    private void runOption(char option)
    {
        scanner.nextLine();
        
        switch(option)
        {
            case '1':
                listSupplements();
                promptContinue();
                break;
            case '2':
                listCustomers();
                promptContinue();
                break;
            case '3':
                showWeeklyEmails();
                promptContinue();
                break;
            case '4':
                showMonthlyEmails();
                promptContinue();
                break;
            case '5':
                promptAddCustomer();
                promptContinue();
                break;
            case '6':
                promptRemoveCustomer();
                promptContinue();
                break;
            case '7':
                exitSystem();
            
            default:
                System.out.println("Invalid option selected");
                break;
        }
    }
    
/**Get total cost of customer's sub
 * @param id = customer id
 * @return cost of sub in total return 0 if no matches on id
 * 
 */
    private double getCustomerCost(String customerID)
    {
        double cost=0;
        ArrayList<Customer>matchingID=customers.getCustomerByID(customerID);
        if(matchingID.size()>0)
        {
            Customer customer=matchingID.get(0);
            ArrayList<String>supplements=customer.getSupplements();
            cost+=magazine.calculateTotalCost(supplements);
        }
        return cost;
    }
    
    /**
     * constructors
     */
    public Subscriber()
    {
        scanner=new Scanner(System.in);
        magazine=new Magazine();
        customers=new Customers();
        runSystem=true;
        createCustomers();
        createSupplements();
        promptMainOptions();
    }
    
    public void run()
    {
        while(true)
        {
            promptMainOptions();
        }
        
    }
    
    public static void main(String[] args)
    {
        Subscriber sub = new Subscriber();
        sub.run();
        
    }

}


