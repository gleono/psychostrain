package psychotileeditor;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Mapa implements Serializable{
    
    private String nombreImagen;
    private int columnasImagen;
    private int renglonesImagen;
    private TileHash tilesDisponibles=null;
    private TileMatrix mapaTiles=null;
    private BufferedImage fondo;

    public Mapa(String nombreImagen, int columnasImagen, int renglonesImagen) {
        this.nombreImagen = nombreImagen;
        this.columnasImagen = columnasImagen;
        this.renglonesImagen = renglonesImagen;
        tilesDisponibles=new TileHash();
        mapaTiles = new TileMatrix();
        fondo = Imagenes.cargaImagen(nombreImagen);
    }

    public void setColumnasImagen(int columnasImagen) {
        this.columnasImagen = columnasImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
        fondo = Imagenes.cargaImagen(nombreImagen);
    }

    public void setRenglonesImagen(int renglonesImagen) {
        this.renglonesImagen = renglonesImagen;
    }

    public int getColumnasImagen() {
        return columnasImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public int getRenglonesImagen() {
        return renglonesImagen;
    }

    public TileMatrix getMapaTiles() {
        return mapaTiles;
    }

    public TileHash getTilesDisponibles() {
        return tilesDisponibles;
    }
    
    public BufferedImage getFondo(){
        return fondo;
    }
}