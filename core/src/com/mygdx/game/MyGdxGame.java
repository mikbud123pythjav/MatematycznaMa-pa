package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter implements MechanicsInterface {
	Stage stage;
	SpriteBatch batch;
	Texture player;
	Texture banan;
	float Speed = 150.0f;
	float playerx = 0;
	float playery = 0;
	float timeSeconds = 0f;
	private float period = 1f;
	private MyGdxGame game;
	private MainMenuScreen mainMenuScreen;
	private Random bananaX;
	private Random bananaY;
	
	@Override
	public void create () {
		banan = new Texture("Banan_preview_rev_1.png");
		player = new Texture("malpka_preview_rev_1.png");
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
		game = new MyGdxGame();
		this.s
	}

	@Override
	public void render () {
		timeSeconds += Gdx.graphics.getDeltaTime();
		if(timeSeconds > period){
			timeSeconds -= period;
			handleEventBanana();
		}
		mainMenuScreen.dispose();



//		if(){
//
//		}








		Gdx.gl.glClearColor(1, 1, 1, 0);
		ScreenUtils.clear(1, 1, 1, 0);
		batch.begin();
		stage.draw();
		batch.draw(banan, 100, 100);
		batch.draw(player, playerx, playery);
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			System.out.printf("W\n");
			playery += Gdx.graphics.getDeltaTime()*Speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			System.out.printf("S\n");
			playery -= Gdx.graphics.getDeltaTime()*Speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			System.out.printf("A\n");
			playerx -= Gdx.graphics.getDeltaTime()*Speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			System.out.printf("D\n");
			playerx += Gdx.graphics.getDeltaTime()*Speed;
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void handleEventBanana() {
//		bananaX = (r.nextInt(1840));
//		bananaY = (r.nextInt(1000));
//		batch.draw(banan, (Integer)bananaX, bananaY);
//		balloon.x = rand_x;
//		balloon.y = rand_y;
//		System.out.println("deneme");
	}
	public void catchBananaEvent(){

	}

	public void handleEventQuestion() {

	}
	public void handleEvenetAnswerQuestion(){

	}
}


