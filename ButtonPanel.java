package application;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private JButton button = new JButton("Open");
	private final JFileChooser fc = new JFileChooser();
	private ImageComponent imgComp;

	public ButtonPanel(ImageComponent imgComp) {
		
		this.imgComp = imgComp;
		this.add(this.button);
		this.button.addActionListener((ev) -> updateFileObject(fc));

	}

	public String getPath(JFileChooser fc) {
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String fullPath = fc.getSelectedFile().getAbsolutePath();
			System.out.println(fullPath);
			return fullPath;
		}

		else {
			String s = "No selection";
			return s;
		}
	}
	
	
	public File updateFileObject(JFileChooser fc) {
		File file = new File(this.getPath(fc));
		this.imgComp.updateImage(file);
		this.imgComp.setImageName(fc.getSelectedFile().getName());
		this.imgComp.setImagePath(fc.getSelectedFile().getAbsolutePath());
		return file;
	}
}
