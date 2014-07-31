/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ProcessFramework;

/**
 *
 * @author Shama H
 */
public abstract class MaterialLot {

    double totalAmount;
    public void setTAmount(double amount){
        totalAmount=amount;
    }
    public double getTAmount(){
        return totalAmount;
    }
}
