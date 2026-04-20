package src;

// CLASE HIJA: Furgon
// Hereda de Vehiculo.
// Agrega un atributo propio: volumenCarga
// =====================================================
class Furgon extends Vehiculo {

    private double volumenCarga;

    public Furgon(String patente, String marca, double capacidadCarga, double volumenCarga) {
        super(patente, marca, capacidadCarga);
        setVolumenCarga(volumenCarga);
    }

    public Furgon(String patente, String marca){
        this(patente, marca, 800, 12);
    }

    public double getVolumenCarga() {
        return volumenCarga;
    }

    public void setVolumenCarga(double volumenCarga) {
        if (volumenCarga <= 0) {
            throw new IllegalArgumentException("El volumen de carga debe ser mayor que 0.");
        }
        this.volumenCarga = volumenCarga;
    }

    @Override
    public String getTipo() {
        return "Furgón";
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + " | Volumen: " + volumenCarga + " m3";
    }
}