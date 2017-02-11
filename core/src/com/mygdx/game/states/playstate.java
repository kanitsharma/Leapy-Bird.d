package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.bird;
import com.mygdx.game.sprites.tube;

import static com.mygdx.game.sprites.tube.Tube_width;
import static java.lang.System.console;
import static java.lang.System.in;

/**
 * Created by kt-uchiha on 05-02-2017.
 */

public class playstate extends state {


    private bird bd;
    private Texture bg;
    private tube tb;
    private Texture ground;
    public static final int Tube_spacing = 125;
    public static final int Tube_count = 4;
    private static final int ground_y_offset = -50;
    private static Array<tube> tubes;
    private Vector2 groundpos1,groundpos2;


    playstate(GameStateManager gm) {
        super(gm);
        bd = new bird(40,300);
        bg = new Texture("bg.png");
        ground = new Texture("ground.png");
        groundpos1 = new Vector2(cam.position.x-cam.viewportWidth/2,ground_y_offset);
        groundpos2 = new Vector2((cam.position.x - cam.viewportWidth/2)+ground.getWidth(),ground_y_offset);
        tubes = new Array<tube>();
        for ( int i = 1;i<=Tube_count;i++){
            tubes.add( new tube(i*(Tube_spacing + Tube_width)));
        }
        cam.setToOrtho(false, MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
    }

    @Override
    public void handleinput() {

        if (Gdx.input.justTouched()){
            bd.jump();
        }

    }

    @Override
    public void update(float dt) {
        handleinput();
        updateground();
        bd.update(dt);
        cam.position.x = bd.getPosition().x + 80;

        for(tube tb : tubes){
            if (cam.position.x-(cam.viewportWidth/2)>tb.getTpos().x+tb.getTtube().getWidth())

            tb.reposition(tb.getTpos().x  + ((tb.Tube_width + Tube_spacing) * Tube_count));

            if(tb.collide(bd.getBoundbird())) {
                gm.setStates(new playstate(gm));
            }

        }

        if(bd.getPosition().y < ground.getHeight() + ground_y_offset){
            gm.setStates(new playstate(gm));
        }


        cam.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x-(cam.viewportWidth/2),0);
        sb.draw(bd.getBird(),bd.getPosition().x,bd.getPosition().y);
        for (tube tb : tubes) {
            sb.draw(tb.getTtube(), tb.getTpos().x, tb.getTpos().y);
            sb.draw(tb.getBtube(), tb.getBpos().x, tb.getBpos().y);
        }
        sb.draw(ground,groundpos1.x,groundpos1.y);
        sb.draw(ground,groundpos2.x,groundpos2.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bd.dispose();
        for (tube tb : tubes){
            tb.dispose();
        }
        ground.dispose();
        System.out.println("Playstate disposed");
    }
    public void updateground(){
        if(cam.position.x-(cam.viewportWidth/2)>groundpos1.x+ground.getWidth())
            groundpos1.add(ground.getWidth()*2,0);
        if(cam.position.x-(cam.viewportWidth/2)>groundpos2.x+ground.getWidth())
            groundpos2.add(ground.getWidth()*2,0);
    }
}
