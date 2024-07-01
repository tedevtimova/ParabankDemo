package Helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

   public static List<TestParameters> loadFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        JsonNode parameterSetsNode = rootNode.get("parameterSets");
        return objectMapper.convertValue(parameterSetsNode, new TypeReference<List<TestParameters>>(){});
    }

}
