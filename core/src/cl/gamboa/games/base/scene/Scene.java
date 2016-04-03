package cl.gamboa.games.base.scene;

import cl.gamboa.games.base.MyCamera;
import cl.gamboa.games.base.layer.Layer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author gamboa
 */
public abstract class Scene {
    protected MyCamera camera;
    protected MyCamera hudCamera;
    protected Array<Layer> layers;
    
    protected Scene(){
        camera = new MyCamera();
        hudCamera = new MyCamera();
        layers = new Array<Layer>();
    }
    public MyCamera getHudCamera(){
        return hudCamera;
    }
    public MyCamera getCamera(){
        return camera;
    }
    
    public void resize(int width, int height) {
        hudCamera.resize(width, height);
        camera.resize(width, height);
    }    
    
    public void update(float deltaTime) {
        hudCamera.update();
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
        
        spriteBatch.begin();
        spriteBatch.setProjectionMatrix(hudCamera.combined);
        for(Layer layer : layers){
            layer.renderHud(spriteBatch);
        }
        spriteBatch.end();
    }
    
}
