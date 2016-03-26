package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.entity.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author gamboa
 */
public abstract class Layer {
    protected Texture texture;
    protected Array<Entity> entities;
    
    public Layer(Texture texture) {
        this.texture = texture;
        entities = new Array<Entity>();
    }
    
    public Layer() {
        this.texture = null;
        entities = new Array<Entity>();
    }
    
    public void addEntity(Entity entity){
        entities.add(entity);
    }
    
    public void render(SpriteBatch spriteBatch) {
        if(texture != null)
            spriteBatch.draw(texture, 0, 0);
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
