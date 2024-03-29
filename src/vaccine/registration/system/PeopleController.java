package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeopleController {

    Function<Integer, Integer> idIncrement = x -> x + 1;

    public int calculatePeople_ID() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
        int id
                = reader.lines().map(line -> line.split("//"))
                        .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                        .reduce((first, second) -> second)
                        .get()
                        .People_ID();

        return idIncrement.apply(id);
    }

}
