package ie.ucd.noteit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
    int count = 0;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("count", count++);
        return "hello.html";
    }
}