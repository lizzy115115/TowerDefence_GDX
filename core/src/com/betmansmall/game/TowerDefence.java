package com.betmansmall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;


/**
 * Created by BetmanSmall on 13.10.2015.
 */
public class TowerDefence extends Game {
    public Screen mainMenu;

    private static volatile TowerDefence instance;

    public static TowerDefence getInstance() {
        TowerDefence localInstance = instance;
        if (localInstance == null) {
            synchronized (TowerDefence.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TowerDefence();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void create() {
//        Gdx.graphics.setDisplayMode(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),true);
        instance = this;
        mainMenu = new MainMenuScreen(this);
        setMainMenu(null);
    }

    public void setMainMenu(Screen toDel) {
        this.setScreen(mainMenu);
        if (toDel != null) {
            toDel.dispose();
        }
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        mainMenu.dispose();
        getScreen().dispose();
        closeApplication();
    }

    public void closeApplication(){
        Gdx.app.exit();
    }
}
