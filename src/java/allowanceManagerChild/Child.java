/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allowanceManagerChild;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jaysonread
 */
public class Child{
    private int childID;
    private String childFirstName;
    private String childLastName;
    private String childFullName;
    private Date childBirthDate;
    //private List<Child> childObject;
    
    public void setChildID(int childID){this.childID = childID;}
    public void setChildFirstName(String childFirstName){this.childFirstName = childFirstName;}
    public void setChildLastName(String childLastName){this.childLastName = childLastName;}
    public void setChildFullName(String childFullName){this.childFullName = childFullName;}
    public void setChildBirthDate(Date childBirthDate){this.childBirthDate = childBirthDate;}
    //public void setChildObject(List<Child> childObject){this.childObject = childObject;}
    
    public int getChildID(){return this.childID;}
    public String getChildFirstName(){return this.childFirstName;}
    public String getChildLastName(){return this.childLastName;}
    public String getChildFullName(){return this.childFullName;}
    public Date getChildBirthDate(){return this.childBirthDate;}
    //public List<Child> getChildObject(){return this.childObject;}
    
    public String toString(){
        return String.format("first name:%s,last name:%s", childFirstName, childLastName);
        //return String.format("title:%s,id:%d,children:%s,groups:%s", title, id, children, groups);
    }
}
