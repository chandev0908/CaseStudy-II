package cs.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDataModel {
    private static List<Integer> id = new ArrayList<Integer>();
    private String txtFName;
    private String txtLName;
    private String txtEmail;
    private String txtCourse;
    private String txtSection;
    private String txtYear;
    
    public void addID(int studId){
        id.add(studId);
    }
    public void removeID(int studId){
        id.remove(studId);
    }
    public int getID(int studId){
        return id.get(studId);
    }
    public String getTxtFName(){
        return txtFName;
    }
    public void setTxtFName(String txtFName){
        this.txtFName = txtFName;
    }
    public String getTxtLName(){
        return txtLName;
    }
    public void setTxtLName(String txtLName){
        this.txtLName = txtLName;
    }
    public String gettxtEmail(){
        return txtEmail;
    }
    public void setTxtEmail(String txtEmail){
        this.txtEmail = txtEmail;
    }
    public String getTxtCourse(){
        return txtCourse;
    }
    public void setTxtCourse(String txtCourse){
        this.txtCourse = txtCourse;
    }
    public String getTxtSection(){
        return txtSection;
    }
    public void setTxtSection(String txtSection){
        this.txtSection = txtSection;
    }
    public String getTxtYear(){
        return txtYear;
    }
    public void setTxtYear(String txtYear){
        this.txtYear = txtYear;
    }
}   
