package cl.gamboa.games.base.scene;

import cl.gamboa.games.base.entity.Player;
import cl.gamboa.games.base.layer.DebugLayer;
import cl.gamboa.games.base.layer.StaticLayer;
import cl.gamboa.games.base.pyxeledit.PyxelEditMapImporter;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author gamboa
 */
public class MenuScene extends Scene{
    
    public MenuScene() {
        super();
        PyxelEditMapImporter pmi = new PyxelEditMapImporter("prueba-uno");
        
        StaticLayer mainLayer = new StaticLayer();
        mainLayer.addEntity(new Player(new Vector2(0, 0), new Vector2(0, 0)));
        
        layers.add(pmi.getLayer("Layer 0")); // pmi returns a TiledLayer
        layers.add(mainLayer);
        layers.add(new DebugLayer());
    }
}
