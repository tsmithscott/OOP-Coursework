package application;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ImageInfo extends JFrame {
	
	private ImagePanel imgPanel = new ImagePanel();
	private ImageComponent imgComp = imgPanel.getImageComponent();
	private ButtonPanel bPanel = new ButtonPanel(imgComp);
	private CheckBoxPanel cbPanel = new CheckBoxPanel(imgComp);

	public ImageInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Image Information");

		this.setMinimumSize(new Dimension(400, 100));
		this.setLayout(new BorderLayout());

		this.add(cbPanel, BorderLayout.NORTH);
		this.add(bPanel, BorderLayout.SOUTH);
		this.add(imgPanel, BorderLayout.CENTER);

		this.pack();
		this.setVisible(true);
	}


	public static void launch() {
		new ImageInfo();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> launch());
	}


}
