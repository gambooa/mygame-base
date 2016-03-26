package cl.gamboa.games.base.scene;

import cl.gamboa.games.base.layer.Layer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author gamboa
 */
public abstract class Scene {
    protected OrthographicCamera camera;
    protected Array<Layer> layers;
    
    protected Scene(){
        camera = new OrthographicCamera();
        layers = new Array<Layer>();
    }
    
    public void update(float deltaTime) {
        for(Layer layer : layers){
            layer.update(deltaTime);
        }
    }
    public void render(SpriteBatch spriteBatch){
        spriteBatch.begin();
        for(Layer layer : layers){
            layer.render(spriteBatch);
        }
        spriteBatch.end();
    }
    
}
