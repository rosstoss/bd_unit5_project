package com.bloomtech.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.bloomtech.entities.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillsRepository {
    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public Skills save(Skills skills) {
        mapper.save(skills);
        return skills;
    }

    // Read
    public Skills findById(String id) {
        return mapper.load(Skills.class, id);
    }

    public List<Skills> findAll() {
        return mapper.scan(Skills.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, Skills skills) {
        mapper.save(skills, new DynamoDBSaveExpression()
                .withExpectedEntry("id", new ExpectedAttributeValue(
                        new AttributeValue(id))));

        return "Successfully uploaded skill: " + id;
    }

    // Delete
    public String delete(String id) {
        Skills skills = mapper.load(Skills.class, id);
        mapper.delete(skills);
        return "Successfully deleted skill: " + id;
    }
}