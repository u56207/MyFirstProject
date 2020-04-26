package com.tmobile.yaml.parser.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderParser {
    public static void main(String[] args) throws  Exception{


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
       // mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        mapper.findAndRegisterModules();
        Order order1 = mapper.readValue(new File("C:\\Yaml-Sample\\order.yml"), Order.class);
        System.out.println(order1);
        //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<OrderLine> lines = new ArrayList<>();
        OrderLine o1 = new OrderLine();
        o1.setItem("Item1");o1.setQuantity(10);o1.setUnitPrice(new BigDecimal(100));
        OrderLine o2 = new OrderLine();
        o2.setItem("Item2");o2.setQuantity(20);o2.setUnitPrice(new BigDecimal(200));
        lines.add(o1);lines.add(o2);
        Order order = new Order();
        order.setCustomerName("Murali");
        order.setDate(LocalDate.parse("2020-04-25", DateTimeFormatter.ISO_DATE));
        order.setOrderNo("MyOrderNumber");
        order.setOrderLines(lines);
        mapper.writeValue(new File("C:\\Yaml-Sample\\order-New.yml"), order);
        //String yaml = mapper.writeValueAsString(order);
    }
}
