package me.devlisuu.synthesizer.gui;

import eu.pb4.sgui.api.elements.GuiElementBuilder;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

import static me.devlisuu.synthesizer.gui.GuiManager.*;
import static me.devlisuu.synthesizer.util.NoteTranslator.indexToNote;

public class PianoOctave2 {
    public static void addElements() {
        gui.setSlot(9, new GuiElementBuilder(Items.LIGHT_BLUE_STAINED_GLASS)
                .setName(new LiteralText("Note C").formatted(Formatting.AQUA))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(1), clickType)));
        gui.setSlot(10, new GuiElementBuilder(Items.BLUE_STAINED_GLASS)
                .setName(new LiteralText("Note D").formatted(Formatting.BLUE))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(2), clickType)));
        gui.setSlot(11, new GuiElementBuilder(Items.PURPLE_STAINED_GLASS)
                .setName(new LiteralText("Note E").formatted(Formatting.DARK_PURPLE))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(3), clickType)));
        gui.setSlot(12, new GuiElementBuilder(Items.GREEN_STAINED_GLASS)
                .setName(new LiteralText("Note F").formatted(Formatting.DARK_GREEN))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(4), clickType)));
        gui.setSlot(13, new GuiElementBuilder(Items.LIME_STAINED_GLASS)
                .setName(new LiteralText("Note G").formatted(Formatting.GREEN))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(5), clickType)));
        gui.setSlot(14, new GuiElementBuilder(Items.YELLOW_STAINED_GLASS)
                .setName(new LiteralText("Note A").formatted(Formatting.YELLOW))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(6), clickType)));
        gui.setSlot(15, new GuiElementBuilder(Items.RED_STAINED_GLASS)
                .setName(new LiteralText("Note B").formatted(Formatting.RED))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(7), clickType)));
        gui.setSlot(16, new GuiElementBuilder(Items.PINK_STAINED_GLASS)
                .setName(new LiteralText("Note C").formatted(Formatting.LIGHT_PURPLE))
                .setCallback((index, clickType, actionType) -> playNote(indexToNote(8), clickType)));
        gui.setSlot(17, new GuiElementBuilder(Items.QUARTZ_BLOCK)
                .setName(new LiteralText("Octave 1"))
                .setCallback(((index, type, action) -> changeOctave(type))));
    }
}
