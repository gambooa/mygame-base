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
    
    private final Rectangle viewport;
    
    public MyCamera(){
        super(MyGame.WIDTH, MyGame.HEIGHT);
        zoom = MyGame.ZOOM_FACTOR;
        position.x = MyGame.WIDTH/2;
        position.y = MyGame.HEIGHT/2;
        viewport = new Rectangle(0, 0, MyGame.WIDTH, MyGame.HEIGHT);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(position.x - zoom*viewportWidth/2, position.y - zoom*viewportHeight/2, position.x + zoom*viewportWidth/2, position.y + zoom*viewportHeight/2);
    }
    
    public Rectangle getViewPort(){
        return viewport;
    }
    
    public void resize(int width, int height){
        float aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        if(aspectRatio > ASPECT_RATIO) {
            scale = (float)height/(float)MyGame.HEIGHT;
            crop.x = (width - MyGame.WIDTH*scale)/2f;
        }else if(aspectRatio < ASPECT_RATIO) {
            scale = (float)width/(float)MyGame.WIDTH;
            crop.y = (height - MyGame.HEIGHT*scale)/2f;
        } else {
            scale = (float)width/(float)MyGame.WIDTH;
        }

        viewport.x = crop.x;
        viewport.y = crop.y;
        viewport.width = (float)MyGame.WIDTH*scale;
        viewport.height = (float)MyGame.HEIGHT*scale;
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
