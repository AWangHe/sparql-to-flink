package org.univalle.rdf.mapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class CreateJavaFlinkProgram {

    private String flinkProgram;
    private String fileName;

    public CreateJavaFlinkProgram(String flinkProgram, String fileName){
        this.flinkProgram = flinkProgram;
        this.fileName = fileName;
    }

    public void createJavaFP() {
        byte data[] = this.flinkProgram.getBytes();
        Path p = Paths.get("./" + this.fileName + ".java");
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE))) {
            out.write(data, 0, data.length);
            System.out.println("Java Program File created successfully...");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
