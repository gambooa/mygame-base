package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.MyCamera;
import cl.gamboa.games.base.entity.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author gamboa
 */
public abstract class Layer {
    
    protected Array<Entity> entities;
    
    protected MyCamera camera;
    protected MyCamera hudCamera;
    
    protected boolean isHud;
        
    public Layer(MyCamera camera, MyCamera hudCamera) {
        entities        = new Array<Entity>();
        this.camera     = camera;
        this.hudCamera  = hudCamera;
        this.isHud      = false;
    }
    
    public Layer(MyCamera camera, MyCamera hudCamera, boolean isHud) {
        entities        = new Array<Entity>();
        this.camera     = camera;
        this.hudCamera  = hudCamera;
        this.isHud      = isHud;
    }
    
    public void addEntity(Entity entity){
        entities.add(entity);
    }
    
    public void render(SpriteBatch spriteBatch) {
        if (!isHud) {
            for(Entity entity : entities){
                entity.render(spriteBatch);
            }
        }
    }
    
    public void renderHud(SpriteBatch spriteBatch) {
        if (isHud) {
            for(Entity entity : entities){
                entity.render(spriteBatch);
            }
        }
    }
    
    public void update(float deltaTime){
        for(Entity entity : entities){
            entity.update(deltaTime);
        }
    }
}
