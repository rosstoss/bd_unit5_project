package controllers;

import entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.ProjectsRepository;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
public class ProjectsController {

    @Autowired
    ProjectsRepository projectsRepository;

    @PostMapping
    public Projects save(@RequestBody Projects projects) {
        return projectsRepository.save(projects);
    }

    @GetMapping("{id}")
    public Projects findById(@PathVariable(value = "id") String id) {
        return projectsRepository.findById(id);
    }

    @GetMapping
    public List<Projects> findAll() {
        return projectsRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable( value = "id") String id, @RequestBody Projects projects) {
        return projectsRepository.update(id, projects);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable (value = "id") String id) {
        return projectsRepository.delete(id);
    }
}
