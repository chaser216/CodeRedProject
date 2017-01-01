package com.codered.ef.Characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Interpolation;
import com.codered.ef.Utils;

public abstract class Character{// extends Thread{
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static OrthographicCamera camera;

    private String name;
    private int basicDamage;
    private int magicDamage;
    private int magicResistance;
    private int basicResistance;
    private int lifeStealPercentage;
    private boolean cooldownCheck = false;
    private Texture texture;
    public Sprite sprite;

    public Character(String name,
                     int basicDamage,
                     int basicResistance,
                     int magicDamage,
                     int magicResistance,
                     int lifeStealPercentage,
                     Texture texture){


        this.name = name;
        this.basicDamage = basicDamage;
        this.basicResistance = basicResistance;
        this.magicDamage = magicDamage;
        this.magicResistance = magicResistance;
        this.lifeStealPercentage = lifeStealPercentage;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setOriginCenter();
        this.sprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/4);
        camera =  new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public abstract void passiveAbility();
    public abstract void qAbility();
    public abstract void wAbility();
    public abstract void eAbility();
    public abstract void rAbility();

    public void move(float mouseX,float mouseY){
        Vector3 unprojected = camera.unproject(new Vector3(mouseX, mouseY , 0));
        //TODO RTS-like movement/
        sprite.setPosition(
                Utils.lerp(sprite.getX(), unprojected.x+Gdx.graphics.getWidth()/2-sprite.getWidth()/2, 0.05f),
                Utils.lerp(sprite.getY(), unprojected.y+Gdx.graphics.getHeight()/2-sprite.getHeight()/2, 0.05f)

        );
    }

    public void projectionPrint(){
        Vector3 unprojectedMouse = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        Vector3 unprojectedSprite = camera.unproject(new Vector3(this.sprite.getX(), this.sprite.getY(), 0));
        Vector3 projectedMouse = camera.project(new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0));
        Vector3 projectedSprite = camera.project(new Vector3(this.sprite.getX(), this.sprite.getY(),0));

        System.out.println(ANSI_WHITE  + "MOUSE X: "              + Gdx.input.getX()    + "; Y: " + Gdx.input.getY()    + ANSI_RESET);
        System.out.println(ANSI_RED    + "PROJECTED MOUSE X: "    + projectedMouse.x    + "; Y: " + projectedMouse.y    + ANSI_RESET);
        System.out.println(ANSI_BLUE   + "UNPROJECTED MOUSE X: "  + unprojectedMouse.x  + "; Y: " + unprojectedMouse.y  + ANSI_RESET);
        System.out.println(ANSI_CYAN   + "PROJECTED SPRITE X: "   + projectedSprite.x   + "; Y: " + projectedSprite.y   + ANSI_RESET);
        System.out.println(ANSI_GREEN  + "UNPROJECTED SPRITE X: " + unprojectedSprite.x + "; Y: " + unprojectedSprite.y + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "SPRITE X: "             + this.sprite.getX()  + "; Y: " + this.sprite.getY()  + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "CAMERA X: "             + camera.position.x   + "; Y: " + camera.position.y   + ANSI_RESET + "\n");
    }
}
