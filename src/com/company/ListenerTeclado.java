package com.company;

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
        switch (e.getKeyCode()) {
            case VK_DOWN: areaJuego.moverBloqueAbajo(); break;
            case VK_LEFT: areaJuego.moverBloqueIzquierda(); break;
            case VK_RIGHT: areaJuego.moverBloqueDerecha(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
