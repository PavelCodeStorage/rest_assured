package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJson {

    public String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
