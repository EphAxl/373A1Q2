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
public class Magazine {
    private final String magName="Weekly Subscription";
    private final double magCost=5;
    private ArrayList<Supplement> supplements;
    
    /**
     * Constructors
     */
    public Magazine()
    {
        supplements=new ArrayList<Supplement>();
    }
    /**
     * @return returns mag name
     */
    public String getName()
    {
        return magName;
    }
    /**
     * @return mag cost
     */
    public double getCost()
    {
        return magCost;
    }
    /**
     * Add supplement instance to record
     * @param name name of supplement
     * @param cost cost of supplement
     */
    public void addSupplement(String name, double cost)
    {
        supplements.add(new Supplement(name,cost));
    }
    /**
     * @return list of supplements
     */
    public ArrayList<Supplement>getSupplements()
    {
        return supplements;
    }
    /**
     * check for mag with supplement
     * @param id supplement id
     * @return true if match found else false
     */
    public Boolean hasSupplement(String id)
    {
        for(int i=0;i<supplements.size();i++)
        {
            if(id.equals(supplements.get(i).getID()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the name of the supplement that matches id
     * @param id supplement id
     * @return supplement name if matched else empty string
     */
    public String getSupplementName(String id)
    {
        String match="";
        for(int i=0;i<supplements.size();i++)
        {
            if(id.equals(supplements.get(i).getID()))
            {
                return supplements.get(i).getName();
            }
        }
        return match;
    }
    /**
     * Gets the costs of supplement that matches id
     * @param id supplement id
     * @return returns supplement costs if matched else -1 assuming supplment can be free
     */
    public double getSupplementCost(String id)
    {
        double cost=-1;
        for(int i=0;i<supplements.size();i++)
        {
            if(id.equals(supplements.get(i).getID()))
            {
                return supplements.get(i).getCost();
            }
        }
        return cost;
    }
    /**
     * calculate total cost
     * @param supplementIDs list of supplement ids
     * @return total cost
     */
    public double calculateTotalCost(ArrayList<String>supplementIDs)
    {
        double total=getCost();
        for(int i=0;i<supplementIDs.size();i++)
        {
            total+=getSupplementCost(supplementIDs.get(i));
        }
        return total;
    }
}
