package sample.data.jpa.domain;

import java.util.Date;

public class JSONtoVitalsObjectMapper {


    private Double temperature;
    private Double pulseRate;
    private Double spo2;
    private Date entryTimeStamp;


    public void setPulseRate(Double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Double getPulseRate() {
        return pulseRate;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperature() {
        return temperature;
    }


    public void setEntryTimeStamp(Date entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public Date getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public Double getSpo2() {
        return spo2;
    }

    public void setSpo2(Double spo2) {
        this.spo2 = spo2;
    }
}
