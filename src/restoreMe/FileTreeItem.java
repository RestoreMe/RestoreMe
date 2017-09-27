package restoreMe;

import java.nio.file.Path;

import com.jfoenix.controls.JFXCheckBox;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class FileTreeItem extends JFXCheckBox {
	
	private Path path;
	private MaterialDesignIconView icon = new MaterialDesignIconView();
	private boolean isDirectory;
	
	
	public FileTreeItem(Path path) {
		setPath(path);
		icon.setGlyphSize(20);
		setGraphic(icon);
	}
	
	private void setIcon() {
		if(isDirectory)
			icon.setGlyphName("FOLDER");
		else
			icon.setGlyphName("FILE");
	}
	
	public Path getPath() {
		return path;
	}
	
	public void setPath(Path path) {
		this.path = path;
		isDirectory = this.path.toFile().isDirectory();
		setIcon();
		setText(path.getFileName().toString());
	}
	
	public boolean isDirectory() {
		return isDirectory;
	}
}
