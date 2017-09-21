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
	private JFXTreeView<JFXCheckBox> tree;
	
	public DirectoryTree(ArrayList<Path> roots, JFXTreeView<JFXCheckBox> tree) {
		this.roots = roots;
		this.tree = tree;
		
		tree.setShowRoot(false);
		
		/*checkBox.setIndeterminate(true);
		
		Path q = Paths.get("C\\a");
		ImageView z = new ImageView("/application/Logo.png");
		z.setPreserveRatio(true);
		z.setFitWidth(30);
		TreeItem<Path> root = new TreeItem<Path>(q);
		System.out.println(root);
		
		TreeItem<Path> a = new TreeItem<Path>(q);
		TreeItem<Path> b = new TreeItem<Path>();
		a.setGraphic(z);
		root.getChildren().add(a);
		root.getChildren().add(b);
		treeView.setRoot(root);*/
	}
	
	public void addTreeItem() {
		
	}

}