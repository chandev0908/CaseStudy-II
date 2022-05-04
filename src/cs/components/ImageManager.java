package cs.components;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageManager {
	
	
	public ImageIcon rescaleImage(int objWidth, int objHeight,String FileName) {
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("cs/images/" + FileName + ".png"));
		Image bgx = bgIcon.getImage().getScaledInstance(objWidth, objHeight,Image.SCALE_SMOOTH);
		bgIcon = new ImageIcon(bgx);
		return bgIcon;
	}
	


}
