package cl.gamboa.games.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author gamboa
 */
public abstract class Entity {
    
    protected Vector2 velocity;
    protected Vector2 position;
    protected Texture texture;
    
    public Entity(Texture texture, Vector2 position, Vector2 velocity){
        this.texture  = texture;
        this.position = position;
        this.velocity = velocity;
    }
    
    public abstract void update(float deltaTime);
    
    public void render(SpriteBatch spriteBatch){
        spriteBatch.draw(texture, position.x, position.y);
    }
    
    public Texture getTexture(){
        return texture;
    }
    
    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }
    
    public void setVelocity(int velX, int velY){
        velocity.x = velX;
        velocity.y = velY;
    }
            
    public Vector2 getPosition(){
        return position;
    }
    
    public Vector2 getVelocity(){
        return velocity;
    }
}
