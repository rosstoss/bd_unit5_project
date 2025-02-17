package com.bloomtech.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.bloomtech.entities.ContactMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactMessagesRepository {

    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public ContactMessages save(ContactMessages contactMessages) {
        mapper.save(contactMessages);
        return contactMessages;
    }

    // Read
    public ContactMessages findById(String id) {
        return mapper.load(ContactMessages.class, id);
    }

    public List<ContactMessages> findAll() {
        return mapper.scan(ContactMessages.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, ContactMessages contactMessages) {
        mapper.save(contactMessages, new DynamoDBSaveExpression()
                .withExpectedEntry("id", new ExpectedAttributeValue(
                        new AttributeValue(id))));

        return "Successfully uploaded message: " + id;
    }

    // Delete
    public String delete(String id) {
        ContactMessages contactMessages = mapper.load(ContactMessages.class, id);
        mapper.delete(contactMessages);
        return "Successfully deleted message: " + id;
    }
}