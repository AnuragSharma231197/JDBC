/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

/**
 *
 * @author Anurag
 */
import java.util.*;
import java.sql.*;


public class Issue1 {
    
    int id_student;
    String student_firstname;
    String student_lastname;
   
    String date_of_return;
    Scanner scan=new Scanner(System.in);
    public void BookIssue(){
        
        try {
            System.out.println("Hope You are doing nice!!!");
            System.out.println("Please enter the details to issue a book");
            // Get a connection
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymain","root","");
            // Create a statement
            PreparedStatement pst=c.prepareStatement("insert into library(id_student, student_firstname,student_lastname,date_of_issue) values(?,?,?,?)");
            System.out.println("Enter the id of Student");
            id_student=scan.nextInt();
            pst.setInt(1,id_student);
            System.out.println("Enter the firstname of Student");
            student_firstname=scan.next();
            pst.setString(2,student_firstname);
            System.out.println("Enter the lastname of Student");
            student_lastname=scan.next();
            pst.setString(3,student_lastname);
            System.out.println("Date is used from System");
            java.util.Date now=new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(now.getTime());
            pst.setDate(4,sqlDate);
            pst.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void BookReturn(){
        try {
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymain","root","");
               // Create a statement
                Statement str=c.createStatement();
                System.out.println("Enter the student id to return");
                int id_student=scan.nextInt();
                PreparedStatement pst=c.prepareStatement("update library set date_of_return=? where id_student=?");
                java.util.Date now=new java.util.Date();
                java.sql.Date returnDate = new java.sql.Date(now.getTime());
                pst.setDate(1,returnDate);
                pst.setInt(2,id_student);
                pst.executeUpdate();
                
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
}
    public void Update(){
        try{
             Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymain","root","");
              System.out.println("What you want to Update?");
             System.out.println("1.Student_id 2.Firstname 3.Lastname");
             int response=scan.nextInt();
             
             if(response==1){
             System.out.println("Enter the Student ID");
             this.id_student=scan.nextInt();
             System.out.println("Enter the Student Firstname");
             String student_firstname=scan.next();
             System.out.println("Enter the Student Lastname");
             String student_lastname=scan.next();
                 PreparedStatement pst=c.prepareStatement("update library set id_student=? where student_firstname=? and student_lastname=?");
                     
             pst.setInt(1,id_student);
             pst.setString(2,student_firstname);
             pst.setString(3,student_lastname);
             pst.executeUpdate();
             }
             else if(response==2){
                 System.out.println("Enter the Student ID");
                 this.id_student=scan.nextInt();
                 PreparedStatement pst=c.prepareStatement("update library set student_firstname=? where id_student=?");
                 System.out.println("Enter the Student Firstname");
                 this.student_firstname=scan.next();
                 pst.setString(1,student_firstname);
                 pst.setInt(2,id_student);
                 pst.executeUpdate();
             }
             else if(response==3){
                 System.out.println("Enter the Student ID");
                 this.id_student=scan.nextInt();
                 PreparedStatement pst=c.prepareStatement("update library set student_lastname=? where id_student=?");
                 System.out.println("Enter the Student Lastname");
                 this.student_lastname=scan.next();
                 pst.setString(1,student_lastname);
                 pst.setInt(2,id_student);
                 pst.executeUpdate();
             }
             else{
                 System.out.println("Sorry");
             }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
        
        
    }

