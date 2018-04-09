package com.app.avro.kafka;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by samgupta0 on 3/26/2018.
 */
public class HdfsSinkTask extends SinkTask {

    private static Logger log = LogManager.getLogger(HdfsSinkTask.class);
    public String version() {
        return null;
    }

    public void start(Map<String, String> map) {

        log.info("initialized the HDFS Sink ");
    }

    public void put(Collection<SinkRecord> collection) {

        try {
           /* Collection<String> recordsAsString = collection.stream().map(r -> String.valueOf(r.value()))
                    .collect(Collectors.toList());*/
            Iterator<SinkRecord> it = collection.iterator();
            process(it);
        }
        catch (Exception e) {
            log.error("Error while processing records");
            log.error(e.toString());
        }
    }

    public void flush(Map<TopicPartition, OffsetAndMetadata> map) {
        log.trace("Flushing the queue");
    }

    public void stop() {

    }

    public void process(Iterator<SinkRecord> it){

        log.info("processing the record");

        System.out.println("started processing");
        log.info("The record is --> " +it.next().value());
        while(it.hasNext()){
            System.out.println("The record is --> " +it.next().value());
        }


    }

    /*public void process(Collection<String> record){

        log.info("processing the record");
        record.parallelStream().map(rec -> {
            System.out.println("The record is --> " + rec);
            return null;
        });
    }*/
}
