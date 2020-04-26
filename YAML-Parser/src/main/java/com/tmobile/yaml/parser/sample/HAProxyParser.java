package com.tmobile.yaml.parser.sample;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.tmobile.yaml.parser.haproxy.HAProxyConfig;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HAProxyParser {
    public static void main(String... a) {
        Constructor constructor = new Constructor(HAProxyConfig.class);
        Yaml yaml = new Yaml( constructor );
        new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        InputStream input = null;
        try {
            input = new FileInputStream(new File("C:\\Yaml-Sample\\app4.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HAProxyConfig data = yaml.loadAs( input, HAProxyConfig.class );
        System.out.println( data );
        System.out.println( yaml.dump( data ));
    }
}
