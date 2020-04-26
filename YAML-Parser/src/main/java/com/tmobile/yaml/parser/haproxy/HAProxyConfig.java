package com.tmobile.yaml.parser.haproxy;

import java.util.List;
import java.util.Map;

public class HAProxyConfig {
   private ConfigVersion global;
    private InputConfig input;
    private GrokConfig grok;
    private List<MetricsConfig> metrics;
    private ServerConfig server;
    public ConfigVersion getGlobal() {
        return global;
    }

    public void setGlobal(ConfigVersion global) {
        this.global = global;
    }

    public InputConfig getInput() {
        return input;
    }

    public void setInput(InputConfig input) {
        this.input = input;
    }

    public GrokConfig getGrok() {
        return grok;
    }

    public void setGrok(GrokConfig grok) {
        this.grok = grok;
    }

    public List<MetricsConfig> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricsConfig> metrics) {
        this.metrics = metrics;
    }

    public ServerConfig getServer() {
        return server;
    }

    public void setServer(ServerConfig server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "HAProxy{" +
                "global=" + global +
                "}, input="+ input +
                "}, grok="+ grok +
                "}, metrics="+ metrics +
                "}, server="+ server ;
    }
}
