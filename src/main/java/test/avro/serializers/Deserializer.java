package test.avro.serializers;

import example.avro.User;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecord;

import java.io.IOException;

/**
 * Created by dshybeka on 24.10.2015.
 */
public abstract class Deserializer<T extends SpecificRecord> {

    public T deserialize(byte[] bytes) throws IOException {

        DatumReader<T> reader = new SpecificDatumReader<>(getCurrentClass());

        Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);

        T t = reader.read(null, decoder);

        return t;
    }

    protected abstract Class<T> getCurrentClass();

}
