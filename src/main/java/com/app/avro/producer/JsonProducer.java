package com.app.avro.producer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

import static java.util.Collections.unmodifiableList;

/**
 * Created by samgupta0 on 3/26/2018.
 */
public class JsonProducer {
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    //private static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
    private static final String TOPIC = "test3";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        Producer<String, byte[]> producer = createProducer();
        try {
            for (int i = 0; i < 1; i++) {
                publishMessage(producer);
                Thread.sleep(random.nextInt(500));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            producer.close();
        }
    }

    private static Producer<String, byte[]> createProducer() {
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        config.put(ProducerConfig.CLIENT_ID_CONFIG, "CouchbaseJsonProducerExample");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());
        return new KafkaProducer<String, byte[]>(config);
    }

    private static void publishMessage(Producer<String, byte[]> producer) throws Exception {
        // Try setting the key to null and see how the Couchbase Sink Connector behaves.
        // For extra fun, try configuring the Couchbase Sink Connector with the property:
        //     couchbase.document.id=/airport
        String key = UUID.randomUUID().toString();

        ObjectNode weatherReport = randomWeatherReport();
        byte[] valueJson = objectMapper.writeValueAsBytes(weatherReport);

        ProducerRecord<String, byte[]> record = new ProducerRecord<String, byte[]>(TOPIC, key, valueJson);

        producer.send(record);
        /*RecordMetadata md = producer.send(record).get();
        System.out.println("Published " + md.topic() + "/" + md.partition() + "/" + md.offset()
                + " (key=" + key + ") : " + weatherReport);*/
    }

    private static final List<String> airports = unmodifiableList(Arrays.asList(
            "SFO", "YVR", "LHR", "CDG", "TXL", "VCE", "DME", "DEL", "BJS"));

    private static ObjectNode randomWeatherReport() {
        // In a real app you might want to take advantage of Jackson's data binding features.
        // Since Jackson is not the focus of this example, let's just build the JSON manually.
        ObjectNode report = objectMapper.createObjectNode();
        report.put("airport", airports.get(random.nextInt(airports.size())));
        report.put("degreesF", 70 + (int) (random.nextGaussian() * 20));
        report.put("timestamp", System.currentTimeMillis());
        return report;
    }
}
