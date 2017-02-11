package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by kt-uchiha on 05-02-2017.
 */

public class bird {
    public static final int GRAVITY = -15;
    private static final int Movement = 100;
    private Rectangle boundbird;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public bird(int x, int y){
        position = new Vector3(x,y,0);

        velocity = new Vector3(0,0,0);
        bird = new Texture("bird.png");
        boundbird = new Rectangle(x,y,bird.getWidth(),bird.getHeight());
    }
    public void update(float dt){
        if (position.y>0)
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(Movement*dt,velocity.y,0);
        if (position.y<0)
            position.y = 0;
        velocity.scl(1/dt);
        boundbird.setPosition(position.x,position.y);
    }
    public void jump(){
        velocity.y=300;
    }

    public Rectangle getBoundbird() {
        return boundbird;
    }
    public void dispose(){bird.dispose();}
}
