package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.pyxeledit.TileMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Gamboa
 */
public class TiledLayer extends Layer{
    
    private final TileMap tileMap;
    
    public TiledLayer(TileMap tileMap) {
        super();
        this.tileMap = tileMap;
    }
    
    @Override
    public void render(SpriteBatch spriteBatch){
        tileMap.render(spriteBatch);
        super.render(spriteBatch);
    }
}
