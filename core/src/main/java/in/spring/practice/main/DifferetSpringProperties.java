package in.spring.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SpringVersion;

import in.spring.practice.bean.CollectionPojo;
import in.spring.practice.bean.Employee;
import in.spring.practice.bean.PrintSomeMessage;
import in.spring.practice.bean.Vehicles;
import in.spring.practice.utils.Log;

public class DifferetSpringProperties {

	private static final String START_METHOD = "-------Start-------";
	private static final String END_METHOD = "-------End-------";
	private static final String EMPLOYEE_BEAN_ID = "employee";
	
	public static void main(String...strings) {
		injectionUsingParameter();
		injectionUsingConstructor();
		singletonObjectCreation();
		multiInstanceObjectCreation();
		beanLifeCycleMethodsExample();
		beanPostProcessorExample();
		beanFacotryPostProcessorExample();
		beanDefinationInheritance();
		innerBeanExample();
		createCollectionObject();
		autoWiringByName();
		autoWiringByType();
		autoWiringUsingConstructor();
		Log.logMessage(SpringVersion.getVersion());
	}
	private static void autoWiringUsingConstructor() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/AutoWiringUsingConstructor.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.toString());
		((ClassPathXmlApplicationContext) context).close();
		
		beanXMLFile = "com/spring/practice/configurationmatadatas/AutoWiringUsingConstructor.xml";
		context = new ClassPathXmlApplicationContext(beanXMLFile);
		employee = context.getBean("employeeObj2", Employee.class);
		Log.logMessage(employee.toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void autoWiringByType() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/AutoWiringByType.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void autoWiringByName() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/AutoWiringByName.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void createCollectionObject() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/CreatingCollectionObject.xml";
		String beanID = "collectionPojo";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		CollectionPojo collectionPojo = context.getBean(beanID, CollectionPojo.class);
		Log.logMessage(collectionPojo.getListOfString().toString());
		Log.logMessage(collectionPojo.getSetOfString().toString());
		Log.logMessage(collectionPojo.getMapOfIntegerString().toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void innerBeanExample() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/InnerBean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void beanDefinationInheritance() {
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/BeanDefinationInheritance.xml";
		String beanID = "cbr250r";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Vehicles vechicles = context.getBean(beanID, Vehicles.class);
		Log.logMessage(vechicles.toString());
		((ClassPathXmlApplicationContext) context).close();
		
		beanID = "pulsar150";
		context = new ClassPathXmlApplicationContext(beanXMLFile);
		vechicles = context.getBean(beanID, Vehicles.class);
		Log.logMessage(vechicles.toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void beanFacotryPostProcessorExample() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/InstantiateBeanFactoryPostProcessor.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.getName());
		
		/* If we get the bean of Employee class again
		 * from the context then it will change the
		 * employee name and will return declared in
		 * the XML file
		 **/
		String beanID = "printSomeMessage";
		PrintSomeMessage messagePrint = context.getBean(beanID, PrintSomeMessage.class);
		Log.logMessage(messagePrint.getSomeMessage());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void beanPostProcessorExample() {

		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/InstantiateBeanPostProcessor.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.getName());
		
		/* If we get the bean of Employee class again
		 * from the context then it will change the
		 * employee name and will return declared in
		 * the XML file
		 **/
		String beanID = "printSomeMessage";
		PrintSomeMessage messagePrint = context.getBean(beanID, PrintSomeMessage.class);
		Log.logMessage(messagePrint.getSomeMessage());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void beanLifeCycleMethodsExample() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/BeanLifecycleMethods.xml";
		String beanID = "printSomeMessage";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		PrintSomeMessage messagePrinting = context.getBean(beanID, PrintSomeMessage.class);
		Log.logMessage(messagePrinting.getSomeMessage());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void multiInstanceObjectCreation() {

		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/MultiInstanceObjectCreation.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		employee.setName("Subhankar Biswas");
		Log.logMessage(employee.getName());
		
		/* If we get the bean of Employee class again
		 * from the context then it will change the
		 * employee name and will return declared in
		 * the XML file
		 **/
		Employee employee2 = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee2.getName());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void singletonObjectCreation() {

		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/SingletonObjectCreation.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		employee.setName("Subhankar Biswas");
		Log.logMessage(employee.getName());
		
		/* If we get the bean of Employee class again
		 * from the context then it will not change the
		 * employee name and will return name as "Subhankar Biswas"
		 **/
		Employee employee2 = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee2.getName());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void injectionUsingConstructor() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/DependencyInjectionUsingConstructor.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.getAddress().toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
	private static void injectionUsingParameter() {
		
		Log.logInfo(START_METHOD);
		String beanXMLFile = "com/spring/practice/configurationmatadatas/DependencyInjectionUsingParameter.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXMLFile);
		Employee employee = context.getBean(EMPLOYEE_BEAN_ID, Employee.class);
		Log.logMessage(employee.getAddress().toString());
		((ClassPathXmlApplicationContext) context).close();
		Log.logInfo(END_METHOD);
	}
}
