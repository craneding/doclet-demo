package com.dinghz.doclet;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author craneding
 * @date 16/5/7
 */
public class Main {

    public static void main(String[] args) {
        final String packageName = "com/dinghz/doclet/demo";

        final ArrayList argsList = new ArrayList();
        argsList.add("-doclet");
        argsList.add(DocDoclet.class.getName());

        final File srcDir = new File(new File("./src/main/java"), packageName);
        srcDir.list((dir, name) -> dir.isFile() && name.endsWith(".java"));

        Arrays.asList(srcDir.listFiles((dir, name) -> dir.isDirectory() && name.endsWith(".java")))
                .stream()
                .forEach(f -> argsList.add(f.getAbsolutePath()));

        com.sun.tools.javadoc.Main.execute((String[]) argsList.toArray(new String[]{}));
    }

}
