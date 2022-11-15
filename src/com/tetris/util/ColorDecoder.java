package com.tetris.util;

import java.awt.*;

public class ColorDecoder implements TiposBloques {

    public static Color getColorFromInt(int code) {
        switch (code) {
            case BLOQUE_I: return COLOR_I;
            case BLOQUE_L: return COLOR_L;
            case BLOQUE_J: return COLOR_J;
            case BLOQUE_S: return COLOR_S;
            case BLOQUE_Z: return COLOR_Z;
            case BLOQUE_T: return COLOR_T;
            case BLOQUE_O: return COLOR_O;
            default: return Color.black;
        }
    }

}
