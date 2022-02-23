/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schwork.question2;

/**
 *
 * @author Liew Zi Hao
 */
public class Supplement {
    private static int suppCount=0;
    private String name;
    private double cost;
    private String id;
    
    /**
     * constructors
     */
    public Supplement(String supName,double supCost)
    {
        id="Supplement("+(suppCount++)+")";
        name=supName;
        cost=supCost;
    }
    
    /**
     * @return return customer id
     */
    public String getID()
    {
        return id;
    }
    /**
     * @return customer's name
     */
    public String getName()
    {
        return name;
    }
    /**
     * returns cost
     */
    public double getCost()
    {
        return cost;
    }
}
