package app.Scene;

import app.MoviesPackage.Tickets;
import app.Users.User;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import app.components.UserFormUI;
import app.components.UserTextFieldUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UserSceneCreator extends SceneCreator {
    Parent mainLayout;
    
    public UserSceneCreator(double width, double height) {
        super(width, height);
        
        //rootGridPane = new FlowPane();
        
        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Create TableView for Tickets
        TableView<Ticket> ticketTableView = createTicketTable();
        mainLayout.setLeft(ticketTableView);

        Button cancelButton = new Button("Cancel");
        Button modifyButton = new Button("Modify");
        Button newButton = new Button("New");

        cancelButton.setOnAction(event -> System.out.println("Cancel button clicked"));
        modifyButton.setOnAction(event -> System.out.println("Modify button clicked"));
        newButton.setOnAction(event -> System.out.println("New button clicked"));

        // Create input area for new ticket
        HBox newTicketInputBox = createNewTicketInputBox();
        mainLayout.setBottom(newTicketInputBox);
        
    }
    
    @Override
    public Scene createScene() {
        
        return new Scene(mainLayout, width, height);
        //return new Scene(UserText.UserTextFieldUI(), width, height);
        
                
    }
    
    private HBox createNewTicketInputBox() {
        HBox newTicketInputBox = new HBox(10);
        newTicketInputBox.setPadding(new Insets(10));

        TextField movieField = new TextField();
        TextField typeField = new TextField();
        TextField seatField = new TextField();
        TextField priceField = new TextField();

        Button addTicketButton = new Button("Add Ticket");

        // Add event handler for adding a new ticket
        addTicketButton.setOnAction(event -> {
            // Retrieve user input from text fields
            String movie = movieField.getText();
            String type = typeField.getText();
            String seat = seatField.getText();
            double price = Double.parseDouble(priceField.getText()); // Assuming price is a double

            // Create a new Ticket object and add it to the table
            Ticket newTicket = new Ticket("NEW_CODE", movie, "NEW_DATE", type, seat, price);
            createTicketTable().getItems().add(newTicket);
            //ticketTableView.getItems().add(newTicket);

            // Clear the text fields
            
            movieField.clear();
            typeField.clear();
            seatField.clear();
            priceField.clear();
        });

        newTicketInputBox.getChildren().addAll(
                new Label("Movie: "), movieField,
                new Label("Type: "), typeField,
                new Label("Seat: "), seatField,
                new Label("Price: "), priceField,
                addTicketButton
        );

        return newTicketInputBox;
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

        return ticketTableView;
    }
    
      
            
    
//    public void tableSync() {
//        List <Undergraduate> items = undergraduateTableView.getItems();
//        items.clear();
//        for (Students undergrad : studentsList) {
//            if (undergrad instanceof Undergraduate) {
//                items.add((Undergraduate) undergrad);
//            }
//        }
//    }
    
//    @Override
//    public void handle(MouseEvent event) {
//        if (event.getSource() == nameBtn) {
//            System.out.println("this");
//        }
//    }
    
    
    
}