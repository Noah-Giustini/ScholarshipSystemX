package backend;

import java.util.Scanner;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//The Admin class is used to contain the methods that can be used only by an administrator of the system
public class Admin{

    /**
	 * confirm an application
	 * @param s is of type Scholarship and is the scholarship that the students application is associated with
     * @param a is of type Application and is the application to be confirmed
     * @return void
	 */
    public void confirmAward(Scholarship s, Application a) throws Exception{
        a.setStatus("Awarded");
        s.setChosen(s.getChosen()+1);      
        String name = s.getName();
        String student = a.getStudent();
        System.out.println("The scholarship " + name + " has been granted to student " + student + " and is awaiting their acceptance.");
    }
    /**
	 * reject an application
	 * @param s is of type Scholarship and is the scholarship that the students application is associated with
     * @param a is of type Application and is the application to be rejected
     * @return void
	 */
    public void rejectApplication(Scholarship s, Application a) throws Exception{
        a.setStatus("Rejected");
        String name = s.getName();
        String student = a.getStudent();
        System.out.println("The application from student" + student + " has been rejected for the scholarship " + name);
    }
    
    public boolean status(Scholarship s) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String cd = dateFormat.format(date);
        String[] parts = cd.split("/");
        int cdDay = Integer.parseInt(parts[0]); //current day
        int cdMonth = Integer.parseInt(parts[1]); //current month
        int cdYear = Integer.parseInt(parts[2]); //current year
        String sd = s.getDueDate();
        String[] parts2 = cd.split("/");
        int sdDay = Integer.parseInt(parts2[0]); //due date day
        int sdMonth = Integer.parseInt(parts2[1]); //due date month
        int sdYear = Integer.parseInt(parts2[2]); //due date year
        boolean status = false;

        if (sdYear < cdYear){
            status = true; //closed
        }
        else if (sdYear == cdYear){
            if (sdMonth < cdMonth){
            status = true; //closed
            }
            else if (sdMonth == cdMonth){
                if (sdDay < cdDay){
                status = true; //closed
                }
                else{
                    status = false; // open
                }
            }
            else{
                status = false; // open
            }
        }
        else{
            status = false; //open
        }
        return status;
    }

}