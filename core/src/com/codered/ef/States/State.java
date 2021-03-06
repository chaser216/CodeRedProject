package com.codered.ef.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public abstract class State {
//    protected OrthographicCamera cam;
//    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
//        cam = new OrthographicCamera();
//        mouse = new Vector3();
    }

    public abstract void update();
    public abstract void render(SpriteBatch sb);
}
