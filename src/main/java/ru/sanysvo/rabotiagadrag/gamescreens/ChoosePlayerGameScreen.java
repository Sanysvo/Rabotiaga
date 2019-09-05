package ru.sanysvo.rabotiagadrag.gamescreens;

import org.sikuli.script.Location;
import org.sikuli.script.Match;
import ru.sanysvo.rabotiagadrag.NoxPlayer;
import ru.sanysvo.rabotiagadrag.PatternLoader;

public class ChoosePlayerGameScreen extends GameScreen {
    public static int countRace = 0;
    @Override
    public void detected(NoxPlayer noxPlayer, Thread thread) {
        try {
            System.out.println("Считаем число гонок");
            getCountRace(noxPlayer);
            Match match = noxPlayer.getScreen().find(PatternLoader.LST);
            Location loc = new Location(match.x,match.y - 20);
            noxPlayer.getScreen().click(loc);





        }catch (Exception e){

        }

    }

    private void getCountRace(NoxPlayer noxPlayer){
        try {
            countRace = 9 - noxPlayer.getScreen().findAllByColumn(PatternLoader.LST_COUNT.similar(0.8)).size();

        }catch (Exception e){
            countRace = 9;
        }


        System.out.println("Число гонок:" + countRace);
    }
}
