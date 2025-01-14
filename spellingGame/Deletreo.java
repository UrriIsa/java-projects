/**
 * Spelling Game: An interactive program where players try to spell words correctly
 * in various difficulty modes, earning points based on their performance.
 *
 * This program handles serialization to save and retrieve historical scores.
 * 
 * @author Urrutia Alfaro Isaac Arturo
 *
 * MIT License
 * Copyright (c) 2024 Urrutia Alfaro Isaac Arturo
 */

import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.util.InputMismatchException;
import java.io.EOFException;

import java.util.Scanner;
import java.util.Random;

/**
 * Main class that runs the game.
 */
class Deletreo{
    /**
     * Main method controlling the game flow.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
        String nomJug = "";
        int modalidad = 0;
        int puntosJug = 0;

        System.out.print("------------ BIENVENIDO AL JUEGO DEL DELETREO ------------ \nPor favor proporciona tu nombre de jugador: ");
        nomJug = sc.nextLine();

        while(nomJug.isEmpty() || (nomJug.length() == 0) || (nomJug.matches("^[^a-zA-Z]*$"))){
            nomJug = "";
            System.out.print("No se puede seguir si no introduce un nombre válido (con letras).\nIntroduzca nuevamente el nombre: ");
            nomJug = sc.nextLine();
        }

        try{
            System.out.print("Existen las siguientes modalidades: \n [3] DIFICIL \n [2] MEDIO \n [1] FÁCIL\nPor favor escribe el número de tu elección: ");
            modalidad = sc.nextInt();

            if (modalidad < 1 || modalidad > 3) {
                throw new InputMismatchException("Número de modalidad no válido.");
            }else{

                Juego juego = null;
                switch (modalidad) {
                    case 3:
                        juego = new Juego(3);
                        puntosJug = juego.jugar(nomJug);
                        break;
                    case 2:
                        juego = new Juego(2);
                        puntosJug = juego.jugar(nomJug);
                        break;
                    case 1:
                        juego = new Juego(1);
                        puntosJug = juego.jugar(nomJug);
                        break;
                    default:
                        System.out.println("Hubo un error en tu modalidad");
                }
            }
        }catch(InputMismatchException ime){
            System.out.println("No se introdujo correctamente el número, vuelva a intentar");
            return;
        }
        
        try {
            String nomModalidad = "" ;
            FileInputStream fis = null ;
            FileOutputStream fos = null ;
            String archivoTop = "";

            switch (modalidad) {
                case 3:
                    archivoTop = "topHard.txt" ;
                    nomModalidad = "DIFICIL" ;
                    break ;
                case 2:
                    archivoTop = "topNormal.txt" ;
                    nomModalidad = "NORMAL" ;
                    break ;
                case 1:
                    archivoTop = "topEasy.txt" ;
                    nomModalidad = "FÁCIL" ;
                    break ;
                default:
                    System.out.println("Hubo un error con el archivo del top de jugadores.") ;
            }
            fis = new FileInputStream(archivoTop) ;
            ObjectInputStream ois = new ObjectInputStream(fis);
            TopPuntos puntosGuardados = (TopPuntos) ois.readObject();
            ois.close();

            TopPuntos puntosActu = null;
            puntosActu = cambiaTop(puntosGuardados, nomJug, puntosJug);

            System.out.println("\nEL TOP ACTUALMENTE DE LA MODALIDAD " + nomModalidad + " ES: \n" + puntosActu);

            fos = new FileOutputStream(archivoTop);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(puntosActu);
            oos.close();



        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hubo errores con el archivo del top de jugadores. En este momento no se puede visualizar");
        }

    }
    /**
     * Updates the leaderboard with a new player and score.
     *
     * @param topActual (currentTop) The current leaderboard.
     * @param nuevoNombre (newName) The name of the new player.
     * @param nuevoPuntaje (newScore) The score of the new player.
     * @return The updated leaderboard.
     */
    public static TopPuntos cambiaTop(TopPuntos topActual, String nuevoNombre, int nuevoPuntaje){
        for (int i = 0; i < topActual.puntajes.length; i++) {
            if (nuevoPuntaje > topActual.puntajes[i]) {
                // Move items down
                for (int j = topActual.puntajes.length - 1; j > i; j--) {
                    topActual.puntajes[j] = topActual.puntajes[j - 1];
                    topActual.nombres[j] = topActual.nombres[j - 1];
                }
                // Insert the new score and name
                topActual.puntajes[i] = nuevoPuntaje;
                topActual.nombres[i] = nuevoNombre;
                break;
            }
        }
        return topActual;
    }
}
/**
 * Represents a leaderboard of players' scores.
 */
class TopPuntos implements Serializable {
    String[] nombres = new String[10];
    int[] puntajes = new int[10];
    /**
     * Constructs a leaderboard with given names and scores.
     *
     * @param nombres (names) The names of the players.
     * @param puntajes (scores) The scores of the players.
     */
    public TopPuntos(String[] nombres, int[] puntajes) {
        this.nombres = nombres;
        this.puntajes = puntajes;
    }
    /**
     * Provides a string representation of the leaderboard.
     *
     * @return The leaderboard in a human-readable format.
     */
    @Override
    public String toString() {
        String topString = "";
        for(int i = 0 ; i < 10; i++){
            topString += "\t[" + (i+1) + "] " + nombres[i] + " - " + puntajes[i] + "\n";
        }
        return topString;
    }
}
/**
 * Controls the game logic based on the selected difficulty mode.
 */
class Juego {
    String[][] palabras = {
        {"sol", "dona", "agua", "rayo", "nube", "beso", "cielo", "medir", "tres", "dos", "rosa", "pluma", "cerro", "reno", "velo", "recio"},
        {"cuaderno", "guitarra", "puntiagudo", "solsticio", "eminencia", "magnificencia", "sismógrafo", "autóctono", "ferrocarril", "azulejo", "escarlata", "controversial", "almendra", "amurallar", "célula", "resonancia"},
        {"revolucionario", "recalcitrante", "biocompatibilidad", "desoxirribonucleico", "microorganismo", "neurocirujano", "imprescriptibilidad", "anticonstitucionalmente", "recursividad", "psicopedagógico", "comportamiento", "circunferencia", "idiosincrasia", "ininteligible", "desparpajo", "inconstitucionalidad"}
    };

    int modalidad;
    /**
     * Constructs a game with the specified difficulty level.
     *
     * @param modalidad (difficulty) The difficulty level (1: Easy, 2: Medium, 3: Hard).
     */
    public Juego(int modalidad) {
        this.modalidad = modalidad;
    }
     /**
     * Executes the main logic of the game.
     *
     * @param nomUsuario (playerName) The player's name.
     * @return The total score achieved by the player.
     */
    public int jugar(String nomUsuario) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] palMod = palabras[modalidad - 1]; // here it separates the words in a vector according to the modality
        int puntosTotales = 0;

        for (int i = 0; i < 7; i++) { // Show only 7 random words

            int indAleat = random.nextInt(palMod.length); // A random index that is within the length of palMod
            String palabra = palMod[indAleat]; // Save the word according to the random index

            clearScreen();
            
            System.out.println(palabra);// Show the word to the user

            long tiempoInicio = System.currentTimeMillis();// Record start time
            String entradaUsuario = scanner.nextLine(); // Capture user input
            long tiempoFin = System.currentTimeMillis(); // Record the end time

            // Calculate response time
            long tiempoTardado = tiempoFin - tiempoInicio;
            double tiempoSegundos = tiempoTardado / 1000.0; //between 1000 because I go from milliseconds to seconds

            // Calculate the score
            int puntosPorPalabra = 0;

            if (entradaUsuario.isEmpty()) {
                // Penalize if input is empty
                System.out.println("No escribiste nada. Puntos esta palabra: 0");
            }else if(!entradaUsuario.contains(palabra)){
                System.out.println("La palabra no contiene la palabra objetivo. Puntos esta palabra: 0");
            } else{
                // Calculate score if there is input
                int puntosPalabra = calcularPuntos(palabra, entradaUsuario);
                int puntosTiempo = (int) (1000 / (tiempoSegundos + 1)); // Penalty for time taken

                // Total points for this word
                puntosPorPalabra = puntosPalabra + puntosTiempo;

                // Make sure the points are not negative
                if (puntosPorPalabra < 0) puntosPorPalabra = 0;
            }

            puntosTotales += puntosPorPalabra;
        }
        clearScreen();
        System.out.println("¡Juego terminado!\n" + nomUsuario + ". Tu puntuación total es: " + puntosTotales);
        return puntosTotales;
    }
    /**
     * Calculates the points obtained by comparing the original word with the user's input.
     *
     * @param palabraOriginal The word the player is supposed to spell.
     * @param entradaUsuario The word entered by the player.
     * @return The points obtained by the player.
     */
    public int calcularPuntos(String palabraOriginal, String entradaUsuario) {
        int puntos = 0;

        // Add or subtract points for letters
        for (int i = 0; i < Math.min(palabraOriginal.length(), entradaUsuario.length()); i++) {
            if (palabraOriginal.charAt(i) == entradaUsuario.charAt(i)) {
                puntos += 10; // For each correct letter
            }else{
                puntos -= 3; //For every wrong letter
            }
        }

        // Discount points for missing letters
        if (entradaUsuario.length() < palabraOriginal.length()) {
            puntos -= (palabraOriginal.length() - entradaUsuario.length()) * 5; // Descuento por letras faltantes
        }

        // Discount for extra letters
        if (entradaUsuario.length() > palabraOriginal.length()) {
            puntos -= (entradaUsuario.length() - palabraOriginal.length()) * 2; 
        }

        return puntos;
    }


    /**
     * Clears the console screen (platform-dependent implementation).
     */
    public void clearScreen() {
                System.out.print("\033[H\033[2J");
    }
}
