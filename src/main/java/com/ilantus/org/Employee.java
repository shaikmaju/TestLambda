package com.ilantus.org;

public class Employee  {
 private int eid;
 private String emp_Name;
 private String mbl_no;
 private String mail_Id;
 private String designation;
 

public int getEid() {
    return eid;
}


public void setEid(int eid) {
    this.eid = eid;
}


public String getEmp_Name() {
    return emp_Name;
}


public void setEmp_Name(String emp_Name) {
    this.emp_Name = emp_Name;
}


public String getMbl_no() {
    return mbl_no;
}


public void setMbl_no(String mbl_no) {
    this.mbl_no = mbl_no;
}


public String getMail_Id() {
    return mail_Id;
}


public void setMail_Id(String mail_Id) {
    this.mail_Id = mail_Id;
}


public String getDesignation() {
    return designation;
}


public void setDesignation(String designation) {
    this.designation = designation;
}


@Override
public String toString() {
    return "Employee [eid=" + eid + ", emp_Name=" + emp_Name + ", mbl_no=" + mbl_no + ", mail_Id=" + mail_Id + ", designation=" + designation + "]";
}


public Employee() {
    super();
}
 
    
}