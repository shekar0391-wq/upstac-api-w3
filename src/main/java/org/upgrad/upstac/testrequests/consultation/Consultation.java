package org.upgrad.upstac.testrequests.consultation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Consultation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public TestRequest getRequest() {
        return request;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private TestRequest request;

    public void setSuggestion(DoctorSuggestion suggestion) {
        this.suggestion = suggestion;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    private DoctorSuggestion suggestion;


    public DoctorSuggestion getSuggestion() {
        return suggestion;
    }

    public String getComments() {
        return comments;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    private String comments;

    private LocalDate updatedOn;

    public void setRequest(TestRequest request) {
        this.request = request;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    @ManyToOne
    User doctor;

}
