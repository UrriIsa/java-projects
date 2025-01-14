# IndicacionesJuego


# Deletreo (Spelling Game)



`Deletreo` is an interactive Java game where players try to spell words correctly in various difficulty modes, earning points according to their performance. The program includes the functionality to save and retrieve historical scores through serialization, in addition to taking into account the time of writing and letter hits. It was done in my first semester.

---

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Classes and Methods](#classes-and-methods)
- [License](#license)

---

## Features

- Multiple difficulty levels to suit different abilities.
- Use of serialization to save and load historical scores.
- User input validation to avoid errors.
- Interactive console-based interface
- Cumulative scoring system for progress tracking.

---


## Requirements

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) versión 8 o superior.

---

## Installation

1. Clone this repository..
2. Make sure you have the JDK installed on your system.
3. Compile and use the file.

---

## Usage

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

## Classes and Methods

### 1. `Deletro` (Main class) :
  Controls the main flow of the game. It includes the scoring and serialization logic. Methods:
  - main(): Ask the user for name and mode, create an object to play and print the leaderboard.
  - cambiaTop() : Checks and adjusts the leaderboard depending on the players' points. As input parameters it has the leaderboard before being updated, the player's name and his score. Its output parameter is the updated leaderboard.

  
### 2. `TopPuntos` :
  It is the class that helps us to serialize. It includes the printing of the table of best scores. Methods :
  - TopPuntos() : the constructor method to have the names and scores.
  - toString () : method that returns the string to correctly print the score table.
  
### 3. `Juego` :
  Stores the words to be spelled depending on the difficulty. It stores the player's input and calculates the points to be assigned per word. Methods :
  - Juego () : the constructor method to save the difficulty.
  - jugar () : has the operation of the game that is not visible, gets the writing time, calls the necessary method to calculate points and keeps track of them.
  - calcularPuntos() : has the logic of obtaining points, in its input parameters there is the original word and the user's input, with that it makes the sum of the score per word.

  
---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
