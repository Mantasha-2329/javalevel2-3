import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class CalculatorApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Create buttons for numbers and operations
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btnPlus = new Button("+");
        // Add event handlers for button clicks
        btn1.setOnAction(e -> System.out.println("Button 1 clicked"));
        btn2.setOnAction(e -> System.out.println("Button 2 clicked"));
        btnPlus.setOnAction(e -> System.out.println("Plus button clicked"));

        // Add buttons to the grid
        gridPane.add(btn1, 0, 0);
        gridPane.add(btn2, 1, 0);
        gridPane.add(btnPlus, 2, 0);

        // Set up the scene and show the stage
        Scene scene = new Scene(gridPane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator App");
        primaryStage.show();
    }
}

