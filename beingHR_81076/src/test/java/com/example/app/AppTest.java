package com.example.app;

import java.util.ArrayList;

import org.junit.*;

import com.example.app.*;

import junit.framework.TestCase;



/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	String[] listOfEmployees = {"Varun","Monti","Shalini","kuldeep","Arun"};
	
	public static int[] Varun = {94,97,21,71,80};
	public static int[] Monti = {95,90,11,80,81};
	public static int[] Shalini = {90,91,20,71,72};
	public static int[] Kuldeep = {78,77,18,90,92};
	public static int[] Arun = {71,71,21,78,98};
	
	ArrayList<int[]> parameters = new ArrayList<int[]>();
	
	@Test
	public void testEmployeeList() {
	HR obj = new HR();
	Assert.assertArrayEquals(new String[] {"Arun", "Monti", "Shalini", "Varun", "kuldeep"}, obj.employeeList(App.listOfEmployees));

	}
	
	@Test
	public void testTopPerformers() {
		HR obj = new HR();
		parameters.add(Varun);
		parameters.add(Monti);
		parameters.add(Shalini);
		parameters.add(Kuldeep);
		parameters.add(Arun);
		Assert.assertArrayEquals(new String[] {"Varun","Monti", "kuldeep"}, obj.topPerformers(listOfEmployees, parameters));
	}
	
	@Test
	public void testParameterTopper() {
		HR obj = new HR();
		parameters.add(Varun);
		parameters.add(Monti);
		parameters.add(Shalini);
		parameters.add(Kuldeep);
		parameters.add(Arun);
		Assert.assertEquals("Monti", obj.parameterTopper(listOfEmployees, parameters, App.performanceParameters[0]));
	}
	
	@Test
	public void testLazyEmployees() {
		HR obj = new HR();
		Assert.assertArrayEquals(new String[] {"Monti", "kuldeep", "Shalini"}, obj.lazyEmployees(listOfEmployees, App.attendenceList));
	}
    

}
