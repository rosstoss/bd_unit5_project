package com.bloomtech.controllers;

import com.bloomtech.entities.Skills;
import com.bloomtech.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String update(@PathVariable(value = "id") String id, @RequestBody Skills skills) {
        return skillsRepository.update(id, skills);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return skillsRepository.delete(id);
    }
}