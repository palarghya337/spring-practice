package in.spring.practice.bean;

import org.springframework.stereotype.Controller;

@Controller
public interface IBooks {

	double getPrice();
	String getType();
	String getName();
	String getAuthorName();
	String getPublishers();
}
