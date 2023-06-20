package org.myorg.smudge-soft.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    public static List<String> getLinesFromFile(String filePath) throws IOException {

        LOGGER.info("Loading sample data list from file {}", filePath);
        List<String> lines = org.apache.commons.io.FileUtils.readLines(new File(filePath), "UTF-8");

        return lines;
    }
}