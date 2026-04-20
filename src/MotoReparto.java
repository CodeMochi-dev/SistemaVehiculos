package src;

// CLASE HIJA: MotoReparto
// Hereda de Vehiculo.
// Agrega un atributo propio: cajaTermica
// =====================================================
class MotoReparto extends Vehiculo {

    private boolean cajaTermica;

    public MotoReparto(String patente, String marca, double capacidadCarga, boolean cajaTermica) {
        super(patente, marca, capacidadCarga);
        this.cajaTermica = cajaTermica;
    }

    public MotoReparto(String patente, String marca){
        this(patente, marca, 80,false);
    }

    public boolean isCajaTermica() {
        return cajaTermica;
    }

    public void setCajaTermica(boolean cajaTermica) {
        this.cajaTermica = cajaTermica;
    }

    @Override
    public String getTipo() {
        return "Moto de reparto";
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + " | Caja térmica: " + (cajaTermica ? "Sí" : "No");
    }
}