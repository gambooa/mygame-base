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
        PyxelEditMapImporter pmi = new PyxelEditMapImporter("prueba-uno", camera, hudCamera);
        
        StaticLayer mainLayer = new StaticLayer(camera, hudCamera);
        mainLayer.addEntity(new Player(new Vector2(camera.position.x, camera.position.y), new Vector2(0, 0)));
        
        layers.add(pmi.getLayer("bg")); // pmi returns a TiledLayer
        layers.add(mainLayer);
        layers.add(new DebugLayer(camera, hudCamera));
    }
}
