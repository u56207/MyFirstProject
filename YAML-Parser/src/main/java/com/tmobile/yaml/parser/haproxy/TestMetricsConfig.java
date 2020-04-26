package com.tmobile.yaml.parser.haproxy;

import java.util.List;

public class TestMetricsConfig {
    private List<MetricsConfig> metrics;

    public List<MetricsConfig> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricsConfig> metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "metrics=" + metrics;
    }
}
