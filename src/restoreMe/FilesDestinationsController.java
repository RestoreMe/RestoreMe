package restoreMe;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTreeView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FilesDestinationsController implements Initializable {

	@FXML
	JFXTreeView<FileTreeItem> backupFilesTreeView;
	
	private ArrayList<Path> roots = new ArrayList<Path>();
	private ArrayList<Path> openPaths = new ArrayList<Path>();
	
	public FilesDestinationsController() {
		Path osRoot = Paths.get(System.getProperty("user.home")).getRoot();
		roots.add(osRoot);
		openPaths.add(osRoot);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//DirectoryTree backupFiles = new DirectoryTree(roots, openPaths, backupFilesTreeView);
	}

}
