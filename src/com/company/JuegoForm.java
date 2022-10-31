package com.company;

import javax.swing.*;
import java.awt.*;

public class JuegoForm extends JFrame {

    private JPanel background;
    private JPanel placeholder;
    private AreaJuego areaJuego;

    public JuegoForm(int displayWidth, int displayHeight) {

        // Configuracion basica de la ventana
        super("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Creacion de ventana
        int width = 800;
        int height = 600;
        int x = (displayWidth - width) / 2;
        int y = (displayHeight - height) / 2;
        this.setBounds(x,y,width,height);
        this.setBackground(Color.black);
        this.setVisible(true);

        // Creacion de placeholder para determinar el area de juego
        placeholder = new JPanel();
        createPlaceHolder(placeholder);

        // Instanciación de area de juego
        areaJuego = new AreaJuego(placeholder, 10);
        this.add(areaJuego);

        //Creacion de panel del background
        background = new JPanel();
        background.setBounds(0,0,800,600);
        background.setBackground(Color.DARK_GRAY);
        background.setVisible(true);
        this.add(background);

        // INICIAR JUEGO
        ListenerTeclado input = new ListenerTeclado(areaJuego);
        this.addKeyListener(input);
        iniciarJuego();



    }

    public void iniciarJuego() {
        new HiloJuego(areaJuego).start();
    }


    private void createPlaceHolder(JPanel placeholder) {
        placeholder.setBounds(275,40,250 + 1,500 + 1);
        placeholder.setBackground(Color.white);

    }
}
