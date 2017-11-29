package sample.data.jpa.domain;

import javax.persistence.Column;
import java.util.Date;

public class MetricEntityWrapper {

    public MetricEntityWrapper (Metrics metricObject, MetricsMetadata metaDataObject){
            setMetricName(metaDataObject.getDescription());
            setHighValue(metaDataObject.getHighValue());
            setLowValue(metaDataObject.getLowValue());
            setMetricUnit(metaDataObject.getMetricUnit());
            setHealthStatus(metaDataObject.getLowValue(),metaDataObject.getHighValue(),metricObject.getMetricValue());
            setValue(metricObject.getMetricValue());
    }

    private String metricName;
    private Double value;
    private Double lowValue;
    private Double highValue;
    private String metricUnit;
    private String healthStatus;


    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getLowValue() {
        return lowValue;
    }

    public void setLowValue(Double lowValue) {
        this.lowValue = lowValue;
    }

    public Double getHighValue() {
        return highValue;
    }

    public void setHighValue(Double highValue) {
        this.highValue = highValue;
    }

    public String getMetricUnit() {
        return metricUnit;
    }

    public void setMetricUnit(String metricUnit) {
        this.metricUnit = metricUnit;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Double lowValue, Double highValue, Double value) {
        if(value <= highValue && value>=lowValue)
            this.healthStatus = "Good";
        else
            this.healthStatus = "NotGood";
    }
}
