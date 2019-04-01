package backend;

import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;

/**
 * Application class manages the creation of applications and their interaction with the file system. 
 * It allows information about applications to be stored in file system for later use.
 * Application has methods to update, delete, create, edit, and retrieve information about an application
 * from the file system. 
 * 
 * @author Roxanne
 */
public class Application{


	private boolean submit = false;
	private String scholarship = "--";
	private String student = "--";
	private String appfile = "--";
	private String date = "--";
	private double gpa = 0;
	private String edulvl = "--";
	private String status = "--";
        private String ans1 = "--";
        private String ans2 = "--";
        private String ans3 = "--";
        private String ans4 = "--";
        private String ans5 = "--";
        private String ans6 = "--";
        private String ans7 = "--";
        private String ans8 = "--";
        private String ans9 = "--";
	private int priority = 0;

	

	/**
	 * Constructor.
	 * Loads an application for given scholarship and student if the file exists
	 * or generates a new application if a file for that application does not exist.
	 * Names file the student's name followed by the scholarship name.
	 * @param mnscholarship name of scholarship of type String
	 * @param mnstudent name of student of type String
	 */
	public Application(String nmscholarship, String nmstudent, Boolean submit)throws Exception{
		try{
		this.scholarship = nmscholarship;
		this.student = nmstudent;
		this.submit = submit;
		
		if (this.submit){
			this.appfile = "Applications\\" + this.scholarship + this.student + ".txt";
                        this.status = "Pending";
		}
		else{
			this.appfile = "ApplicationDrafts\\" + this.scholarship + this.student + ".txt";
		}
		
		File f = new File(this.appfile);
		if(f.exists() && !f.isDirectory()) { 
			loadApplication();
		}
		else{
			newApplication();
		}} catch (Exception e){


		}		
	}
	
	//Getters
	
        /**
	 * Returns name of application file
	 * @return Name of application of type String
	 */
	public String getAppFile(){
		
		return this.appfile;
	}
        
	/**
	 * Returns name of scholarship being applied for
	 * @return Name of scholarship of type String
	 */
	public String getScholarship(){
		
		return this.scholarship;
	}
	
	/**
	 * Returns name of student applying for scholarship
	 * @return Name or student of type String
	 */
	public String getStudent(){
		
		return this.student;
	}
	
	/**
	 * Returns date application was last edited
	 * @return Date of type String
	 */
	public String getDate(){
		
		return this.date;
	}
	
	/**
	 * Returns gpa of scholarship applicant
	 * @return GPA of type double
	 */
	public double getGPA(){
		
		return this.gpa;
	}
	
	/**
	 * Returns education level of scholarship applicant
	 * @return Education level of type String
	 */
	public String getEducationLevel(){
		
		return this.edulvl;
	}
	
	/**
	 * Returns status of application; pending, accepted, rejected.
	 * @return Status of type String
	 */
	public String getStatus(){
		
		return this.status;
	}
	
	/**
	 * Returns priority student has selected for the scholarship
	 * @return Priority of type int
	 */
	public int getPriority(){
		
		return this.priority;
	}
        
        /**
	 * Returns answer to first custom question
	 * @return Answer of type String
	 */
	public String getAnswer1(){
		
		return this.ans1;
	}
        /**
	 * Returns answer to second custom question
	 * @return Answer of type String
	 */
	public String getAnswer2(){
		
		return this.ans2;
	}
        
        /**
	 * Returns answer to third custom question
	 * @return Answer of type String
	 */
	public String getAnswer3(){
		
		return this.ans3;
	}
        
        /**
	 * Returns answer to fourth custom question
	 * @return Answer of type String
	 */
	public String getAnswer4(){
		
		return this.ans4;
	}
        
        /**
	 * Returns answer to fifth custom question
	 * @return Answer of type String
	 */
	public String getAnswer5(){
		
		return this.ans5;
	}
        
        /**
	 * Returns answer to sixth custom question
	 * @return Answer of type String
	 */
	public String getAnswer6(){
		
		return this.ans6;
	}
        
        
        /**
	 * Returns answer to seventh custom question
	 * @return Answer of type String
	 */
	public String getAnswer7(){
		
		return this.ans7;
	}
        
        /**
	 * Returns answer to eighth custom question
	 * @return Answer of type String
	 */
	public String getAnswer8(){
		
		return this.ans8;
	}
        
        /**
	 * Returns answer to ninth custom question
	 * @return Answer of type String
	 */
	public String getAnswer9(){
		
		return this.ans9;
	}
        
    
	//Setters
	
	/**
	 * Changes date if given in correct format: 00/00/0000
	 * @param newDate of type String
	 */
	public void setDate(String newDate)throws Exception{
		
		if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", newDate)){
			this.date = newDate;
			overWriteLine("Date", newDate);
		}
	
	}

	/**
	 * Changes gpa given is a postive number and is 4.0 or less
	 * @param newGPA of type double
	 */
	public void setGPA(double newGPA)throws Exception{
		
		if ((newGPA >= 0) && (newGPA <= 4.0)){
			this.gpa = newGPA;
			String txt = Double.toString(newGPA);
			overWriteLine("GPA", txt);
		}

	}
	
	/**
	 * Changes education level
	 * @param newEduLvl of type String
	 */
	public void setEducationLevel(String newEduLvl)throws Exception{
		
		this.edulvl = newEduLvl;
		overWriteLine("Education Level", newEduLvl);
	}
	
	/**
	 * Changes status of application
	 * @param newStatus of type String
	 */
	public void setStatus(String newStatus)throws Exception{
		
		this.status = newStatus;
		overWriteLine("Status", newStatus);
	}
	
	/**
	 * Changes priority if natural number is given
	 * @param newPriority of type int
	 */
	public void setPriority(int newPriority)throws Exception{
		
		if (newPriority >= 0){
			this.priority = newPriority;
			String txt = Integer.toString(newPriority);
			overWriteLine("Priority", txt);
		}
	
	}
        
        /**
	 * Changes answer to first custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer1(String newAnswer)throws Exception{
		
		this.ans1 = newAnswer;
		overWriteLine("Answer1", newAnswer);
	}
        
        /**
	 * Changes answer to second custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer2(String newAnswer)throws Exception{
		
		this.ans2 = newAnswer;
		overWriteLine("Answer2", newAnswer);
	}
        
        /**
	 * Changes answer to third custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer3(String newAnswer)throws Exception{
		
		this.ans3 = newAnswer;
		overWriteLine("Answer3", newAnswer);
	}
        
        /**
	 * Changes answer to fourth custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer4(String newAnswer)throws Exception{
		
		this.ans4 = newAnswer;
		overWriteLine("Answer4", newAnswer);
	}
        
        /**
	 * Changes answer to fifth custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer5(String newAnswer)throws Exception{
		
		this.ans5 = newAnswer;
		overWriteLine("Answer5", newAnswer);
	}
        
        /**
	 * Changes answer to sixth custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer6(String newAnswer)throws Exception{
		
		this.ans6 = newAnswer;
		overWriteLine("Answer6", newAnswer);
	}
        
        /**
	 * Changes answer to seventh custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer7(String newAnswer)throws Exception{
		
		this.ans7 = newAnswer;
		overWriteLine("Answer7", newAnswer);
	}
        
        /**
	 * Changes answer to eighth custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer8(String newAnswer)throws Exception{
		
		this.ans8 = newAnswer;
		overWriteLine("Answer8", newAnswer);
	}
        
        /**
	 * Changes answer to ninth custom question
	 * @param newAnswer of type String
	 */
	public void setAnswer9(String newAnswer)throws Exception{
		
		this.ans9 = newAnswer;
		overWriteLine("Answer9", newAnswer);
	}
        
	/**
	* Changes a line in scholarship file given the name of the parameter that needs to be 
	* changed and the new value for that parameter
	* @param tag is a String of the name of the parameter to be changed
	* @param newtext is a String of the value to change to parameter's value to
	 */
	public void overWriteLine(String tag, String newtext) throws Exception{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.scholarship +  " " + this.student + ".temp")));
		BufferedReader br = new BufferedReader(new FileReader(this.appfile));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			if (line.equals(tag)) {
				writer.println(line);
				line = br.readLine();
				line = newtext;
			}
		
			writer.println(line);
		}
		
		br.close();
		writer.close();	
		
		File f = new File(this.appfile);
		boolean b = f.delete();
		File f1 = new File(this.appfile);
		File f2 = new File(this.scholarship +  " " + this.student + ".temp");
		b = f2.renameTo(f1);
		File f3 = new File(this.scholarship +  " " + this.student + ".temp");
		b = f3.delete();
	}
	
	
	//load and generate applications
	
	/**
	* Loads application from a file into a application object
	 */
	private void loadApplication() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(this.appfile));
		String line;
		
		while ((line = br.readLine()) != null) {
			if (line.equals("Date")){
				line = br.readLine();
				setDate(line);
			}
			else if (line.equals("GPA")){
				line = br.readLine();
				double newGPA = Double.parseDouble(line);
				setGPA(newGPA);
			}
			else if (line.equals("Education Level")){
				line = br.readLine();
				setEducationLevel(line);
			}
			else if (line.equals("Status")){
				line = br.readLine();
				setStatus(line);
			}
			else if (line.equals("Priority")){
				line = br.readLine();
				int newPriority = Integer.parseInt(line);
				setPriority(newPriority);
			}
                        else if (line.equals("Answer1")){
				line = br.readLine();
				setAnswer1(line);
			}
                        else if (line.equals("Answer2")){
				line = br.readLine();
				setAnswer2(line);
			}
                        else if (line.equals("Answer3")){
				line = br.readLine();
				setAnswer3(line);
			}
                        else if (line.equals("Answer4")){
				line = br.readLine();
				setAnswer4(line);
			}
                        else if (line.equals("Answer5")){
				line = br.readLine();
				setAnswer5(line);
			}
                        else if (line.equals("Answer6")){
				line = br.readLine();
				setAnswer6(line);
			}
                        else if (line.equals("Answer7")){
				line = br.readLine();
				setAnswer7(line);
			}
                        else if (line.equals("Answer8")){
				line = br.readLine();
				setAnswer8(line);
			}
                        else if (line.equals("Answer9")){
				line = br.readLine();
				setAnswer9(line);
			}
		}
		br.close();	
	}
	
	
	/**
	* Create a new file for an application. Names file the given name of the application and sets 
	* basic file format. 
	 */
	private void newApplication() throws Exception{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.appfile)));
		int counter = 0;
		
		writer.println("Scholarship");
		writer.println(this.scholarship);
		writer.println();
		writer.println("Student");
		writer.println(this.student);
		writer.println();
		writer.println("GPA");
		writer.println(this.gpa);
		writer.println();
		writer.println("Education Level");
		writer.println(this.edulvl);
		writer.println();
		writer.println("Date");
		writer.println(this.date);
		writer.println();
		writer.println("Status");
		writer.println(this.status);
		writer.println();
		writer.println("Priority");
		writer.println(this.priority);
		writer.println();
                writer.println("Answer1");
		writer.println(this.ans1);
		writer.println();
                writer.println("Answer2");
		writer.println(this.ans2);
		writer.println();
                writer.println("Answer3");
		writer.println(this.ans3);
		writer.println();
                writer.println("Answer4");
		writer.println(this.ans4);
		writer.println();
                writer.println("Answer5");
		writer.println(this.ans5);
		writer.println();
                writer.println("Answer6");
		writer.println(this.ans6);
		writer.println();
                writer.println("Answer7");
		writer.println(this.ans7);
		writer.println();
                writer.println("Answer8");
		writer.println(this.ans8);
		writer.println();
                writer.println("Answer9");
		writer.println(this.ans9);
		writer.println();

		writer.close();
		
	}
	
	public String toString(){
		 
		String toReturn =  this.scholarship + "\n " + this.student + "\n Date Submitted: " + this.date + "\n GPA: " + this.gpa + "\n Education Level: " + this.edulvl + "\n Priority: " + this.priority + "\n Status: " + this.status;
                System.out.println(this.ans1);
                System.out.println(this.ans2);
                System.out.println(this.ans3);
                System.out.println(this.ans4);
                System.out.println(this.ans5);
                System.out.println(this.ans6);
                System.out.println(this.ans7);
                System.out.println(this.ans8);
                System.out.println(this.ans9);
                
                
                if (!this.ans1.equals("--")){
                    toReturn += this.ans1 + "\n";
                
                }
                if (!this.ans2.equals("--")){
                    toReturn += this.ans2 + "\n";
                
                }
                if (!this.ans3.equals("--")){
                    toReturn += this.ans3 + "\n";
                
                }
                if (!this.ans4.equals("--")){
                    toReturn += this.ans4 + "\n";
                
                }
                if (!this.ans5.equals("--")){
                    toReturn += this.ans5 + "\n";
                
                }
                if (!this.ans6.equals("--")){
                    toReturn += this.ans6 + "\n";
                
                }
                if (!this.ans6.equals("--")){
                    toReturn += this.ans7 + "\n";
                
                }
                if (!this.ans8.equals("--")){
                    toReturn += this.ans8 + "\n";
                
                }
                if (!this.ans9.equals("--")){
                    toReturn += this.ans9 + "\n";
                
                }
                return toReturn;
        
        }
        
        /**
         * Simple toString method created for the displaying for submitted scholarships in admin GUI
         * 
         * @return String with name of scholarship and date
         */
        public String simpleToString(){
            return this.student + "\n Submitted: " + this.date + "\n Status: " + this.status;
        }
        
        public void delete(){
        File f = new File(this.appfile);
        f.delete();
        }
        
}
