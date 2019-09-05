package ru.sanysvo.rabotiagadrag;

import org.sikuli.script.App;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.Sikulix;

public class NoxPlayer {
    public App nox;
    private Region region;
    private Screen screen = new Screen();
    private static NoxPlayer noxPlayer;

    public static NoxPlayer getInstance(){
        if(noxPlayer==null){
            noxPlayer = new NoxPlayer();
        }
        return noxPlayer;
    }

    private NoxPlayer(){
        nox = new App("NoxPlayer");
        if(!nox.isRunning()){
            Sikulix.popup("Запустите Нокс!");
            System.exit(0);
        }
        region = nox.window(4);
    }

    public int getX(){
        return region.x;
    }

    public int getY(){
        return region.y;
    }

    public int getHeight(){
        return region.h;
    }

    public int getWidth(){
        return region.w;
    }

    public Screen getScreen(){
        screen.setRect(region);

        return screen;
    }
}
