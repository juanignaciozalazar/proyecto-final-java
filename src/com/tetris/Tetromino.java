package com.tetris;

import com.tetris.util.ColorDecoder;
import com.tetris.util.InfoArea;
import com.tetris.util.TiposBloques;

import java.awt.*;

public class Tetromino  implements TiposBloques, InfoArea {

    private int[][] forma;
    private Color color;
    private int posX;
    private int posY;
    private int tipo;


    public Tetromino(int[][] forma, int tipo){
        this.forma = forma;
        this.color = ColorDecoder.getColorFromInt(tipo);
        this.tipo = tipo;
        spawnBloque();
    }

    public void spawnBloque() {


        int bloqueWidth = getWidth();
        int bloqueHeight = getHeight();

        this.posY = 0;
        this.posX = (GRID_COLUMNAS - bloqueWidth) / 2;

    }

    public int getBordeInferior() {
        return (this.posY + this.getHeight());
    }


    public int[][] getForma() {
        return forma;
    }
    public int getCellForma(int i, int j) {
        return forma[i][j];
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

    public int getTipo() {
        return tipo;
    }

    public void moverAbajo() { posY++; }

    public void moverDerecha() { posX++; }

    public void moverIzquierda() { posX--;}






}
