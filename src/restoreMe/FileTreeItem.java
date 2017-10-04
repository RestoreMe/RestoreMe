package restoreMe;

import java.nio.file.Path;

import com.jfoenix.controls.JFXCheckBox;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;

public class FileTreeItem extends JFXCheckBox {
	
	private Path path;
	private MaterialDesignIconView icon = new MaterialDesignIconView();
	private boolean isDirectory;
	
	public FileTreeItem() {
		super ("");
	}
	
	public FileTreeItem(Path path, boolean isDirectory) {
		this.path = path;
		this.isDirectory = isDirectory;
		setPath();
		setIcon();
		icon.setStyleClass("file-or-folder");
		setGraphic(icon);
	}
	
	private void setPath() {
		if(path.getFileName() != null)
			setText(path.getFileName().toString());
		else
			setText(path.toString());
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
	
	public boolean isDirectory() {
		return isDirectory;
	}
}
