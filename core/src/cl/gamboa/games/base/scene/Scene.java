package cl.gamboa.games.base.scene;

import cl.gamboa.games.base.MyCamera;
import cl.gamboa.games.base.MyGame;
import cl.gamboa.games.base.layer.Layer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author gamboa
 */
public abstract class Scene {
    protected MyCamera camera;
    protected Array<Layer> layers;
    
    protected Scene(){
        camera = new MyCamera();
        layers = new Array<Layer>();
    }
    
    public MyCamera getCamera(){
        return camera;
    }
    
    public void resize(int width, int height) {
        camera.resize(width, height);
    }    
    
    public void update(float deltaTime) {
        camera.update();
        for(Layer layer : layers){
            layer.update(deltaTime);
        }
    }
    public void render(SpriteBatch spriteBatch){
        spriteBatch.begin();
        spriteBatch.setProjectionMatrix(camera.combined);
        for(Layer layer : layers){
            layer.render(spriteBatch);
        }
        spriteBatch.end();
    }
    
}
