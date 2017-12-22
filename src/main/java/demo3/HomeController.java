package demo3;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by maxa on 12/17/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String showMyIndexPage() {
        return "index";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @InitBinder
    public void innitBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }


    @RequestMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @RequestMapping("/studentData")
    public String showStudentData(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        System.out.println("Student: " + student.getLastName());
        if(bindingResult.hasErrors()) {
            return "student-form";
        } else {
            return "student-data";
        }
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String name,/*HttpServletRequest request,*/ Model model) {
//        String studentName = request.getParameter("studentName");
        String studentName = name;
        studentName = studentName.toUpperCase();
        studentName = "Yo! " + studentName;
        model.addAttribute("message", studentName);
        return "helloworld";
    }

}
