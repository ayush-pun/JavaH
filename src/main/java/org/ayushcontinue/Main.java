package org.ayushcontinue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Configuration cf = new Configuration();

        cf.addAnnotatedClass(Alien.class);
        cf.addAnnotatedClass(Laptop.class);
        cf.configure();

        SessionFactory sf = cf.buildSessionFactory();

        Session session = sf.openSession();

        //level-1 cache is working
        Laptop l1 = session.find(Laptop.class,1);
        System.out.println( l1);

        Laptop l2 = session.find(Laptop.class,1);
        System.out.println( l2);

        session.close();

        //checking for the level2 caching and it was possible with the
        //@Cacheable on the top of the Laptop class
        Session session1 = sf.openSession();
        Laptop l3 = session1.find(Laptop.class,1);
        System.out.println( l3);

        session1.close();


        sf.close();


    }
}
