package ru.sanysvo.rabotiagadrag;

import org.sikuli.script.Pattern;

public class PatternLoader {
    public static final Pattern BENZIN = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/benzin_on_main.bmp"));
    public static final Pattern GONKA = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/gonka_btn.bmp"));
    public static final Pattern GONKA2 = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/gonka_btn_2.bmp"));
    public static final Pattern GARAGE = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/garage.png"));
    public static final Pattern LST = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/lst.png"));
    public static final Pattern CHANGE_PLAYER = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/change_player.png"));
    public static final Pattern LST_COUNT = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/lst_count.png"));
    public static final Pattern BRAKE = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/brake.png"));
    public static final Pattern PEREGIM = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/peregim.png"));
    public static final Pattern OK_AFTER_RACE = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/ok_after_race.png"));
    public static final Pattern NEXT_RACE = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/next_race.png"));
    public static final Pattern OK_ERROR = new Pattern(PatternLoader.class.getClassLoader().getResource("drag/error_ok.png"));
}
