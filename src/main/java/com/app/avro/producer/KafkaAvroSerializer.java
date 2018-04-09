package com.app.avro.producer;

/**
 * Created by samgupta0 on 3/26/2018.
 */

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
/*
public class KafkaAvroSerializer extends AbstractKafkaAvroSerializer implements Serializer<Object> {

    private boolean isKey;

    */
/**
     * Constructor used by Kafka producer.
     *//*

    public KafkaAvroSerializer() {

    }

    public KafkaAvroSerializer(SchemaRegistryClient client) {
        schemaRegistry = client;
    }

    public KafkaAvroSerializer(SchemaRegistryClient client, Map<String, ?> props) {
        schemaRegistry = client;
        configure(serializerConfig(props));
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.isKey = isKey;
        configure(new KafkaAvroSerializerConfig(configs));
    }

    @Override
    public byte[] serialize(String topic, Object record) {
        return serializeImpl(getSubjectName(topic, isKey, record), record);
    }

    @Override
    public void close() {

    }
}*/
