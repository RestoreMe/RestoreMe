package restoreMe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class SidebarController implements Initializable{
	
	//@FXML
 //   private JFXButton profileTab;
	
	@FXML	
	private JFXTreeView<String> sidebarTreeView;
  //  @FXML
   // private JFXButton backupTab;

   // @FXML
    //private JFXButton restoreTab;

    //private JFXButton filesDestinationsTab;

   // @FXML
   //private JFXButton historyTab;

    //@FXML
   // private JFXButton settingsTab;
   // 
    @FXML
    void windowSwitch(ActionEvent event) {
    	JFXButton btn = (JFXButton) event.getSource();
    	BorderPane root = (BorderPane) btn.getScene().getRoot();
    	//selectButton(btn.getAccessibleText());
	    switch(btn.getAccessibleText()) {
	    	case "Profile": root.setCenter(profilePane); break;
	    	case "Backup": root.setCenter(backupPane); break;
	    	case "Restore": root.setCenter(restorePane); break;
	    	case "Files and Destinations": root.setCenter(filesDestinationsPane); break;
	    	case "History": root.setCenter(historyPane); break;
	    	case "Settings": root.setCenter(settingsPane); break;
	    	default: root.setCenter(backupPane); break;
    	}
    	
    }
    
    private final String fxmlFolder = "/restoreMe/fxml/";
    private final String buttonSelectionId = "selected";
    private final AnchorPane profilePane;
    private final AnchorPane backupPane;
    private final AnchorPane restorePane;
    private final AnchorPane filesDestinationsPane;
    private final AnchorPane historyPane;
    private final AnchorPane settingsPane;
    
	public SidebarController () throws IOException{
		profilePane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Profile.fxml"))).getCenter();
		backupPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Backup.fxml"))).getCenter();
		restorePane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Restore.fxml"))).getCenter();
		filesDestinationsPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "FilesDestinations.fxml"))).getCenter();
		historyPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "History.fxml"))).getCenter();
		settingsPane = (AnchorPane)((BorderPane)FXMLLoader.load(getClass().getResource(fxmlFolder + "Settings.fxml"))).getCenter();
	
		
		
		
		
		

		 TreeItem<String> root = new TreeItem<String>("Sobacon");
		 root.setExpanded(true);
		 root.getChildren().addAll(
				 new TreeItem<String>("Profile"),
				 new TreeItem<String>("Backup"),
				 new TreeItem<String>("Restore"),
				 new TreeItem<String>("Files/Destinations"),
			     new TreeItem<String>("History"),
			     new TreeItem<String>("Settings")
			); 
			sidebarTreeView = new JFXTreeView<String>(root);
			//sidebarTreeView.setShowRoot(false);
			sidebarTreeView.setVisible(true);
	}
/*	public void selectButton(String button) {
		if(!button.equals("Profile"))
			profileTab.setId("");
		else
			profileTab.setId(buttonSelectionId);
		
		if(!button.equals("Backup"))
			backupTab.setId("");
		else
			backupTab.setId(buttonSelectionId);
		
		if(!button.equals("Restore"))
			restoreTab.setId("");
		else
			restoreTab.setId(buttonSelectionId);
		
		if(!button.equals("Files and Destinations"))
			filesDestinationsTab.setId("");
		else
			filesDestinationsTab.setId(buttonSelectionId);
		
		if(!button.equals("History"))
			historyTab.setId("");
		else
			historyTab.setId(buttonSelectionId);
		
		if(!button.equals("Settings"))
			settingsTab.setId("");
		else
			settingsTab.setId(buttonSelectionId);
	}*/
	
	//Returns the Button Id in segments
	public String getBtnId(JFXButton btn, boolean isName) {
		if(btn.getId().indexOf(' ') == -1) {
			System.out.println("Error: Button Id missing space character");
			return "";
		}
		
		if(isName)
			return btn.getId().substring(0, btn.getId().indexOf(' ') + 1);
		return btn.getId().substring(btn.getId().indexOf(' '));
	}
	
	//Sets the Button Id after the name of the button in the buttons Id attribute
	public void setBtnId(JFXButton btn, String id) {
		if (btn.getId().indexOf(' ') == -1) 
			btn.setId(btn.getId() + " ");
		
		btn.setId(btn.getId().substring(0, btn.getId().indexOf(' ') + 1) + id);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//selectButton("Backup");

	}
	
}
