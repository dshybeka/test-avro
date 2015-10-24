package test.avro.serializers;

import example.avro.User;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by dshybeka on 24.10.2015.
 */
public abstract class Serializer<T extends SpecificRecord> {

    public byte[] serialize(T t) {

        byte[] bytes = null;

        SpecificDatumWriter<T> writer = new SpecificDatumWriter<>(t.getSchema());

        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {

            BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(stream, null);
            writer.write(t, binaryEncoder);
            binaryEncoder.flush();

            bytes = stream.toByteArray();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return bytes;
    }

}
