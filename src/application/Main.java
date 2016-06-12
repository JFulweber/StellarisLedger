package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

			Parent root = FXMLLoader.load(getClass().getResource("PrimaryStage.fxml"));
			primaryStage.setScene(new Scene(root, 1080, 720));
			primaryStage.setTitle("Stellaris Planet Ledger - /u/intoxicated_penguin");
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
