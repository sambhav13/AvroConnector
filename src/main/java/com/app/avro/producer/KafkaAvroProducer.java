package com.app.avro.producer;

import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by samgupta0 on 3/26/2018.
 */
public class KafkaAvroProducer {

    public static void main(String[] args){
        Properties properties =  new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.setProperty("acks","1");
        properties.setProperty("retries","5");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());


    }
}
