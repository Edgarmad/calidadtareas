package com.mayab.calidad.proyectoJava.dbunit;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;


public class MyDbUnitTest extends DBTestCase {
	public String URL= "jdbc:mysql://localhost/mydb"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public MyDbUnitTest(String name){
		super( name );
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, URL);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
		//System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "public.mydb" );
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream xmlFile= getClass().getResourceAsStream("/data.xml");
	    return new FlatXmlDataSetBuilder().build(xmlFile);
	}

	@Before
	public void setUp() throws Exception{
		super.setUp();
		IDatabaseConnection conn = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet());
		}
		finally {
			conn.close();
		}
	}
	@Test
	public void testInsert() throws Exception{
		try
		{
            Connection con= DriverManager.getConnection(URL, "root", "password");
            Statement st;
            st= con.createStatement();
           int isEx = st.executeUpdate("insert into alumno(idAlumno,nombre, apellido, promedio) values (554,'cosa','cosa',5);");
           con.close();

        }catch (Exception e)
		{
           e.printStackTrace();
        }

		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("alumno");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("E:\\Documentos\\JavaProjects\\trianguloBueno\\src\\main\\resources\\prueba.xml"));
		ITable expectedTable = expectedDataSet.getTable("alumno");

        Assertion.assertEquals(expectedTable, actualTable);

	}
	@Test
	public void testDelete() throws Exception{
		try
		{
            Connection con= DriverManager.getConnection(URL, "root", "password");
            Statement st;
            st= con.createStatement();
           int isEx = st.executeUpdate("delete from alumno where idAlumno = 1001;");
           con.close();

        }catch (Exception e)
		{
           e.printStackTrace();
        }

		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("alumno");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("E:\\Documentos\\JavaProjects\\trianguloBueno\\src\\main\\resources\\pruebaDelete.xml"));
		ITable expectedTable = expectedDataSet.getTable("alumno");

        Assertion.assertEquals(expectedTable, actualTable);
	}
	@Test
	public void testUpdate() throws Exception{
		try
		{
            Connection con= DriverManager.getConnection(URL, "root", "password");
            Statement st;
            st= con.createStatement();
           int isEx = st.executeUpdate("UPDATE alumno set promedio = 10 where idAlumno = 1002");
           con.close();

        }catch (Exception e)
		{
           e.printStackTrace();
        }

		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("alumno");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("E:\\Documentos\\JavaProjects\\trianguloBueno\\src\\main\\resources\\pruebaUpdate.xml"));
		ITable expectedTable = expectedDataSet.getTable("alumno");

        Assertion.assertEquals(expectedTable, actualTable);

	}
	@Test
	public void testGetAll() throws Exception{
		try
		{
            Connection con= DriverManager.getConnection(URL, "root", "password");
            Statement st;
            st= con.createStatement();
           int isEx = st.executeUpdate("Select * from alumno;");
           con.close();

        }catch (Exception e)
		{
           e.printStackTrace();
        }

		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("alumno");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("E:\\Documentos\\JavaProjects\\trianguloBueno\\src\\main\\resources\\data.xml"));
		ITable expectedTable = expectedDataSet.getTable("alumno");

        Assertion.assertEquals(expectedTable, actualTable);

	}



	}