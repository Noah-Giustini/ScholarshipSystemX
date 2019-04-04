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
import seng300.Seng300;

/**
 * Manager class communicates with backend classes, scholarship and application
 * and makes sure required functionality for GUI controllers is provided. 
 * 
 * @author Owner
 */
public class Manager{

	private ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>(); 
	private ArrayList<Scholarship> scholarshipdrafts = new ArrayList<Scholarship>(); 
        private Scholarship currentScholarship;
        private Application currentApplication;
        private ArrayList<Application> studentApplications = new ArrayList<Application>();
        private ArrayList<Application> draftApplications = new ArrayList<Application>();
        private boolean editMode = false;
        private boolean editModeApplication = false;
        private String user;

	
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
	}
	
        /**
	* Getter that returns current scholarships
        * 
        * @return ArrayList of Current Scholarships
	 */
	public ArrayList<Scholarship> getScholarships(){
		
		ArrayList<Scholarship> newsch = new ArrayList<Scholarship>();
		
		for (int i = 0; i < scholarships.size(); i++){
			
			newsch.add(scholarships.get(i));
		}
		
		return 	newsch;
	}
	
        /**
	* Getter that returns drafted scholarships
        * 
        * @return ArrayList of Drafted Scholarships
	 */
	public ArrayList<Scholarship> getScholarshipDrafts(){

		ArrayList<Scholarship> newsch = new ArrayList<Scholarship>();
		
		for (int i = 0; i < scholarshipdrafts.size(); i++){
			
			newsch.add(scholarshipdrafts.get(i));
		}
		
		return 	newsch;	
	}
        
        /**
	* Getter that returns scholarship that is currently being worked with
        * 
        * @return Current Scholarship
	 */
        public Scholarship getCurrentScholarship(){
            return this.currentScholarship;
        }
        
        /**
	* Setter that set scholarship that is currently being worked with
        * 
        * @param s, Working scholarship
	 */
        public void setCurrentScholarship(Scholarship s){
            this.currentScholarship = s;
        }
        
         /**
	* Setter that set scholarship that is currently being worked with
        * 
        * @param s, Working scholarship
	 */
        public void clearScholarships(){
            ArrayList<Scholarship> clear = new ArrayList<Scholarship>();
            this.scholarships = clear;
        }
        
         /**
	* Setter that set scholarship that is currently being worked with
        * 
        * @param s, Working scholarship
	 */
        public void clearScholarshipDrafts(){
            ArrayList<Scholarship> clear = new ArrayList<Scholarship>();
            this.scholarshipdrafts = clear;
        }
        
        /**
         * Getter that gets current application that is being worked with
         * 
         * @return Current application
         */
        public Application getCurrentApplication(){
            return this.currentApplication;
        }
        
        /**
         * Setter that sets what application is being worked with
         * 
         * @param s, Current application
         */
        public void setCurrentApplication(Application s){
            this.currentApplication = s;
        }
        
        /**
         * Gets whether application creator should be entered in edit or create mode
         * 
         * @return True if edit mode should be entered
         */
        public boolean getEditMode(){
            return this.editMode;
        }
        
        /**
         * Sets whether application creator should be entered in edit or create mode
         * 
         * @param ed 
         */
        public void setEditMode(boolean ed){
            this.editMode = ed;
        }
        
        /**
         * Gets whether application creator should be entered in edit or create mode
         * 
         * @return True if edit mode should be entered
         */
        public boolean getEditModeApplication(){
            return this.editModeApplication;
        }
        
        /**
         * Sets whether application creator should be entered in edit or create mode
         * 
         * @param ed 
         */
        public void setEditModeApplication(boolean ed){
            this.editModeApplication = ed;
        }
        
        /**
         * Gets ArrayList of student applications
         * 
         * @return ArrayList of student applications
         */
        public ArrayList<Application> getStudentApplications (){
            return this.studentApplications;
        }
        
        /**
         * Gets ArrayList of draft applications
         * 
         * @return ArrayList of draft applications
         */
        public ArrayList<Application> getDraftApplications(){
            return this.draftApplications;
        }
        
        /**
         * Adds an application to list of application drafts
         * 
         * @param app 
         */
        public void addDraftApplication(Application app){
            this.draftApplications.add(app);
        }
        
        /**
         * Adds an application to the array of student applications
         * 
         * @param app 
         */
        public void addApplication(Application app){
            this.studentApplications.add(app);
        }
        
        /**
         * Gets name of current user
         * 
         * @return current user
         */
        public String getUser(){
            return this.user;
        }
        
        /**
         * Sets user of an application
         * 
         * @param user 
         */
        public void setUser(String user){
            this.user = user;
        }
        
        
        
        /**
         * Gets toStrings for submitted Scholarships.
         * Used to display information about scholarships on the Gui.
         * 
         * @return ArrayList of toStrings of Submitted Scholarships
         */
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
        
        /**
         * Gets toStrings for saved Scholarships.
         * Used to display information about scholarships on the Gui.
         * 
         * @return ArrayList of toStrings of Saved Scholarships
         */
        public ArrayList<String> showSavedScholarships(){
            try {
                findScholarshipDrafts();
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
        
        /**
         * Creates a new scholarship and puts it in the submitted folder
         * 
         * @param schname, name of scholarship
         * @param submit, true if scholarship should be submitted
         * @param description, scholarship description
         * @param gpa, true if GPA is required
         * @param duedate, date scholarship is due by
         * @param amt, amount of money given if scholarship is one
         * @param numReciepients, number of students who can receive the scholarship
         * @param bach, true if student can be bachelor
         * @param mast, true if student can be master
         * @param doc, true if student can be doctorate. 
         * @param cs, custom questions 1-9
         */
        public void addSubmittedScholarship(String schname, boolean submit, String description, boolean gpa, String dueDate, double amt, int numReciepients, boolean bach, boolean mast, boolean doc, String cs1, String cs2, String cs3, String cs4, String cs5, String cs6, String cs7, String cs8, String cs9){
            try {
                scholarships.add(new Scholarship(schname, submit, description, gpa, dueDate, amt, numReciepients, bach, mast, doc, cs1, cs2, cs3, cs4, cs5, cs6, cs7, cs8, cs9));
                //delete saved scholarship
                Scholarship olddraft = new Scholarship(schname, false);
                olddraft.delete();
                findScholarshipDrafts(); 
            } catch (Exception ex) {
                System.out.println("There was an error when adding the scholarship ");
            }
        }
        
        /**
         * Creates a new scholarship draft and puts it in the submitted folder
         * 
         * @param schname, name of scholarship
         * @param submit, true if scholarship should be submitted
         * @param description, scholarship description
         * @param gpa, true if GPA is required
         * @param duedate, date scholarship is due by
         * @param amt, amount of money given if scholarship is one
         * @param numReciepients, number of students who can receive the scholarship
         * @param bach, true if student can be bachelor
         * @param mast, true if student can be master
         * @param doc, true if student can be doctorate. 
         * @param cs, custom questions 1-9
         */
        public void addSavedScholarship(String schname, boolean submit, String description, boolean gpa, String dueDate, double amt, int numReciepients, boolean bach, boolean mast, boolean doc, String cs1, String cs2, String cs3, String cs4, String cs5, String cs6, String cs7, String cs8, String cs9){
            try {
                scholarshipdrafts.add(new Scholarship(schname, submit, description, gpa, dueDate, amt, numReciepients, bach, mast, doc, cs1, cs2, cs3, cs4, cs5, cs6, cs7, cs8, cs9));
            } catch (Exception ex) {
                System.out.println("There was an error when adding the scholarship draft");
            }
        }
	
        /**
         * Gets toString of applications so they can be displayed in the GUI
         * 
         * @param s
         * @return 
         */
        public ArrayList<String> showApplications( Scholarship s){
            ArrayList<String> toReturn = new ArrayList<String>();
            ArrayList<Application> apps = s.getApplications();
            for (int i=0; i<apps.size(); i++){
                Application temp = apps.get(i);
                toReturn.add(temp.simpleToString());
            }
            return toReturn;
        }
     
        
    public void addSch(Scholarship newSch) {
        this.scholarships.add(newSch);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Gets scholarships from file system.
     */
    public void startUp() {
        File folder = new File("Scholarships");
        File[] listOfFiles = folder.listFiles();
        for (File a : listOfFiles) {
            if (a.isFile()) {
                String name = a.getName().substring(0, (a.getName().length() - 4));
                try {
                    Scholarship newSch = new Scholarship(name, true);

                    addSch(newSch);
                } catch (Exception e) {
                    System.out.println("Something done went wrong loading scholarships");
                }
            }
        }
    }
    
    /**
     * Loads applications from file system.
     * 
     * @param path
     * @param student
     * @param submit 
     */
    public void loadApps(String path, String student, boolean submit){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        String ending = student + ".txt";
        int nameLength = ending.length();
        for (File a : listOfFiles) {
            if (a.isFile() && a.getName().endsWith(ending)) {
                String name = a.getName().substring(0, (a.getName().length() - 4));
                int length = a.getName().length();
                
                String sch = a.getName().substring(0, length - nameLength);
                try {
                    
                    Application newApp = new Application(sch, student, submit);
                    
                    if(submit){
                        this.addApplication(newApp);
                    }
                    else{
                        this.addDraftApplication(newApp);
                    }
                        
                } catch (Exception e) {
                    System.out.println("Something done fucked up loading applications from " + path);
                }
            }
        }
    }
    
    /**
     * Loads both application drafts and applications from file system
     * 
     * @param student 
     */
    public void loadAllApps(String student){
        loadApps("ApplicationDrafts", student, false);
        loadApps("Applications", student, true);
    }
        
    /**
     * Gets the applications for the current student.
     * 
     * @param sch
     * @return 
     */
    public Application getStudentApplication(String sch){
       File file = new File("Applications" + File.separator + sch + Seng300.theManager.getUser());
       if(file.exists()){ 
           try{
           Application app = new Application(sch, Seng300.theManager.getUser(), true );
           return app;
           }
           catch (Exception e){
               System.out.println("Really need to catch those exceptions");
               System.out.println("but error was getting a specfic application");
           }           
       }
       System.out.println("File not found ");
       return null;   
    }
    
    /**
     * Clears arrays when user logs out. 
     */
    public void clearOnLogout(){
        studentApplications.clear();
        this.scholarships.clear();
        draftApplications.clear();
        this.scholarshipdrafts.clear();
    }
    
    public boolean[] getPriority(){
        boolean[] pri = new boolean[5];
        int i = 0;
        for(Application a : this.studentApplications){
            pri[a.getPriority() - 1] = true;
        }
        
        return pri;
    }
}
    

