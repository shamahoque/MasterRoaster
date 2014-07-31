/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ProcessFramework;

/**
 *
 * @author Shama H
 */
public abstract class Process {
    String Name;
    String type;
    public void setName(String Name){
        this.Name=Name;
    }
    public String getName(){
        return Name;
    }
    public void setType(String Type){
        this.type=Type;
    }
    public String getType(){
        return type;
    }

}
