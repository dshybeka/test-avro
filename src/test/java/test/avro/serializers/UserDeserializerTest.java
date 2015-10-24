package test.avro.serializers;

import example.avro.Event;
import example.avro.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserDeserializerTest {

    private UserSerializer serializer = new UserSerializer();
    private UserDeserializer deserializer = new UserDeserializer();

    @Test
    public void testDeserialize() throws Exception {

        User user = User.newBuilder()
                .setName("some name")
                .setFavoriteNumber(33)
                .setFavoriteColor("my color")
                .build();

        byte[] bytes = serializer.serialize(user);

        assertNotNull(bytes);

        User dematerializedUser = deserializer.deserialize(bytes);

        assertNotNull(dematerializedUser);
        assertEquals(user.getName(), dematerializedUser.getName());
        assertEquals(user.getFavoriteColor(), dematerializedUser.getFavoriteColor());
        assertEquals(user.getFavoriteNumber(), dematerializedUser.getFavoriteNumber());
    }

    @Test
    public void testMapSerialization() throws Exception {

        Map<String, String> values = new HashMap<>();
        values.put("prop1", "value1");
        values.put("prop2", "value2");

        Event event = Event.newBuilder().setName(values)
                .build();

        EventSerializer eventSerializer = new EventSerializer();
        EventDeserializer eventDeserializer = new EventDeserializer();

        byte[] bytes = eventSerializer.serialize(event);

        assertNotNull(bytes);

        Event dematerializedEvent = eventDeserializer.deserialize(bytes);

        assertNotNull(dematerializedEvent);
        assertEquals("value1", dematerializedEvent.getName().get("prop1"));
        assertEquals("value2", dematerializedEvent.getName().get("prop2"));
    }
}