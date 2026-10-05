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

        /*find() vs getReference (eager vs lazy loading)
        so find () method is basically a eager method it searches the database for the data if avaliable returns the data and if not then null
        even when we dont need the data right now  it executes  the query and fetch (say we are not using sout(laptop)) it will still execute the query*/
        Laptop laptop = session.find(Laptop.class,1);
        System.out.println(laptop);


        /*But the getReference() is a lazy way of fetching the data what it does is if we not necessaraly need the data right now it will just give me the
        * reference of the Laptop, Hibernate returns a proxy a placeholder object represent the Laptop with id = 1*/

        Laptop laptop1 = session.getReference(Laptop.class, 2);

        //only when we do the need the data actully like for example we need data to print then only the data data is actually fetched
        System.out.println("lazy fetching : ");
        System.out.println(laptop1);


        session.close();
        sf.close();




    }
}
