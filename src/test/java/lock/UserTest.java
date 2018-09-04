//package lock;
//
//import com.mysql.cj.xdevapi.SessionFactory;
//
//import javax.security.auth.login.Configuration;
//
//public class UserTest {
//    public static void main(String[] args) {
//        Configuration conf=new Configuration().configure();
//        SessionFactory sf=conf.buildSessionFactory();
//        Session session=sf.openSession();
////      Session session2=sf.openSession();
//        User user=(User) session.createQuery(" from User user where user=5").uniqueResult();
////      User user2=(User) session.createQuery(" from User user where user=5").uniqueResult();
//        System.out.println(user.getVersion());
////      System.out.println(user2.getVersion());
//        Transaction tx=session.beginTransaction();
//        user.setUserName("101");
//        tx.commit();
//
//        System.out.println(user.getVersion());
////      System.out.println(user2.getVersion());
////      System.out.println(user.getVersion()==user2.getVersion());
////      Transaction tx2=session2.beginTransaction();
////      user2.setUserName("4468");
////      tx2.commit();
//
//    }
//
//}
