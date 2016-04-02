package cl.gamboa.games.base.pyxeledit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author Gamboa
 */
public class TileMap {
    
    private final int tileswide;
    private final int tileshigh;
    private final int tileheight;
    private final int tilewidth;
    private final int tilesonx;
    
    private final Array<Tile> tiles;
    private final Texture texture;
    
    public TileMap(int tileswide, int tileshigh, int tileheight, int tilewidth, int tilesonx, Array<Tile> tiles, Texture texture){
        this.texture     = texture;
        this.tileswide   = tileswide;
        this.tileshigh   = tileshigh;
        this.tileheight  = tileheight;
        this.tilewidth   = tilewidth;
        this.tilesonx    = tilesonx;
        this.tiles       = tiles;
    }
    
    public void render(SpriteBatch spriteBatch) {
        for(Tile tile : tiles){
            spriteBatch.draw(texture, 
                            tile.getX()*tilewidth, // x pos 
                            -tile.getY()*tileheight, // y pos
                            tilewidth,  // width
                            tileheight, // height
                            (tile.getTile() - tilesonx*((int)(tile.getTile()/tilesonx)))*tilewidth, // source x
                            ((int)(tile.getTile()/tilesonx))*tileheight, // source y
                            tilewidth,  // source width
                            tileheight, // source height
                            tile.isFlipX(), // x flip
                            false); // y flip
        }
    }
}
