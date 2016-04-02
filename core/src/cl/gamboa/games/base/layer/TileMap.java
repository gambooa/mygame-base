package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.entity.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

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
    
    public TileMap(String jsonFile, Texture texture){
        
        this.texture = texture;
        
        JsonValue json = new JsonReader().parse(Gdx.files.internal(jsonFile));
        this.tileswide = json.getInt("tileswide");
        this.tileshigh = json.getInt("tileshigh");
        this.tileheight = json.getInt("tileheight");
        this.tilewidth = json.getInt("tilewidth");
        this.tilesonx = texture.getWidth()/tilewidth;
        
        tiles = new Array<Tile>();
        
        JsonValue jsonTiles = json.get("layers").get(0).get("tiles"); // The first layer of the tiledmap
        for (JsonValue jsonTile : jsonTiles.iterator()) {
            tiles.add(new Tile( jsonTile.getBoolean("flipX"), 
                                jsonTile.getInt("y"), 
                                jsonTile.getInt("rot"),
                                jsonTile.getInt("tile"),
                                jsonTile.getInt("index"),
                                jsonTile.getInt("x")));
        }
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
