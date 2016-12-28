package com.codered.ef.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.codered.ef.Characters.Character;
import com.codered.ef.Characters.Olympians.Gunslinger;
import com.codered.ef.ThreadMonitor;

public class InGame extends State{
    private static Character character = new Gunslinger();

    public InGame(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void update() {
            if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
                character.move();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
                character.qAbility();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                character.wAbility();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                character.eAbility();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                character.rAbility();
            }
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.draw(character.sprite, character.sprite.getX(), character.sprite.getY());
    }

    public static Character getCharacter(){
        return character;
    }

    public void setCharacter(Character c){
        this.character = c;
    }
}