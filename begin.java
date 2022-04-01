
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.layout.*;
    import javafx.stage.Stage;
    import java.time.LocalDateTime;

/*
Unfinished: 
CancelBooking
menus and how to order
staff list
*/
public class Begin extends Application {
        public static void main(String[] args) {
            Application.launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {
            stage.setTitle("Demo2");

            Label label = new Label("Welcome to the restaurant system");
            Button button0 = new Button("Customer");
            Button button1 = new Button("Staff");
            label.setLayoutX(150);
            label.setLayoutY(100);
            button0.setLayoutX(100);
            button0.setLayoutY(200);
            button1.setLayoutX(300);
            button1.setLayoutY(200);
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.getChildren().addAll(label,button0,button1);

            button0.setOnAction(event -> {
                customerid open  = new customerid();
                open.start(new Stage());
                stage.hide();

            });
            button1.setOnAction(event -> {
                Stage stage1=new Stage();
                stage1.setHeight(200);
                stage1.setWidth(200);
                stage1.show();
            });

            Scene scene = new Scene(anchorPane,500,300);
            stage.setScene(scene);
            stage.show();
        }



        public class customerid extends Application {
            @Override
            public void start(Stage primaryStage) {
                Label customerID=new Label("customer ID");
                TextField tf=new TextField();
                Button b = new Button("Submit");
                b.setOnAction(event -> {
                    System.out.println("You entered: customerID: "+tf.getText());
                    customer open  = new customer();
                    open.start(new Stage());
                    primaryStage.hide();

                });
                GridPane root = new GridPane();
                root.addRow(0, customerID, tf);
                root.addRow(2, b);
                Scene scene=new Scene(root,500,200);
                primaryStage.setScene(scene);

                primaryStage.show();
            }
        }

        public class customer extends Application {
            @Override
            public void start(Stage primaryStage) {
                Button button0 = new Button("new order");
                Button button1 = new Button("order history");

                button0.setLayoutX(100);
                button0.setLayoutY(200);
                button1.setLayoutX(300);
                button1.setLayoutY(200);

                AnchorPane anchorPane = new AnchorPane();
                anchorPane.getChildren().addAll(button0,button1);
                button0.setOnAction(event -> {
                    newOrder open  = new newOrder();
                    open.start(new Stage());
                    primaryStage.hide();
                });
                button1.setOnAction(event -> {
                    orderHistory open  = new orderHistory();
                    open.start(new Stage());
                    primaryStage.hide();
                });

                Scene scene=new Scene(anchorPane,500,500);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        }

        public class newOrder extends Application {
            @Override
            public void start(Stage primaryStage) {
                Button button0 = new Button("new booking");
                Button button1 = new Button("cancel booking");
                Button button2 = new Button("new devlivry order");
                Button button3 = new Button("new takeaway order");

                button0.setLayoutX(50);
                button0.setLayoutY(200);
                button1.setLayoutX(300);
                button1.setLayoutY(200);
                button2.setLayoutX(550);
                button2.setLayoutY(200);
                button3.setLayoutX(800);
                button3.setLayoutY(200);

                AnchorPane anchorPane = new AnchorPane();
                anchorPane.getChildren().addAll(button0,button1,button2,button3);
                button0.setOnAction(event -> {
                    newBooking open  = new newBooking();
                    open.start(new Stage());
                    primaryStage.hide();
                });
                button1.setOnAction(event -> {
                    //cancelBooking open  = new cancelBooking();
                    //open.start(new Stage());
                    //primaryStage.hide();
                });
                button2.setOnAction(event -> {
                    newDevlivry open  = new newDevlivry();
                    open.start(new Stage());
                    primaryStage.hide();
                });
                button3.setOnAction(event -> {
                    newTakeaway open  = new newTakeaway();
                    open.start(new Stage());
                    primaryStage.hide();
                });


                Scene scene=new Scene(anchorPane,1000,500);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        }
        public class orderHistory extends Application{
            @Override
            public void start(Stage primaryStage) {

                TableView tableView = new TableView();

                TableColumn<MenuItem, String> column1 = new TableColumn<>("MenuItem");
                column1.setCellValueFactory(new PropertyValueFactory<>("MenuItem"));

                TableColumn<LocalDateTime, String> column2 = new TableColumn<>("LocalDateTime");
                column2.setCellValueFactory(new PropertyValueFactory<>("LocalDateTime"));

                tableView.getColumns().add(column1);
                tableView.getColumns().add(column2);

                /*tableView.getItems().add();
                tableView.getItems().add();*/

                VBox vbox = new VBox(tableView);

                Scene scene = new Scene(vbox, 1000, 500);

                primaryStage.setScene(scene);

                primaryStage.show();
        }
    }

    public class newBooking extends Application {
        @Override
        public void start(Stage primaryStage) {
            Label customerID=new Label("customer ID");
            TextField tf1=new TextField();
            Label date=new Label("Date");
            TextField tf2=new TextField();
            Label time=new Label("Time");
            TextField tf3=new TextField();
            Label number=new Label("number of guests");
            TextField tf4=new TextField();

            Button b = new Button("Submit");
            b.setOnAction(event -> {
                System.out.println("You entered: customerID: "+tf1.getText());
                customer open  = new customer();
                open.start(new Stage());
                primaryStage.hide();

            });
            GridPane root = new GridPane();
            root.addRow(0, customerID, tf1);
            root.addRow(1,date, tf2);
            root.addRow(2,time, tf3);
            root.addRow(3,number, tf4);
            root.addRow(4, b);
            Scene scene=new Scene(root,500,200);
            primaryStage.setScene(scene);

            primaryStage.show();
        }
    }
    public class newDevlivry extends Application {
        @Override
        public void start(Stage primaryStage) {
            Label customerID=new Label("customer ID");
            TextField tf1=new TextField();
            Label date=new Label("Date");
            TextField tf2=new TextField();
            Label time=new Label("Time");
            TextField tf3=new TextField();
            Label address=new Label("address");
            TextField tf4=new TextField();

            Button b = new Button("Submit");
            b.setOnAction(event -> {
                System.out.println("You entered: customerID: "+tf1.getText());
                customer open  = new customer();
                open.start(new Stage());
                primaryStage.hide();

            });
            GridPane root = new GridPane();
            root.addRow(0, customerID, tf1);
            root.addRow(1, date, tf2);
            root.addRow(2, time, tf3);
            root.addRow(3, address, tf4);
            root.addRow(4, b);
            Scene scene=new Scene(root,500,200);
            primaryStage.setScene(scene);

            primaryStage.show();
        }
    }

    public class newTakeaway extends Application {
        @Override
        public void start(Stage primaryStage) {
            Label customerID=new Label("customer ID");
            TextField tf1=new TextField();
            Label date=new Label("Date");
            TextField tf2=new TextField();
            Label time=new Label("Time");
            TextField tf3=new TextField();

            Button b = new Button("Submit");
            b.setOnAction(event -> {
                System.out.println("You entered: customerID: "+tf1.getText());
                customer open  = new customer();
                open.start(new Stage());
                primaryStage.hide();

            });
            GridPane root = new GridPane();
            root.addRow(0, customerID, tf1);
            root.addRow(1, date, tf2);
            root.addRow(2, time, tf3);
            root.addRow(4, b);
            Scene scene=new Scene(root,500,200);
            primaryStage.setScene(scene);

            primaryStage.show();
        }
    }
}
