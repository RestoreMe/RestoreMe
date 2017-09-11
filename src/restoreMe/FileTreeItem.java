package restoreMe;

import java.nio.file.Path;

import com.jfoenix.controls.JFXCheckBox;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FileTreeItem extends HBox {
	
	private Path path;
	private Label label = new Label();
	private JFXCheckBox checkbox = new JFXCheckBox();
	
	public FileTreeItem(Path path) {
		super(5);
		this.path = path;
		label.setText(this.path.toString());
		this.getChildren().addAll(checkbox, label);
		this.setAlignment(Pos.CENTER_LEFT);
	}
	
	public String toString() {
		return label.getText();
	}
}
