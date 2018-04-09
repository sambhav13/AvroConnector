package com.app.avro.producer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

//import org.apache.kafka.connect.json.JsonSerializer;

/**
 * Created by samgupta0 on 3/26/2018.
 */
public class Producer {
    private static Scanner in;
    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        System.out.println("Enter message(type exit to quit)");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"com.app.producer.JsonSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

        ObjectMapper objectMapper = new ObjectMapper();

        String line = in.nextLine();
        while(!line.equals("exit")) {
            Contact contact = new Contact();
            contact.parseString(line);
            JsonSerializer js;
            JsonNode  jsonNode = objectMapper.valueToTree(contact);
            ProducerRecord<String, JsonNode> rec = new ProducerRecord<String, JsonNode>(topicName,jsonNode);
            producer.send(rec);
            line = in.nextLine();
        }
        in.close();
        producer.close();
    }
}