package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

/*
 * Character class
 */
public class Character {
	

	private float x;

	void create() {
	Rectangle Blizzard;
	Blizzard = new Rectangle();
	Blizzard.width = 64;
	Blizzard.height = 64;
	Blizzard.x = 400;
	Blizzard.y = 20;
	
	}
	
	void Movement() {
	Character Blizzard = new Character();

	if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		Blizzard.x -= 200 * Gdx.graphics.getDeltaTime();
	if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		Blizzard.x += 200* Gdx.graphics.getDeltaTime();
	}

}
