package Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;

public class StoreTest {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();


		HashMap<String, String> m1 = new HashMap<String,String>();
		m1.put("java is a programming language", "John Milton");
		m1.put("java is a platform", "Ashok kumar");


		HashMap<String, String> m2 = new HashMap<String,String>();
		m2.put("Servlet is an interface", "Ashok Kumar");
		m2.put("Servlet is an api", "Rahul kumar");

		Ques q1 = new Ques("What is java?" , "Alok", m1);
		Ques q2 = new Ques("What is servlet", "jai Dixit" , m2);

		session.persist(q1);
		session.persist(q2);

		t.commit();

		session.close();

		System.out.println("successfully stored");

	}
}
