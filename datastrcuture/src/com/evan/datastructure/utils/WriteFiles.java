package com.evan.datastructure.utils;

// Author : CSR丶SUSE
// Time ： 2021-12-20  18:43
// TOOLS : INTELLIJ IDEA
// FILENAME : WriteFiles.java
// STATEMENT: 


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFiles {
    public static void writeToFile(String filePath, Object data, boolean append) {
        if (filePath == null || data == null) return;

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                boolean mkdirs = file.getParentFile().mkdirs();
                if (mkdirs) {
                    boolean newFile = file.createNewFile();
                    if (newFile) {
                        System.out.println("file create success");
                    } else {
                        System.out.println("file create failed!");
                    }
                } else {
                    System.out.println("file not exists!");
                }

            }

            try (FileWriter writer = new FileWriter(file, append);
                 BufferedWriter out = new BufferedWriter(writer)) {
                out.write(data.toString());
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath, Object data) {
        writeToFile(filePath, data, false);
    }
}
