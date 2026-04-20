package src;

// CLASE HIJA: Camion
// Hereda de Vehiculo.
// Agrega un atributo propio: numeroEjes
// =====================================================
class Camion extends Vehiculo {

    private int numeroEjes;

    public Camion(String patente, String marca, double capacidadCarga, int numeroEjes) {
        // super(...) llama al constructor del padre
        super(patente, marca, capacidadCarga);
        setNumeroEjes(numeroEjes);
    }

    //Constructor sobrecargado
    public Camion(String patente, String marca){
        this(patente, marca, 1000, 2);
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        if (numeroEjes <= 0) {
            throw new IllegalArgumentException("El número de ejes debe ser mayor que 0.");
        }
        this.numeroEjes = numeroEjes;
    }

    // Sobrescritura:
    // cada clase hija responde su propio tipo
    @Override
    public String getTipo() {
        return "Camión";
    }

    // Sobrescritura:
    // agrega información específica del camión
    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + " | Ejes: " + numeroEjes;
    }
}