package com.codetest.tests;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

import com.codetest.main.Person;

public class PersonTest{

	Person personComma,personSpace,personPipe;
	ArrayList<Person> persons;
	
	@Before
	public void init(){
		
		personComma=new Person("Abercrombie" ,"Neil", null, "Male", "Tan", "2/13/1943");
		personSpace=new Person("Hingis", "Martina", "M", "F", "Green", "4-2-1979");
		personPipe=new Person("Smith", "Steve", "D", "M", "Red", "3-3-1985");
		
		persons = new ArrayList<Person>();
		persons.add(new Person("Benedict","Sam",null, "Male","Green","01/16/1985"));
		persons.add(new Person("Clinton","Hilary","X","F","Yellow", "10-26-1947"));
		persons.add(new Person("Grey","John", "H","M","Pink","8-24-1977"));
		persons.add(new Person("Granger","Hermione",null, "F","Red", "9/19/1977"));
		persons.add(new Person("Hopper","Grace","Z","Female" ,"Blue", "12-9/1905"));
		
	}
	
	@Test
	public void testPersonCommaInput(){
		assertEquals(personComma.toString(),"Abercrombie Neil Male 2/13/1943 Tan");
	}
	
	@Test
	public void testPersonSpaceInput(){
		assertEquals(personSpace.toString(), "Hingis Martina Female 4/2/1979 Green");
	}
	
	@Test
	public void testPersonPipeInput(){
		assertEquals(personPipe.toString(), "Smith Steve Male 3/3/1985 Red");
	}
	
	@Test
	public void testParseCommaInputToPerson(){
		ArrayList<String> a = new ArrayList<>();
		a.add("Abercrombie, Neil, Male, Tan, 2/13/1943");
		assertEquals(Person.parseCommaList(a).get(0).toString(),
				"Abercrombie Neil Male 2/13/1943 Tan");	    
	}
	
	@Test
	public void testParseSpaceInputToPerson(){
		ArrayList<String> a = new ArrayList<>();
		a.add("Seles Monica H F 12-2-1973 Black");
		assertEquals(Person.parseSpaceList(a).get(0).toString(),
				"Seles Monica Female 12/2/1973 Black");	    
	}
	
	@Test
	public void testParsePipeInputToPerson(){
		ArrayList<String> a = new ArrayList<>();
		a.add("Bouillon | Francis | G | M | Blue | 6-3-1975");
		assertEquals(Person.parsePipeList(a).get(0).toString(),
				"Bouillon Francis Male 6/3/1975 Blue");	    
	}
	
	
	@Test 
	public void testSortableByLastNameDesc(){
		Collections.sort(persons, Person.lastNameComparator);
		assertEquals(persons.toString(), 
				"[Hopper Grace Female 12/9/1905 Blue, "+
				"Grey John Male 8/24/1977 Pink, "+
				"Granger Hermione Female 9/19/1977 Red, "+
				"Clinton Hilary Female 10/26/1947 Yellow, "+
				"Benedict Sam Male 01/16/1985 Green]");
	}
	
	@Test
	public void testSortableByBirthDate(){
		Collections.sort(persons,Person.birthDayComparator);
		assertEquals(persons.toString(),
				"[Hopper Grace Female 12/9/1905 Blue, "+
				"Clinton Hilary Female 10/26/1947 Yellow, "+
				"Grey John Male 8/24/1977 Pink, "+
				"Granger Hermione Female 9/19/1977 Red, "+
				"Benedict Sam Male 01/16/1985 Green]");
	}
	
	@Test
	public void testSortableByGenderThenLastName(){
		Collections.sort(persons,Person.genderComparator);
		assertEquals(persons.toString(),
				"[Clinton Hilary Female 10/26/1947 Yellow, "+
				"Granger Hermione Female 9/19/1977 Red, "+
				"Hopper Grace Female 12/9/1905 Blue, "+
				"Benedict Sam Male 01/16/1985 Green, "+
				"Grey John Male 8/24/1977 Pink]");
	}
	
}
