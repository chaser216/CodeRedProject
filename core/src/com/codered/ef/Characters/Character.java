package com.codered.ef.Characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public abstract class Character{//} extends Thread{

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

    public void move(){
        Vector3 unprojectedMouse = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        Vector3 unprojectedSprite = camera.unproject(new Vector3(this.sprite.getX(), this.sprite.getY(), 0));
        Vector3 projectedMouse = camera.project(new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0));
        Vector3 projectedSprite = camera.project(new Vector3(this.sprite.getX(), this.sprite.getY(),0));

        this.sprite.translate((unprojectedMouse.x-unprojectedSprite.x)/75,
                              (unprojectedMouse.y-unprojectedSprite.y)/75);

        camera.position.set(this.sprite.getX(), this.sprite.getY(), 0);

        System.out.println("PROJECTED MOUSE X: " + projectedMouse.x + "; Y: " + projectedMouse.y);
        System.out.println("PROJECTED SPRITE X: " + projectedSprite.x + "; Y: " + projectedSprite.y);
        System.out.println("UNPROJECTED MOUSE X: " + unprojectedMouse.x + "; Y: " + unprojectedMouse.y);
        System.out.println("UNPROJECTED SPRITE X: " + unprojectedSprite.x + "; Y: " + unprojectedSprite.y);
        System.out.println("SPRITE X: " + this.sprite.getX() + "; Y: " + this.sprite.getY());
        System.out.println("CAMERA X: " + camera.position.x + "; Y: " + camera.position.y + "\n");

        camera.update();
    }
}
