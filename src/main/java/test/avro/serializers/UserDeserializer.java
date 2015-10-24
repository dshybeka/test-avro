package test.avro.serializers;

import example.avro.User;

/**
 * Created by dshybeka on 24.10.2015.
 */
public class UserDeserializer extends Deserializer<User>{
    @Override
    protected Class<User> getCurrentClass() {
        return User.class;
    }
}
