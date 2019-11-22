package com.mayab.calidad.proyectoJava.testSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mayab.calidad.proyectoJava.dbunit.*;
import com.mayab.calidad.proyectoJava.doubles.*;
import com.mayab.calidad.proyectoJava.funcionales.*;
@RunWith(Suite.class)
@SuiteClasses({
	MyDbUnitTest.class,
	testDependency.class,
	FacebookTest.class,
	loginTest.class
})
public class AllTests {

}
