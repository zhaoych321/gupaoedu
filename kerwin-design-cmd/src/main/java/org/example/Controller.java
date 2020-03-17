package org.example;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    static List<ICmd> cmds = new ArrayList<>();

    public static void addCmd(ICmd cmd) {
        cmds.add(cmd);
    }

    public static void execute() {
        for (ICmd cmd : cmds) {
            cmd.execute();
        }
        cmds.clear();
    }

    public static void execute(ICmd cmd) {
        cmd.execute();
    }
}
