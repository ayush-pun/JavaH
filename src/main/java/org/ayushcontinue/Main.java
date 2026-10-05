package org.ayushcontinue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

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

        /* basic fetching form the database using HQL

        String hql = "From Laptop";

        Query<Laptop> query = session.createQuery(hql,Laptop.class);

        List<Laptop> laptops = query.getResultList();

        System.out.println("");
        System.out.println("the laptops form database :");
        for(Laptop laptop : laptops){
            System.out.println(laptop);
        }
        */


        /*
        String hql = "select Lmodel from Laptop where Lname like ?1";

        Query<String> query = session.createQuery(hql, String.class);
        query.setParameter(1,"acer-nitro");

        List<String> names = query.getResultList();

        System.out.println(names);
        */


        //fetching multiple column form the database

        String hql = "select Lname, Lmodel from Laptop where ram = ?1";

        Query<Object[]> query = session.createQuery(hql,Object[].class);
        query.setParameter(1,32);

        List<Object[]> laptops = query.getResultList();

        System.out.println("the data form the database :");
        for(Object[] obj : laptops)
        {
            System.out.println(obj[0] + "  "+ obj[1]);
        }

        session.close();
        sf.close();




    }
}
