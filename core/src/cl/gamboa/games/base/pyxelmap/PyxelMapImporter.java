package cl.gamboa.games.base.pyxelmap;

import cl.gamboa.games.base.layer.TiledLayer;
import cl.gamboa.games.base.manager.TextureManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import java.util.HashMap;

/**
 * @author Gamboa
 */
public class PyxelMapImporter {
    private final HashMap<String, TiledLayer> layers;
    
    public PyxelMapImporter(String tileName){
        layers = new HashMap<String, TiledLayer>();
        
        Texture texture = TextureManager.getInstance().getTexture(tileName);
        
        JsonValue json = new JsonReader().parse(Gdx.files.internal("tilemaps/" + tileName + ".json"));
        int tileswide = json.getInt("tileswide");
        int tileshigh = json.getInt("tileshigh");
        int tileheight = json.getInt("tileheight");
        int tilewidth = json.getInt("tilewidth");
        int tilesonx = texture.getWidth()/tilewidth;
        
        // We get the layers from the json file
        JsonValue jsonLayers = json.get("layers");
        for (JsonValue jsonLayer : jsonLayers.iterator()) {
            Array<Tile> tiles = new Array<Tile>();
            // this will be the key of our hashmap
            String layerName = jsonLayer.getString("name");
            JsonValue jsonTiles = jsonLayer.get("tiles");
            // Read every tile on the layer
            for (JsonValue jsonTile : jsonTiles.iterator()) {
                tiles.add(new Tile( jsonTile.getBoolean("flipX"), 
                                    jsonTile.getInt("y"), 
                                    jsonTile.getInt("rot"),
                                    jsonTile.getInt("tile"),
                                    jsonTile.getInt("index"),
                                    jsonTile.getInt("x")));
            }
            TileMap tileMap = new TileMap(tileswide, tileshigh, tileheight, tilewidth, tilesonx, tiles, texture);
            TiledLayer tiledLayer = new TiledLayer(tileMap);
            // add the layer to the hashmap
            layers.put(layerName, tiledLayer);
        }
    }
    
    public TiledLayer getLayer(String layerName){
        return layers.get(layerName);
    }
}
