package study.springmvcdemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.springmvcdemo.business.Student;
import study.springmvcdemo.forms.NameListForm;

@Controller
public class HomeController {
	
	@Value("#{countryOptions}")	//Field Injection From .properties file
	private Map<String, String> countriesMap;
	
	@RequestMapping("/")
	public String getDefaultViewName() {
		return "main-menu";
	}
	
	@RequestMapping("/redirectForms") 
	public String redirectForms(HttpServletRequest request, Model model) {
		
		String radioSelection = request.getParameter("formSelect");
		
		if(radioSelection.equals("SpringMVC")) {
			return showStudentForm(request, model);
		}
		else if(radioSelection.equals("HTML")) {
			return showForm();
		}
		else {
			return "error-page";
		}
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}
	
	@RequestMapping("/submitForm")
	public String submitForm(HttpServletRequest request, Model model, NameListForm nameForm) {
		
		String name = request.getParameter("nameInp");
		name = name.toUpperCase();
		
		String message = null;
		if(name.length() % 2 == 0) {
			message = new String("Your Name Has Even Letters");
		}
		else {
			message = new String("Your Name Has Odd Letters");
		}
		nameForm.setName(name);
		
		model.addAttribute("message", message);
		model.addAttribute("nameForm", nameForm);
		return "submit-form";
	}
	
	public boolean checkIfIsValidate(HttpServletRequest request) {
		String validateStr = request.getParameter("validate");
		
		if(validateStr != null) 
			return validateStr.equals("Validate");
		
		return false;
	}
	
	@RequestMapping("/showStudentForm")
	public String showStudentForm(HttpServletRequest request, Model model) {
		
		model.addAttribute("validate", checkIfIsValidate(request));
		model.addAttribute("student", new Student());
		System.out.println(countriesMap);
		model.addAttribute("availableCountries",countriesMap);
		return "show-student-form";
	}
	
	/*Added New Method with Validation
	 * @RequestMapping("/submitStudent") //The Parameter with @ModelAttribute is
	 * mandatory if we want to use the model data in the confirm-student //Added
	 * Spring form tags in previous JSP thats why we can use studentObj directly
	 * here as data is bound. public String submitStudent(@ModelAttribute("student")
	 * Student studentObj, HttpServletRequest request, Model model) {
	 * 
	 * System.out.println(studentObj.getFirstName() + " "+studentObj.getLastName());
	 * System.out.println(model.getClass()); //class
	 * org.springframework.validation.support.BindingAwareModelMap
	 * model.addAttribute("availableCountries",countriesMap);
	 * 
	 * return "confirm-student"; }
	 */	
	
	@RequestMapping("/submitStudent")
	//The BindingResult object parameter must be after ModelAttribute's and Valid's parameter, otherwise it can't bind
	public String submitStudent(@Valid @ModelAttribute("student") Student studentObj, BindingResult theBindingResult , HttpServletRequest request, Model model) {
		
		if(checkIfIsValidate(request) && theBindingResult.hasErrors()) {
			model.addAttribute("validate", checkIfIsValidate(request));
			model.addAttribute("availableCountries",countriesMap);
			//model.addAttribute("student", new Student());	//Dont add this line
			return "show-student-form";
		}
		
		System.out.println(studentObj.getFirstName() + " "+studentObj.getLastName());
		System.out.println(model.getClass()); //class org.springframework.validation.support.BindingAwareModelMap
		model.addAttribute("availableCountries",countriesMap);
		
		return "confirm-student";
	
	}
}
