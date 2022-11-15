package com.tetris.game;

import com.tetris.util.TiposBloques;

public class HiloJuego extends Thread implements TiposBloques {

    AreaJuego areaJuego;

    public HiloJuego(AreaJuego areaJuego) {
        this.areaJuego = areaJuego;
    }


    @Override
    public void run() {
        while (true) {

            areaJuego.createBlock(BLOQUE_O);

            while (areaJuego.moverBloqueAbajo() == true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

}
