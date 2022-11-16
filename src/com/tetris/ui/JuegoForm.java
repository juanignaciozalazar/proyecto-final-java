package com.tetris.ui;

import com.tetris.game.AreaJuego;
import com.tetris.game.HiloJuego;
import com.tetris.util.InfoArea;
import com.tetris.game.ListenerTeclado;

import javax.swing.*;
import java.awt.*;

public class JuegoForm extends JFrame implements InfoArea {

    private JPanel background;
    private JPanel placeholder;
    private JLabel puntaje;
    private JLabel nivel;
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
        createPlaceHolder(placeholder, 800, 600);
		
        // Instanciación de area de juego
        areaJuego = new AreaJuego(placeholder);
        this.add(areaJuego);

        // Creacion de ventanas de puntuación y nivel.

        Font mifuente = new Font("Arial", 0, 20);

        puntaje = new JLabel();
        puntaje.setBounds(areaJuego.getX() + areaJuego.getWidth() + 20, areaJuego.getY(), 200, 100);
        puntaje.setFont(mifuente);
        puntaje.setForeground(Color.WHITE);
        puntaje.setText("PUNTUACION :\n");
        puntaje.setVisible(true);
        this.add(puntaje);

        nivel = new JLabel();
        nivel.setBounds(areaJuego.getX() + areaJuego.getWidth() + 20, areaJuego.getY() + 100, 200, 100);
        nivel.setFont(mifuente);
        nivel.setForeground(Color.WHITE);
        nivel.setText("NIVEL: ");
        nivel.setVisible(true);
        this.add(nivel);

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


    private void createPlaceHolder(JPanel placeholder, int displayWidth, int displayHeight) {

        int width = 200;
        int gridCellSize = width / GRID_COLUMNAS;
        int height = gridCellSize * 24;
        int x = (displayWidth - width) / 2;
        int y = (displayHeight - height) / 2;

        // SE SUMA 1 AL ANCHO Y ALTO PARA QUE SE DIBUJEN LOS BORDES DE INFERIOR Y DERECHOS
        placeholder.setBounds(x, y, width + 1, height + 1);
        placeholder.setBackground(Color.white);
    }
}
