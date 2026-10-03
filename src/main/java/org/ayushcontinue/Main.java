package org.ayushcontinue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setLname("macbook air");
        laptop.setLmodel("m4");
        laptop.setRam(16);

        Laptop laptop1 = new Laptop();
        laptop1.setLid(2);
        laptop1.setLname("macbook pro");
        laptop1.setLmodel("m5");
        laptop1.setRam(32);

        Alien alien = new Alien();
        alien.setaId(101);
        alien.setaName("ayush");
        alien.setTech("java developer");
        alien.setLaptop(laptop);

        Alien alien2 = new Alien();
        alien2.setaId(102);
        alien2.setaName("Ram");
        alien2.setTech("Python");



        Configuration cf = new Configuration();

        cf.addAnnotatedClass(Alien.class);
        cf.addAnnotatedClass(Laptop.class);
        cf.configure();

        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(laptop);
        session.persist(laptop1);
        session.persist(alien);
        session.persist(alien2);


        transaction.commit();

        session.close();
        sf.close();




    }
}
