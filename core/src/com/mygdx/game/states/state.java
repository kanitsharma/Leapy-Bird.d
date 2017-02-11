package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by kt-uchiha on 05-02-2017.
 */

public abstract class state {
    protected OrthographicCamera cam;
    Vector3 mouse;
    GameStateManager gm;
    state(GameStateManager gm){
        this.gm = gm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    public abstract void handleinput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
