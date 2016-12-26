package com.codered.ef;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codered.ef.States.GameStateManager;
import com.codered.ef.States.InGame;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
//	Texture img;
	GameStateManager gsm;

	@Override
	public void create () {
		batch = new SpriteBatch();
//		img = new Texture("MACHETA.png");
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 0.01f);
		gsm.push(new InGame(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update();
		batch.begin();
		gsm.render(batch);
		batch.end();


//		gsm.update(Gdx.graphics.getDeltaTime());
//		gsm.render(batch);
//		batch.begin();
//		batch.draw(img, Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth()/2);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
