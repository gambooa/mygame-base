package cl.gamboa.games.base.scene;

import cl.gamboa.games.base.entity.Player;
import cl.gamboa.games.base.layer.StaticLayer;
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
        layers.add(mainLayer);
    }
}
