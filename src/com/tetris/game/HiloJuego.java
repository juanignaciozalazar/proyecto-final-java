package com.tetris.game;

import com.tetris.util.TiposBloques;

import javax.swing.*;

public class HiloJuego extends Thread implements TiposBloques {

    AreaJuego areaJuego;

    public HiloJuego(AreaJuego areaJuego) {
        this.areaJuego = areaJuego;
    }


    @Override
    public void run() {
        while (true) {

            int nuevoBloque = (int) (Math.random() * 8);
            areaJuego.createBlock(nuevoBloque);

            while (areaJuego.moverBloqueAbajo()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (areaJuego.checkOOB()) {
                areaJuego.deleteBloque();
                break;
            }

            if (!areaJuego.blockIsNull())
                areaJuego.addBloqueBackground();
            areaJuego.completarFilas();

        }


        JOptionPane.showMessageDialog(null,"FIN DEL JUEGO");
    }

}
