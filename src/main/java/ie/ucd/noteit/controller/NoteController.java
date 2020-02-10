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

    @GetMapping("/index")
    public String getIndexPage() {
        return "index.html";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "create.html";
    }

    @GetMapping("/browse")
    public String getBrowsePage() {
        return "browse.html";
    }

    @GetMapping("/view")
    public String getNotePage(@RequestParam(id="id") int id,Model model) {
        return model.getAttribute("id") + ".html";
    }
}