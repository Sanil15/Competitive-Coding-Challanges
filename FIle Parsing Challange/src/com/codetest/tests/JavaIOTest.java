package com.codetest.tests;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.codetest.main.JavaIO;
import com.codetest.main.Person;

public class JavaIOTest {
	
	private JavaIO obj;
	
	@Before
	public void init(){
		obj=new JavaIO();
	}
	
	@Test
	public void readInputFileAsListOfString(){
		ArrayList<String> persons = obj.readInput("comma.txt");
		assertEquals(persons.contains("Bishop, Timothy, Male, Yellow, 4/23/1967"),true);
		assertEquals(persons.size(),3);
	}
	
	@Test
	public void parseCommaInputToCreatePeople(){
		String commaInput = 
				"[Abercrombie Neil Male 2/13/1943 Tan,"+
				" Bishop Timothy Male 4/23/1967 Yellow,"+
				" Kelly Sue Female 7/12/1959 Pink]";
		ArrayList<Person> persons = Person.parseCommaList(obj.readInput("comma.txt"));
		assertEquals(commaInput, persons.toString());
	}
		
	@Test 
	public void parsePipeInputToCreatePeople(){
		String pipeInput = 
				"[Smith Steve Male 3/3/1985 Red,"+
				" Bonk Radek Male 6/3/1975 Green,"+
				" Bouillon Francis Male 6/3/1975 Blue]";
		ArrayList<Person> persons = Person.parsePipeList(obj.readInput("pipe.txt"));
		assertEquals(pipeInput, persons.toString());
	}
	
	@Test 
	public void parseSpaceInputToCreatePeople(){
		String spaceInput = 
				"[Kournikova Anna Female 6/3/1975 Red,"+
				" Hingis Martina Female 4/2/1979 Green,"+
				" Seles Monica Female 12/2/1973 Black]";
		ArrayList<Person> persons = Person.parseSpaceList(obj.readInput("space.txt"));
		assertEquals(spaceInput, persons.toString());
	}

}
