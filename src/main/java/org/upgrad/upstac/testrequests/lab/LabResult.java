package org.upgrad.upstac.testrequests.lab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class LabResult {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long resultId;

    public void setRequest(TestRequest request) {
        this.request = request;
    }

    public void setTester(User tester) {
        this.tester = tester;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setHeartBeat(String heartBeat) {
        this.heartBeat = heartBeat;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setOxygenLevel(String oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setResult(TestStatus result) {
        this.result = result;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private TestRequest request;

    private String bloodPressure;
    private String heartBeat;
    private String temperature;
    private String oxygenLevel;
    private String comments;
    private TestStatus result;
    private LocalDate updatedOn;

    @ManyToOne
    private User tester;


}
