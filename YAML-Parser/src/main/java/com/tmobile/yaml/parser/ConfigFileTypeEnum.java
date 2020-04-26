package com.tmobile.yaml.parser;

public enum ConfigFileTypeEnum {
    YAML("yaml"), YML("yml");
    public String fileType;
    private ConfigFileTypeEnum(String fileType)
    {
        this.fileType = fileType;
    }
    public static String getFileType(String fileType)
    {
        return fileType;
    }
}