package sample.data.jpa.domain;

import java.util.ArrayList;
import java.util.Date;

public class MetricsWrapper {


    public MetricsWrapper(Metrics metrics, Iterable <Metrics> data){

        setMetricsName(metrics.getMetricType());
        setMetricsUnit(metrics.getMetricType());
        setMetricsValue(metrics.getMetricValue());
        setNormalValue(metrics.getMetricType());
        setThreshold(0);
        setTimeStamp(metrics.getEntryTimeStamp());
        setHistoricalDataPoints(data);

    }
    String metricsName;
    String metricsValue;
    String metricsUnit;
    String normalValue;
    Date timeStamp;
    int threshold;

    ArrayList<HistoricalData> hdPointsList = new ArrayList<>();

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public String getMetricsUnit() {
        return metricsUnit;
    }

    public void setMetricsUnit(String metricsUnit) {
        if(metricsUnit.equalsIgnoreCase("Temperture")){
            this.metricsUnit = "Degrees";
        }
        else
            if(metricsUnit.equalsIgnoreCase("SPO2"))
                this.metricsUnit="Percentage";
        else
            this.metricsUnit = "BPM";
    }

    public String getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(String metricsValue) {
        this.metricsValue = metricsValue;
    }

    public String getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(String metricType) {
        if(metricType.equalsIgnoreCase("Temperature"))
            this.normalValue = "97";
        else if(metricType.equalsIgnoreCase("PulseRate"))
            this.normalValue = "70";
        else
            this.normalValue = "98";
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setHistoricalDataPoints(Iterable <Metrics> data) {
        for(Metrics obj: data){
            HistoricalData hdObject = new HistoricalData();
            hdObject.setValue(obj.getMetricValue());
            hdObject.setTimeStamp(obj.getEntryTimeStamp());
            hdPointsList.add(hdObject);

        }
    }

    public ArrayList<HistoricalData> getHistoricalDataPoints(){
        return hdPointsList;
    }

}
