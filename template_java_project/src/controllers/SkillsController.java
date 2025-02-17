package controllers;

import entities.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.SkillsRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class SkillsController {

    @Autowired
    SkillsRepository skillsRepository;

    @PostMapping
    public Skills save(@RequestBody Skills skills) {
        return skillsRepository.save(skills);
    }

    @GetMapping("{id}")
    public Skills findById(@PathVariable(value = "id") String id) {
        return skillsRepository.findById(id);
    }

    @GetMapping
    public List<Skills> findAll() {
        return skillsRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable( value = "id") String id, @RequestBody Skills skills) {
        return skillsRepository.update(id, skills);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable (value = "id") String id) {
        return skillsRepository.delete(id);
    }
}
