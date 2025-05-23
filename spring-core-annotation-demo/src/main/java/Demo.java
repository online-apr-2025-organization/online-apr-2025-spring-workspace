import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Person;

public class Demo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext("com.demo.beans");
		Person person1 = context1.getBean("person", Person.class);
		System.out.println(person1);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("my-beans.xml");
		Person person2 = context.getBean("person", Person.class);
		System.out.println(person2);
	}

}
