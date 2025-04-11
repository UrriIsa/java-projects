# Generator (Ascii Generator)

`Generator` convierte imágenes en representaciones artísticas de texto ASCII. Escala una imagen de entrada a un tamaño específico, mapea los valores de brillo de los píxeles a caracteres ASCII predefinidos y guarda el resultado en un archivo de texto. Lo hice en mi primer semestre.

***Traduction :***

`Generator` converts images into artistic ASCII text representations. It scales an input image to a specific size, maps pixel brightness values to predefined ASCII characters, and saves the result in a text file. It was done in my first semester.

---

## Table of Contents
  
- [Características / Features](#caracteristicas--features)
- [Requisitos / Requirements](#requisitos--requirements)
- [Instalación / Installation](#instalación--installation)
- [Uso / Usage](#uso--usage)
- [Clases y Métodos / Classes and Methods](#clases-y-métodos--classes-and-methods)
- [Licencia / License](#licencia--license)

---

## Caracteristicas / Features

- Convierte imágenes en arte ASCII.
- Ancho de salida ajustable para controlar el tamaño del arte ASCII.
- Utiliza un juego de caracteres en escala de grises optimizado para una mayor fidelidad visual.
- Soporta múltiples formatos de imagen como PNG, JPG y BMP.
- Guarda el arte ASCII de salida en un archivo de texto.
- Proporciona manejo de errores para archivos de entrada inválidos o faltantes.

***Traduction :***

- Converts images into ASCII art.
- Adjustable output width for controlling the ASCII art size.
- Uses an optimized grayscale character set for visual fidelity.
- Supports multiple image formats like PNG, JPG, and BMP.
- Saves the output ASCII art to a text file.
- Provides error handling for invalid or missing input files
  
---

## Requisitos / Requirements

- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html) versión 8 o superior.  
- Editor de texto o IDE: Un editor de texto (como Visual Studio Code, Sublime Text, Atom) o un entorno de desarrollo integrado (como IntelliJ IDEA, Eclipse, NetBeans).
- Un archivo de imagen de entrada en formatos como PNG, JPG o BMP que se encuentre en la misma carpeta.

***Traducción:***

- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html) version 8 or higher.  
- Text editor or IDE: A text editor (such as Visual Studio Code, Sublime Text, Atom) or an integrated development environment (such as IntelliJ IDEA, Eclipse, NetBeans).
- An input image file in formats such as PNG, JPG, or BMP that is in the same folder.
  
---

## Instalación / Installation

1. Clona este repositorio..
2. Asegúrate de que tienes el JDK instalado en tu sistema.
3. Compila y utiliza el archivo.

***Traduction :***

1. Clone this repository..
2. Make sure you have the JDK installed on your system.
3. Compile and use the file.

---


## Uso / Usage

1. Abre el terminal en la carpeta donde se encuentran los archivos
2. Compila el archivo.
   ```bash
   javac Generator.java
   ```
3. Ejecuta el programa con:
   ```bash
   java Generador Imagen.jpeg
   ```
4. Una vez finalizado, verás un fichero de texto plano en la carpeta

***Traduction :***

1. Opens the terminal in the folder where the files are located
2. Compile the file.

   ```bash
   javac Generator.java
   ```
3. Run the program with:

     ```bash
     java Generator Image.jpeg
     ```
4. Once finished, you will see a plain text file in the folder
---

## Clases y Métodos / Classes and Methods

### 1. `Generator` (Clase principal / Main class) :

  Tiene toda la implementación. Métodos:
   - main(): Punto de entrada del programa y convierte una imagen de entrada a arte ASCII.
        - Lógica destacada:
            - Escalado de imagen: Escala la imagen a un ancho fijo (90) manteniendo la relación de aspecto.
            - Cálculo del brillo: Utiliza una fórmula ponderada para el brillo basada en los componentes RGB (brillo=0,2126×rojo+0,7152×verde+0,0722×azul)
   - Mapeado de caracteres: Asigna los niveles de brillo a los caracteres de una cadena en escala de grises (@%${|*+=-:. ).

  ***Traduction :***

  It has all the implementation. Methods:
  - main(): Entry point of the program and converts an input image to ASCII art.
      - Logic Highlights:
          - Image Scaling: Scales the image to a fixed width (90) while maintaining the aspect ratio.
          - Brightness Calculation: Uses a weighted formula for brightness based on the RGB components (brightness=0.2126×red+0.7152×green+0.0722×blue)
          - Character Mapping: Maps brightness levels to characters in a grayscale string (@%${|*+=-:. ).

---

## Licencia / License
Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo [LICENCIA](LICENCIA) para obtener más información.

***Traduction :***
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
