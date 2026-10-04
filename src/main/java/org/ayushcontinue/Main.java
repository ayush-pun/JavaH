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



        alien.setLaptops(Arrays.asList(laptop,laptop1));
        alien1.setLaptops(Arrays.asList(laptop2));

        laptop.setAliens(alien);
        laptop1.setAliens(alien);
        laptop2.setAliens(alien1);




        Configuration cf = new Configuration();

        cf.addAnnotatedClass(Alien.class);
        cf.addAnnotatedClass(Laptop.class);
        cf.configure();

        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(laptop);
        session.persist(laptop1);
        session.persist(laptop2);

        session.persist(alien);
        session.persist(alien1);

        transaction.commit();



        session.clear();

        Alien a1 = session.find(Alien.class, 101);

        System.out.println("ALIEN FOUND");
        System.out.println(a1);


        session.close();
        sf.close();




    }
}
