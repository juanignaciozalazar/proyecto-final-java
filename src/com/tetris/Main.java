package com.tetris;

import com.tetris.ui.JuegoForm;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
                JFrame inicio = new JuegoForm(displaySize.width, displaySize.height);
                inicio.setVisible(true);

            }
        });


    }
}
