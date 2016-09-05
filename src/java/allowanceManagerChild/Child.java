/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allowanceManagerChild;

import BackendHelpers.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    
    public void setChildID(int childID){this.childID = childID;}
    public void setChildFirstName(String childFirstName){this.childFirstName = childFirstName;}
    public void setChildLastName(String childLastName){this.childLastName = childLastName;}
    public void setChildFullName(String childFullName){this.childFullName = childFullName;}
    public void setChildBirthDate(Date childBirthDate){this.childBirthDate = childBirthDate;}
    
    public int getChildID(){return this.childID;}
    public String getChildFirstName(){return this.childFirstName;}
    public String getChildLastName(){return this.childLastName;}
    public String getChildFullName(){return this.childFullName;}
    public Date getChildBirthDate(){return this.childBirthDate;}
    
    
//    public String toString(Child child){
//        //return String.format("first name:%s,last name:%s", childFirstName, childLastName);
//        StringBuilder sb = new StringBuilder();
//        sb.append("************************************");
//        sb.append("\nchildID: ").append(child.childID);
//        sb.append("\nchildFirstName: ").append(child.childFirstName);
//        sb.append("\nchildLastName: ").append(child.childLastName);
//        sb.append("\nchildFullName: ").append(child.childFullName);
//        sb.append("\nchildBirthDate:").append(child.childBirthDate);
//        sb.append("\n************************************");
//        
//        return sb.toString();
//    }
    
    public static Set<Child> GetAllChildInfo(){
        String response = "";
        ResultSet rs;
        String query = "{ call ChildReturnAll() }";
        
        Set <Child> children = new HashSet<>();
        
        try(Connection conn = DatabaseConnection.GetDBConnection()){
            CallableStatement stmt = conn.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()){
                Child child = new Child();
                child.setChildID(rs.getInt("ChildID"));
                child.setChildFirstName(rs.getString("FirstName"));
                child.setChildLastName(rs.getString("LastName"));
                child.setChildFullName(rs.getString("FullName"));
                child.setChildBirthDate(rs.getDate("BirthDay"));
                children.add(child);
            }

        }catch(SQLException e) {
            e.toString();
        }
        return children;
    }
}
