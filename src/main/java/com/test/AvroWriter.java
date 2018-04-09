package com.test;


import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samgupta0 on 3/26/2018.
 */
public class AvroWriter {


    public static void main(String[] args) throws NullPointerException,IOException{

        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://localhost:9000");
        FileSystem fs = null;

        try {
            fs = FileSystem.get(conf);

            Path dir = new Path("/kafka/data/avro");
            if(!fs.exists(dir))
                fs.mkdirs(dir);

            OutputStream os = fs.create(new Path("/kafka/data/avro/"+args[0]));

            Schema schema = makeSchema();
            DataFileWriter<GenericData.Record> writer = testWrite(schema);
            DataFileWriter<GenericData.Record> writer_alt = writer.create(schema, os);
            writer_alt.append(makeObject(schema, "Person A", 23));
            writer_alt.append(makeObject(schema, "Person B", 31));
            writer_alt.append(makeObject(schema, "Person C", 28));

            writer_alt.close();
            os.close();
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            fs.close();
        }
    }


    public static Schema makeSchema() {
        List<Schema.Field> fields = new ArrayList<Schema.Field>();
        fields.add(new Schema.Field("name", Schema.create(Schema.Type.STRING), null, null));
        fields.add(new Schema.Field("age", Schema.create(Schema.Type.INT), null, null));

        Schema schema = Schema.createRecord("Person", null, "avro.test", false);
        schema.setFields(fields);

        return(schema);
    }

    public static GenericData.Record makeObject (Schema schema, String name, int age) {
        GenericData.Record record = new GenericData.Record(schema);
        record.put("name", name);
        record.put("age", age);
        return(record);
    }

    public static DataFileWriter<GenericData.Record> testWrite (Schema schema) throws IOException {
        GenericDatumWriter<GenericData.Record> datum = new GenericDatumWriter<GenericData.Record>(schema);
        DataFileWriter<GenericData.Record> writer = new DataFileWriter<GenericData.Record>(datum);

        return writer;

    }
}
