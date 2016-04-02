package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.entity.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author gamboa
 */
public abstract class Layer {
    protected Array<Entity> entities;

    public Layer() {
        entities = new Array<Entity>();
    }
    
    public void addEntity(Entity entity){
        entities.add(entity);
    }
    
    public void render(SpriteBatch spriteBatch) {
        for(Entity entity : entities){
            entity.render(spriteBatch);
        }
    }
    
    public void update(float deltaTime){
        for(Entity entity : entities){
            entity.update(deltaTime);
        }
    }
}
