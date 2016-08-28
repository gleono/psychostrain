
//GameObject.java

package PsychoGame;

import PsychoSystem.GameImage;
import java.awt.image.BufferedImage;
import java.util.Observable;

//  PsySoft Team 2008
//       (Manuel Espinoza, Alberto Zorrilla, Guillermo Leon y Arquimides Diaz)

public class GameObject{
    
    protected double Xposition, Yposition; //Coordenadas en donde será pintado en la pantalla.
    protected String imageName; //Nombre de la imagen
    protected BufferedImage image; 
    //Imagen del objeto, en caso de ser inanimado, solo es una imagen pequeña
    //En caso de ser animado, es la imagen que contiene todas las subimagenes
    //de la animación del objeto.
    
    public GameObject(){
    }
    
    public GameObject(String s){
        Xposition = 0;
        Yposition = 0;
        imageName = s;
        image = GameImage.loadImage(imageName);
    }
    
    public GameObject(String Imagen, double Xposition, double Yposition){
        this.Xposition = Xposition;
        this.Yposition = Yposition;
        imageName = Imagen;
        image = GameImage.loadImage(imageName);
    }
    
    public double getXposition(){
        return Xposition;
    }
    
    public double getYposition(){
        return Yposition;
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public void setXposition(double x) {
        Xposition = x;
    }
    
    //Recibe como parámetro la posicion en el eje y
    public void setYposition(double y){
        Yposition = y;
    }
    
    //Para settear la imagen solo se la un string e intentara cargala apartir de ese nombre.
    public void setImage(String Imagen) {
        imageName = Imagen;
        image = GameImage.loadImage(imageName);
    }
}