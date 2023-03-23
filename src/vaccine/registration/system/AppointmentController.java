/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
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
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
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

    //remove appointment
    public boolean Remove_Appointment(int Appointnment_ID) throws IOException {
        List<AppointmentRecord> appointmentList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Appointment.txt"));
        appointmentList = bufferedReader.lines().map(line -> line.split("//"))
        .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
        .filter(appointment -> appointment.Appointnment_ID() != Appointnment_ID)
                .collect(Collectors.toList());
        bufferedReader.close();
        // Write data
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", false)));
        appointmentList.stream()
                .forEach(app -> {
                    printWriter.printf("%s//%s//%s//%s//%s//%s//\n", app.Appointnment_ID(), app.People_ID(), app.Vaccine_ID(), app.Appointment_Time(), app.Dose_Number(), app.Status());
                });
        printWriter.close();
        return true;
    }

    //update appointment status
    public boolean Update_Appointment_Status(AppointmentUpdateRecord editAppointmentUpdateRecord) throws IOException {
        List<AppointmentRecord> appointmentList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Appointment.txt"));
        appointmentList = bufferedReader.lines()
                .map(line -> line.split("//"))
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = appointmentList.stream()
                .anyMatch(appointment -> appointment.Appointnment_ID() == editAppointmentUpdateRecord.Appointment_ID());
        if (!dataExist) {
            return false;
        } else {
            List<AppointmentRecord> updateAppointmentList = appointmentList.stream()
                    .map(appointment -> {
                        if (appointment.Appointnment_ID() == editAppointmentUpdateRecord.Appointment_ID()) {
                            return new AppointmentRecord(editAppointmentUpdateRecord.Appointment_ID(), appointment.People_ID(), appointment.Vaccine_ID(), appointment.Appointment_Time(), appointment.Dose_Number(), editAppointmentUpdateRecord.Status());
                        } else {
                            return appointment;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", false)));
            updateAppointmentList.stream()
                    .forEach(appointment -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//\n", appointment.Appointnment_ID(), appointment.People_ID(), appointment.Vaccine_ID(), appointment.Appointment_Time(), appointment.Dose_Number(), appointment.Status());
                    });
            printWriter.close();
            return true;
        }
    }

    //update appointment
    public boolean Update_Appointment(EditAppointmentRecord editAppointmentRecord) throws IOException {
        List<AppointmentRecord> appointmentList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Appointment.txt"));
        appointmentList = bufferedReader.lines()
                .map(line -> line.split("//"))
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = appointmentList.stream()
                .anyMatch(appointment -> appointment.Appointnment_ID() == editAppointmentRecord.Appointment_ID());
        if (!dataExist) {
            return false;
        } else {
            List<AppointmentRecord> updateAppointmentList = appointmentList.stream()
                    .map(appointment -> {
                        if (appointment.Appointnment_ID() == editAppointmentRecord.Appointment_ID()) {
                            return new AppointmentRecord(editAppointmentRecord.Appointment_ID(), editAppointmentRecord.People_ID(), editAppointmentRecord.Vaccine_ID(), editAppointmentRecord.Appointment_Time(), appointment.Dose_Number(), appointment.Status());
                        } else {
                            return appointment;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", false)));
            updateAppointmentList.stream()
                    .forEach(appointment -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//\n", appointment.Appointnment_ID(), appointment.People_ID(), appointment.Vaccine_ID(), appointment.Appointment_Time(), appointment.Dose_Number(), appointment.Status());
                    });
            printWriter.close();
            return true;
        }
    }

    // Add vaccine ID
    public int Add_Vaccine_Id(AddVaccineIDRecord addVaccineIDRecord) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Vaccine.txt"));
        return reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                .filter(vac -> vac.Center_ID() == Integer.parseInt(addVaccineIDRecord.Center_ID()) && vac.date().equals(addVaccineIDRecord.date()))
                .findFirst().get().Vaccine_ID();
    }

    //display location
    public List<VaccineRecord> Show_Locations(String date) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Vaccine.txt"));

        return reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                .filter(vac -> vac.date().equals(date))
                .collect(Collectors.toList());
    }

    //add dose
    public int Add_Dose(int People_ID) throws FileNotFoundException {
        BufferedReader appointment = new BufferedReader(new FileReader("Appointment.txt"));
        int dose = (int) appointment.lines()
                .map(line -> line.split("//"))
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
                .filter(app -> app.People_ID() == People_ID).count();

        return dose < 1 ? 1 : dose + 1;
    }

    // Add appointment
    public boolean Add_Appointment(AppointmentRecord newAppointmentRecord) throws IOException {
        boolean data_exist;
        PrintWriter add_appointment = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", true)));
        BufferedReader appointment = new BufferedReader(new FileReader("Appointment.txt"));
        //check for appointment id
        data_exist
                = appointment.lines()
                        .map(line -> line.split("//"))
                        .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
                        .anyMatch(app -> app.Appointnment_ID() == newAppointmentRecord.Appointnment_ID());

        if (!data_exist && newAppointmentRecord.Dose_Number() <=2) {
            // Insert data (not have record)
            add_appointment.append(newAppointmentRecord.Appointnment_ID() + "//" + newAppointmentRecord.People_ID() + "//" + newAppointmentRecord.Vaccine_ID() + "//" + newAppointmentRecord.Appointment_Time() + "//" + newAppointmentRecord.Dose_Number() + "//" + newAppointmentRecord.Status() + "//");
            add_appointment.print("\n");
            add_appointment.close();
            return true;
        }
        return false;
    }

    //edit appointment
    public boolean Update_Appointment(AppointmentRecord editAppointmentRecord) throws IOException {

        List<AppointmentRecord> appointmentList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Appointment.txt"));
        appointmentList = bufferedReader.lines()
                .map(line -> line.split("//"))
                .map(data -> new AppointmentRecord(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), data[5]))
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = appointmentList.stream()
                .anyMatch(appointment -> appointment.Appointnment_ID() == appointment.Appointnment_ID());

        if (!dataExist) {
            return false;
        } else {
            List<AppointmentRecord> updateAppointmentList = appointmentList.stream()
                    .map(app -> {
                        if (app.Appointnment_ID() == editAppointmentRecord.Appointnment_ID()) {
                            return new AppointmentRecord(editAppointmentRecord.Appointnment_ID(), editAppointmentRecord.People_ID(), 
                            editAppointmentRecord.Vaccine_ID(), editAppointmentRecord.Appointment_Time(), app.Dose_Number(), app.Status());
                        } else {
                            return app;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", false)));
            updateAppointmentList.stream()
                    .forEach(appointment -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//\n", appointment.Appointnment_ID(), appointment.People_ID(), appointment.Vaccine_ID(), appointment.Appointment_Time(), appointment.Dose_Number(), appointment.Status());
                    });
            printWriter.close();
            return true;
        }
    }


}
