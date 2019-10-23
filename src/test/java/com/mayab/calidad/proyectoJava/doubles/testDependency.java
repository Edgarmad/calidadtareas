package com.mayab.calidad.proyectoJava.doubles;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

//import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class testDependency {
	public Dependency dependency;
	@Before
	public void setupMock() {
		//dependency = new Dependency(null);
		dependency = Mockito.mock(Dependency.class);
	}
	@After
	public void tearDown() throws Exception{
		
	}
	@Test
	public void testDummy() {
		//assertNull(dependency.getClass());
		//assertNull(dependency.getClassNameUpperCase());
		//assertNull(dependency.getSubdependencyClassName());
		//assertThat(dependency.getClassName(), is(nullValue()));
	}
	@Test
	public void testClassname() {
		when(dependency.getClassName()).thenReturn("HolaMundo");
		assertThat(dependency.getClassName(), is(equalTo("HolaMundo")));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		when(dependency.getClassNameUpperCase()).thenThrow(IllegalArgumentException.class);
		dependency.getClassNameUpperCase();
	}
	@Test
	public void testAddTwo() {
		int valor = 3;
		when(dependency.addTwo(anyInt())).thenReturn(0);
		assertThat(dependency.addTwo(anyInt()),is(equalTo(2)));
	}
	@Test
	public void testAnswer() 
	{
		when(dependency.addTwo(anyInt())).thenAnswer(
		new Answer<Integer>(){
			public Integer answer(InvocationOnMock invocation) 
					throws Throwable
			{
				int sumando =(Integer) invocation.getArguments()[0];
				System.out.println("El arg es: " + sumando);
				return sumando +20;
				
			}
		});
		assertThat(dependency.addTwo(10),is(equalTo(30)));
		assertThat(dependency.addTwo(20),is(equalTo(40)));
	}
	
	@Test
	public void testgetClassNameUpperCase() 
	{
		when(dependency.getClassNameUpperCase()).thenAnswer(
		new Answer(){
			public String answer(InvocationOnMock invocation) 
					throws Throwable
			{
				String respuesta = "";
				respuesta = "ClaseEnMayusculas";
				String str = invocation.getMock().getClass().toString();
				String nameClas = str.split("\\$")[0];
				respuesta = respuesta + ":" + nameClas.toUpperCase();
				return respuesta;
			}
		});
		assertThat(dependency.getClassNameUpperCase(),
				is(equalTo("ClaseEnMayusculas:CLASS COM.MAYAB.CALIDAD.DOUBLES.DEPENDENCY")));
	}
}
