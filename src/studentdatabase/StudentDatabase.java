/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package studentdatabase;

import java.util.List;

/**
 *
 * @author ittak
 */
public class StudentDatabase {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.insertStudent(new Student("Somying", 3.5));
        studentDAO.insertStudent(new Student("Somchai", 3.7));

        studentDAO.updateStudent(1, "Somchai AI", 3.8);

        studentDAO.deleteStudent(2);

        Student student = studentDAO.findStudentById(1);
        System.out.println(student);

        List<Student> studentsByName = studentDAO.findStudentsByName("Somying IA");
        studentsByName.forEach(System.out::println);

        List<Student> allStudents = studentDAO.findAllStudents();
        allStudents.forEach(System.out::println);
    }
}
