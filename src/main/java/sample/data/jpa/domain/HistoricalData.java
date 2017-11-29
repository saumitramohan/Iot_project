package sample.data.jpa.domain;

import java.util.Date;

public class HistoricalData {
    Double value;
    Date timeStamp;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
