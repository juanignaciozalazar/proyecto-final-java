package com.tetris;
import com.tetris.ui.InicioForm;
import com.tetris.ui.JuegoForm;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new InicioForm(300,300);
                 frame.setVisible(true);
                 frame.setLocationRelativeTo(null);

            }
        });
    }
}
