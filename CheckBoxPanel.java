package application;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CheckBoxPanel extends JPanel {

	private JCheckBox chBox1;
	private JCheckBox chBox2;
	private JCheckBox chBox3;
	private JCheckBox chBox4;
	private JCheckBox chBox5;


	public CheckBoxPanel(ImageComponent imgComp) {

		ActionListener actionListener = new ActionHandler(imgComp);

		this.chBox1 = new JCheckBox("Name");
		chBox1.addActionListener(actionListener);

		this.chBox2 = new JCheckBox("Path");
		chBox2.addActionListener(actionListener);

		this.chBox3 = new JCheckBox("Size");
		chBox3.addActionListener(actionListener);

		this.chBox4 = new JCheckBox("Date");
		chBox4.addActionListener(actionListener);

		this.chBox5 = new JCheckBox("Dimensions");
		chBox5.addActionListener(actionListener);

		this.add(chBox1);
		this.add(chBox2);
		this.add(chBox3);
		this.add(chBox4);
		this.add(chBox5);
	}

	class ActionHandler implements ActionListener {

		private ImageComponent imgComp;

		private Graphics g;

		public ActionHandler(ImageComponent imgComp) {
			this.imgComp = imgComp;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			JCheckBox checkbox = (JCheckBox) e.getSource();
			if (checkbox == chBox1) {
				if (checkbox.isSelected()) {
					String imageName = this.imgComp.getImageName();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Name: " + imageName, 10, 20);
				}

				else {
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));

				}

				this.imgComp.repaint();

			} else if (checkbox == chBox2) {
				if (checkbox.isSelected()) {
					String imagePath = this.imgComp.getImagePath();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Path: " + imagePath, 10, 40);
				}

				else {
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
				}

				this.imgComp.repaint();
			} else if (checkbox == chBox3) {
				if (checkbox.isSelected()) {
					long imageSize = this.imgComp.getImageSize();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Size: " + imageSize + " Bytes", 10, 60);
				}

				else {
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
				}

				this.imgComp.repaint();
			} else if (checkbox == chBox4) {
				if (checkbox.isSelected()) {
					try {
						String imageDate = this.imgComp.getImageDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));

						this.g = this.imgComp.image.getGraphics();
						this.g.setFont(g.getFont().deriveFont(15f));
						this.g.drawString("Date: " + imageDate, 10, 80);
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}

				else {
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
				}

				this.imgComp.repaint();
			} else if (checkbox == chBox5) {
				if (checkbox.isSelected()) {
					Dimension imageDimensions = this.imgComp.getImageDimensions();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Dimensions: " + imageDimensions.width + " x " + imageDimensions.height, 10, 100);
				}

				else {
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
				}

				this.imgComp.repaint();
			}
		}

	}

}
