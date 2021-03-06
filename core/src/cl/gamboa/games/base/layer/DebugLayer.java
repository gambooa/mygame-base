package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.MyCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Gamboa
 */
public class DebugLayer extends Layer {
    
    private float timePassed;
    private final BitmapFont font; 
    private final Vector2 hudPosition;
    private final Vector2 mousePosition;
    private final float lineHeight;
    private final float padding;
    private float fps;

    
    public DebugLayer(MyCamera camera, MyCamera hudCamera) {
        super(camera, hudCamera, true);
        font            = new BitmapFont();
        font.setColor(Color.YELLOW);
        hudPosition     = new Vector2();
        mousePosition   = new Vector2();
        lineHeight      = 18f;
        padding         = 10f;
    }    
    
    @Override
    public void update(float deltaTime){
        super.update(deltaTime);

        if (Gdx.input.isKeyPressed(Keys.T)) {
            camera.zoom += 0.01f;
        }
        if (Gdx.input.isKeyPressed(Keys.G)) {
            camera.zoom -= 0.01f;
        }
        
        hudPosition.x = hudCamera.getBounds().x + padding;
        hudPosition.y = hudCamera.getBounds().height - padding;

        timePassed     += deltaTime;
        mousePosition.x = Gdx.input.getX();
        mousePosition.y = Gdx.input.getY();
        fps             = Gdx.graphics.getFramesPerSecond();
        
        camera.update();
        hudCamera.update();
    }    
    
    @Override
    public void renderHud(SpriteBatch spriteBatch){
        super.render(spriteBatch);
        font.draw(spriteBatch, "STim: " + timePassed, hudPosition.x, hudPosition.y);
        font.draw(spriteBatch, "CPos X=" + camera.position.x + " Y=" + camera.position.y, hudPosition.x, hudPosition.y - lineHeight);
        font.draw(spriteBatch, "MPos X=" + mousePosition.x + " Y=" + mousePosition.y, hudPosition.x, hudPosition.y - 2f*lineHeight);
        font.draw(spriteBatch, "FPS: " + fps, hudPosition.x, hudPosition.y - 3f*lineHeight);
    }
    
}
