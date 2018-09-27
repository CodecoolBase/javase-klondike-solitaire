package com.codecool.klondike;

import java.util.*;
import java.util.Map.Entry;

public class Undoer {
    public enum ActionOwner {
        USER,
        GAME
    }

    private static Undoer instance;

    private final LinkedList<Entry<ActionOwner, Runnable>> undoSteps;

    private Undoer(){
        undoSteps = new LinkedList<>();
    }

    public void addAction(ActionOwner owner, Runnable undoStep) {
        Entry<ActionOwner, Runnable> step = new AbstractMap.SimpleEntry<>(owner, undoStep);

        undoSteps.push(step);
    }

    public void undoAction() {
        if(undoSteps.isEmpty()) return;

        Entry<ActionOwner, Runnable> lastStep = undoSteps.pop();
        lastStep.getValue().run();

        while(!undoSteps.isEmpty() && undoSteps.getLast().getKey() == ActionOwner.GAME) {
            lastStep = undoSteps.pop();
            lastStep.getValue().run();
        }
    }

    public static Undoer getInstance() {
        if(instance == null) {
            instance = new Undoer();
        }

        return instance;
    }
}
