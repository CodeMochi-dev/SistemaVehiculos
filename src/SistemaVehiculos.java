package src;

import java.util.ArrayList;
import java.util.Scanner;

// CLASE PRINCIPAL
// Aquí está el menú y toda la lógica del sistema.
// Esta sí debe ser public.
// =====================================================
public class SistemaVehiculos {

    // Scanner para leer datos del usuario
    static Scanner sc = new Scanner(System.in);

    // Lista donde se guardan todos los vehículos
    // Es de tipo Vehiculo para aprovechar polimorfismo
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    // -------------------------------
    // METODO MAIN
    // Punto de inicio del programa
    // -------------------------------
    public static void main(String[] args) {  // Punto de inicio del programa
        int opcion;

        // do-while: repite el menú hasta elegir salir
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: "); //

            // switch: ejecuta una acción según la opción elegida
            switch (opcion) {
                case 1:
                    registrarCamion();
                    break;
                case 2:
                    registrarFurgon();
                    break;
                case 3:
                    registrarMoto();
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    mostrarDisponibles();
                    break;
                case 6:
                    marcarNoDisponible();
                    break;
                case 7:
                    mostrarReporteGeneral();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);
    }

    // -------------------------------
    // MUESTRA EL MENÚ PRINCIPAL
    // -------------------------------
    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE VEHÍCULOS DE REPARTO ===");
        System.out.println("1. Registrar camión");
        System.out.println("2. Registrar furgón");
        System.out.println("3. Registrar moto de reparto");
        System.out.println("4. Mostrar todos los vehículos");
        System.out.println("5. Mostrar vehículos disponibles");
        System.out.println("6. Marcar vehículo como no disponible");
        System.out.println("7. Mostrar reporte general");
        System.out.println("8. Salir");
    }

    // -------------------------------
    // VERIFICA SI YA EXISTE UNA PATENTE
    // Sirve para evitar duplicados
    // -------------------------------
    public static boolean patenteExiste(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente.trim())) {
                return true;
            }
        }
        return false;
    }

    public static Vehiculo buscarVehiculo(String patente){
        for(Vehiculo v: vehiculos){
            if(v.getPatente().equalsIgnoreCase(patente.trim())){
                return v;
            }
        }
        return null;
    }

    // -------------------------------
    // REGISTRAR CAMIÓN
    // Crea un objeto Camion y lo guarda en la lista
    // -------------------------------
    public static void registrarCamion() {
        try {
            System.out.println("\n--- Registro de camión ---");

            String patente = leerTexto("Patente: ");

            // validación para no repetir patentes
            if (patenteExiste(patente)) {
                System.out.println("Ya existe un vehículo con esa patente.");
                return;
            }

            String marca = leerTexto("Marca: ");
            double capacidad = leerDouble("Capacidad de carga (kg): ");
            int ejes = leerEntero("Número de ejes: ");

            vehiculos.add(new Camion(patente, marca, capacidad, ejes));
            System.out.println("Camión registrado correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------------------
    // REGISTRAR FURGÓN
    // -------------------------------
    public static void registrarFurgon() {
        try {
            System.out.println("\n--- Registro de furgón ---");

            String patente = leerTexto("Patente: ", true);

            if (patenteExiste(patente)) {
                System.out.println("Ya existe un vehículo con esa patente.");
                return;
            }

            String marca = leerTexto("Marca: ");
            double capacidad = leerDouble("Capacidad de carga (kg): ");
            double volumen = leerDouble("Volumen de carga (m3): ");

            vehiculos.add(new Furgon(patente, marca, capacidad, volumen));
            System.out.println("Furgón registrado correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------------------
    // REGISTRAR MOTO DE REPARTO
    // -------------------------------
    public static void registrarMoto() {
        try {
            System.out.println("\n--- Registro de moto de reparto ---");

            String patente = leerTexto("Patente: ", true);

            if (patenteExiste(patente)) {
                System.out.println("Ya existe un vehículo con esa patente.");
                return;
            }

            String marca = leerTexto("Marca: ");
            double capacidad = leerDouble("Capacidad de carga (kg): ");
            String respuesta = leerTexto("¿Tiene caja térmica? (si/no): ");

            // si escribe "si", la variable será true
            boolean cajaTermica = respuesta.equalsIgnoreCase("si");

            vehiculos.add(new MotoReparto(patente, marca, capacidad, cajaTermica));
            System.out.println("Moto de reparto registrada correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------------------
    // MUESTRA TODOS LOS VEHÍCULOS
    // Aquí se usa polimorfismo:
    // v puede ser Camion, Furgon o MotoReparto
    // y Java ejecuta el mostrarDatos() correcto
    // -------------------------------
    public static void mostrarTodos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("\n--- TODOS LOS VEHÍCULOS ---");
        for (Vehiculo v : vehiculos) {
            System.out.println(v.mostrarDatos(true));
        }
    }

    // -------------------------------
    // MUESTRA SOLO LOS DISPONIBLES
    // -------------------------------
    public static void mostrarDisponibles() {
        boolean hayDisponibles = false;

        System.out.println("\n--- VEHÍCULOS DISPONIBLES ---");
        for (Vehiculo v : vehiculos) {
            if (v.isDisponible()) {
                System.out.println(v.mostrarDatos());
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay vehículos disponibles.");
        }
    }

    // -------------------------------
    // CAMBIA EL ESTADO DE UN VEHÍCULO
    // Busca por patente y lo deja no disponible
    // -------------------------------
    public static void marcarNoDisponible() {
        String patente = leerTexto("Ingrese la patente del vehículo: ");

        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                v.setDisponible(false);
                System.out.println("Vehículo marcado como no disponible.");
                return;
            }
        }

        System.out.println("No se encontró un vehículo con esa patente.");
    }

    // -------------------------------
    // REPORTE GENERAL
    // Cuenta cuántos hay por tipo y disponibilidad
    // -------------------------------
    public static void mostrarReporteGeneral() {
        int camiones = 0;
        int furgones = 0;
        int motos = 0;
        int disponibles = 0;
        int noDisponibles = 0;

        for (Vehiculo v : vehiculos) {

            // instanceof sirve para saber
            // de qué clase es cada objeto
            if (v instanceof Camion) {
                camiones++;
            } else if (v instanceof Furgon) {
                furgones++;
            } else if (v instanceof MotoReparto) {
                motos++;
            }

            if (v.isDisponible()) {
                disponibles++;
            } else {
                noDisponibles++;
            }
        }

        System.out.println("\n--- REPORTE GENERAL ---");
        System.out.println("Total de vehículos: " + vehiculos.size());
        System.out.println("Camiones: " + camiones);
        System.out.println("Furgones: " + furgones);
        System.out.println("Motos de reparto: " + motos);
        System.out.println("Disponibles: " + disponibles);
        System.out.println("No disponibles: " + noDisponibles);
    }

    // -------------------------------
    // MÉTODOS AUXILIARES DE LECTURA
    // Sirven para pedir datos al usuario
    // y evitar errores al ingresar números.
    // -------------------------------
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    public static String leerTexto(String mensaje, boolean obligatorio){
        while(true) {
            System.out.println(mensaje);
            String texto = sc.nextLine().trim();
            if (!obligatorio || !texto.isEmpty()) {
                return texto;
            }
            System.out.println("Este campo es obligatorio");
        }
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine().trim().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}