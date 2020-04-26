package com.tmobile.yaml.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class YamlToProperties {
    public static String toProperties(TreeMap<String, Map<String, Object>> config) {
        StringBuilder sb = new StringBuilder();
        for (String key : config.keySet()) {
            sb.append(toString(key, config.get(key)));
        }
        return sb.toString();
    }

    public static String toString(String key, Object mapr) {
        StringBuilder sb = new StringBuilder();
        if (!(mapr instanceof Map)) {
            sb.append(key + "=" + mapr + "\n");
            return sb.toString();
        }
        Map<String, Object> map = (Map<String, Object>) mapr;
        for (String mapKey : map.keySet()) {
            if (map.get(mapKey) instanceof Map) {
                sb.append(toString(key + "." + mapKey, map.get(mapKey)));
            } else {
                sb.append(String.format("%s.%s=%s%n", key, mapKey, map.get(mapKey).toString()));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        try {
            Yaml yaml = new Yaml();
            String fileName = "C:\\Yaml-Sample\\app4.yml";
            String fileType = FilenameUtils.getExtension(fileName);
            if (!fileType.equalsIgnoreCase(ConfigFileTypeEnum.YML.fileType)) {
                throw new IOException("Invalid File Type");
            }
            System.out.println("+++++++++++++ File Type :" + fileType);
            try (InputStream in = Files.newInputStream(Paths.get(fileName))) {
                TreeMap<String, Map<String, Object>> config = yaml.loadAs(in, TreeMap.class);
                String strConfig = config.toString();
                System.out.println("+++++++++++++++ strConfig ++++++++++++\n"+strConfig);
                String prop = toProperties(config);
                System.out.println("+++++++++++++++ prop ++++++++++++\n"+prop);
                //System.out.println(String.format("%s%n\nConverts to Properties:%n%n%s", config.toString(), toProperties(config)));
                ObjectMapper mapper = new ObjectMapper();
                String jsonNode = mapper.writeValueAsString(config);
                System.out.println("+++++++++++++++ YAML(jsonNode) Format ++++++++++++\n"+jsonNode);
                String yamlStr = new YAMLMapper().writeValueAsString(jsonNode);
                System.out.println("+++++++++++++++ YAML Format ++++++++++++\n"+yamlStr);
                FileWriter writer = new FileWriter("C:\\Yaml-Sample\\murali-jsonNode.yaml");
                yaml.dump(yamlStr, writer);
                System.out.printf("Finsished Writing..........");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getLocalizedMessage());
        }
    }
}

