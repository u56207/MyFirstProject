package com.tmobile.yaml.parser.haproxy;

public class InputConfig {
    private String type;
    private String path;
    private boolean readall;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isReadall() {
        return readall;
    }

    public void setReadall(boolean readall) {
        this.readall = readall;
    }
}
