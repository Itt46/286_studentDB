/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdatabase;

/**
 *
 * @author ittak
 */


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO {

    private final EntityManagerFactory emf;

    public StudentDAO() {
        emf = Persistence.createEntityManagerFactory("StudentPU");
    }

    public void insertStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public void updateStudent(int id, String name, double gpa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            student.setName(name);
            student.setGpa(gpa);
            em.merge(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudent(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Student findStudentById(int id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    public List<Student> findStudentsByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class);
        query.setParameter("name", name);
        List<Student> students = query.getResultList();
        em.close();
        return students;
    }

    public List<Student> findAllStudents() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        em.close();
        return students;
    }
}
