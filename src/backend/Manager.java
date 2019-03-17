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
import java.util.logging.Level;
import java.util.logging.Logger;


public class Manager{

	private ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>(); 
	private ArrayList<Scholarship> scholarshipdrafts = new ArrayList<Scholarship>(); 
        private Scholarship currentScholarship;
        private Application currentApplication;

	
	/**
	* Looks through Scholarships folder and adds all scholarships to the 
	* arraylist scholarships
	 */	
	public void findScholarships()throws Exception{
		
		this.scholarships.clear();
		
		File dir = new File("Scholarships\\");
		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			for (File child : directoryListing) { 	
				String schname = child.getName().substring(0, child.getName().length() - 4);
				Scholarship s = new Scholarship(schname, true);
					scholarships.add(s);
				}
			}
		
		//for (int i = 0; i < scholarships.size(); i++){
		//	System.out.println(scholarships.get(i));
		//}	
	}
	
	/**
	* Looks through the ScholarshipDrafts folder and adds all scholarships to the 
	* arraylist ScholarshipSaves.
	* This method can 
	 */	
	public void findScholarshipDrafts()throws Exception{
		
		this.scholarshipdrafts.clear();
		
		File dir = new File("ScholarshipDrafts\\");
		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			for (File child : directoryListing) { 	
				String schname = child.getName().substring(0, child.getName().length() - 4);
				Scholarship s = new Scholarship(schname, false);
				
				
				scholarshipdrafts.add(s);
				
				}
			}
		
		//for (int i = 0; i < scholarshipdrafts.size(); i++){
		//	System.out.println(scholarshipdrafts.get(i));
		//}	
	}
	
	public ArrayList<Scholarship> getScholarships(){
		
		ArrayList<Scholarship> newsch = new ArrayList<Scholarship>();
		
		for (int i = 0; i < scholarships.size(); i++){
			
			newsch.add(scholarships.get(i));
		}
		
		return 	newsch;
	}
	
	public ArrayList<Scholarship> getScholarshipDrafts(){

		ArrayList<Scholarship> newsch = new ArrayList<Scholarship>();
		
		for (int i = 0; i < scholarshipdrafts.size(); i++){
			
			newsch.add(scholarshipdrafts.get(i));
		}
		
		return 	newsch;	
	}
        
        public Scholarship getCurrentScholarship(){
            return this.currentScholarship;
        }
        
        public void setCurrentScholarship(Scholarship s){
            this.currentScholarship = s;
        }
        
        public Application getCurrentApplication(){
            return this.currentApplication;
        }
        
        public void setCurrentApplication(Application s){
            this.currentApplication = s;
        }
        
        public ArrayList<String> showSubmittedScholarships(){
            try {
                findScholarships();
            } catch (Exception ex) {
               System.out.println("There was an error when reading the files");
            }
            ArrayList<String> toReturn = new ArrayList<String>();
            for (int i=0; i<scholarships.size(); i++){
                Scholarship temp = scholarships.get(i);
                toReturn.add(temp.simpleToString());
            }
            return toReturn;
        }
        
        public ArrayList<String> showSavedScholarships(){
            try {
                findScholarships();
            } catch (Exception ex) {
               System.out.println("There was an error when reading the files");
            }
            ArrayList<String> toReturn = new ArrayList<String>();
            for (int i=0; i<scholarshipdrafts.size(); i++){
                Scholarship temp = scholarshipdrafts.get(i);
                toReturn.add(temp.simpleToString());
            }
            return toReturn;
        }
        
        public void addSubmittedScholarship(String schname, boolean submit, String description, boolean gpa, String dueDate, double amt, int numReciepients, boolean bach, boolean mast, boolean doc, String cs1, String cs2, String cs3){
            try {
                scholarships.add(new Scholarship(schname, submit, description, gpa, dueDate, amt, numReciepients, bach, mast, doc, cs1, cs2, cs3));
                //delete saved scholarship
                Scholarship olddraft = new Scholarship(schname, false);
                olddraft.delete();
                findScholarshipDrafts(); 
            } catch (Exception ex) {
                System.out.println("There was an error when adding the scholarship ");
            }
        }
        
        public void addSavedScholarship(String schname, boolean submit, String description, boolean gpa, String dueDate, double amt, int numReciepients, boolean bach, boolean mast, boolean doc, String cs1, String cs2, String cs3){
            try {
                scholarshipdrafts.add(new Scholarship(schname, submit, description, gpa, dueDate, amt, numReciepients, bach, mast, doc, cs1, cs2, cs3));
            } catch (Exception ex) {
                System.out.println("There was an error when adding the scholarship draft");
            }
        }
	
        public ArrayList<String> showApplications( Scholarship s){
            ArrayList<String> toReturn = new ArrayList<String>();
            ArrayList<Application> apps = s.getApplications();
            for (int i=0; i<apps.size(); i++){
                Application temp = apps.get(i);
                toReturn.add(temp.simpleToString());
            }
            return toReturn;
        }
}
