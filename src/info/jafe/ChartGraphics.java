package info.jafe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ChartGraphics {
	BufferedImage image;
	int heightArray[]=new int[5];

	public void creatImage(String fileLocation) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileLocation);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			encoder.encode(image);
			File file=new File(fileLocation);
			System.out.println("an image has been saved at "+file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImageFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void graphicsGeneration(int h1, int h2, int h3, int h4, int h5,File file){
		final int X=10;
		int imageWidth = 300;
		int imageHeight = 300;
		int columnWidth = 30;
		int columnHeight = 200;
		ChartGraphics chartGraphics=new ChartGraphics();
		chartGraphics.image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = chartGraphics.image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, imageWidth, imageHeight);
		g.setColor(Color.BLACK);
		g.drawRect(X+1*columnWidth, columnHeight-h1, columnWidth, h1);
		g.drawRect(X+2*columnWidth, columnHeight-h2, columnWidth, h2);
		g.drawRect(X+3*columnWidth, columnHeight-h3, columnWidth, h3);
		g.drawRect(X+4*columnWidth, columnHeight-h4, columnWidth, h4);
		g.drawRect(X+5*columnWidth, columnHeight-h5, columnWidth, h5);
		chartGraphics.creatImage(file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
	}
	
	public int[] getHeightArray(){
		for(int i=0;i<heightArray.length;i++){
			heightArray[i]=(int)(Math.random()*50);
		}
		return heightArray;
	}
	public static void main(String[] args) {
		new ChartGraphics();
//		for(int i:cg.getHeightArray()){
//			System.out.println(i);
//		}
	}
}
