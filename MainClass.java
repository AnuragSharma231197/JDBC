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
public class MainClass extends Issue {
    public static void main(String []args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Hello!!!!");
        System.out.println("Please select what you want to do?");
        System.out.println("1.Issue 2.Return 3.Update Table 4.Fine");
        int response=scan.nextInt();
        MainClass c=new MainClass();
        if(response==1){
            c.BookIssue();
        }
        else if(response==2){
            c.BookReturn();
        }
        else if(response==3){
            c.Update();
        }
        else{
            System.out.println("Error");
        }
        
    }
    
}
