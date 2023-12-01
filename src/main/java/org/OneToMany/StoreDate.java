package org.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class StoreDate {
    public static void main(String[] args) {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();


        Transaction t=session.beginTransaction();
        Student S1=new Student();
        S1.setStudent_name("Ramky");
        S1.setStudent_gender("prefer not to say");

        Student S2=new Student();
        S2.setStudent_name("Supriya");
        S2.setStudent_gender("Female");

        Student S3=new Student();
        S3.setStudent_name("priya");
        S3.setStudent_gender("Female");

        Student S4=new Student();
        S4.setStudent_name("riya");
        S4.setStudent_gender("Female");

        ArrayList<Student> list1= new ArrayList<Student>();
        list1.add(S1);
        list1.add(S2);

        ArrayList<Student>list2=new ArrayList<Student>();
        list2.add(S3);
        list2.add(S4);

        Teacher teacher1=new Teacher();
        teacher1.setTeacher_name("name");
        teacher1.setStudents(list1);

        Teacher teacher2=new Teacher();
        teacher2.setTeacher_name("name");
        teacher2.setStudents(list2);

        session.persist(teacher1);
        session.persist(teacher2);
        t.commit();
        session.close();
        System.out.println("data inserted successfully");


    }
}
