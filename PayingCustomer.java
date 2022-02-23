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
 */
public class PayingCustomer extends Customer{

    private ArrayList<String> associates;
    
    /**
     * Constructor
     */
    public PayingCustomer(String pcName, String pcEmail)
    {
        name=pcName;
        email=pcEmail;
        associates=new ArrayList<String>();
        supplements=new ArrayList<String>();
        id=createID();
        membership=true;
    }
   
}

