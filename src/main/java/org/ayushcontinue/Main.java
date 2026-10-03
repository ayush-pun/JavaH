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

        Alien alien = new Alien();
        alien.setaId(101);
        alien.setaName("ayush");
        alien.setTech("java developer");
        alien.setLaptop(laptop);

        Configuration cf = new Configuration();

        cf.addAnnotatedClass(Alien.class);
        cf.configure();

        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(alien);

        transaction.commit();

        session.close();
        sf.close();




    }
}
