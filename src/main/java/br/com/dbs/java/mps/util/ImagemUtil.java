package br.com.dbs.java.mps.util;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImagemUtil {
    
    private static final int TAM_120_PX = 120;
    
    public static ImageIcon converteArquivoEmIcone(File arquivo) throws IOException {
        BufferedImage imagem = ImageIO.read(arquivo);
        ImageIcon icon = new ImageIcon(imagem);
        icon.setImage(defineTamanhoDoIcone(icon));
        return icon;
    }
    
    public static ImageIcon converteByteEmIcone(byte[] bytes) {
        if (bytes == null)
            return null;
        
         BufferedImage bufferedImage=null;
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new ImageIcon(bufferedImage);
    }

    public static byte[] converteIconeEmByte(Icon foto) {
        ImageIcon icone = (ImageIcon) foto;
        Image image = icone.getImage();
        
        BufferedImage bi = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);  
        
        Graphics bg = bi.getGraphics();  
        bg.drawImage(image, 0, 0, null);  
        bg.dispose();  

        ByteArrayOutputStream buff = new ByteArrayOutputStream();         
        try {    
            ImageIO.write(bi, "JPG", buff);    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return buff.toByteArray();
    }
   
     private static Image defineTamanhoDoIcone(ImageIcon icon) {
        final Image imagemDoIcone = icon.getImage();
        return imagemDoIcone.getScaledInstance(TAM_120_PX, TAM_120_PX, 100);
    }
     
}