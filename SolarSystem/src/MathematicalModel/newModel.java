package MathematicalModel;



import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class newModel {
	public static void display(String title, Stage primaryStage) {
		
		primaryStage.setTitle("Solar System");
		GridPane root = new GridPane();
		root.getChildren().add(null);
		root.setBackground(Background);
		
		Scene scene = new Scene(root, 1200, 800);
		
	}
}
