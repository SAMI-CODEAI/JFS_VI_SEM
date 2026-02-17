import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveClient1 
{
	public static void main(String[] args) throws Exception
	{
		Session session=HSFactory.getSession();
		Transaction t=session.beginTransaction();
		try
		{
			Course c1=new Course(1,"Core Java","OOPs",60);
			Course c2=new Course(1,"Adv Java","JDBC,Serverlets,JSP",60);
			Course c3=new Course(1,"Hibernate","IS-A,HAS-A",60);
			Course c4=new Course(1,"Spring","Ioc,AOP",60);
			Course c5=new Course(1,"Sprng Boot","Spring Boot,Microservices with JPA",60);
			  session.save(c1); session.save(c2); session.save(c3);
			  session.save(c4); session.save(c5);
			  session.flush();
			  t.commit();
			  System.out.println("TX Success");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}



