package sample.data.jpa.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
public class Metrics {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "deviceid")
    private String deviceid;

    @Column(name = "metrictype")
    private int metricType;

    @Column(name = "metricvalue")
    private Double metricValue;

    @Column(name = "entrytimestamp")
    private Date entryTimeStamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getMetricType() {
        return metricType;
    }

    public void setMetricType(int metricType) {
        this.metricType = metricType;
    }

    public Double getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(Double metricValue) {
        this.metricValue = metricValue;
    }

    public Date getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setEntryTimeStamp(Date entrytimestamp) {
        if (entrytimestamp == null) {
            Calendar calendar = Calendar.getInstance();
            this.entryTimeStamp = calendar.getTime();
        } else {
            this.entryTimeStamp = entrytimestamp;
        }

    }
}