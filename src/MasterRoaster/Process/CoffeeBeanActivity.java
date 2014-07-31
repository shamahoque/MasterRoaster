/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Process;

/**
 *
 * @author shama
 */
import MasterRoaster.Material.*;


public class CoffeeBeanActivity {

   BeanLot bean;
   public CoffeeBeanActivity(BeanLot bean){
        this.bean=bean;
   }
   public double getTb(){
    return bean.getCoffeeBean().getBeanTemperature().getValue();
   }
   public double getTa(){
    return bean.getTemp().getValue();
   }
   public double getMb(){
    return bean.getMass().getValue();
   }
   public double getX(){
    return bean.getCoffeeBean().getBeanMoistureContent();
   }
   public double getCb(){
    return bean.getCoffeeBean().getCb().getValue();
   }
   public double getLv(){
    return bean.getCoffeeBean().getBeanLv().getValue();
   }
   public double getdp(){
    return bean.getCoffeeBean().getBeanDiameter().getDiameter();
   }

}
