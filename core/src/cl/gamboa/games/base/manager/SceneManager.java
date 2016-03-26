package cl.gamboa.games.base.manager;

import cl.gamboa.games.base.scene.Scene;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 *
 * @author gamboa
 */
public class SceneManager {
    private static final SceneManager INSTANCE = new SceneManager();
    private final Stack<Scene> scenes;
    
    public SceneManager(){
        scenes = new Stack<Scene>();
    }
    
    public static SceneManager getInstance(){
        return INSTANCE;
    }
    
    public Scene getCurrentScene(){
        return scenes.peek();
    }
    
    public void push(Scene scene){
        scenes.push(scene);
    }
    
    public void pop(){
        scenes.pop();
    }
    
    public void set(Scene scene){
        scenes.pop();
        scenes.push(scene);
    }
    
    public void update(float deltaTime){
        scenes.peek().update(deltaTime);
    }
    
    public void render(SpriteBatch spriteBatch){
        scenes.peek().render(spriteBatch);
    }
}
