package com.tetris.util;

import java.awt.*;

public interface TiposBloques {
    final int BLOQUE_I = 1,
            BLOQUE_L = 2,
            BLOQUE_Z = 5,
            BLOQUE_T = 6,
            BLOQUE_O = 7,
            BLOQUE_S = 4,
            BLOQUE_J = 3;

    final int[][][] FORMA_I = {
            {
                    {1},
                    {1},
                    {1},
                    {1},
            },
            {
                    {1,1,1,1}
            },
            {
                    {1},
                    {1},
                    {1},
                    {1},
            },
            {
                    {1,1,1,1}
            },
    };

    final int[][][] FORMA_L = {
            {
                    {1,0},
                    {1,0},
                    {1,1}
            },
            {
                    {1,1,1},
                    {1,0,0}
            },
            {
                    {1,1},
                    {0,1},
                    {0,1}
            },
            {
                    {0,0,1},
                    {1,1,1}
            }
    };

    final int[][][] FORMA_J = {
            {
                    {0,1},
                    {0,1},
                    {1,1}
            },
            {
                    {1,0,0},
                    {1,1,1}
            },
            {
                    {1,1},
                    {1,0},
                    {1,0}
            },
            {
                    {1,1,1},
                    {0,0,1}
            }
    };

    final int[][][] FORMA_S = {
            {
                    {0,1,1},
                    {1,1,0}
            },
            {
                    {1,0},
                    {1,1},
                    {0,1}
            },
            {
                    {0,1,1},
                    {1,1,0}
            },
            {
                    {1,0},
                    {1,1},
                    {0,1}
            }
    };

    final int[][][] FORMA_Z = {
            {
                    {1,1,0},
                    {0,1,1}
            },
            {
                    {0,1},
                    {1,1},
                    {0,1}
            },
            {
                    {1,1,0},
                    {0,1,1}
            },
            {
                    {0,1},
                    {1,1},
                    {0,1}
            }
    };

    final int[][][] FORMA_T = {
            {
                    {0,1,0},
                    {1,1,1}
            },
            {
                    {1,0},
                    {1,1},
                    {1,0}
            },
            {
                    {1,1,1},
                    {0,1,0}
            },
            {
                    {0,1},
                    {1,1},
                    {0,1}
            }

    };


    final int[][][] FORMA_O = {
            {
                    {1,1},
                    {1,1}
            },
            {
                    {1,1},
                    {1,1}
            },
            {
                    {1,1},
                    {1,1}
            },
            {
                    {1,1},
                    {1,1}
            }

    };

    final Color COLOR_I = Color.cyan;
    final Color COLOR_L = Color.orange;
    final Color COLOR_J = Color.blue;
    final Color COLOR_S = Color.green;
    final Color COLOR_Z = Color.red;
    final Color COLOR_T = Color.magenta;
    final Color COLOR_O = Color.yellow;


}
