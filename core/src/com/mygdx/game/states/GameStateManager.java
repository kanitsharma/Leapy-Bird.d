package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by kt-uchiha on 05-02-2017.
 */
public class GameStateManager {

    private Stack<state> states;

    public GameStateManager(){
    states = new Stack<state>();
    }
    public void push(state state){
        states.push(state);
    }
    public void pop(){
        states.pop().dispose();
    }
    public void setStates(state state){
        states.pop();
        states.push(state);
    }
    public void update(float dt){
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

}
