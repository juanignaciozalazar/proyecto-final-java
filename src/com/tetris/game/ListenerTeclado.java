package com.tetris.game;

import com.tetris.game.AreaJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

public class ListenerTeclado implements KeyListener {

    AreaJuego areaJuego;

    public ListenerTeclado(AreaJuego areaJuego) {
        this.areaJuego = areaJuego;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!areaJuego.blockIsNull()) {

            int keyCode = e.getKeyCode();

            if (keyCode == VK_DOWN) {
                areaJuego.moverBloqueAbajo();
            }

            if (keyCode == VK_LEFT) {
                areaJuego.moverBloqueIzquierda();
            }

            if (keyCode == VK_RIGHT) {
                areaJuego.moverBloqueDerecha();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
