package sample.data.jpa.domain;

import java.util.ArrayList;
import java.util.Date;

public class MetricsWrapper implements Comparable <MetricsWrapper> {

    @Override
    public int compareTo(MetricsWrapper o) {
        return this.metricsName.compareTo(o.metricsName);
    }


    public MetricsWrapper(Metrics metrics, Iterable<Metrics> metricsObject, Iterable<MetricsMetadata> metricMetaObject) {
        for (MetricsMetadata itr : metricMetaObject) {

            if (metrics.getMetricType() == itr.getMetricType()) {

                setMetricsName(itr.getDescription());
                setMetricsUnit(itr.getMetricUnit());
                setMetricsValue(metrics.getMetricValue());
                setTimeStamp(metrics.getEntryTimeStamp());
                setHistoricalDataPoints(metricsObject);
                setHealthStatus(itr.getLowValue(), itr.getHighValue(), metrics.getMetricValue());
                setAlertValue(this.alertValueCalc, itr.getHighValue(), itr.getLowValue(), alertFlag, alertValue);
            }
        }

    }

    String metricsName;
    Double metricsValue;
    String metricsUnit;
    Date timeStamp;
    String healthStatus;
    Double alertValueCalc = 0.0;
    Double alertValue = 0.0;



    boolean alertFlag = false;


    public Double getAlertValue() {
        return alertValue;
    }

    public boolean isAlertFlag() {
        return alertFlag;
    }

    public void setAlertFlag(boolean alertFlag) {
        this.alertFlag = alertFlag;
    }




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

        this.metricsUnit = metricsUnit;
    }

    public Double getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(Double metricsValue) {
        this.metricsValue = metricsValue;
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setHistoricalDataPoints(Iterable<Metrics> data) {
        for (Metrics obj : data) {
            HistoricalData hdObject = new HistoricalData();
            hdObject.setValue(obj.getMetricValue());
            hdObject.setTimeStamp(obj.getEntryTimeStamp());
            hdPointsList.add(hdObject);
            if (obj.getMetricValue() > 0)
                this.alertValueCalc += obj.getMetricValue();

        }
    }

    public ArrayList<HistoricalData> getHistoricalDataPoints() {
        return hdPointsList;
    }

    public void setHealthStatus(Double lowValue, Double highValue, Double value) {
        if (value <= highValue && value >= lowValue)
            this.healthStatus = "Good";
        else
            this.healthStatus = "NotGood";
    }

    public String getHealthStatus() {

        return healthStatus;
    }

//    public Double getAlertValue() {
//        return alertValue;
//    }

    public void setAlertValue(Double alertValueCalc, Double highvalue, Double lowValue, boolean alertFlag, Double alertValue) {
        Double alertValueAvg = alertValueCalc / 100;
        System.out.println("Average Value" + alertValueAvg);
        System.out.println("High Value" + highvalue);

        if (alertValueAvg > highvalue) {
            this.alertValue = alertValueAvg;
            this.alertFlag = true;
        } else if (alertValueAvg < lowValue) {
            this.alertValue = alertValueAvg;
            this.alertFlag = true;

        } else {
            this.alertFlag = false;
        }

    }
}
