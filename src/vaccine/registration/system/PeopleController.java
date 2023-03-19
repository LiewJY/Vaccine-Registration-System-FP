/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author liewjy
 */
public class PeopleController {

    public int calculatePeople_ID() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
        Integer id
        = reader.lines().map(line -> line.split("//"))
                .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]))
                .reduce((first, second) -> second)
                .get()
                .People_ID();
        //read data to collection 
        // List<PeopleRecord> people = Files.lines(Paths.get("People.txt"))
        // .map(line -> line.split("//"))
        // .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]))
        // .collect(Collectors.toList());
   
        return id + 1;
    }

}
