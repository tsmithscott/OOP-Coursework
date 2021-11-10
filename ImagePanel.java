package application;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private ImageComponent imgComp;
	
	public ImagePanel() {
		this.imgComp = new ImageComponent();
		this.add(imgComp);
	}

	public ImageComponent getImageComponent() {
		return this.imgComp;
	}

}
