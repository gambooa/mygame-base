package cl.gamboa.games.base.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

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
        Texture text  = new Texture(Gdx.files.internal("img/abuelo.png"));
        text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        textures.put("abuelo", text);
        text  = new Texture(Gdx.files.internal("tilemaps/prueba-uno.png"));
        text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        textures.put("prueba-uno", text);
    }
    
    public Texture getTexture(String key){
        return textures.get(key);
    }
    
    public static TextureManager getInstance(){
        return INSTANCE;
    }
    
    public void dispose(){
        Iterator it = textures.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Texture> entry = (Map.Entry<String, Texture>)it.next();
            Texture text = (Texture) entry.getValue();
            text.dispose();
            it.remove();
        }
    }
}
