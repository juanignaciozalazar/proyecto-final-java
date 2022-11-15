package com.tetris.ui;

import javax.swing.*;

public class InicioForm extends JFrame {
    private JLabel Title;
    private JButton botonIniciarJuego;
    private JButton botonAyuda;
    private JButton botonSalir;
    private JPanel panelPrincipal;


    public InicioForm(int displayWidth, int displayHeight) {
        super("Tetris pero croto");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Calcular posicion central de la pantalla y tamaño de la ventana
        int width = 800;
        int height = 600;
        int x = (displayWidth - width) / 2;
        int y = (displayHeight - height) / 2;
        this.setBounds(x,y,width,height);
        this.setContentPane(panelPrincipal);

    }


}
