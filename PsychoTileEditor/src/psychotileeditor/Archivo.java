package psychotileeditor;

import java.io.*;

public class Archivo {

    static public boolean guardaMapa(String nombreArchivo,Mapa mapa)
    {
     try{
          ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(nombreArchivo));
          salida.writeObject(mapa);
          salida.flush(); 
          salida.close();
          return true;
        }
     catch(IOException e)
     {
       return false;
     }
    }
    
    static public Mapa cargaMapa(String nombreArchivo)
    {
        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
            Mapa mapa = (Mapa) entrada.readObject();
            entrada.close();
            return mapa;
        } catch (Exception e) {
            return null;
        }         
    }
}
