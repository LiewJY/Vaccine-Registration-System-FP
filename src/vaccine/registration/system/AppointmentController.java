/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author liewjy
 */
public class AppointmentController {
    // Calculate appointment ID

    public int calculateAppointnment_ID() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"));
        Integer id
                = reader.lines().map(line -> line.split("//"))
                        .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], data[4], data[5]))
                        .reduce((first, second) -> second)
                        .get()
                        .Appointnment_ID();
        return id + 1;
    }

    //view appointment
    public List<AppointmentRecord> View_Appointment() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"));
        return reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], data[4], data[5]))
                .collect(Collectors.toList());
    }

    // Check IC or passport number exist
    public CheckExistRecord Check_Exist(String ic_passport_number) throws FileNotFoundException {
        Optional<PeopleRecord> rec;
        BufferedReader reader = new BufferedReader(new FileReader("People.txt"));

        rec = reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(ids -> ids.IC_Passport_Number().equals(ic_passport_number)).findFirst();

        return new CheckExistRecord(rec.isPresent(), rec.isPresent() ? rec.get().People_ID() : 0);

    }

    public int Add_Dose(int People_ID) throws FileNotFoundException {
      BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"));

      reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(ids -> ids.People_ID() ==People_ID).findFirst();



      return 1;


    }




}
