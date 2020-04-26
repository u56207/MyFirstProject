package com.tmobile.yaml.parser.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import com.tmobile.yaml.parser.haproxy.HAProxyConfig;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class ParseSample {

    public static void main(String... a) {
        //Constructor constructor = new Constructor(YamlConfig.class);
        Constructor constructor = new Constructor(HAProxyConfig.class);

        Yaml yaml = new Yaml( constructor );

        InputStream input = null;
        try {
            input = new FileInputStream(new File("C:\\Yaml-Sample\\app0.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //YamlConfig data = yaml.loadAs( input, YamlConfig.class );
        HAProxyConfig data = yaml.loadAs( input, HAProxyConfig.class );
        System.out.println( data );
        System.out.println( yaml.dump( data ));
    }
}