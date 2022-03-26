package course.demos.streams.util;

import java.time.LocalDate;

public class Letter {
    private String returningAddress;
    private String insideAddress;
    private LocalDate dateOfLetter;
    private String salutation;
    private String body;
    private String closing;

    public Letter(String salutation, String body) {
        this.salutation = salutation;
        this.body = body;
    }

    public Letter(String returningAddress, String insideAddress, LocalDate dateOfLetter,
           String salutation, String body, String closing) {
        this.returningAddress = returningAddress;
        this.insideAddress = insideAddress;
        this.dateOfLetter = dateOfLetter;
        this.salutation = salutation;
        this.body = body;
        this.closing = closing;
    }

    public String getReturningAddress() {
        return returningAddress;
    }

    public String getInsideAddress() {
        return insideAddress;
    }

    public LocalDate getDateOfLetter() {
        return dateOfLetter;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getBody() {
        return body;
    }

    public String getClosing() {
        return closing;
    }
}
