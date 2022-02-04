package me.devlisuu.synthesizer.gui;

import eu.pb4.sgui.api.ClickType;
import eu.pb4.sgui.api.elements.GuiElementBuilder;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

import static me.devlisuu.synthesizer.gui.GuiManager.*;
import static me.devlisuu.synthesizer.util.NoteTranslator.clicktypeToNote;

public class PianoCommon {
    public static void generateGui() {
        gui.setTitle(new LiteralText("Music Synthesizer"));

        gui.setSlot(32, new GuiElementBuilder(Items.QUARTZ_STAIRS)
                .setName(new LiteralText("Keyboard Playing"))
                .addLoreLine(new LiteralText("Keep this hovered and use 0-8 slot keys on your keyboard to play."))
                .addLoreLine(new LiteralText("Press 9 to change octave."))
                .setCallback((index, clickType, actionType) -> playNote(clicktypeToNote(clickType), ClickType.MOUSE_LEFT)));

        gui.setSlot(31, new GuiElementBuilder(Items.BARRIER)
                .setName(new LiteralText("Close").formatted(Formatting.RED))
                .setCallback((index, clickType, actionType) -> {
                    if(clickType != ClickType.MOUSE_LEFT && clickType != ClickType.MOUSE_RIGHT) return;
                    gui.close();
                }));

        if(secondOctave) {
            PianoOctave2.addElements();
        }else {
            PianoOctave1.addElements();
        }
    }
}
