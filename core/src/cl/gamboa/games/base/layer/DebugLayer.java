package cl.gamboa.games.base.layer;

import cl.gamboa.games.base.manager.SceneManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Gamboa
 */
public class DebugLayer extends Layer {
    
    private float timePassed;
    private OrthographicCamera camera;
    private final BitmapFont font; 
    private final Vector2 hudPosition;
    private final Vector2 mousePosition;
    private int lineHeight;
    private float fps;
    
    public DebugLayer() {
        super();
        font = new BitmapFont();
        font.setColor(Color.YELLOW);
        hudPosition = new Vector2();
        mousePosition = new Vector2();
        lineHeight = 20;
    }
    
    @Override
    public void update(float deltaTime){
        super.update(deltaTime);
        camera = SceneManager.getInstance().getCurrentScene().getCamera();
        mousePosition.x = Gdx.input.getX();
        mousePosition.y = Gdx.input.getY();
        hudPosition.x = 0;
        hudPosition.y = 0 + camera.viewportHeight;
        timePassed += deltaTime;
        fps = Gdx.graphics.getFramesPerSecond();
    }    
    
    @Override
    public void render(SpriteBatch spriteBatch){
        super.render(spriteBatch);
        font.draw(spriteBatch, "STim: " + timePassed, hudPosition.x, hudPosition.y);
        font.draw(spriteBatch, "CPos X=" + camera.position.x + " Y=" + camera.position.y, hudPosition.x, hudPosition.y - lineHeight);
        font.draw(spriteBatch, "MPos X=" + mousePosition.x + " Y=" + mousePosition.y, hudPosition.x, hudPosition.y - 2*lineHeight);
        font.draw(spriteBatch, "FPS: " + fps, hudPosition.x, hudPosition.y - 3*lineHeight);
    }
    
}
