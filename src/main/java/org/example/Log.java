package org.example;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log{

    public Logger logger;
    FileHandler fileHandler;
    public Log(String logger_file) throws SecurityException, IOException {
        File file = new File(logger_file);
        fileHandler = new FileHandler(logger_file,true);
        logger = Logger.getLogger(logger_file);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.WARNING);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }


}
