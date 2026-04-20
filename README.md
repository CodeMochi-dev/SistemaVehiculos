# 🚚 Sistema de Gestión de Vehículos de Reparto

Este es un sistema de consola desarrollado en **Java** para la gestión y control de flotas de transporte. El proyecto implementa conceptos avanzados de Programación Orientada a Objetos (POO) como herencia, polimorfismo, encapsulamiento y clases abstractas.

## 🏗️ Arquitectura del Proyecto

El sistema sigue una arquitectura de **Monolito Modular**. Se ha descompuesto el código original en múltiples archivos para mejorar la mantenibilidad y escalabilidad.

### Jerarquía de Clases
- `Vehiculo` (Clase Abstracta): Define el contrato y atributos base (patente, marca, carga).
    - `Camion`: Especialización para carga pesada con número de ejes.
    - `Furgon`: Especialización para carga urbana con volumen en m³.
    - `MotoReparto`: Especialización para entregas rápidas con opción de caja térmica.
- `SistemaVehiculos`: Clase principal que orquesta la lógica del negocio y la interfaz de usuario por consola.

## 📂 Estructura de Archivos

```text
SistemaVehiculos/
├── src/
│   ├── Vehiculo.java         # Clase base (Abstracta)
│   ├── Camion.java           # Subclase
│   ├── Furgon.java           # Subclase
│   ├── MotoReparto.java      # Subclase
│   └── SistemaVehiculos.java # Punto de entrada (Main)
├── .gitignore                # Configuración para Git
└── README.md                 # Documentación del proyecto