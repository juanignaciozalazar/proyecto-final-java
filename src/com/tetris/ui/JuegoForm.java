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
    private AreaJuego areaJuego;
    private javax.swing.JButton jButton1;



    public JuegoForm(int displayWidth, int displayHeight) {
        // Configuracion basica de la ventana
        super("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        initComponents();

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

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton1.setFocusable(false);
        //Si dejamos que el boton para retroceder sea focuseable, desactiva las teclas para poder jugar ya que se centra en el botón de atrás
        //para ser activado con el espacio, ignorando el juego por completo.

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon("assets\\pngwing.com.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)
                                .addContainerGap(715, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1)
                                .addContainerGap(379, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        InicioForm form = new InicioForm();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
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