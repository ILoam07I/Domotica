package room_environment;

public class Habitacion {
    private final String nombre;
    private final int ancho;
    private final int largo;
    private final String tipoSuelo;
    private final int nivelSuciedad;  /* 0 si es limpia, 10 si está muy sucia */
    private final boolean tieneObstaculos;

    Habitacion(HabitacionBuilder builder) {
        this.nombre = builder.nombre; // Atributo obligatorio
        this.ancho = builder.ancho;
        this.largo = builder.largo;
        this.tipoSuelo = builder.tipoSuelo;
        this.nivelSuciedad = builder.nivelSuciedad;
        this.tieneObstaculos = builder.tieneObstaculos;
    }

    public String getNombre(){ 
        return nombre; 
    }
    
    public int getAncho(){
        return ancho; 
    }
    
    public int getLargo(){ 
        return largo;
    }
    
    public String getTipoSuelo(){ 
        return tipoSuelo;
    }
    
    public int getNivelSuciedad(){
        return nivelSuciedad; 
    }
    public boolean isTieneObstaculos(){
        return tieneObstaculos;
    }

    @Override
    public String toString() {
        return "['" + nombre + "' (" + ancho + "x" + largo + "m), Suelo: " +
               tipoSuelo + ", Suciedad: " + nivelSuciedad + ", Obstáculos: " +
               (tieneObstaculos ? "Sí" : "No") + "]";
    }
    
}