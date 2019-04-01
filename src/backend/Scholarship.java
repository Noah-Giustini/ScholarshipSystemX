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

/**
 * Scholarship class manages the creation of scholarships and their interaction with the file system. 
 * It allows information about scholarships to be stored in file system for later use. 
 * Scholarship has methods to update, delete, create, edit, and retrieve information about a scholarship
 * from the file system. 
 * It also allows users to retrieve a list of applications associated with that scholarship in the file system.
 * 
 * @author Roxanne
 */
public class Scholarship {

    private boolean submit = false;
    private String name = "--";
    private String schfile = "--";
    private String duedate = "dd/mm/yyyy";
    private boolean gpareq = false;
    private double amount = 0;
    private int recipients = 0;
    private int chosen = 0;
    private ArrayList<String> levels = new ArrayList<String>();
    private ArrayList<Application> applications = new ArrayList<Application>();
    private String custom1 = "";
    private String custom2 = "";
    private String custom3 = "";
    private String custom4 = "";
    private String custom5 = "";
    private String custom6 = "";
    private String custom7 = "";
    private String custom8 = "";
    private String custom9 = "";
    private String description = "--";

    /**
     * Constructor. Scholarship constructor that creates a new scholarship
     * object and file or load an old scholarship if a scholarship file with the
     * given name already exists.
     *
     * @param schname is the name of the scholarship given by the user
     */
    public Scholarship(String schname, boolean submit) throws Exception {

        this.name = schname;
        this.submit = submit;

        if (this.submit) {
            this.schfile = "Scholarships\\" + schname + ".txt";
        } else {
            this.schfile = "ScholarshipDrafts\\" + schname + ".txt";
        }

        File f = new File(this.schfile);
        if (f.exists() && !f.isDirectory()) {
            loadScholarship();
        } else {
            newScholarship();
        }
    }

    /**
     * Constructor. Scholarship constructor used when loading in all
     * scholarships to the ScholarshipSystem.
     */
    public Scholarship(String schname, boolean submit, String description, boolean gpa, String dueDate, double amt, int numReciepients, boolean bach, boolean mast, boolean doc, String cs1, String cs2, String cs3, String cs4, String cs5, String cs6, String cs7, String cs8, String cs9) throws Exception {
        this.name = schname;
        this.submit = submit;

        if (this.submit) {
            this.schfile = "Scholarships\\" + schname + ".txt";
        } else {
            this.schfile = "ScholarshipDrafts\\" + schname + ".txt";
        }

        File f = new File(this.schfile);
        if (f.exists() && !f.isDirectory()) {
            loadScholarship();
        } else {
            newScholarship();
        }
        
        ArrayList<String> templvls = new ArrayList<String>();
        
        if (bach) {
            templvls.add("Bachelors");
        }
        if (mast) {
            templvls.add("Masters");
        }
        if (doc) {
            templvls.add("Doctorate");
        }
        
        setGPAReq(gpa);
        setDueDate(dueDate);
        setDescription(description);
        setAmount(amt);
        setRecipients(numReciepients);
        setLevels(templvls);
        setCustom1(cs1);
        setCustom2(cs2);
        setCustom3(cs3);
        setCustom4(cs4);
        setCustom5(cs5);
        setCustom6(cs6);
        setCustom7(cs7);
        setCustom8(cs8);
        setCustom9(cs9);
    }

    //Getters
    /**
     * Returns the name of the scholarship
     *
     * @return name of the scholarship
     */
    public String getName() {

        return this.name;
    }

    /**
     * Returns the name of the scholarship
     *
     * @return Name of the scholarship of type String
     */
    public String getDueDate() {

        return this.duedate;
    }

    /**
     * Returns boolean, true if gpa is required, false otherwise
     *
     * @return boolean
     */
    public boolean getGPAReq() {

        return this.gpareq;
    }

    /**
     * Returns the amount of money awarded by the scholarship
     *
     * @return Amount of type double
     */
    public double getAmount() {

        return this.amount;
    }

    /**
     * Returns the number of recipients a scholarship has
     *
     * @return Number of recipient of type int
     */
    public int getRecipients() {

        return this.recipients;
    }

    /**
     * Returns the number of applicants chosen for a scholarship
     *
     * @return Number of chosen applicants of type int
     */
    public int getChosen() {

        return this.chosen;
    }

    /**
     * Returns the first custom question
     *
     * @return String of first question
     */
    public String getCustom1() {

        return this.custom1;
    }

    /**
     * Returns the second custom question
     *
     * @return String of second question
     */
    public String getCustom2() {

        return this.custom2;
    }

    /**
     * Returns the third custom question
     *
     * @return String of third question
     */
    public String getCustom3() {

        return this.custom3;
    }
    
    /**
     * Returns the fourth custom question
     *
     * @return String of fourth question
     */
    public String getCustom4() {

        return this.custom4;
    }
    
    /**
     * Returns the fifth custom question
     *
     * @return String of fifth question
     */
    public String getCustom5() {

        return this.custom5;
    }
    
    /**
     * Returns the sixth custom question
     *
     * @return String of sixth question
     */
    public String getCustom6() {

        return this.custom6;
    }
    
    /**
     * Returns the seventh custom question
     *
     * @return String of seventh question
     */
    public String getCustom7() {

        return this.custom7;
    }
    
    /**
     * Returns the eighth custom question
     *
     * @return String of eighth question
     */
    public String getCustom8() {

        return this.custom8;
    }
    
    /**
     * Returns the ninth custom question
     *
     * @return String of ninth question
     */
    public String getCustom9() {

        return this.custom9;
    }

    /**
     * Returns the scholarship description
     *
     * @return String of description
     */
    public String getDescription() {

        return this.description;
    }

    /**
     * Returns eligible education levels for a scholarship
     *
     * @return ArrayList of levels of type ArrayList<String>
     */
    public ArrayList<String> getLevels() {

        return this.levels;
    }

    public ArrayList<Application> getApplications() {
        return this.applications;
    }
    //Setters

    /**
     * Changes name of scholarship if new one is given if blank name is given it
     * will not be changed
     *
     * @param newName should be a String to change name to
     */
    public void setName(String newName) throws Exception {

        String newschfile;

        if (!(newName.trim().equals(""))) {
            this.name = newName;

            if (this.submit) {
                newschfile = "Scholarships\\" + this.name + ".txt";
            } else {
                newschfile = "ScholarshipDrafts\\" + this.name + ".txt";
            }

            File f1 = new File(newschfile);
            File f2 = new File(this.schfile);
            boolean b = f2.renameTo(f1);
            File f = new File(this.schfile);
            f.delete();

            this.schfile = newschfile;

            overWriteLine("Name", this.name);
        }
    }

    /**
     * Changes due date if given in correct format: 00/00/0000
     *
     * @param newDueDate should be a String in correct format: 00/00/0000
     */
    public void setDueDate(String newDueDate) throws Exception {

        if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", newDueDate)) {
            this.duedate = newDueDate;
            overWriteLine("Due Date", newDueDate);
        }

    }

    /**
     * Changes gpa required
     *
     * @param req boolean true if gpa is required
     */
    public void setGPAReq(boolean req) throws Exception {
        this.gpareq = req;
        if (this.gpareq) {
            overWriteLine("GPA Required", "true");
        } else {
            overWriteLine("GPA Required", "false");
        }
    }

    //will only change if amount given is a postive number
    /**
     * Changes amount if it is a positive number
     *
     * @param newAmount should be a positive double
     */
    public void setAmount(double newAmount) throws Exception {

        if (newAmount >= 0) {
            this.amount = newAmount;
            String txt = Double.toString(newAmount);
            overWriteLine("Amount", txt);
        }

    }

    /**
     * Changes number of recipients if given a natural number
     *
     * @param newRecipients should be a natural number of type int
     */
    public void setRecipients(int newRecipients) throws Exception {

        if (newRecipients >= 0) {
            this.recipients = newRecipients;
            String txt = Integer.toString(newRecipients);
            overWriteLine("Recipients", txt);
        }

    }

    /**
     * Changes number of recipients chosen if given a natural number
     *
     * @param newChosen should be a natural number of type int
     */
    public void setChosen(int newChosen) throws Exception {

        if (newChosen >= 0) {
            this.chosen = newChosen;
            String txt = Integer.toString(newChosen);
            overWriteLine("Chosen", txt);
        }

    }

    /**
     * Changes first custom question
     *
     * @param cus1 the custom question
     */
    public void setCustom1(String cus1) throws Exception {
        this.custom1 = cus1;
        overWriteLine("Custom1", cus1);
    }

    /**
     * Changes second custom question
     *
     * @param cus2 the custom question
     */
    public void setCustom2(String cus2) throws Exception {
        this.custom2 = cus2;
        overWriteLine("Custom2", cus2);
    }

    /**
     * Changes third custom question
     *
     * @param cus3 the custom question
     */
    public void setCustom3(String cus3) throws Exception {
        this.custom3 = cus3;
        overWriteLine("Custom3", cus3);
    }
    
    /**
     * Changes fourth custom question
     *
     * @param cus4 the custom question
     */
    public void setCustom4(String cus4) throws Exception {
        this.custom4 = cus4;
        overWriteLine("Custom4", cus4);
    }
    
    /**
     * Changes fifth custom question
     *
     * @param cus5 the custom question
     */
    public void setCustom5(String cus5) throws Exception {
        this.custom5 = cus5;
        overWriteLine("Custom5", cus5);
    }
    
    /**
     * Changes sixth custom question
     *
     * @param cus6 the custom question
     */
    public void setCustom6(String cus6) throws Exception {
        this.custom6 = cus6;
        overWriteLine("Custom6", cus6);
    }
    
    /**
     * Changes seventh custom question
     *
     * @param cus7 the custom question
     */
    public void setCustom7(String cus7) throws Exception {
        this.custom7 = cus7;
        overWriteLine("Custom7", cus7);
    }
    
    /**
     * Changes eighth custom question
     *
     * @param cus8 the custom question
     */
    public void setCustom8(String cus8) throws Exception {
        this.custom8 = cus8;
        overWriteLine("Custom8", cus8);
    }
    
    /**
     * Changes ninth custom question
     *
     * @param cus9 the custom question
     */
    public void setCustom9(String cus9) throws Exception {
        this.custom9 = cus9;
        overWriteLine("Custom9", cus9);
    }

    /**
     * Changes scholarship description
     *
     * @param desc the new description
     */
    public void setDescription(String desc) throws Exception {
        this.description = desc;
        overWriteLine("Description", desc);
    }

    //this needs to be revised!!!!
    /**
     * Replaces ArrapList in levels to new education levels
     *
     * @param newLevels of type ArrayList<String>
     */
    public void setLevels(ArrayList<String> newLevels) throws Exception {

        this.levels = newLevels;

        String txt = "";
        for (int i = 0; i < this.levels.size(); i++) {
            txt = txt + this.levels.get(i) + " ";
        }
        overWriteLine("Education Level", txt);
    }

    /**
     * Looks through Applications folder and adds all applications for the
     * scholarship to the arraylist applications
     */
    public void findApplications() throws Exception {

        File dir = new File("Applications\\");
        File[] directoryListing = dir.listFiles();

        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.getName().indexOf(this.name) == 0) {

                    String appname = child.getName();
                    String stuname = appname.substring(this.name.length(), appname.length() - 4);
                    //System.out.println(stuname);
                    Application a = new Application(this.name, stuname, true);
                    applications.add(a);
                }
            }
        }
        //for (int i = 0; i < applications.size(); i++){
        //	System.out.println(applications.get(i));
        //}	
    }

    /**
     * Changes a line in scholarship file given the name of the parameter that
     * needs to be changed and the new value for that parameter
     *
     * @param tag is a String of the name of the parameter to be changed
     * @param newtext is a String of the value to change to parameter's value to
     */
    private void overWriteLine(String tag, String newtext) throws Exception {

        String tmpfile;

        tmpfile = "Scholarships\\" + this.name + ".temp";

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tmpfile)));
        BufferedReader br = new BufferedReader(new FileReader(this.schfile));

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

        File f = new File(this.schfile);
        boolean b = f.delete();
        File f1 = new File(this.schfile);
        File f2 = new File(tmpfile);
        b = f2.renameTo(f1);
        File f3 = new File(tmpfile);
        b = f3.delete();
    }

    //load and generate scholarships
    /**
     * Loads scholarship from a file into a scholarship object
     */
    private void loadScholarship() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(this.schfile));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals("Due Date")) {
                line = br.readLine();
                setDueDate(line);
            } else if (line.equals("Amount")) {
                line = br.readLine();
                double newAmount = Double.parseDouble(line);
                setAmount(newAmount);
            } else if (line.equals("GPA Required")) {
                line = br.readLine();
                if (line.trim().equals("true")) {
                    setGPAReq(true);
                } else {
                    setGPAReq(false);
                }
            } else if (line.equals("Recipients")) {
                line = br.readLine();
                int newRecipients = Integer.parseInt(line);
                setRecipients(newRecipients);
            } else if (line.equals("Recipients Chosen")) {
                line = br.readLine();
                int newChosen = Integer.parseInt(line);
                setChosen(newChosen);
            } else if (line.equals("Education Level")) {
                line = br.readLine();
                String[] tmpLevels = line.split(" ");
                ArrayList<String> newLevels = new ArrayList(Arrays.asList(tmpLevels));
                setLevels(newLevels);
            } else if (line.equals("Custom1")) {
                line = br.readLine();
                setCustom1(line);
            } else if (line.equals("Custom2")) {
                line = br.readLine();
                setCustom2(line);
            } else if (line.equals("Custom3")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Custom4")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Custom5")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Custom6")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Custom7")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Custom8")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Custom9")) {
                line = br.readLine();
                setCustom3(line);
            } else if (line.equals("Description")) {
                line = br.readLine();
                setDescription(line);
            }
        }

        findApplications();
        br.close();
    }

    /**
     * Create a new file for a scholarship. Names file the given name of the
     * scholarship and sets basic file format.
     */
    private void newScholarship() throws Exception {

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.schfile)));
        int counter = 0;

        writer.println("Name");
        writer.println(this.name);
        writer.println();
        writer.println("Due Date");
        writer.println(this.duedate);
        writer.println();
        writer.println("GPA Required");
        writer.println(this.gpareq);
        writer.println();
        writer.println("Amount");
        writer.println(this.amount);
        writer.println();
        writer.println("Recipients");
        writer.println(this.recipients);
        writer.println();
        writer.println("Recipients Chosen");
        writer.println(this.chosen);
        writer.println();
        writer.println("Education Level");
        for (int i = 0; i < this.levels.size(); i++) {
            writer.write(this.levels.get(i));
            writer.write(" ");
        }
        writer.println();
        writer.println();
        writer.println("Custom1");
        writer.println(this.custom1);
        writer.println();
        writer.println("Custom2");
        writer.println(this.custom2);
        writer.println();
        writer.println("Custom3");
        writer.println(this.custom3);
        writer.println();
        writer.println("Custom4");
        writer.println(this.custom4);
        writer.println();
        writer.println("Custom5");
        writer.println(this.custom5);
        writer.println();
        writer.println("Custom6");
        writer.println(this.custom6);
        writer.println();
        writer.println("Custom7");
        writer.println(this.custom7);
        writer.println();
        writer.println("Custom8");
        writer.println(this.custom8);
        writer.println();
        writer.println("Custom9");
        writer.println(this.custom9);
        writer.println();
        writer.println("Description");
        writer.println(this.description);
        writer.println();
        writer.println();

        writer.close();

    }

    /**
     * Overrides toString method. For use in the command line implementation of
     * Scholarship System
     *
     * @return Information from scholarship in type String
     */
    public String toString() {

        String EduLvls = "";
        for (int i = 0; i < this.levels.size(); i++) {
            EduLvls = EduLvls + this.levels.get(i);
            if (i != this.levels.size() - 1) {
                EduLvls = EduLvls + ", ";
            }
        }

        return this.name + "\n Due: " + this.duedate + "\n Amount: " + this.amount + "$ \n Recipient(s): " + this.recipients + "\n Recipient(s) Chosen: " + this.chosen + "\n Education Levels: " + EduLvls;
    }

    public String simpleToString() {
        return this.name + " " + this.duedate;
    }
    
    /**
     * Deletes a scholarship from the file system
     * object should be deleted after use. 
     */
    public void delete(){
        File f = new File(this.schfile);
        f.delete();
    }
    
    /**
     * Archived a scholarship
     */
    public void archive() {
      
        try {
            findApplications();
        } catch (Exception ex) {
            Logger.getLogger(Scholarship.class.getName()).log(Level.SEVERE, null, ex);
        }
        String arch = "ArchivedScholarships\\" + this.name + ".txt";
        
        File f1 = new File(arch);
        File f2 = new File(this.schfile);
        boolean b = f2.renameTo(f1);
        File f3 = new File(this.schfile);
        b = f3.delete();
        
        
        for(int i = 0; i < this.applications.size(); i++){
            Application app = applications.get(i);
            String nm = app.getAppFile();
            
            String arch0 = "ArchivedApplications\\" + app.getScholarship() + app.getStudent() + ".txt";
            
            File f11 = new File(arch0);
            File f22 = new File(nm);
            boolean bb = f22.renameTo(f11);
            File f33 = new File(nm);
            bb = f33.delete();
        }
    }
   
}
