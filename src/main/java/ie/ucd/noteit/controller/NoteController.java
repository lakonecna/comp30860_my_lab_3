package ie.ucd.noteit.controller;

import ie.ucd.noteit.entities.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

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
    public String getBrowsePage(@RequestParam(name="name") String name,Model model) {
        model.addAttribute("name",name);
        return "browse.html";
    }

    @GetMapping("/notes")
    public String notes(@RequestParam(name="name") String name,Model model) {
        model.addAttribute("name",name);
        ArrayList<Note> notes = new ArrayList<Note>();
        notes.add(new Note(0,"Title0","I like dogs"));
        notes.add(new Note(1,"Title1","I like cats"));
        notes.add(new Note(2,"Title2","I like lions"));
        model.addAttribute("notes",notes);
        return "browse.html";
    }

    @GetMapping("/error")
    public String getErrorPage(Model model) {
        return "";
    }

    @GetMapping("/note")
    public String getNotePage(@RequestParam(username="username") String username,
                              @RequestParam(password="password") String password,
                              Model model) {
        if(password.equals("ilovecats")) {
            model.addAttribute(username);
            return "note.html";
        }
        return "browse.html";
    }
    /*@GetMapping("/view")
    public String getNotePage(@RequestParam(id="id") int id,Model model) {
        return model.getAttribute("id") + ".html";
    }*/
}