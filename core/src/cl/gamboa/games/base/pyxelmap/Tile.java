package cl.gamboa.games.base.pyxelmap;

/**
 * @author Gamboa
 */
public class Tile {
    
    private final boolean flipX;
    private final int y;
    private final int rot;
    private final int tile;
    private final int index;
    private final int x;
    
    public Tile(boolean flipX, int y, int rot, int tile, int index, int x){
        this.flipX  = flipX;
        this.y      = y;
        this.rot    = rot;
        this.tile   = tile;
        this.index  = index;
        this.x      = x;
    }
    
    public boolean isFlipX() {
        return flipX;
    }

    public int getY() {
        return y;
    }

    public int getRot() {
        return rot;
    }

    public int getTile() {
        return tile;
    }

    public int getIndex() {
        return index;
    }

    public int getX() {
        return x;
    }
    
}
