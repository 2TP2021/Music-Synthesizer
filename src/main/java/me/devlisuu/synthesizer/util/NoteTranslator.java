package me.devlisuu.synthesizer.util;

import eu.pb4.sgui.api.ClickType;

import static me.devlisuu.synthesizer.gui.GuiManager.changeOctave;


public class NoteTranslator {
    public static int indexToNote(Integer i) {
        switch(i) {
            case 1, 8 -> {return 6;}
            case 2 -> {return 8;}
            case 3 -> {return 10;}
            case 4 -> {return 11;}
            case 5 -> {return 1;}
            case 6 -> {return 3;}
            case 7 -> {return 5;}
        }
        return -1;
    }

    public static int clicktypeToNote(ClickType type) {
        switch(type) {
            case NUM_KEY_1, NUM_KEY_8 -> {return indexToNote(1);}
            case NUM_KEY_2 -> {return indexToNote(2);}
            case NUM_KEY_3 -> {return indexToNote(3);}
            case NUM_KEY_4 -> {return indexToNote(4);}
            case NUM_KEY_5 -> {return indexToNote(5);}
            case NUM_KEY_6 -> {return indexToNote(6);}
            case NUM_KEY_7 -> {return indexToNote(7);}
            case NUM_KEY_9 -> changeOctave(type);
        }
        return -1;
    }
}
