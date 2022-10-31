package com.company;

import java.sql.SQLOutput;

public class HiloJuego extends Thread {

    AreaJuego areaJuego;

    public HiloJuego(AreaJuego areaJuego) {
        this.areaJuego = areaJuego;
    }


    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000);
                areaJuego.moverBloqueAbajo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
