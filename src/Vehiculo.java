package src;

abstract class Vehiculo {

    // -------------------------------
    // ATRIBUTOS PRIVADOS
    // Encapsulación: nadie accede directo,
    // solo por getters y setters.
    // -------------------------------
    private String patente;
    private String marca;
    private double capacidadCarga;
    private boolean disponible;

    // -------------------------------
    // CONSTRUCTOR
    // Se ejecuta cuando se crea un vehículo.
    // Aquí usamos setters para validar datos.
    // -------------------------------
    public Vehiculo(String patente, String marca, double capacidadCarga) {
        setPatente(patente);
        setMarca(marca);
        setCapacidadCarga(capacidadCarga);
        this.disponible = true; // al registrarlo queda disponible
    }

    // -------------------------------
    // GETTERS
    // Permiten obtener los valores
    // de los atributos privados.
    // -------------------------------
    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // -------------------------------
    // SETTERS
    // Permiten modificar atributos,
    // pero con validación.
    // -------------------------------
    public void setPatente(String patente) {
        if (patente == null || patente.trim().isEmpty()) {
            throw new IllegalArgumentException("La patente no puede estar vacía.");
        }
        this.patente = patente.trim().toUpperCase();
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }
        this.marca = marca.trim();
    }

    public void setCapacidadCarga(double capacidadCarga) {
        if (capacidadCarga <= 0) {
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor que 0.");
        }
        this.capacidadCarga = capacidadCarga;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // -------------------------------
    // MÉTODO ABSTRACTO
    // Obliga a las clases hijas a decir
    // qué tipo de vehículo son.
    // -------------------------------
    public abstract String getTipo();

    // -------------------------------
    // MÉTODO GENERAL
    // Devuelve los datos comunes
    // del vehículo.
    // Luego cada hija lo puede sobrescribir.
    // -------------------------------
    public String mostrarDatos() {
        return "Tipo: " + getTipo()
                + " | Patente: " + patente
                + " | Marca: " + marca
                + " | Capacidad: " + capacidadCarga + " kg"
                + " | Disponible: " + (disponible ? "Sí" : "No");
    }
}