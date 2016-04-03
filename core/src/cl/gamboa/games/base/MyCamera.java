package cl.gamboa.games.base;

import static cl.gamboa.games.base.MyGame.ASPECT_RATIO;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Gamboa
 */
public class MyCamera extends OrthographicCamera {
    
    private Rectangle viewport;
    
    public MyCamera(){
        super(MyGame.WIDTH, MyGame.HEIGHT);
        position.x = 0 + viewportWidth/2;
        position.y = 0 + viewportHeight/2;
        viewport = new Rectangle(0, 0, MyGame.WIDTH, MyGame.HEIGHT);
    }
    
    public void resize(int width, int height){
        // calculate new viewport
        float aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        if(aspectRatio > ASPECT_RATIO) {
            scale = (float)height/(float)MyGame.HEIGHT;
            crop.x = (width - MyGame.WIDTH*scale)/2f;
        }
        else if(aspectRatio < ASPECT_RATIO) {
            scale = (float)width/(float)MyGame.WIDTH;
            crop.y = (height - MyGame.HEIGHT*scale)/2f;
        } else {
            scale = (float)width/(float)MyGame.WIDTH;
        }

        float w = (float)MyGame.WIDTH*scale;
        float h = (float)MyGame.HEIGHT*scale;
        viewport.x = crop.x;
        viewport.y = crop.y;
        viewport.width = w;
        viewport.height = h;
    }
    
    @Override
    public void update(){
        super.update();
        if (null != viewport) {
            Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
                    (int) viewport.width, (int) viewport.height);
        }
    }
}
