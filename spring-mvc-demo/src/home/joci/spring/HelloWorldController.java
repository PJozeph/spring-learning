package home.joci.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("processForm")
	public String processForm() {
		return "helloworld";
	}

	// read from data
	// add data to model
	@RequestMapping("processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String result = "Yoo!! " + name;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name , Model model) {
		name = name.toUpperCase();
		String result = "Hi my friend, " + name;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
}
