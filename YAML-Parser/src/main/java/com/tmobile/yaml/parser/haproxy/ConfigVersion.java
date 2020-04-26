package com.tmobile.yaml.parser.haproxy;

public class ConfigVersion {
    private String config_version;

    public String getConfig_version() {
        return config_version;
    }

    public void setConfig_version(String config_version) {
        this.config_version = config_version;
    }
    @Override
    public String toString() {
        return "ConfigVersion{" +
                "config_version='" + config_version + '\'' +
                '}';
    }
}
