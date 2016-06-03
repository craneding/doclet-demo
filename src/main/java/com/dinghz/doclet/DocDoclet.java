package com.dinghz.doclet;

import com.dinghz.doclet.demo.TransInfo;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

import java.util.Arrays;

/**
 * @author craneding
 * @date 16/5/7
 */
public class DocDoclet {

    public static boolean start(RootDoc root) {
        ClassDoc[] classes = root.classes();

        for (int i = 0; i < classes.length; ++i) {
            println("------------------------------------------------------------");

            final ClassDoc classDoc = classes[i];

            println("包名:{} 类名:{}\n", classDoc.containingPackage().toString(), classDoc.name());

            // find @TransInfo
            Arrays.asList(classDoc.annotations())
                    .stream()
                    .filter(a -> a.toString().startsWith("@" + TransInfo.class.getName()))
                    .distinct()
                    .forEach(a -> System.out.println(a.elementValues()));

            // find methods
            println("方法总数:{}", classDoc.methods().length);

            for (int i1 = 0; i1 < classDoc.methods().length; i1++) {
                MethodDoc methodDoc = classDoc.methods()[i1];

                println("{}: {}", i1, methodDoc);
            }
        }

        return true;
    }

    static void println(String txt, Object... args) {
        if (args != null) {
            for (Object arg : args) {
                txt = txt.replaceFirst("\\{\\}", arg.toString());
            }
        }

        System.out.println(txt);
    }
}
