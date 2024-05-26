import javax.swing.*;
import java.io.*;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.imageio.ImageIO;
/**
 * Escreva uma descrição da classe App aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class App
{
    public class Pixel{
        public int[] p = new int[3];
    }
    
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public static void main(String[] args) throws IOException  {  
        File f = new File("flor.jpg");  
        BufferedImage imagem = ImageIO.read(f);  
        Raster raster = imagem.getRaster();  
        int[] pixel = new int[3];  int brancos = 0;
        int w = imagem.getWidth();
        int h = imagem.getHeight();
        Pixel[][] image = new Pixel[w][h];
        for(int h=0;h<imagem.getHeight();h++) { 
            for(int w=0;w<imagem.getWidth();w++) {
                raster.getPixel(w,h,pixel);
                image[w][h].p[] = (Pixel) pixel; 
                if ((pixel[0] == 255) && (pixel[1] == 255) &&
                (pixel[2] == 255)) brancos++;
            }  
        }
        
        System.out.println(brancos+" pixels brancos");  
    }
}
