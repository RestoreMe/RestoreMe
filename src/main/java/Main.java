import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("fxml/Sidebar.fxml"));
			BorderPane defaultScreen = FXMLLoader.load(getClass().getResource("fxml/Backup.fxml"));
			root.setCenter(defaultScreen);
			Scene scene = new Scene(root,1200,750);
			scene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("RestoreMe!");
			primaryStage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("img/Logo.png")));
			primaryStage.setMinWidth(900);
			primaryStage.setMinHeight(475);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
