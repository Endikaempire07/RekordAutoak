package Ventanas;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;



public class Imprimirpdf {
	public static void printToPDF(java.awt.Image awtImage, String fileName)
	{
		try
		{
			File dir = new File("C:\\Rekordautoak\\Facturas");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			Document d = new Document();
			PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(fileName));
			d.open();
			
			Image iTextImage = Image.getInstance(writer, awtImage, 1);
	         iTextImage.scalePercent(75);
	         d.add(iTextImage);
			
			d.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static java.awt.Image getImageFromPanel(Component component)
	{
        BufferedImage image = new BufferedImage(component.getWidth(),
                component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }
}
