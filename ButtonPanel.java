package application;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private JButton button = new JButton("Open");
	private final JFileChooser fc = new JFileChooser();
	private ImageComponent imgComp;

	public ButtonPanel(ImageComponent imgComp, CheckBoxPanel cbPanel) {
		
		this.imgComp = imgComp;
		this.add(this.button);
		this.button.addActionListener((ev) -> updateFileObject(fc, cbPanel));

	}

	public String getPath(JFileChooser fc) {
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String fullPath = fc.getSelectedFile().getAbsolutePath();
			return fullPath;
		}

		else {
			return "No selection";
		}
	}

	public File updateFileObject(JFileChooser fc, CheckBoxPanel cbPanel) {
		File file = new File(this.getPath(fc));
		this.imgComp.updateImage(file);
		this.imgComp.setImageName(fc.getSelectedFile().getName());
		this.imgComp.setImagePath(fc.getSelectedFile().getAbsolutePath());
		cbPanel.getActionHandler().flagCheck();
		return file;
	}
}
