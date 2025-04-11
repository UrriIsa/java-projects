# Deletreo (Spelling Game)


`Deletreo` es un juego Java interactivo en el que los jugadores intentan deletrear palabras correctamente en varios modos de dificultad, ganando puntos según su rendimiento. El programa incluye la funcionalidad de guardar y recuperar puntuaciones históricas mediante serialización, además de tener en cuenta el tiempo de escritura y los aciertos de las letras. Lo hice en mi primer semestre.

***Traduction :***

`Deletreo` is an interactive Java game where players try to spell words correctly in various difficulty modes, earning points according to their performance. The program includes the functionality to save and retrieve historical scores through serialization, in addition to taking into account the time of writing and letter hits. It was done in my first semester.

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

- Múltiples niveles de dificultad para adaptarse a diferentes habilidades.
- Uso de serialización para guardar y cargar puntuaciones históricas.
- Validación de las entradas del usuario para evitar errores.
- Interfaz interactiva basada en consola
- Sistema de puntuación acumulativa para el seguimiento del progreso.

***Traduction :***

- Multiple difficulty levels to suit different abilities.
- Use of serialization to save and load historical scores.
- User input validation to avoid errors.
- Interactive console-based interface
- Cumulative scoring system for progress tracking.

---

## Requisitos / Requirements

- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html) versión 8 o superior.  
- Editor de texto o IDE: Un editor de texto (como Visual Studio Code, Sublime Text, Atom) o un entorno de desarrollo integrado (como IntelliJ IDEA, Eclipse, NetBeans).

***Traducción:***

- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html) version 8 or higher.  
- Text editor or IDE: A text editor (such as Visual Studio Code, Sublime Text, Atom) or an integrated development environment (such as IntelliJ IDEA, Eclipse, NetBeans).

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
    javac Deletro.java
    ```
3. Ejecuta el programa con:
     ```bash
    java Deletro
    ```
4. Selecciona el nivel de dificultad deseado.
5. Introduce las palabras que se te pidan para sumar puntos.
6. Al finalizar, las puntuaciones se guardarán automáticamente.
   
***Traduction :***

1. Opens the terminal in the folder where the files are located
2. Compile the file.

   ```bash
   javac Deletro.java
   ```
3. Run the program with:

     ```bash
     java Deletro
     ```
4. Select the desired difficulty level.
5. Enter the words as prompted to score points.
6. Upon completion, scores will be automatically saved.
---

## Clases y Métodos / Classes and Methods

### 1. `Deletro` (Clase principal / Main class) :
  Controla el flujo principal del juego. Incluye la lógica de puntuación y serialización. ***Traduction :*** Controls the main flow of the game. It includes the scoring and serialization logic.
  - `main()` : pide al usuario nombre y modo, crea un objeto para jugar e imprime la tabla de clasificación. ***Traduction :*** ask the user for name and mode, create an object to play and print the leaderboard.
  - `cambiaTop()` : comprueba y ajusta la clasificación dependiendo de los puntos de los jugadores. Como parámetros de entrada tiene la tabla de clasificación antes de ser actualizada, el nombre del jugador y su puntuación. Su parámetro de salida es la clasificación actualizada. ***Traduction :*** checks and adjusts the leaderboard depending on the players' points. As input parameters it has the leaderboard before being updated, the player's name and his score. Its output parameter is the updated leaderboard.

  
### 2. `TopPuntos` :
  Es la clase que nos ayuda a serializar. Incluye la impresión de la tabla de mejores puntuaciones. ***Traduction :*** it is the class that helps us to serialize. It includes the printing of the table of best scores.
  - `TopPuntos()` : el método constructor para tener los nombres y puntuaciones. ***Traduction :*** the constructor method to have the names and scores.
  - `toString()` : método que devuelve la cadena para imprimir correctamente la tabla de puntuaciones. ***Traduction :*** method that returns the string to correctly print the score table.
  
### 3. `Juego` :
  Almacena las palabras a deletrear en función de la dificultad. Almacena la entrada del jugador y calcula los puntos a asignar por palabra. ***Traduction :*** Stores the words to be spelled depending on the difficulty. It stores the player's input and calculates the points to be assigned per word. Methods :
  - `Juego ()` : el método constructor para guardar la dificultad. ***Traduction :*** the constructor method to save the difficulty.
  - `jugar ()` : tiene el funcionamiento del juego que no es visible, obtiene el tiempo de escritura, llama al método necesario para calcular los puntos y lleva la cuenta de los mismos. ***Traduction :*** has the operation of the game that is not visible, gets the writing time, calls the necessary method to calculate points and keeps track of them.
  - `calcularPuntos()` :  tiene la lógica de obtención de puntos, en sus parámetros de entrada está la palabra original y la entrada del usuario, con eso hace la suma de la puntuación por palabra. ***Traduction :*** has the logic of obtaining points, in its input parameters there is the original word and the user's input, with that it makes the sum of the score per word.

  
---

## Licencia / License
Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo [LICENCIA](LICENCIA) para obtener más información.

***Traduction :***
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
