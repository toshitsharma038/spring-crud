package com.demo.SpringCrud.Controller;

import com.demo.SpringCrud.Beans.Student;
import com.demo.SpringCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController
{
    @Autowired
    StudentService stuservice;

    @GetMapping("/register")
    public String addData()
    {
       return "RegisterPage";
    }

    @PostMapping("/listpage")
    public void addDatas(@ModelAttribute(value = "stu")Student  student, Model model)
    {
        stuservice.addData(student);
     }

    @GetMapping("/listpage")
    public String Listpage(Model model)
    {
        List<Student> stu=stuservice.fetchdata();
        model.addAttribute("stu",stu);

        return "listpage";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model)
    {
       Student stuobj = stuservice.searchData(id);
       System.out.println(stuobj);
       model.addAttribute("stuobj",stuobj);
       return "updatestu";
    }


   @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Student student, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            student.setId(id);
            return "/updatestu";
        }
        Student stuobj = stuservice.inserData(student);
        System.out.println("I am from/update/{id} "+stuobj);
        return "redirect:/listpage";
    }

    @GetMapping("/delete/{id}")
    public String deleteByID(@PathVariable("id") long id,Student student,Model model)
    {
        boolean status = stuservice.deleteData(student);
        System.out.println("I am from controller"+status);
        if(status)
        {
            return "redirect:/listpage";
        }
        return "redirect:/listpage";
    }

}
