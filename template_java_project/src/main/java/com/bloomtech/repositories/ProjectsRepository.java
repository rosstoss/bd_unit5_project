package com.bloomtech.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.bloomtech.entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectsRepository {
    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public Projects save(Projects projects) {
        mapper.save(projects);
        return projects;
    }

    // Read
    public Projects findById(String id) {
        return mapper.load(Projects.class, id);
    }

    public List<Projects> findAll() {
        return mapper.scan(Projects.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, Projects projects) {
        mapper.save(projects, new DynamoDBSaveExpression()
                .withExpectedEntry("id", new ExpectedAttributeValue(
                        new AttributeValue(id))));

        return "Successfully uploaded project: " + id;
    }

    // Delete
    public String delete(String id) {
        Projects projects = mapper.load(Projects.class, id);
        mapper.delete(projects);
        return "Successfully deleted project: " + id;
    }
}