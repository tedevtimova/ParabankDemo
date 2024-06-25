package Helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestParameters {

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String phone;
    public String ssn;
    public String username;
    public String password;
    public String confirmPasswordOne;
    public String confirmPasswordTwo;

    public static TestParameters loadFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(filePath), TestParameters.class);
    }
}
