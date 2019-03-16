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


public class Manager{

	private ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>(); 
	private ArrayList<Scholarship> scholarshipdrafts = new ArrayList<Scholarship>(); 

	
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
				String schname = child.getName();
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
				String schname = child.getName();
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
	
}
