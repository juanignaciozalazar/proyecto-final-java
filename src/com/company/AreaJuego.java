package com.company;

import javax.swing.*;
import java.awt.*;

public class AreaJuego extends JPanel implements TiposBloques {

    private int gridFilas;
    private int gridRealFilas;
    private int gridColumnas;
    private int gridCellSize;
    private Tetromino block;

    public AreaJuego(JPanel placeholder, int columns)
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());


        gridColumnas = columns;
        gridCellSize = this.getBounds().width / gridColumnas;
        gridFilas = this.getBounds().height / gridCellSize;

        createBlock(BLOQUE_T);
    }

    public void createBlock(int type) {

        switch (type) {

            case BLOQUE_I: block = new Tetromino(FORMA_I, COLOR_I); break;
            case BLOQUE_L: block = new Tetromino(FORMA_L, COLOR_L); break;
            case BLOQUE_J: block = new Tetromino(FORMA_J, COLOR_J); break;
            case BLOQUE_S: block = new Tetromino(FORMA_S, COLOR_S); break;
            case BLOQUE_Z: block = new Tetromino(FORMA_Z, COLOR_Z); break;
            case BLOQUE_T: block = new Tetromino(FORMA_T, COLOR_T); break;
            case BLOQUE_O: block = new Tetromino(FORMA_O, COLOR_O); break;

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

                    g.setColor(block.getColor());
                    g.fillRect(
                            x,
                            y,
                            gridCellSize,
                            gridCellSize
                    );

                    g.setColor(Color.black);
                    g.drawRect(
                            x,
                            y,
                            gridCellSize,
                            gridCellSize
                    );
                }
            }
        }
    }

    public void moverBloqueAbajo() {
        if ((block.getPosY() + block.getHeight())< gridFilas) {
            block.moverAbajo();
            repaint();
        }

    }

    public void moverBloqueDerecha() {
        if (block.getPosX() + block.getWidth() < gridColumnas) {
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

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(int columna = 0; columna < gridColumnas; columna++) {
            for (int fila = 0; fila < gridFilas; fila++) {
                g.drawRect(
                        gridCellSize * columna,
                        gridCellSize * fila,
                        gridCellSize,
                        gridCellSize
                );
            }
        }


        drawBlock(g);

    }

    private void snapBlock() {

    }

}
