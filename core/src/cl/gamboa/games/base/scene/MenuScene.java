package cl.gamboa.games.base.scene;

import cl.gamboa.games.base.entity.Player;
import cl.gamboa.games.base.layer.StaticLayer;
import cl.gamboa.games.base.layer.TileMap;
import cl.gamboa.games.base.layer.TiledLayer;
import cl.gamboa.games.base.manager.TextureManager;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author gamboa
 */
public class MenuScene extends Scene{
    
    public MenuScene() {
        super();
        StaticLayer mainLayer = new StaticLayer();
        mainLayer.addEntity(new Player(new Vector2(0, 0), new Vector2(0, 0)));
        // Here we add the tilemap
        TileMap mTileMap = new TileMap("tilemaps/prueba-uno.json", TextureManager.getInstance().getTexture("prueba-uno"));
        TiledLayer tiledLayer = new TiledLayer(mTileMap);
        layers.add(tiledLayer);
        layers.add(mainLayer);
    }
}
