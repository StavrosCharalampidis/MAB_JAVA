package app.components;

import app.MoviesPackage.Tickets;
import app.Users.User;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class UserFormUI implements EventHandler<MouseEvent> {
    FlowPane rootFlowPane;

    
    Button CancelTicketBtn, NewTicketBtn, modifyTicketBtn;
    
    User user = new User();
    List<Tickets> tickets = user.getTickets();
    Tickets ticket = new Tickets();
    

    public FlowPane UserFormUI() {
        rootFlowPane = new FlowPane();
        
        rootFlowPane.setHgap(10);
        
        
        CancelTicketBtn = new Button("Cancel Ticket");
        CancelTicketBtn.setOnMouseClicked(this);
        rootFlowPane.getChildren().add(CancelTicketBtn);
        
        modifyTicketBtn = new Button("modify Ticket");
        modifyTicketBtn.setOnMouseClicked(this);
        rootFlowPane.getChildren().add(modifyTicketBtn);
        
        NewTicketBtn = new Button("New Ticket");
        NewTicketBtn.setOnMouseClicked(this);
        rootFlowPane.getChildren().add(NewTicketBtn);
        
        return rootFlowPane;
    };   
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == NewTicketBtn) {
            ticket.setCode("T001");
            ticket.setScreening("Screening 2");
            ticket.setDateOfIssue("2023-12-19");
            ticket.setType("Student");
            ticket.setSeat("B2");
            ticket.setPrice(8.0);
            
        }
        
        if (event.getSource() == CancelTicketBtn) {
            Tickets ticket = tickets.get(0); 
            user.CancelTicket(ticket);
        }
        
        if (event.getSource() == modifyTicketBtn) { 
            System.out.print("Code: " + ticket.getCode() + ", Screening: " + ticket.getScreening() + ", Date of Issue: " + ticket.getDateOfIssue() + ", Type: " + ticket.getType() + ", Seat: " + ticket.getSeat() + ", Price: " + ticket.getPrice());
        }
        
    }
 
}