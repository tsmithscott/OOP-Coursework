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
	private ActionHandler actionListener;

	public CheckBoxPanel(ImageComponent imgComp) {

		this.actionListener = new ActionHandler(imgComp);

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
	
	public ActionHandler getActionHandler() {
		return this.actionListener;
	}

	class ActionHandler implements ActionListener {

		private ImageComponent imgComp;

		private Graphics g;
		
		private boolean chBox1Flag;
		private boolean chBox2Flag;
		private boolean chBox3Flag;
		private boolean chBox4Flag;
		private boolean chBox5Flag;

		public ActionHandler(ImageComponent imgComp) {
			this.imgComp = imgComp;
			this.chBox1Flag = false;
			this.chBox2Flag = false;
			this.chBox3Flag = false;
			this.chBox4Flag = false;
			this.chBox5Flag = false;
		}

		
		public void flagCheck() {
			
			if (this.chBox1Flag == true) {
				String imageName = this.imgComp.getImageName();

				this.g = this.imgComp.image.getGraphics();
				this.g.setFont(g.getFont().deriveFont(15f));
				this.g.drawString("Name: " + imageName, 10, 20);
				this.imgComp.repaint();
			}
			
			if (this.chBox2Flag == true) {
				String imagePath = this.imgComp.getImagePath();

				this.g = this.imgComp.image.getGraphics();
				this.g.setFont(g.getFont().deriveFont(15f));
				this.g.drawString("Path: " + imagePath, 10, 40);
				this.imgComp.repaint();
			}
			
			if (this.chBox3Flag == true) {
				long imageSize = this.imgComp.getImageSize();

				this.g = this.imgComp.image.getGraphics();
				this.g.setFont(g.getFont().deriveFont(15f));
				this.g.drawString("Size: " + imageSize + " Bytes", 10, 60);
				this.imgComp.repaint();
			}
			
			if (this.chBox4Flag == true) {
				try {
					String imageDate = this.imgComp.getImageDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Date: " + imageDate, 10, 80);
					this.imgComp.repaint();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
			
			if (this.chBox5Flag == true) {
				Dimension imageDimensions = this.imgComp.getImageDimensions();

				this.g = this.imgComp.image.getGraphics();
				this.g.setFont(g.getFont().deriveFont(15f));
				this.g.drawString("Dimensions: " + imageDimensions.width + " x " + imageDimensions.height, 10, 100);
				this.imgComp.repaint();
			}
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
					this.chBox1Flag = true;
				}

				else {
					this.chBox1Flag = false;
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
					flagCheck();

				}

				this.imgComp.repaint();

			} else if (checkbox == chBox2) {
				if (checkbox.isSelected()) {
					String imagePath = this.imgComp.getImagePath();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Path: " + imagePath, 10, 40);
					this.chBox2Flag = true;
				}

				else {
					this.chBox2Flag = false;
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
					flagCheck();
				}

				this.imgComp.repaint();
				
			} else if (checkbox == chBox3) {
				if (checkbox.isSelected()) {
					long imageSize = this.imgComp.getImageSize();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Size: " + imageSize + " Bytes", 10, 60);
					this.chBox3Flag = true;
				}

				else {
					this.chBox3Flag = false;
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
					flagCheck();
				}

				this.imgComp.repaint();
				
			} else if (checkbox == chBox4) {
				if (checkbox.isSelected()) {
					try {
						String imageDate = this.imgComp.getImageDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));

						this.g = this.imgComp.image.getGraphics();
						this.g.setFont(g.getFont().deriveFont(15f));
						this.g.drawString("Date: " + imageDate, 10, 80);
						this.chBox4Flag = true;
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}

				else {
					this.chBox4Flag = false;
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
					flagCheck();
				}

				this.imgComp.repaint();
				
			} if (checkbox == chBox5) {
				if (checkbox.isSelected()) {
					Dimension imageDimensions = this.imgComp.getImageDimensions();

					this.g = this.imgComp.image.getGraphics();
					this.g.setFont(g.getFont().deriveFont(15f));
					this.g.drawString("Dimensions: " + imageDimensions.width + " x " + imageDimensions.height, 10, 100);
					this.chBox5Flag = true;
				}

				else {
					this.chBox5Flag = false;
					this.imgComp.updateImage(new File(this.imgComp.getImagePath()));
					flagCheck();
				}

				this.imgComp.repaint();
			}
			
		}

	}

}
