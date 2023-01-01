package com.lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambdaFileFilter {
    public static void main(String[] args) {

        /*FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };*/
        //instead of above anonymous class
        FileFilter filter = (File pathName) ->
                pathName.getName().endsWith(".java");

        File dir = new File("d:/tmp");
        File[] javaFiles = dir.listFiles(filter);

        for(File f : javaFiles){
            System.out.println(f);
        }
    }
}
