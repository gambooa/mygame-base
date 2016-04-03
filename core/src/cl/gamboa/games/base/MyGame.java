package cl.gamboa.games.base;

import cl.gamboa.games.base.manager.SceneManager;
import cl.gamboa.games.base.manager.TextureManager;
import cl.gamboa.games.base.scene.MenuScene;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MyGame extends ApplicationAdapter {
    
    public static final int WIDTH  = 8*16*2;
    public static final int HEIGHT = 11*16*2;
    public static final float ASPECT_RATIO =
        (float)WIDTH/(float)HEIGHT;
    
    public static final String TITLE = "My Game";
    
    private SpriteBatch spriteBatch;
    
    @Override
    public void create () {
        spriteBatch = new SpriteBatch();
        SceneManager.getInstance().push(new MenuScene());
        Gdx.gl.glClearColor(0, 0, 0, 1);
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SceneManager.getInstance().getCurrentScene().update(Gdx.graphics.getDeltaTime());
        SceneManager.getInstance().getCurrentScene().render(spriteBatch);
    }
    
    @Override
    public void resize(int width, int height) {
        SceneManager.getInstance().getCurrentScene().resize(width, height);
    }
    
    @Override
    public void dispose () {
        TextureManager.getInstance().dispose();
        spriteBatch.dispose();
    }    
}
