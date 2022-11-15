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
            if ( checkFondo() == false ) {
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
        if (block.getPosX() + block.getWidth() < GRID_COLUMNAS) {
            block.moverDerecha();
            repaint();
        }
    }

    public void moverBloqueIzquierda() {
        if (block.getPosX() > 0) {
            block.moverIzquierda();
            repaint();
        }
    }


    // Metodos para rotar el bloque
    public void rotarBloqueAntiHorario() {
        block.getForma();
    }

    public void rotarBloqueHorario() {

    }

    public void rotarBloque180() {
    }

    // Metodos tecnicos
    public boolean checkFondo() {

        if (block.getBordeInferior() == GRID_FILASREALES) {
            return true;
        }
        return false;
    }

    public void addBloqueBackground() {

        for (int i = 0; i < block.getHeight(); i++) {
            for ( int j = 0; j < block.getWidth(); j++ ) {
                gridBackground[block.getPosY() + i][block.getPosX() + j] = (block.getCellForma(i,j) * block.getTipo());
            }
        }
        testPrintBackground();
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
        drawBlock(g);



    }

    private void drawGrid(Graphics g) {
        for(int columna = 0; columna < GRID_COLUMNAS; columna++) {
            for (int fila = 0; fila < GRID_FILASREALES; fila++) {
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

                if (block.getForma()[fila][columna] == 1) {

                    int x = gridCellSize * (block.getPosX() + columna);
                    int y = gridCellSize * (block.getPosY() + fila);

                    drawGridBlock(g, block.getColor(), x, y);
                }
            }
        }
    }

    public void drawGridBlock(Graphics g, Color color, int x, int y) {
        g.setColor(block.getColor());
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

    private void testPrintBackground() {
        for (int fila = 0; fila < GRID_FILASREALES; fila++) {
            for (int columna = 0; columna < GRID_COLUMNAS; columna++) {
                System.out.print(gridBackground[fila][columna]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }






}
