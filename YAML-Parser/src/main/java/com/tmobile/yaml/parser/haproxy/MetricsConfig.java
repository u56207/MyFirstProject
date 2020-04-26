package com.tmobile.yaml.parser.haproxy;

import java.util.List;

public class MetricsConfig {
    private String type;
    private String name;
    private String help;
    private String match;
    private String value;
    private LabelConfig labels;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LabelConfig getLabels() {
        return labels;
    }

    public void setLabels(LabelConfig labels) {
        this.labels = labels;
    }
}
