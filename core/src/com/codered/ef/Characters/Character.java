package com.codered.ef.Characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.codered.ef.States.InGame;
import com.codered.ef.Utils;

public abstract class Character extends Thread{

    private static OrthographicCamera camera;

    public static String name;
    public int basicDamage;
    public int magicDamage;
    public int magicResistance;
    public int basicResistance;
    public int lifeStealPercentage;
    public Type type;
    public AttackType attack;
    public boolean cooldownCheck = false;
    public Texture texture;
    public Sprite sprite;

    public Character(String name,
                     int basicDamage,
                     int basicResistance,
                     int magicDamage,
                     int magicResistance,
                     int lifeStealPercentage,
                     Type type,
                     AttackType attack,
                     Texture texture){


        this.name = name;
        this.basicDamage = basicDamage;
        this.basicResistance = basicResistance;
        this.magicDamage = magicDamage;
        this.magicResistance = magicResistance;
        this.type = type;
        this.lifeStealPercentage = lifeStealPercentage;
        this.attack = attack;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setOriginCenter();
        this.sprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        camera =  new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public abstract void passiveAbility();
    public abstract void qAbility();
    public abstract void wAbility();
    public abstract void eAbility();
    public abstract void rAbility();
    public abstract boolean isOnCooldown();
    public abstract  void setOnCooldown(boolean cooldown);


    // TODO: vector2
    public void move(Vector3 unprojectedMouse){
        this.sprite.translate((unprojectedMouse.x+(Gdx.graphics.getWidth()/2)-this.sprite.getX())/250,
                              (unprojectedMouse.y+(Gdx.graphics.getHeight()/2)-this.sprite.getY())/250);

    }


    @Override
    public void run(){
        Vector3 unprojectedMouse; unprojectedMouse = camera.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
        while(true){
            if(sprite.getX() != unprojectedMouse.x && sprite.getY() == unprojectedMouse.y) {
                InGame.getCharacter().move(unprojectedMouse);
            } else break;

        }
        InGame.getCharacter().interrupt();
    }
}
