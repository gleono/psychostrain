package psychotileeditor;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Imagenes {
    
   static public BufferedImage cargaImagen(String nombreImagen){
   // Recupera la imagen del archivo llamado nombreImagen
   try{
        BufferedImage leer=ImageIO.read(new File(nombreImagen));
        return leer;
      } catch(Exception e) {
          System.out.print("Error al cargar "+nombreImagen+":"+e.toString());
          return null;
      }        
    }
   
   static public int indiceImagen(int x,int y,BufferedImage origen,int renglones,int columnas)
   {
       // Determina el índice lineal de la imagen que corresponde a las coordenadas x y
       int tileWidth=origen.getWidth()/columnas;
       int tileHeight=origen.getHeight()/renglones;
       int renglonImagen=y/tileHeight;
       int columnaImagen=x/tileWidth;
       return renglonImagen*columnas+columnaImagen;
   }           
   
   static public BufferedImage imagenTile(BufferedImage origen,int renglones,int columnas,Tile tile)
   {
       // Recupera el fragmento de la imagen origen que le corresponde al tile, considerando tiles animados
       int tileWidth=origen.getWidth()/columnas;
       int tileHeight=origen.getHeight()/renglones;
       int renglonImagen=tile.getImagenActual()/renglones;
       int columnaImagen=tile.getImagenActual()%renglones;
       int x=tileWidth*columnaImagen;
       int y=tileHeight*renglonImagen;
       return origen.getSubimage(x, y, tileWidth, tileHeight);
   }
      
   
}
