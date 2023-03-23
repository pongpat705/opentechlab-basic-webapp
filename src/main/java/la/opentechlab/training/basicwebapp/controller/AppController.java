package la.opentechlab.training.basicwebapp.controller;

import la.opentechlab.training.basicwebapp.model.StudentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AppController {

    @GetMapping("/")
    public String main(Model model){

        StudentModel studentModel = new StudentModel();
        studentModel.setName("Mao");
        System.out.println(studentModel.toString());
        model.addAttribute("name", "mao");

        return "main";
    }
}
