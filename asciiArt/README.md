# Generator (Ascii Generator) .



`Generator` converts images into artistic ASCII text representations. It scales an input image to a specific size, maps pixel brightness values to predefined ASCII characters, and saves the result in a text file. It was done in my first semester.

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

- Converts images into ASCII art.
- Adjustable output width for controlling the ASCII art size.
- Uses an optimized grayscale character set for visual fidelity.
- Supports multiple image formats like PNG, JPG, and BMP.
- Saves the output ASCII art to a text file.
- Provides error handling for invalid or missing input files
  
---


## Requirements

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) versión 8 o superior.
- An input image file in formats such as PNG, JPG, or BMP that is in the same folder.
---

## Installation

1. Clone this repository.
2. Make sure you have the JDK installed on your system.
3. compile and use the file by entering the file name and file extension in the terminal.

---

## Usage

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

## Classes and Methods

### 1. `Generator` (Main class) :
  It has all the implementation. Methods:
  - main(): Entry point of the program and converts an input image to ASCII art.
      - Logic Highlights:
          - Image Scaling: Scales the image to a fixed width (90) while maintaining the aspect ratio.
          - Brightness Calculation: Uses a weighted formula for brightness based on the RGB components (brightness=0.2126×red+0.7152×green+0.0722×blue)
          - Character Mapping: Maps brightness levels to characters in a grayscale string (@%${|*+=-:. ).

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
