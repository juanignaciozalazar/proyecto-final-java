package com.tetris.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioForm extends JFrame {
    private JLabel Title;
    private JButton botonIniciarJuego;
    private JButton botonAyuda;
    private JButton botonSalir;
    private JPanel panelPrincipal;


    public InicioForm(int displayWidth, int displayHeight) {
        super("el tetri");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Calcular posicion central de la pantalla y tamaño de la ventana
        int width = 800;
        int height = 600;
        int x = (displayWidth - width) / 2;
        int y = (displayHeight - height) / 2;
        this.setBounds(x,y,width,height);
        this.setContentPane(panelPrincipal);

        botonIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        dispose();
                        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
                        JFrame inicio = new JuegoForm(displaySize.width, displaySize.height);
                        inicio.setVisible(true);

                    }
                });
            }
        });
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        botonAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

