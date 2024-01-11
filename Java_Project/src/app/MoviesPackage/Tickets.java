package app.MoviesPackage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tickets {
    private String code;
    private String screening;
    private String dateOfIssue;
    private String type;
    private String seat;
    private double price;

    public Tickets(String code, String screening, String dateOfIssue, String type, String seat, double price) {
        this.code = code;
        this.screening = screening;
        this.dateOfIssue = dateOfIssue;
        this.type = type;
        this.seat = seat;
        this.price = price;
    }
    
    public Tickets(){}
 
    public String getCode() {
        return code;
    }

    public String getScreening() {
        return screening;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public String getType() {
        return type;
    }

    public String getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setScreening(String screening) {
        this.screening = screening;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void modifyTicket(Tickets ticket, String screening, String dateOfIssue, String type, String seat, double price) {
        LocalDateTime screeningDateTime = LocalDateTime.parse(screening, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime currentDateTime = LocalDateTime.now();
        Duration duration = Duration.between(currentDateTime, screeningDateTime);

        if (duration.toHours() <= 2) {
            ticket.setScreening(screening);
            ticket.setDateOfIssue(dateOfIssue);
            ticket.setType(type);
            ticket.setSeat(seat);
            ticket.setPrice(price);
        }
        
        else {
        System.out.println("Ticket modification is not allowed at this time.");
        }
    }
}