package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.manager.SceneManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Gamboa
 */
public class DebugLayer extends Layer {
    
    private float timePassed;
    private OrthographicCamera camera;
    public DebugLayer() {
        super();
        camera = SceneManager.getInstance().getCurrentScene().getCamera();
    }
    
    @Override
    public void update(float deltaTime){
        super.update(deltaTime);
        timePassed += deltaTime;
    }    
    
    @Override
    public void render(SpriteBatch spriteBatch){
        super.render(spriteBatch);
    }
    
}
