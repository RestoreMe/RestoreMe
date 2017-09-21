package restoreMe;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTreeView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FilesDestinationsController implements Initializable {

	@FXML
	JFXTreeView<JFXCheckBox> backupFilesTreeView;
	
	public FilesDestinationsController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}
