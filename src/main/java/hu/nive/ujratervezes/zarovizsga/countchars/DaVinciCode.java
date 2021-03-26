package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaVinciCode {

    public int encode(String path, char ch) {
        if (!List.of('0', '1', 'x').contains(ch)) {
            throw new IllegalArgumentException("Wrong char!");
        }
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            return processLines(reader, ch);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private int processLines(BufferedReader reader, char ch) throws IOException {
        int result = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            result = getResultByLine(ch, result, line);
        }
        return result;
    }

    private int getResultByLine(char ch, int result, String line) {
        for (char item : line.toCharArray()) {
            if (item== ch) {
                result++;
            }
        }
        return result;
    }
}
