package com.codered.ef.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager{
    private Stack<State> states;
    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(){
        states.peek().update();
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
