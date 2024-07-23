package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
// Create tables
        Student s1 = new Student();
        s1.setName("Mohamed Metwally");
        s1.setPhone("01154357533");
        Courses s1c1 = new Courses();
        Courses s1c2 = new Courses();
        s1c1.setCourse_name("Math");
        s1c2.setCourse_name("Science");
        s1.addCourse(s1c1);
        s1.addCourse(s1c2);

        Student s2 = new Student();
        s2.setName("Ahmed Hassan");
        s2.setPhone("01157433422");
        Courses s2c1 = new Courses();
        Courses s2c2 = new Courses();
        s2c1.setCourse_name("English");
        s2c2.setCourse_name("Geographic");
        s2.addCourse(s2c1);
        s2.addCourse(s2c2);
        Session session = null;



             session = HibernateConfig.getsessionFactory().openSession();
            session.beginTransaction();
            session.save(s1);
            session.save(s2);
            session.getTransaction().commit();


//        Update
       Student update = session.get(Student.class,1);
        update.setName("Khaled Mostafa");
        update.setPhone("01223424564");
        session.beginTransaction();
        session.update(update);
        session.getTransaction().commit();


        session.beginTransaction();
//        Read
        Query q = session.createQuery("from Student where name like '%h%' ", Student.class);
        List <Student> s = q.list();
        for(Student student : s){
            System.out.println(student);
        }
        session.getTransaction().commit();




//       Delete
        Student delete=session.get(Student.class,1);
        session.beginTransaction();
        session.delete(delete);
        session.getTransaction().commit();



        session.close();
        HibernateConfig.getsessionFactory().close();

    }
}
