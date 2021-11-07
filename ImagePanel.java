package application;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	protected ImageComponent imgComp;

	public ImagePanel(ImageComponent imgComp) {
		this.imgComp = imgComp;
		this.add(imgComp);
	}
	
	public ImagePanel() {
		this.imgComp = new ImageComponent();
		this.add(imgComp);
	}

	public ImageComponent getImageComponent() {
		return this.imgComp;
	}

}
