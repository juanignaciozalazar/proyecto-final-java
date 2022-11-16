package com.tetris.game;

import com.tetris.util.ColorDecoder;
import com.tetris.util.InfoArea;
import com.tetris.Tetromino;
import com.tetris.util.TiposBloques;

import javax.swing.*;
import java.awt.*;

public class AreaJuego extends JPanel implements TiposBloques, InfoArea {


    private int gridCellSize;
    private Tetromino block;
    // gridBackground representa los bloques ya colocados, el numero que se guarde dentro determina el color del mismo.
    private int[][] gridBackground;


    public AreaJuego(JPanel placeholder)
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());


        gridCellSize = this.getBounds().width / GRID_COLUMNAS;
        gridBackground = new int[GRID_FILASREALES][GRID_COLUMNAS];
        createBlock(BLOQUE_I);
    }

    public void createBlock(int type) {

        switch (type) {

            case BLOQUE_I: block = new Tetromino(FORMA_I, BLOQUE_I); break;
            case BLOQUE_L: block = new Tetromino(FORMA_L, BLOQUE_L); break;
            case BLOQUE_J: block = new Tetromino(FORMA_J, BLOQUE_J); break;
            case BLOQUE_S: block = new Tetromino(FORMA_S, BLOQUE_S); break;
            case BLOQUE_Z: block = new Tetromino(FORMA_Z, BLOQUE_Z); break;
            case BLOQUE_T: block = new Tetromino(FORMA_T, BLOQUE_T); break;
            case BLOQUE_O: block = new Tetromino(FORMA_O, BLOQUE_O); break;

        }

    }

    public boolean blockIsNull() {
        return (block == null);
    }

    // Metodos de movimiento del bloque
    public boolean moverBloqueAbajo() {
        if (!blockIsNull()) {
            if ( checkBordeAbajo() == false && checkColisionAbajo() == false ) {
                block.moverAbajo();
                repaint();
                return true;
            } else {
                addBloqueBackground();
            }
        }
        return false;
    }

    public void moverBloqueDerecha() {
        if (checkBordeDerecho() == false && checkColisionDerecha() == false) {
            block.moverDerecha();
            repaint();
        }
    }

    public void moverBloqueIzquierda() {
        if (checkBordeIzquierdo() == false && checkColisionIzquierda() == false) {
            block.moverIzquierda();
            repaint();
        }
    }

    public void soltarBloque() {
        while (!blockIsNull()) {
            moverBloqueAbajo();
        }
    }

    // Metodos para rotar el bloque
    public void rotarBloqueAntiHorario() {
        block.rotarAntihorario();
        repaint();
    }

    public void rotarBloqueHorario() {
        block.rotarHorario();
        repaint();
    }

    public void rotarBloque180() {
        block.rotar180();
        repaint();
    }

    // Metodos tecnicos
    public boolean checkBordeAbajo() {

        if (block.getBordeInferior() == GRID_FILASREALES) {
            return true;
        }
        return false;
    }

    public boolean checkBordeIzquierdo() {
        if (block.getPosX() == 0)
            return true;
        return false;
    }

    public boolean checkBordeDerecho() {
        if (block.getPosX() + block.getWidth() == GRID_COLUMNAS)
            return true;
        return false;
    }

    // Recorre el bloque por filas de cada columna de manera inversa. Para cada celda que pueda colisionar
    public boolean checkColisionAbajo(){
        int[][] forma = block.getFormaActual();
        int w = block.getWidth();
        int h = block.getHeight();

        for (int columna = 0; columna < w; columna++) {
            for (int fila = h - 1; fila >= 0; fila--) {
                if (forma[fila][columna] != 0) {
                    int x = columna + block.getPosX();
                    int y = fila + block.getPosY() + 1;

                    if (y < 0) break;
                    if (gridBackground[y][x] != 0 ) return true;
                    break;
                }
            }
        }
        return false;
    }

    public boolean checkColisionIzquierda() {

        int[][] forma = block.getFormaActual();
        int w = block.getWidth();
        int h = block.getHeight();

        for (int fila = 0; fila < h; fila++) {
            for (int columna = 0; columna < w; columna++) {
                if (forma[fila][columna] != 0) {
                    int x = columna + block.getPosX() - 1;
                    int y = fila + block.getPosY();

                    if (y < 0) break;
                    if (gridBackground[y][x] != 0 ) return true;
                    break;
                }
            }
        }
        return false;
    }

    public boolean checkColisionDerecha() {

        int[][] forma = block.getFormaActual();
        int w = block.getWidth();
        int h = block.getHeight();

        for (int fila = 0; fila < h; fila++) {
            for (int columna = w - 1; columna >= 0; columna--) {
                if (forma[fila][columna] != 0) {
                    int x = columna + block.getPosX() + 1;
                    int y = fila + block.getPosY();

                    if (y < 0) break;
                    if (gridBackground[y][x] != 0 ) return true;
                    break;
                }
            }
        }
        return false;
    }



    public void addBloqueBackground() {

        for (int i = 0; i < block.getHeight(); i++) {
            for ( int j = 0; j < block.getWidth(); j++ ) {
                if (block.getCellForma(i,j) != 0) {
                    gridBackground[block.getPosY() + i][block.getPosX() + j] = (block.getCellForma(i,j) * block.getTipo());
                }

            }
        }
        deleteBloque();
    }

    private void deleteBloque() {
        this.block = null;
    }


    // Metodos de gráficos
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawGrid(g);
        drawBackground(g);
        if (!blockIsNull()) {
            drawBlock(g);
        }

    }

    private void drawGrid(Graphics g) {
        for(int columna = 0; columna < GRID_COLUMNAS; columna++) {
            for (int fila = 4; fila < GRID_FILASREALES; fila++) {
                g.drawRect(
                        gridCellSize * columna,
                        gridCellSize * fila,
                        gridCellSize,
                        gridCellSize
                );
            }
        }
    }

    private void drawBlock(Graphics g) {

        int width = block.getWidth();
        int height = block.getHeight();

        for(int fila = 0; fila < height; fila++) {

            for (int columna = 0; columna < width; columna++) {

                if (block.getFormaActual()[fila][columna] == 1) {

                    int x = gridCellSize * (block.getPosX() + columna);
                    int y = gridCellSize * (block.getPosY() + fila);

                    drawGridBlock(g, block.getColor(), x, y);
                }
            }
        }
    }

    public void drawGridBlock(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize);
        g.setColor(Color.black);
        g.drawRect(x, y, gridCellSize, gridCellSize);
    }

    private void drawBackground(Graphics g) {
        for (int fila = 0; fila < GRID_FILASREALES; fila++) {
            for (int columna = 0; columna < GRID_COLUMNAS; columna++) {

                int cell = gridBackground[fila][columna];

                if (cell != 0) {

                    int x = gridCellSize * columna;
                    int y = gridCellSize * fila;

                    drawGridBlock(g, ColorDecoder.getColorFromInt(cell), x, y);
                }
            }
        }
    }





}
