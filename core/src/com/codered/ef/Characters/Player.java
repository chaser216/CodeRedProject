package com.codered.ef.Characters;

public class Player {

    private static Character playerCharacter;
    private static Player singleton;

    private Player(){}

    private Player getInstance(){
        if(singleton == null){
            singleton = new Player();
        }
        return singleton;
    }


    public static void setPlayerCharacter(Character playerCharacter) {
        Player.playerCharacter = playerCharacter;
    }

    public static Character getPlayerCharacter(){
        return playerCharacter;
    }
}