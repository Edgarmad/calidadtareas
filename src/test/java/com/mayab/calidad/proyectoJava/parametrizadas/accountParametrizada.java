package com.mayab.calidad.proyectoJava.parametrizadas;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class accountParametrizada {
	private String nombre;
	private int dinero, zona;
	AlertListener alerts;
	private Account account;
	public accountParametrizada(String nombre, int dinero, int zona,String alerts) {
		this.nombre = nombre;
		this.dinero = dinero;
		this.zona = zona;
		this.alerts = new AlertListener();
		this.alerts.alert(alerts);
	};

	@Before
	public void initialize() {
		account = new Account(nombre, dinero, zona);
	}
	@Parameters
	public static Collection<Object[]>
	data(){
		return Arrays.asList(new Object[][]{
			{"Pedro Perez",1000,1,"Mensaje1"},
			{"Pablo Sanchez",5000,2,"Mensaje2"},
			{"Panfico Suarez",500,3,"Mensaje3"}
		
	});
		 
	}
	@Test
	public void testAccount() {
		System.out.print(" "+ nombre +" "+ dinero +" "+ zona +" ");
		this.alerts.alert("cuenta creada \n");
	}
	
	
	
}