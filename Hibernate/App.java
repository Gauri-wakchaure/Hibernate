package com.gauree.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.gauree.hiber.entities.Student;
import com.gauree.hiber.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Hello Gauri Wakchaure Software Developer" );
        
        //student create
        //save: hibernate
        
        Student student = new Student();
        student.setName("Gauri Wakchaure");
        student.setCollege("COEP");
        student.setActive(true);
        student.setPhone("1234567656");
        student.setFatherName("Rajesh Wakchaure");       
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   
        
        //System.out.println(sessionFactory);
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = null;
        
        try {
        	transaction=session.beginTransaction();
        	session.persist(student);
        	transaction.commit();
        	System.out.println("Student saved Successfully");
        } catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	e.printStackTrace();
        } finally {
        	session.close();
        }
        
    }
}