package app.Scene;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//TicketManagementUI
public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ticket Management System");

        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Create TableView for Tickets
        TableView<Ticket> ticketTableView = createTicketTable();
        mainLayout.setLeft(ticketTableView);

        // Create TableView for Parties
        TableView<Party> partyTableView = createPartyTable();
        mainLayout.setCenter(partyTableView);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Ticket> createTicketTable() {
        TableView<Ticket> ticketTableView = new TableView<>();

        // Create columns
        TableColumn<Ticket, String> codeColumn = new TableColumn<>("Code");
        TableColumn<Ticket, String> movieColumn = new TableColumn<>("Movie");
        TableColumn<Ticket, String> issueDateColumn = new TableColumn<>("Issue Date");
        TableColumn<Ticket, String> typeColumn = new TableColumn<>("Type");
        TableColumn<Ticket, String> seatColumn = new TableColumn<>("Seat");
        TableColumn<Ticket, Double> priceColumn = new TableColumn<>("Price");

        // Set column cell value factories
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        movieColumn.setCellValueFactory(new PropertyValueFactory<>("movie"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        seatColumn.setCellValueFactory(new PropertyValueFactory<>("seat"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Add columns to the table
        ticketTableView.getColumns().addAll(codeColumn, movieColumn, issueDateColumn, typeColumn, seatColumn, priceColumn);

        // Set sample data
        ObservableList<Ticket> ticketData = FXCollections.observableArrayList(
                new Ticket("001", "Movie A", "2022-01-11", "Normal", "A1", 10.0),
                new Ticket("002", "Movie B", "2022-01-11", "Student", "B2", 8.0),
                new Ticket("003", "Movie C", "2022-01-12", "Child", "C3", 5.0)
        );

        ticketTableView.setItems(ticketData);

        return ticketTableView;
    }

    private TableView<Party> createPartyTable() {
        TableView<Party> partyTableView = new TableView<>();

        // Create columns
        TableColumn<Party, String> partyCodeColumn = new TableColumn<>("Party Code");
        TableColumn<Party, String> partyDateColumn = new TableColumn<>("Party Date");
        TableColumn<Party, String> partyDetailsColumn = new TableColumn<>("Party Details");
        TableColumn<Party, Double> partyPriceColumn = new TableColumn<>("Party Price");

        // Set column cell value factories
        partyCodeColumn.setCellValueFactory(new PropertyValueFactory<>("partyCode"));
        partyDateColumn.setCellValueFactory(new PropertyValueFactory<>("partyDate"));
        partyDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("partyDetails"));
        partyPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partyPrice"));

        // Add columns to the table
        partyTableView.getColumns().addAll(partyCodeColumn, partyDateColumn, partyDetailsColumn, partyPriceColumn);

        // Set sample data
        ObservableList<Party> partyData = FXCollections.observableArrayList(
                new Party("P001", "2022-01-15", "Birthday Party", 200.0),
                new Party("P002", "2022-02-20", "Theme Party", 150.0),
                new Party("P003", "2022-03-25", "Celebration", 180.0)
        );

        partyTableView.setItems(partyData);

        return partyTableView;
    }
}

class Ticket {
    private String code;
    private String movie;
    private String issueDate;
    private String type;
    private String seat;
    private Double price;

    public Ticket(String code, String movie, String issueDate, String type, String seat, Double price) {
        this.code = code;
        this.movie = movie;
        this.issueDate = issueDate;
        this.type = type;
        this.seat = seat;
        this.price = price;
    }

    // Add getters and setters as needed
}

class Party {
    private String partyCode;
    private String partyDate;
    private String partyDetails;
    private Double partyPrice;

    public Party(String partyCode, String partyDate, String partyDetails, Double partyPrice) {
        this.partyCode = partyCode;
        this.partyDate = partyDate;
        this.partyDetails = partyDetails;
        this.partyPrice = partyPrice;
    }

    // Add getters and setters as needed
}