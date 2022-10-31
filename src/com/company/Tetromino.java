package com.company;

import java.awt.*;

public class Tetromino  implements TiposBloques {

    private int[][] forma;
    private Color color;
    private int posX;
    private int posY;


    public Tetromino(int[][] forma, Color color){
        this.forma = forma;
        this.color = color;
        spawnBloque();
    }

    public void spawnBloque() {


        int bloqueWidth = getWidth();
        int bloqueHeight = getHeight();
        int gridColumnas = 10;
        int gridFilas = 20;

        this.posY = -bloqueHeight;
        this.posX = (gridColumnas - bloqueWidth) / 2;

    }

    public int[][] getForma() {
        return forma;
    }

    public void setForma(int[][] forma) {
        this.forma = forma;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return this.forma[0].length;
    }

    public int getHeight() {
        return this.forma.length;
    }

    public void moverAbajo() { posY++; }

    public void moverDerecha() { posX++; }

    public void moverIzquierda() { posX--;}






}
