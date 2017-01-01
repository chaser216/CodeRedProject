package com.codered.ef.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.codered.ef.Characters.Character;
import com.codered.ef.Characters.Olympians.Gunslinger;

public class InGame extends State{
    private static Character character = new Gunslinger();
    private static final Vector2 STARTING_POSITION = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    private float mouseX = STARTING_POSITION.x,
            mouseY = STARTING_POSITION.y;

    public InGame(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void update() {
          if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
              mouseX = Gdx.input.getX();
              mouseY = Gdx.input.getY();

          }
            character.move(mouseX, mouseY);

      /*      } else if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
                character.qAbility();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                character.wAbility();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                character.eAbility();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                character.rAbility();
            } */

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(character.sprite, character.sprite.getX(), character.sprite.getY());
    }

    public static Character getCharacter(){
        return character;
    }

    public static void setCharacter(Character c){
        character = c;
    }
}