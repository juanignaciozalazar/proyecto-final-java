package com.company;

import java.awt.*;

public interface TiposBloques {
    final int BLOQUE_I = 0;
    final int BLOQUE_L = 1;
    final int BLOQUE_J = 2;
    final int BLOQUE_S = 3;
    final int BLOQUE_Z = 4;
    final int BLOQUE_T = 5;
    final int BLOQUE_O = 6;

    final int[][] FORMA_I = {
            {1},
            {1},
            {1},
            {1},
    };

    final int[][] FORMA_L = {
            {1,0},
            {1,0},
            {1,1}
    };

    final int[][] FORMA_J = {
            {0,1},
            {0,1},
            {1,1}
    };

    final int[][] FORMA_S = {
            {0,1,1},
            {1,1,0}
    };

    final int[][] FORMA_Z = {
            {1,1,0},
            {0,1,1}
    };

    final int[][] FORMA_T = {
            {0,1,0},
            {1,1,1}
    };


    final int[][] FORMA_O = {
            {1,1},
            {1,1}
    };

    final Color COLOR_I = Color.cyan;
    final Color COLOR_L = Color.orange;
    final Color COLOR_J = Color.blue;
    final Color COLOR_S = Color.green;
    final Color COLOR_Z = Color.red;
    final Color COLOR_T = Color.magenta;
    final Color COLOR_O = Color.yellow;


}
