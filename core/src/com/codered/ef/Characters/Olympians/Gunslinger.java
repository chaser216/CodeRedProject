package com.codered.ef.Characters.Olympians;


import com.badlogic.gdx.graphics.Texture;
import com.codered.ef.Characters.AttackType;
import com.codered.ef.Characters.Character;
import com.codered.ef.Characters.Type;

public class Gunslinger extends Character {

    public Gunslinger() {
        super("Gunslinger",
                50,
                25,
                2,
                15,
                15,
                Type.DPS,
                AttackType.RANGED,
                new Texture("Macheta.png"));
    }



    @Override
    public void passiveAbility() {
    }

    @Override
    public void qAbility() {

    }

    @Override
    public void wAbility() {

    }

    @Override
    public void eAbility() {

    }

    @Override
    public void rAbility() {

    }

    @Override
    public boolean isOnCooldown() {
        return cooldownCheck;
    }

    @Override
    public void setOnCooldown(boolean cooldown) {
        cooldownCheck = cooldown;
    }
}
