package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageComponent extends JComponent {
	
	public BufferedImage image;
	private String image_name;
	private String image_path;
	private FileTime image_date;
	private Dimension image_dimensions;
	private BasicFileAttributes metadata;
	
	public ImageComponent() {
        setMinimumSize(new Dimension(400, 110));
	}
	
	public void updateImage(File img) {
		try {
            this.image = ImageIO.read(img);
            this.image_dimensions = new Dimension(this.image.getWidth(), this.image.getHeight());
            Frame masterWindow = Arrays.stream(JFrame.getFrames()).findFirst().get();
            setMinimumSize(image_dimensions);
            setPreferredSize(image_dimensions);
            setMaximumSize(image_dimensions);
            masterWindow.setResizable(true);
            masterWindow.setSize(new Dimension(this.image.getWidth(), this.image.getHeight() + 110));
            masterWindow.setResizable(false);
            repaint();
        } catch (IOException x) {
            x.printStackTrace();
        }
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g = g.create();

        int margin = 0;
        int w = getWidth();
        int h = getHeight();

        g.drawImage(this.image, margin, margin, w, h, this);
    }

	public void setImageName(String name) { this.image_name = name; }
	
	public void setImagePath(String path) { this.image_path = path; }

	public BufferedImage getBufferedImage() { return this.image; }

    public String getImageName() { return this.image_name; }

    public String getImagePath() { return this.image_path; }
    
    public Dimension getImageDimensions() {
	    return this.image_dimensions;
    }

    public long getImageSize() { 
    	Path file = Paths.get(this.getImagePath());
    	return file.toFile().length(); 
    }
    
    public FileTime getImageDate() throws IOException {
        Path file = Paths.get(this.getImagePath());
        this.metadata = Files.readAttributes(file, BasicFileAttributes.class);
        this.image_date = this.metadata.creationTime();
        return this.image_date;
    }

}
