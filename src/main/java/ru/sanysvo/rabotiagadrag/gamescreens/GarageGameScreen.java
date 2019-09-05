package ru.sanysvo.rabotiagadrag.gamescreens;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;
import ru.sanysvo.rabotiagadrag.NoxPlayer;
import ru.sanysvo.rabotiagadrag.PatternLoader;

public class GarageGameScreen extends GameScreen {


    @Override
    public void detected(NoxPlayer noxPlayer, Thread thread) {

        if(noxPlayer.getScreen().has(PatternLoader.BENZIN)){
            System.out.println("Бензин есть");
            try {
                noxPlayer.getScreen().click(new Location(noxPlayer.getX()+ 90,noxPlayer.getY()+ 700));
                noxPlayer.getScreen().wait(PatternLoader.GONKA2, 2).click();

            }catch (Exception e){
                System.out.println("Ошибка в гараже");
            }

        }
    }
}
