package com.mayab.calidad.proyectoJava.dbunit;

public interface AlumnoInterface {
	void addAlumno(Alumno alumno);
	void removeAlumno(Alumno alumno);
	void updatePromedioAlumno(Alumno alumno, float promedio);
	Alumno getAlumno(String nombre, int id);
}
