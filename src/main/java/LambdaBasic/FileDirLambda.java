package LambdaBasic;

import java.io.File;
import java.io.FileFilter;

public class FileDirLambda {

    public static void main(String[] args) {

       /* FileFilter filter = new FileFilter() {

            public boolean accept(File pathname) {

                return pathname.getName().endsWith(".java");
            }
        }; */

        FileFilter filter = (File pathname) -> pathname.getName().endsWith(".java");

        File dir = new File(".");

        File[] files = dir.listFiles(filter);

        for (File f : files) {

            System.out.println(f);

        }

    }
}
