package app.MoviesPackage;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TicketList {
    
    private List<Tickets> tickets;

    public TicketList(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    public void showTicketsForShow(String show) {
        List<Tickets> ticketsForShow = new ArrayList<>();
        for (Tickets ticket : tickets) {
            if (ticket.getScreening().equals(show)) {
                ticketsForShow.add(ticket);
            }
        }

        ListView<Tickets> ticketListView = new ListView<>();
        ticketListView.setItems(FXCollections.observableArrayList(ticketsForShow));
        ticketListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Tickets ticket, boolean empty) {
                super.updateItem(ticket, empty);

                if (empty || ticket == null) {
                    setText(null);
                } else {
                    setText("Code: " + ticket.getCode() + ", Screening: " + ticket.getScreening() + ", Date of Issue: " + ticket.getDateOfIssue() + ", Type: " + ticket.getType() + ", Seat: " + ticket.getSeat() + ", Price: " + ticket.getPrice());
                }
            }
        });

        Stage stage = new Stage();
        stage.setScene(new Scene(ticketListView));
        stage.show();
    }
}
