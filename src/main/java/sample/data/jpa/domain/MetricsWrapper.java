package sample.data.jpa.domain;

import java.util.ArrayList;
import java.util.Date;

public class MetricsWrapper {


    public MetricsWrapper(Metrics metrics, Iterable <Metrics> metricsObject, Iterable <MetricsMetadata> metricMetaObject){
        for(MetricsMetadata  itr : metricMetaObject) {
            if (metrics.getMetricType() == itr.getMetricType()) {

                setMetricsName(itr.getDescription());
                setMetricsUnit(itr.getMetricUnit());
                setMetricsValue(metrics.getMetricValue());
                setTimeStamp(metrics.getEntryTimeStamp());
                setHistoricalDataPoints(metricsObject);
                setHealthStatus(itr.getLowValue(),itr.getHighValue(),metrics.getMetricValue());
            }
        }

    }
    String metricsName;
    Double metricsValue;
    String metricsUnit;
    Date timeStamp;
    String healthStatus;

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

//        if(metricsUnit.equalsIgnoreCase("Temperture")){
//            this.metricsUnit = "Degrees";
        //}
        //else
            //if(metricsUnit.equalsIgnoreCase("SPO2"))
                //this.metricsUnit="Percentage";
        //else
           // this.metricsUnit = "BPM";
        this.metricsUnit = metricsUnit;
    }

    public Double getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(Double metricsValue) {
        this.metricsValue = metricsValue;
    }

    //public String getNormalValue() {
       // return normalValue;
    //}

    //public void setNormalValue(String metricType) {
//        if(metricType.equalsIgnoreCase("Temperature"))
//            this.normalValue = "97";
//        else if(metricType.equalsIgnoreCase("PulseRate"))
//            this.normalValue = "70";
//        else
//            this.normalValue = "98";
//    }

//    public int getThreshold() {
//        return threshold;
//    }
//
//    public void setThreshold(int threshold) {
//        this.threshold = threshold;
//    }

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

    public void setHealthStatus(Double lowValue, Double highValue, Double value) {
        if(value <= highValue && value>=lowValue)
            this.healthStatus = "Good";
        else
            this.healthStatus = "NotGood";
    }

    public String getHealthStatus() {
        return healthStatus;
    }

}
