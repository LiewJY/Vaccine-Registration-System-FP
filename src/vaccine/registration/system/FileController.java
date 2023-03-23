/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

/**
 *
 * @author liewjy
 */
public class FileController {

    public Stream fileAccess(String filename) throws FileNotFoundException  {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.lines().map(line -> line.split("//"));
    }
}
