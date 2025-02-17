package com.bloomtech.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "bd5_skillsTable")
public class Skills {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute(attributeName = "createDate")
    private String createDate;

    @DynamoDBAttribute(attributeName = "proficiency")
    private String proficiency;

    @DynamoDBAttribute(attributeName = "skillName")
    private String skillName;

    @DynamoDBAttribute(attributeName = "updateDate")
    private String updateDate;

}

