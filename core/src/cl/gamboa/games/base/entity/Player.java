package cl.gamboa.games.base.entity;

import cl.gamboa.games.base.manager.TextureManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author gamboa
 */
public class Player extends Entity{

    public static final int VELOCITY = 100;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isMovingUp;
    private boolean isMovingDown;
    
    public Player(Vector2 position, Vector2 velocity) {
        super(TextureManager.getInstance().getTexture("abuelo"), position, velocity);
        
        isMovingDown = false;
        isMovingLeft = false;
        isMovingRight = true;
        isMovingUp = false;
    }
    
    private void moveLeft(float deltaTime){
        velocity.x = -VELOCITY;
        velocity.scl(deltaTime);
        position.add(velocity);
        isMovingLeft  = true;
        isMovingRight = false;
        isMovingDown = false;
        isMovingUp = false;
    }
    
    private void moveRight(float deltaTime){
        velocity.x = VELOCITY;
        velocity.scl(deltaTime);
        position.add(velocity);
        isMovingLeft  = false;
        isMovingRight = true;
        isMovingDown = false;
        isMovingUp = false;
    }
    
    @Override
    public void render(SpriteBatch spriteBatch){
        spriteBatch.draw(texture, position.x, position.y,
            texture.getWidth(), texture.getHeight(), 0, 0,
            texture.getWidth(), texture.getHeight(), isMovingLeft, isMovingDown);
    }
    
    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            moveLeft(deltaTime);
        }else if(Gdx.input.isKeyPressed(Keys.D)) {
            moveRight(deltaTime);
        }
    }

}
