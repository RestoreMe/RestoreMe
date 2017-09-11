package restoreMe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class GUIController implements Initializable{
	
	@FXML
    private JFXButton profileTab;

    @FXML
    private JFXButton backupTab;

    @FXML
    private JFXButton restoreTab;

    @FXML
    private JFXButton filesDestinationsTab;

    @FXML
    private JFXButton historyTab;

    @FXML
    private JFXButton settingsTab;

    @FXML
    void windowSwitch(ActionEvent event) {
    	JFXButton btn = (JFXButton) event.getSource();
    	BorderPane root = (BorderPane) btn.getScene().getRoot();
	    switch(btn.getId()) {
	    	case "profileTab": root.setCenter(profilePane); break;
	    	case "backupTab": root.setCenter(backupPane); break;
	    	case "restoreTab": root.setCenter(restorePane); break;
	    	case "filesDestinationsTab": root.setCenter(filesDestinationsPane); break;
	    	case "historyTab": root.setCenter(historyPane); break;
	    	case "settingsTab": root.setCenter(settingsPane); break;
	    	default: root.setCenter(backupPane); break;
    	}
    	
    }
    
    private final String fxmlFolder = "/restoreMe/fxml/";
    private final AnchorPane profilePane;
    private final AnchorPane backupPane;
    private final AnchorPane restorePane;
    private final AnchorPane filesDestinationsPane;
    private final AnchorPane historyPane;
    private final AnchorPane settingsPane;
    
	public GUIController () throws IOException{
		profilePane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Profile.fxml"))).getCenter();
		backupPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Backup.fxml"))).getCenter();
		restorePane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Restore.fxml"))).getCenter();
		filesDestinationsPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "FilesDestinations.fxml"))).getCenter();
		historyPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "History.fxml"))).getCenter();
		settingsPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Settings.fxml"))).getCenter();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
