// Run this file to produce the desired result in output.txt
// output.txt is initially empty

package com.codetest.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeRun {

	public static void main(String[] args) {

		JavaIO obj=new JavaIO();		
		
		// Function readInput from JavaIO class reads the given files
		// and returns the ArrayList<String> containing elements that 
		// represent each line from input file as a String 
		ArrayList<String> arrComma=obj.readInput("comma.txt");
		ArrayList<String> arrSpace=obj.readInput("space.txt");
		ArrayList<String> arrPipe=obj.readInput("pipe.txt");
		

		// Function parseCommaList takes the input as a List of String
		// and parses each String to a Person object with its various 
		// attributes like firstName, lastName, Gender ...
		// Parsing refers to conversion of String to Person object with
		// attributes specified by String separated by comma, pipe or space
		List<Person> commaList=Person.parseCommaList(arrComma);
		List<Person> spaceList=Person.parseSpaceList(arrSpace);
		List<Person> pipeList=Person.parsePipeList(arrPipe);
		
		// Make a single collection of all elements
		List<Person> persons=new ArrayList<Person>();
		persons.addAll(commaList);
		persons.addAll(pipeList);
		persons.addAll(spaceList);
		
		//Calls the static method to sort the list persons 
		// by their gender then by their last name
	    Collections.sort(persons, Person.genderComparator);
		obj.writeOutput("Output 1:");
		for(Person p: persons)
			obj.writeOutput(p.toString());
	
		obj.writeOutput("");
		
		// Calls the static method to sort the list persons
		// by their birth date(dob) in ascending order
		Collections.sort(persons, Person.birthDayComparator);
		obj.writeOutput("Output 2:");
			for(Person p: persons)
			obj.writeOutput(p.toString());
		
		obj.writeOutput("");		
		
		// Calls the static method to sort the list persons
		// by their last name in descending order
		Collections.sort(persons, Person.lastNameComparator);
		obj.writeOutput("Output 3:");
		for(Person p: persons)
			obj.writeOutput(p.toString());
		
		
	}

}
