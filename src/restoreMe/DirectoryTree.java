package restoreMe;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTreeView;

import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class DirectoryTree {

	private ArrayList<Path> roots;
	private ArrayList<Path> openPaths;
	private JFXTreeView<FileTreeItem> tree;
	private TreeItem<FileTreeItem> treeRoot = new TreeItem<FileTreeItem>();
	
	private ChangeListener<Boolean> treeItem;
	
	public DirectoryTree(ArrayList<Path> roots, ArrayList<Path> openPaths, JFXTreeView<FileTreeItem> tree) {
		this.roots = roots;
		this.openPaths = openPaths;
		this.tree = tree;
		
		this.tree.setRoot(treeRoot);
		tree.setShowRoot(false);
		
		treeItem = (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		    listenTreeItemOpened(observable, oldValue, newValue);
		};
		
		for(Path root:roots) {
			addTreeItem(root, treeRoot);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void listenTreeItemOpened(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue)
			return;
		TreeItem<FileTreeItem> item = ((TreeItem<FileTreeItem>) ((BooleanProperty) observable).getBean());
		File itemFile = item.getValue().getPath().toFile();
		if(itemFile.exists())
			if(itemFile.listFiles().length > 0) {
				item.getChildren().clear();
				for(File subFile:itemFile.listFiles())
					addTreeItem(subFile.toPath(), item);
			}
			else
				return;
		else
			item.getParent().getChildren().remove(item);
	}

	private void addTreeItem(Path base, TreeItem<FileTreeItem> parent) {
		if(base.toFile().exists()) {
			if(base.toFile().isDirectory()) {
				TreeItem<FileTreeItem> baseTreeItem = new TreeItem<FileTreeItem>(new FileTreeItem(base, true));
				if(base.toFile().listFiles().length > 0) {
					baseTreeItem.expandedProperty().addListener(treeItem);
					baseTreeItem.getChildren().clear();
					baseTreeItem.getChildren().add(new TreeItem<FileTreeItem>(new FileTreeItem()));
				}
				parent.getChildren().add(baseTreeItem);
			}
			
			else {
				
			}
			}
	}

}