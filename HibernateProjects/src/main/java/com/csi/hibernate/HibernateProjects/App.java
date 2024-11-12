package com.csi.hibernate.HibernateProjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started..." );
        
        Configuration cfg = new Configuration();
        
        cfg.configure();
       
       SessionFactory factory = cfg.buildSessionFactory();
   
       Student st = new Student();
       st.setId(101);
       st.setName("jhon");
       st.setCity("delhi");
       
       System.out.println(st);
       
       //creating object of address class
       
       Address ad = new Address();
       ad.setStreet("street1");
       ad.setCity("kamshet");
       ad.setOpen(true);
       ad.setAddedDate(new Date());
       ad.setX(11.1211);
       //ad.setImage(null);
       
       //Reading image
  
	FileInputStream fis = new FileInputStream("src/main/java/hibernate property .png");
       byte[] data = new byte[fis.available()];
       fis.read(data);
       ad.setImage(data);
       
       Session session = factory.openSession();
       
       Transaction  tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        tx.commit();
        session.close();
        
        System.out.println("done");
    }
}
