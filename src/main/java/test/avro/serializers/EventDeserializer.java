package test.avro.serializers;

import example.avro.Event;

/**
 * Created by dshybeka on 24.10.2015.
 */
public class EventDeserializer extends Deserializer<Event> {
    @Override
    protected Class<Event> getCurrentClass() {
        return Event.class;
    }
}
