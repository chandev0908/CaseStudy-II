package cs.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import cs.components.ImageManager;

public class Menu_Model {
	
	private String img, name;	
	private MenuType type;
	
	public static enum MenuType {
		BLANK, ITEM, TITLE;
	}
	
	public Menu_Model(String img, String name, MenuType type) {
		this.img = img;
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return img;
	}
	
	public void setImage(String img) {
		this.img = img;
	}
	
	public MenuType getType() {
		return type;
	}
	public void setType(MenuType type) {
		this.type = type;
	}
	
	public Icon toImg() {
		ImageManager IM = new ImageManager();
		return IM.rescaleImage(18, 18, img);
	
	}
}
