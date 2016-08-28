package psychotileeditor;

import java.io.Serializable;
import java.util.HashMap;

public class TileHash extends HashMap<String,Tile> implements Serializable {

    public TileHash() {
        super();
    }   
    
    public void actualizaTile(String nombre, Tile.tipoTile tipo, int imagenInicial) 
    {        
        Tile t=new Tile(nombre,tipo,imagenInicial);
        this.put(nombre, t);
    }

    public boolean existeTile(String nombre) {
        return this.containsKey(nombre);
    }
    
    public void eliminaTile(String nombre){
       this.remove(nombre);
    }
    
    public Tile getTile(String nombre){
        return this.get(nombre);
    }
    
    //Si esto es para tiles animados, entonces no nos sirve.
    /*
    public void actualizaImagenes(){
       // Invocar en cada frame para actualizar las imágenes de tiles animados
       Iterator<Tile> i=this.values().iterator();
       while(i.hasNext())
           i.next().actualizaImagen();
    }
     */
        
    
}
