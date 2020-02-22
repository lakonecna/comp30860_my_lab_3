package ie.ucd.noteit.controller;

import ie.ucd.noteit.entities.Note;
import ie.ucd.noteit.entities.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;
    private int noteCount = 3;

    @GetMapping("/")
    public String firstPage() { return "index.html"; }

    @GetMapping("/index")
    public String index() { return "index.html"; }

    @GetMapping("/create")
    public String create() {
        return "create.html";
    }

    @PostMapping("/saveNote")
    public void saveNote(String title,String note, HttpServletResponse response) throws IOException {
        ++noteCount;
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(note);
        noteRepository.save(newNote);
        response.sendRedirect("/");
    }

    @GetMapping("/browse")
    public String browse(Model model) {
        ArrayList<Note> notes = new ArrayList<Note>(noteRepository.findAll());
        model.addAttribute("notes",notes);
        return "browse.html";
    }

    @GetMapping("/view?id={id}")
    public String note(@RequestParam("id") long id,Model model) {
        Note note = noteRepository.getOne(id);
        model.addAttribute(note);
        model.addAttribute("title",note.getTitle());
        model.addAttribute("content",note.getContent().replaceAll("\n","<br>"));
        return "view.html";
    }
}