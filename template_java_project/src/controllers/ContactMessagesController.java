package controllers;

import entities.ContactMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.ContactMessagesRepository;

import java.util.List;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class ContactMessagesController {

    @Autowired
    ContactMessagesRepository contactMessagesRepository;

    @PostMapping
    public ContactMessages save(@RequestBody ContactMessages skills) {
        return contactMessagesRepository.save(skills);
    }

    @GetMapping("{id}")
    public ContactMessages findById(@PathVariable(value = "id") String id) {
        return contactMessagesRepository.findById(id);
    }

    @GetMapping
    public List<ContactMessages> findAll() {
        return contactMessagesRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable( value = "id") String id, @RequestBody ContactMessages contactMessages) {
        return contactMessagesRepository.update(id, contactMessages);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable (value = "id") String id) {
        return contactMessagesRepository.delete(id);
    }
}
