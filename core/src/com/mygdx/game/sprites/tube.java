package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by kt-uchiha on 05-02-2017.
 */

public class tube {
    public static final int Tube_width = 52;
    private static final int Fluctuation = 130;
    private static final int Tubegap = 100;
    private static final int Lowestube = 120;
    private Texture btube,ttube;
    private Vector2 tpos,bpos;
    private Random rand;
    private Rectangle boundstop , boundsbot;

    public tube(float x){
        btube = new Texture("bottomtube.png");
        ttube = new Texture("toptube.png");
        rand = new Random();
        tpos = new Vector2(x,rand.nextInt(Fluctuation) + Tubegap + Lowestube);
        bpos = new Vector2(x,tpos.y-Tubegap-btube.getHeight());

        boundstop = new Rectangle(tpos.x,tpos.y,ttube.getWidth(),ttube.getHeight());
        boundsbot = new Rectangle(bpos.x,bpos.y,btube.getWidth(),btube.getHeight());

    }

    public static int getFluctuation() {
        return Fluctuation;
    }

    public Vector2 getTpos() {
        return tpos;
    }

    public Vector2 getBpos() {
        return bpos;
    }

    public Texture getTtube() {
        return ttube;
    }

    public Texture getBtube() {
        return btube;
    }
    public void reposition(float x){
        tpos.set(x,rand.nextInt(Fluctuation) + Tubegap + Lowestube);
        bpos.set(x,tpos.y-Tubegap-btube.getHeight());
        boundstop.setPosition(tpos.x,tpos.y);
        boundsbot.setPosition(bpos.x,bpos.y);
    }
    public boolean collide(Rectangle player){
        return player.overlaps(boundstop) || player.overlaps(boundsbot);
    }
    public void dispose(){
        ttube.dispose();
        btube.dispose();
    }
}
