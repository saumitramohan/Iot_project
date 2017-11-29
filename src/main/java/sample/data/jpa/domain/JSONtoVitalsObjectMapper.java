package sample.data.jpa.domain;

import java.util.Date;

public class JSONtoVitalsObjectMapper {


    private String temperature;
    private String pulseRate;
    private String spo2;
    private Date entryTimeStamp;


    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }


    public void setEntryTimeStamp(Date entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public Date getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public String getSpo2() {
        return spo2;
    }

    public void setSpo2(String spo2) {
        this.spo2 = spo2;
    }
}
