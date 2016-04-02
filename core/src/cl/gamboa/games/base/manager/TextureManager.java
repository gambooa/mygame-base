package cl.gamboa.games.base.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;

/**
 *
 * @author gamboa
 */
public class TextureManager {
    private static final TextureManager INSTANCE = new TextureManager();
    
    private final HashMap<String, Texture> textures;
            
    public TextureManager(){
        textures = new HashMap<String, Texture>();
        loadTextures();
    }
    
    private void loadTextures(){
        textures.put("abuelo", new Texture(Gdx.files.internal("img/abuelo.png")));
        textures.put("prueba-uno", new Texture(Gdx.files.internal("tilemaps/prueba-uno.png")));
    }
    
    public Texture getTexture(String key){
        return textures.get(key);
    }
    
    public static TextureManager getInstance(){
        return INSTANCE;
    }
}
