package org.ayushcontinue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.font.LayoutPath;
import java.util.Arrays;
import java.util.jar.JarOutputStream;

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

        Laptop laptop2 = new Laptop();
        laptop2.setLid(3);
        laptop2.setLname("acer-nitro");
        laptop2.setLmodel("v16");
        laptop2.setRam(16);

        Alien alien = new Alien();
        alien.setaId(101);
        alien.setaName("ayush");
        alien.setTech("java developer");

        Alien alien1 = new Alien();
        alien1.setaId(102);
        alien1.setaName("anish");
        alien1.setTech("python developer");

        Alien alien2 = new Alien();
        alien2.setaId(103);
        alien2.setaName("bishal");
        alien2.setTech("react developer");

        alien.setLaptops(Arrays.asList(laptop,laptop1));
        alien1.setLaptops(Arrays.asList(laptop,laptop2));
        alien2.setLaptops(Arrays.asList(laptop1,laptop2));

        laptop.setAliens(Arrays.asList(alien,alien1));
        laptop1.setAliens(Arrays.asList(alien1,alien2));
        laptop2.setAliens(Arrays.asList(alien1,alien2));


        Configuration cf = new Configuration();

        cf.addAnnotatedClass(Alien.class);
        cf.addAnnotatedClass(Laptop.class);
        cf.configure();

        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(alien);
        session.persist(alien1);
        session.persist(alien2);

        session.persist(laptop);
        session.persist(laptop1);
        session.persist(laptop2);

        session.find(Alien.class,102);


        transaction.commit();


        session.close();
        sf.close();




    }
}
