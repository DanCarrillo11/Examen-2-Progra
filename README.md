# Sistema de Control de Acceso a Laboratorio

## Descripción

Este proyecto consiste en una aplicación desarrollada en Java que
permite gestionar el acceso de usuarios a un laboratorio técnico.

El sistema registra usuarios, controla entradas y salidas, y genera
reportes sobre el historial de accesos y el tiempo total de permanencia
en el laboratorio.

Se implementa una arquitectura por capas, siguiendo buenas prácticas de
desarrollo de software.

------------------------------------------------------------------------

## Funcionalidades

### Gestión de usuarios

-   Registrar usuarios (ID, nombre, rol)
-   Listar usuarios
-   Eliminar usuarios
-   Validación de ID duplicado

### Control de accesos

-   Registrar entrada al laboratorio
-   Registrar salida del laboratorio
-   Validación de:
    -   Entrada duplicada
    -   Salida sin entrada previa
    -   Usuario inexistente

### Reportes

-   Historial de accesos por usuario
-   Cálculo del tiempo total dentro del laboratorio

------------------------------------------------------------------------

## Arquitectura del sistema

-   Presentación
-   Lógica de negocio
-   Acceso a datos
-   Entidades

------------------------------------------------------------------------

## Persistencia de datos

Archivos utilizados: - usuarios.txt - accesos.txt

Ubicación: archivos/

------------------------------------------------------------------------

## Cómo ejecutar el proyecto

Ejecutar el proyecto desde Visual Studio Code utilizando la opción "Run"
en la clase Main.java.

------------------------------------------------------------------------

## Tecnologías utilizadas

-   Java
-   Archivos .txt
-   Git y GitHub

------------------------------------------------------------------------

## Estructura del proyecto

ExamenIIDanielCarrillo/ ├── src/ │ ├── entidades/ │ ├── accesoDatos/ │
├── logicaNegocio/ │ └── presentacion/ ├── archivos/ │ ├── usuarios.txt
│ └── accesos.txt ├── README.md

------------------------------------------------------------------------

## Autor

Daniel Carrillo Barzuna
