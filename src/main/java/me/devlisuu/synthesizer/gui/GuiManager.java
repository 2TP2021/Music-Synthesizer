package me.devlisuu.synthesizer.gui;

import eu.pb4.sgui.api.ClickType;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.block.BlockState;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.minecraft.block.NoteBlock.INSTRUMENT;

public class GuiManager {
    public static SimpleGui gui;
    public static boolean secondOctave = false;

    private static BlockState state;
    private static World world;
    private static BlockPos pos;

    public static boolean openPlayGUI(ServerPlayerEntity serverPlayer, BlockState state, World world, BlockPos pos) {
        GuiManager.state = state;
        GuiManager.world = world;
        GuiManager.pos = pos;
        try{
            gui = new SimpleGui(ScreenHandlerType.GENERIC_9X4, serverPlayer, false);
            PianoCommon.generateGui();
            gui.open();

            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void changeOctave(ClickType clickType) {
        if(clickType != ClickType.MOUSE_LEFT && clickType != ClickType.MOUSE_RIGHT && clickType != ClickType.NUM_KEY_9) return;
        if(secondOctave) {
            secondOctave = false;
            PianoOctave1.addElements();
        }else {
            secondOctave = true;
            PianoOctave2.addElements();
        }
    }

    public static void playNote(Integer note, ClickType clickType){
        if(note == -1) return;
        if(clickType != ClickType.MOUSE_LEFT && clickType != ClickType.MOUSE_RIGHT) return;
        if(secondOctave) note += 12;

        float note2 = (float)Math.pow(2.0, (double)(note - 12) / 12.0);
        world.playSound(null, pos, state.get(INSTRUMENT).getSound(), SoundCategory.RECORDS, 3.0f, note2);
    }
}