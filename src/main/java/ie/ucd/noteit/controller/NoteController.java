package ie.ucd.noteit.controller;

import ie.ucd.noteit.entities.Note;
import ie.ucd.noteit.entities.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello.html";
    }

    @GetMapping("/")
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
        notes.add(new Note((long) 0,"Title0","I like dogs"));
        notes.add(new Note((long) 1,"Title1","I like cats"));
        notes.add(new Note((long) 2,"Title2","I like lions"));
        model.addAttribute("notes",notes);
        return "browse.html";
    }

    @GetMapping("/error")
    public String getErrorPage(Model model) {
        return "";
    }

    @GetMapping("/note")
    public String note(@RequestParam("id") long id,Model model) {
        Note note = noteRepository.getOne(id);
        model.addAttribute("title",note.getTitle());
        model.addAttribute("content",note.getContent().replaceAll("\n","<br>"));
        return "note.html";
    }
}