package psychotileeditor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author erosado
 */
public class TileMatrix extends ArrayList<ArrayList> implements Serializable{

    public TileMatrix() {
      super();
    }
    
    public void dimensiona(int renglones,int columnas)
    {
      // Ajusta las dimensiones de la matriz
      int i,j;
      
      for(i=0;i<renglones;i++) {
        // Crea los renglones faltantes
        if(i>=this.size())  this.add(new ArrayList());
        ArrayList<Tile> a=this.get(i);        
        
        // Crea las columnas faltantes
        for(j=0;j<columnas;j++)
          if(j>=a.size())
             // Tile vacío
             a.add(new Tile());
        
        // Elimina las columnas excesivas
        while(a.size()>columnas)
            a.remove(a.size()-1);          
      }
      // Elimina los renglones excesivos
      while (this.size()>renglones)
          this.remove(this.size()-1);
    }
    
    public void setTile(Tile tile,int renglon,int columna)
    // Coloca un Tile en una celda específica de la matriz
    {
        ArrayList<Tile> a=this.get(renglon);
        a.set(columna, tile);
    }
    
    public Tile getTile(int renglon,int columna)
    {
        ArrayList<Tile> a=this.get(renglon);
        return a.get(columna);
    }
}
