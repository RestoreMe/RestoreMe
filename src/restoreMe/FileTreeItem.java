package restoreMe;

import java.nio.file.Path;

import com.jfoenix.controls.JFXCheckBox;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class FileTreeItem extends HBox {
	
	private Path path;
	private Label label = new Label();
	private JFXCheckBox checkbox = new JFXCheckBox();
	private ImageView image;
	
	private final static double hBoxSpace = 5;
	private final static double imageWidth = 30;
	private final static double imageTextGap = 5;
	
	//Constructor for creating this class with only path argument
	public FileTreeItem(Path path) {
		super(hBoxSpace);
		this.path = path;
		
		label.setText(this.path.toString());
		
		this.getChildren().addAll(checkbox, label);
		this.setAlignment(Pos.CENTER_LEFT);
	}
	
	//Constructor for creating this class path and imagePath arguments
	public FileTreeItem(Path path, String imagePath) {
		super(hBoxSpace);
		this.path = path;
		
		label.setText(this.path.toString());
		
		setImage(imagePath);
		
		this.getChildren().addAll(checkbox, label);
		this.setAlignment(Pos.CENTER_LEFT);
	}
	
	//Sets the image
	public void setImage(String imagePath) {
		image = new ImageView(imagePath);
		image.setPreserveRatio(true);
		image.setFitWidth(imageWidth);
		
		label.setGraphic(image);
		label.setGraphicTextGap(imageTextGap);
	}
	
	//returns the checkbox
	public JFXCheckBox getCheckbox() {
		return checkbox;
	}
	
	//returns the text on the label
	public String toString() {
		return label.getText();
	}
}
