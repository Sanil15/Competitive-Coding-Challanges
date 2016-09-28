package com.codetest.main;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

// Person is the Entity with all of its attributes
public class Person {

	private String lastName;
	
	private String firstName;
	
	private String gender;
	
	private String color;
	
	private String dob;
	
	private String other;
	

	// Default Constructor
	public Person() {
	}
	
	//Constructor Parameterized with gender and dob for all object as consistent 
	public Person(String lastName, String firstName,  String other, String gender, String color, String dob) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.setGender(gender);
		this.color = color;
		this.setDob(dob);
		this.other = other;
	}
	

	// Getter & Setter Methods
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getGender() {
		return gender;
	}
	
	// Since gender input is given in the forms of M/Male and F/Female
	// this function will create gender either Male or Female for all inputs
	public void setGender(String gender) {
		
		if(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Male"))
			this.gender = "Male";
		
		else if(gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Female"))
			this.gender = "Female";
		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getDob() {
		return dob;
	}
	
	// Replaces the '-' with '/' as required in the output
	public void setDob(String dob) {
		this.dob = dob.replaceAll("-", "/");
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) {
		this.other = other;
	}
	
	// Override the toString method to print object attributes
	public String toString(){
		return lastName + " " +firstName + " " + gender + " " + 
				getDob() + " " +color; 
	}
	
    // Function parseCommaList takes the input as a List of String
	// and parses each String to a Person object with its various 
	// attributes like firstName, lastName, Gender, dob, color
	// Parsing here refers to conversion of String to Person object with
	// attributes specified by a String separated by comma
	public static ArrayList<Person> parseCommaList(ArrayList<String> arrComma){
		ArrayList<Person> commaList=new ArrayList<Person>();
		for(String a: arrComma){
			if(a.length()>0){
				Person temp=new Person();
				String attr[]=a.split(",");
				temp.setLastName(attr[0].trim());
				temp.setFirstName(attr[1].trim());
				temp.setGender(attr[2].trim());
				temp.setColor(attr[3].trim());
				temp.setDob(attr[4].trim());
				commaList.add(temp);
			}
		}
		return commaList;	
	}
	
	
	// Function parsePipeList takes the input as a List of String
	// and parses each String to a Person object with its various 
	// attributes like firstName, lastName, Gender, dob, color, other
	// Parsing here refers to conversion of String to Person object with
	// attributes specified by a String separated by pipe 	
	public static ArrayList<Person> parsePipeList(ArrayList<String> arrPipe){	
		ArrayList<Person> pipeList=new ArrayList<Person>();
		for(String a: arrPipe){
			if(a.length()>0){
				Person temp=new Person();
				String attr[]=a.split("\\|");
				temp.setLastName(attr[0].trim());
				temp.setFirstName(attr[1].trim());
				temp.setOther(attr[2].trim());
				temp.setGender(attr[3].trim());
				temp.setColor(attr[4].trim());
				temp.setDob(attr[5].trim());
				pipeList.add(temp);
			}	
		}
	
		return pipeList;		
	}
	
	
	// Function parseSpaceList takes the input as a List of String
	// and parses each String to a Person object with its various 
	// attributes like firstName, lastName, Gender, dob, color, other
	// Parsing here refers to conversion of String to Person object with
	// attributes specified by a String separated by space
	public static ArrayList<Person> parseSpaceList(ArrayList<String> arrSpace){
		ArrayList<Person> spaceList=new ArrayList<Person>();
		for(String a: arrSpace){
			if(a.length()>0){
				Person temp=new Person();
				String attr[]=a.split(" ");
				temp.setLastName(attr[0].trim());
				temp.setFirstName(attr[1].trim());
				temp.setOther(attr[2].trim());
				temp.setGender(attr[3].trim());
				temp.setDob(attr[4].trim());
				temp.setColor(attr[5].trim());
				spaceList.add(temp);
			}
		}
		
		return spaceList;
	}
	
	
	// static function lastNameComparator sorts the person objects
	// by their lastName attribute in descending order 
	public static Comparator<Person> lastNameComparator 
	= new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			String personName1 = p1.getLastName();
			String personName2 = p2.getLastName();
			return personName2.compareTo(personName1);
		}
	};
	
	
	// static function birthDayComparator sorts the person objects
	// by their dob (type: util.Date) in ascending order
	public static Comparator<Person> birthDayComparator
	= new Comparator<Person>(){
		public int compare(Person p1, Person p2){
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			try {
				Date date1 = dateFormat.parse(p1.getDob());
				Date date2 = dateFormat.parse(p2.getDob());
				return date1.compareTo(date2);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			return 0;
		}
	};
	
	
	//  static function genderComparator sorts the person objects
	// by their gender and then by lastName ascending 
	public static Comparator<Person> genderComparator
	= new Comparator<Person>(){
		public int compare(Person p1, Person p2){
			int genderCompare=p1.getGender().compareTo(p2.getGender());
			if(genderCompare!=0)
				return genderCompare;
			return p1.getLastName().compareTo(p2.getLastName());
		}
	};
	
}
