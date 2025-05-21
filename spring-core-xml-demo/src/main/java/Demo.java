import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Employee;
import com.demo.beans.Person;

public class Demo {
	public static void main(String[] args) {
		Person person1 = new Person(101, "Will", "Smith");
		System.out.println(person1);
		
		// create the spring core container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("any-name.xml");
		Person person2 = context.getBean("per", Person.class);
		System.out.println(person2);
		
		Employee employee = context.getBean("emp", Employee.class);
		System.out.println(employee);
		
	}

}
