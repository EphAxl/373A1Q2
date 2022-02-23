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
public class AssociateCustomer extends Customer{
    public AssociateCustomer(String acName, String acEmail)
    {
        name=acName;
        email=acEmail;
        supplements=new ArrayList<String>();
        id=createID();
    }
}
