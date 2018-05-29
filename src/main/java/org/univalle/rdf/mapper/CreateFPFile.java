package org.univalle.rdf.mapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class CreateFPFile {

    private String flinkProgram;
    private String fileName;

    public CreateFPFile(String flinkProgram, String fileName){
        this.flinkProgram = flinkProgram;
        this.fileName = fileName;
    }

    public void createFPFile() {
        byte data[] = this.flinkProgram.getBytes();
        //Path p = Paths.get("./src/main/java/org/univalle/ooca/" + this.fileName + ".java");
        Path p = Paths.get("./src/" + this.fileName + ".java");
        //Path p = Paths.get("./" + fileName + ".java");
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, TRUNCATE_EXISTING))) {
            out.write(data, 0, data.length);
            System.out.println("Java Program File << "+fileName+".java >> created successfully...");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
