package Client;
import java.util.*;

import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchTest {
    public static void main(String[] args) {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        TypedQuery query=session.createQuery("from Ques ");
        List<Ques> list=query.getResultList();

        for (Ques question : list) {
            System.out.println("question id:" + question.getId());
            System.out.println("question name:" + question.getName());
            System.out.println("question posted by:" + question.getUsername());
            System.out.println("answers.....");
            Map<String, String> map = question.getAnswers();
            Set<Map.Entry<String, String>> set = map.entrySet();

            for (Map.Entry<String, String> entry : set) {
                System.out.println("answer name:" + entry.getKey());
                System.out.println("answer posted by:" + entry.getValue());
            }
        }
        session.close();
    }
}
