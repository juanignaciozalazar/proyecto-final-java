package com.tetris.ui;

import javax.swing.*;

public class Instrucciones extends JFrame {
    public Instrucciones(){
        int opcion = 0, elemento;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Que teclas usar para mover\n" +
                        "2. que teclas usar para rotar\n" + "3. Salir\n"
                        + "Elige una opcion", "Intrucciones", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Para mover las piezas utilizar las flechas <-^->", "Mover Piezas", JOptionPane.QUESTION_MESSAGE));
                        break;
                    case 2:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Para rotar las piezas utilizar las flechas X (horario) y Z (antihorario)", "Rotar Piezas", JOptionPane.QUESTION_MESSAGE));
                        break;

                    case 3:
                        JOptionPane.showInputDialog(null,
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showInputDialog(null, "opcion incorrecta",
                                "cuidado", JOptionPane.INFORMATION_MESSAGE);
                        break;

                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "" +
                        "error" + n.getMessage());
            }

        }while (opcion != 3) ;
    }

}


