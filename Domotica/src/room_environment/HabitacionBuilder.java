package room_environment;

public class HabitacionBuilder {
    protected String nombre;
    protected int ancho = 10; /* Por defecto 10m */
    protected int largo = 10; /* Por defecto 10m */
    protected String tipoSuelo = "Cerámica";
    protected int nivelSuciedad = 0;
    protected boolean tieneObstaculos = false;

    public HabitacionBuilder(String nombre) {
        this.nombre = nombre;
    }
    
    public HabitacionBuilder conDimensiones(int ancho, int largo) {
        System.out.println("...configurando dimensiones a " + ancho + "x" + largo);
        this.ancho = ancho;
        this.largo = largo;
        return this; 
    }

    public HabitacionBuilder conSueloDeMadera() {
        System.out.println("...configurando suelo de madera");
        this.tipoSuelo = "Parqué";
        return this;
    }

    public HabitacionBuilder conMuchaSuciedad() {
        System.out.println("...configurando mucha suciedad");
        this.nivelSuciedad = 10;
        return this;
    }

    public HabitacionBuilder conObstaculos() {
        System.out.println("...añadiendo obstáculos (muebles)");
        this.tieneObstaculos = true;
        return this;
    }

    
    public HabitacionBuilder comoSalonPrincipal() {
        System.out.println("...cargando preset: Salón Principal");
        this.ancho = 25;
        this.largo = 30;
        this.tipoSuelo = "Parqué";
        this.tieneObstaculos = true;
        return this;
    }
    
    public Habitacion build() {
        System.out.println("-> Construyendo habitación final: " + this.nombre);
        return new Habitacion(this); // Llama al constructor de Habitacion
    }
    
    
}