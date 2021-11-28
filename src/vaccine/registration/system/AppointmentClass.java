
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class AppointmentClass {
    private String Appoinment_Date, Appointment_Time, Status;
    private int Appointnment_ID, Dose_Numeber;
    // for add function (no need to be in class diagram)
    protected boolean Success_Save = false;
    protected boolean Exist = false;
        protected ArrayList<String> Appointment_Data = new ArrayList<>();

    AppointmentClass() {
        Appointnment_ID = 1;
    }
    public int getAppointnment_ID() {
        return Appointnment_ID;
    }
    public void setAppointnment_ID(int appointment_id) {
        Appointnment_ID = appointment_id;
    }
    public int getDose_Numeber() {
        return Dose_Numeber;
    }
    public void setDose_Numeber(int dose_number) {
        Dose_Numeber = dose_number;
    }
    public void setAppoinment_Date(String appointment_name) {
        Appoinment_Date = appointment_name;
    }
    public String getAppoinment_Date() {
        return Appoinment_Date;
    }
    public void setAppointment_Time(String appointment_time) {
        Appointment_Time = appointment_time;
    }
    public String getAppointment_Time() {
        return Appointment_Time;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getsetStatus() {
        return Status;
    }
    // for save (add and edit) function (no need to be in class diagram)
    public boolean getSuccess_Save() {
        return Success_Save;
    }
        public boolean getExist() {
        return Exist;
    }
    // data passing no need to be in class diagram
    public ArrayList<String> getAppointment_Data() {
        return Appointment_Data;
    }
    
    public void calculateAppointnment_ID() {
        String line;
        String[] line_array;
        String lastLine;
        try {
            FileReader appointment_file = new FileReader("Appointment.txt");
            BufferedReader appointment = new BufferedReader(appointment_file);

            while ((line = appointment.readLine()) != null) 
            {
                System.out.println(line);
                lastLine = line;
                line_array = lastLine.split("//");
                Appointnment_ID = Integer.parseInt(line_array[0]) + 1;
                System.out.println(Integer.parseInt(line_array[0]) + 1);
            }
            System.out.println(Appointnment_ID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    
    
    public void View_Appointment() {
        String line;
        Appointment_Data = new ArrayList<>();
        try {
            FileReader appointment_file = new FileReader("Appointment.txt");
            BufferedReader appointment = new BufferedReader(appointment_file);
        while ((line = appointment.readLine()) != null) {
            Appointment_Data.add(line);
            
        }
        appointment_file.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public void Check_Exist(String ic_passport_number) {
        String line;
        String[] line_array;
            try { 
                FileReader vaccine_file = new FileReader("People.txt");
                BufferedReader vaccine = new BufferedReader(vaccine_file);
                // Check ID
                while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (!line_array[4].equals(ic_passport_number)){
                        Exist = false;
                    } else {
                        Exist = true;
                    }
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        }

     
    //PeopleClass people_class = new PeopleClass();
    public void Add_Appointment(String people_id, String name, String ic_passport_number, String center_id, String center_name, String type) {
        String line;
        String[] line_array;
//        center_class.setCenter_ID(Integer.parseInt(id));
//        center_class.setCenter_Name(name);
        try (PrintWriter add_appointment = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", true)))) {
            try { 
                FileReader appointment_file = new FileReader("Appointment.txt");
                BufferedReader appointment = new BufferedReader(appointment_file);
                // Check ID
                while ((line = appointment.readLine()) != null) {
                    line_array = line.split("//");
                    if (!line_array[0].equals(Appointnment_ID)){
                        Success_Save = true;
                    } else {
                        Success_Save = false;
                    }
                }
                
                Success_Save = true;
                
                // calculate dose here
                if(Success_Save == true) {                   
                    //Insert data (not match)
                    add_appointment.append(Appointnment_ID + "//");
                    add_appointment.append(people_id + "//");
                    add_appointment.append(name + "//");
                    add_appointment.append(ic_passport_number + "//");
                    add_appointment.append(Appoinment_Date + "//");
                    add_appointment.append(Appointment_Time + "//");
                    add_appointment.append(center_id + "//");
                    add_appointment.append(center_name + "//");
                    add_appointment.append(type + "//");
                    
                    // add calcualte dose here 
                    
                    add_appointment.append(Status + "//");
                    add_appointment.print("\n");
                    add_appointment.close();
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

