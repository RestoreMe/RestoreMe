package restoreMe;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTreeView;

import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;

public class DirectoryTree {

	private ArrayList<Path> roots;
	private ArrayList<Path> openPaths;
	private JFXTreeView<FileTreeItem> tree;
	private TreeItem<FileTreeItem> treeRoot = new TreeItem<FileTreeItem>();
	
	public DirectoryTree(ArrayList<Path> roots, ArrayList<Path> openPaths, JFXTreeView<FileTreeItem> tree) {
		this.roots = roots;
		this.openPaths = openPaths;
		this.tree = tree;
		
		this.tree.setRoot(treeRoot);
		tree.setShowRoot(false);
		
		for(Path root:roots) {
			treeRoot.getChildren().add(new TreeItem<FileTreeItem>(new FileTreeItem(root)));
		}
	}
	
	public void addTreeItem() {
		
	}

}