package client;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DynamoDBConfiguration.class);

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;

    @Value("${aws.dynamodb.accessKey}")
    private String awsAccessKey;

    @Value("${aws.dynamodb.secretKey}")
    private String awsSecretKey;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        logger.info("DynamoDB Endpoint: " + dynamoDbEndpoint);
        logger.info("AWS Access Key: " + awsAccessKey);
        // Avoid logging the secret key for security reasons
        return new DynamoDBMapper(amazonDynamoDB());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, "us-west-2"))
                .withCredentials(amazonDynamoDbCredentials())
                .build();
    }

    @Bean
    public AWSCredentialsProvider amazonDynamoDbCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }
}