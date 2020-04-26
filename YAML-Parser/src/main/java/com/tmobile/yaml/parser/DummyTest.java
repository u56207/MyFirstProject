package com.tmobile.yaml.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DummyTest {
    public static String asYaml(String jsonString) throws JsonProcessingException, IOException {
        // parse JSON
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
        // save it as YAML
        String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
        return jsonAsYaml;
    }

    public static String convertYamlToJson(String yaml) throws Exception{
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yaml, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }
    public static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream input = null;
        String yamlContent = "";
        try {
            //input = new FileInputStream(new File("C:\\Yaml-Sample\\acl.cfg"));
            //Object obj = yaml.load(input);
            //System.out.println(obj);
            yamlContent = readLineByLineJava8("C:\\Yaml-Sample\\app4.yml");
            String jsonStr = convertYamlToJson(yamlContent);
            System.out.println("+++++++++++++++ JSON Format ++++++++++++\n"+jsonStr);
            //String yamlStr = asYaml(jsonStr);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonStr);
            String yamlStr = new YAMLMapper().writeValueAsString(jsonNode);
            System.out.println("+++++++++++++++ YAML Format ++++++++++++\n"+yamlStr);
            FileWriter writer = new FileWriter("C:\\Yaml-Sample\\murali.yaml");
            yaml.dump(yamlStr, writer);
            System.out.printf("Finsished Writing..........");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
