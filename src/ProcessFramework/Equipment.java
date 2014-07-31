package ProcessFramework;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
/*



 */

public abstract class Equipment {
    String ModelName, EquipmentID, Manufacturer;
    public void setModelName(String name){
        ModelName=name;
    }
    public String getModelName(){
        return ModelName;
    }

    public void setEquipmentID(String Id){
        EquipmentID=Id;
    }
    public String getEquipmentID(){
        return EquipmentID;
    }
    public void setManufacturer(String manufacturer){
        Manufacturer=manufacturer;
    }
    public String getManufacturer(){
        return Manufacturer;
    }
}
