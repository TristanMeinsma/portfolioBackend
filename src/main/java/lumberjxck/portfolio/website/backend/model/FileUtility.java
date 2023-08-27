package lumberjxck.portfolio.website.backend.model;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Tristan Meinsma
 * Dit zorgt voor het importeren van files naar de database
 */
public class FileUtility {

    public static byte[] readFileToByteArray(String path) throws IOException {
        try (InputStream input = Files.newInputStream(Paths.get(path))) {
            return IOUtils.toByteArray(input);
        }
    }
}

