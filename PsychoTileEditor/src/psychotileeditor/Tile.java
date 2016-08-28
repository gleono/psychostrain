package psychotileeditor;

import java.io.Serializable;

public class Tile implements Serializable{

    public enum tipoTile {vacio,obstaculo,item};
    //En nuestro juego solo habrá 3 tipos de tiles Vacío que no tiene imagen
    //Obstaculo que es una imagen pero no se puede atravesar.
    //Item que es una imagen pero si se puede atravesar.
    
    
    
    //No habra tiles animados, por lo tanto lo quitamos.
    private String nombre;
    private tipoTile tipo;
    private int imagenActual;
    
    //private int imagenInicial;
    //private int imagenFinal;
    //private int framesImagen;
    //private int cuentaFrames;

    public Tile() {
        nombre="";
        tipo=tipoTile.vacio;
        imagenActual=0;
    }   
    
    public Tile(String nombre, tipoTile tipo, int imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        //this.imagenInicial = imagenInicial;
        //this.imagenFinal = imagenFinal;
        //this.framesImagen = framesImagen;
        imagenActual=imagen;
        //cuentaFrames=0;
    }   

    public int getImagenActual() {

        return imagenActual;
    }    
    
    
    
    //Este método se comenta, porque nuestro juego no lleva tiles animados.
    /*public void actualizaImagen()
    {        
        if(imagenFinal>imagenInicial)
        {
            cuentaFrames++;
            if(cuentaFrames>framesImagen)
            {
              imagenActual=imagenActual++;
              cuentaFrames=0;
            }
            if(imagenActual>imagenFinal)
              imagenActual=imagenInicial;
        }
    }*/
    
}
