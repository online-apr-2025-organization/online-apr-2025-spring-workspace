import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.Employee;
import com.demo.beans.Person;
import com.demo.config.JavaConfig;

public class Demo {

	public static void main(String[] args) {
		// Bean scopes - singleton, prototype, session, request, application
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Person person1 = context.getBean("myPerson", Person.class);
		System.out.println(person1);
		Person person2 = context.getBean("myPerson", Person.class);
		person2.setFirstName("test");
		System.out.println(person2);
		System.out.println(person1);
		
		
		Employee emp = context.getBean("myEmployee", Employee.class);
		System.out.println(emp);

	}

}
