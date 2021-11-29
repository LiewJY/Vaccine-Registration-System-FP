
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class AppointmentClass {
    private String Appointment_Time, Status;
    private int Appointnment_ID, Dose_Numeber;
    // for add function (no need to be in class diagram)
    protected boolean Success_Save = false;
    protected boolean Exist = false;
    protected int count;
    protected ArrayList<String> Appointment_Data = new ArrayList<>();
    protected ArrayList<String> avaliable_location = new ArrayList<>();
    protected String Vaccine_ID;


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
    public int getCount() {
        return count;
    }
    // data passing no need to be in class diagram
    public ArrayList<String> getAppointment_Data() {
        return Appointment_Data;
    }
    public ArrayList<String> getAvaliableLocation() {
        return avaliable_location;
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
    

    
    PeopleClass people_class = new PeopleClass();
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
        Exist = false;
        try { 
            FileReader vaccine_file = new FileReader("People.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            // Check ID
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[4].equals(ic_passport_number)){
                    Exist = true;
                    people_class.setPeople_ID(Integer.parseInt(line_array[0]));
                     System.out.println("set id" + line_array[0]);
                }
            } 
        } catch (IOException c) {
            c.printStackTrace();
        }
    }
    public void Add_Dose() {
        String line;
        String[] line_array;
        try { 
            FileReader vaccine_file = new FileReader("Appointment.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            // Check ID
            count = 0;
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[1].equals(String.valueOf(people_class.getPeople_ID()))){
                    //System.out.println("id + 1  get " + people_class.getPeople_ID());
                    count = count + 1;
                } else {
                    //System.out.println("else  get " + people_class.getPeople_ID());
                }
            }
            Dose_Numeber = count;
        } catch (IOException c) {
            c.printStackTrace();
        }
    }
    public void Show_Locations(String date) {
        String line;
        String[] line_array;
        avaliable_location = new ArrayList<>();
        try { 
            FileReader vaccine_file = new FileReader("Vaccine.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            //edit line
             while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                System.out.println(line);
                if (line_array[3].equals(date)) {
                    avaliable_location.add(line);
                    System.out.println("added");
                } else {

                }
            }
            vaccine_file.close();
           } catch (IOException c) {
            c.printStackTrace();
        }
                    
    }
    
    public void Add_Vaccine_Id(String date, String center_id) {
        String line;
        String[] line_array;
        avaliable_location = new ArrayList<>();
        try { 
            FileReader vaccine_file = new FileReader("Vaccine.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            //edit line
             while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                System.out.println(line);
                if (line_array[3].equals(date) && line_array[7].equals(center_id)) {
                    avaliable_location.add(line);
                    Vaccine_ID = line_array[0];
                    System.out.println("added id" + line + "  " + Vaccine_ID);
                } else {

                }
            }
            vaccine_file.close();
           } catch (IOException c) {
            c.printStackTrace();
        }
    }
                    
    

     
    //PeopleClass people_class = new PeopleClass();
    public void Add_Appointment() {
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

                if(Success_Save == true) {                   
                    //Insert data (not match)
                    add_appointment.append(Appointnment_ID + "//");
                    add_appointment.append(people_class.getPeople_ID() + "//");
                    add_appointment.append(Vaccine_ID + "//");
                    add_appointment.append(Appointment_Time + "//");
                    add_appointment.append(Dose_Numeber + "//");                   
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
    
    
        public void Remove_Appointment() {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader vaccine_file = new FileReader("Appointment.txt");
                BufferedReader vaccine = new BufferedReader(vaccine_file);
                //edit line
                 while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Appointnment_ID))) {
                        //do nothing
                    } else {
                        temp_data.add(line);
                    }
                }
                vaccine_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt")))) {
            for (String new_data : temp_data) {
                edit_vaccine.println(new_data);
            }
            edit_vaccine.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
        public void Update_Appointment() {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader appointment_file = new FileReader("Appointment.txt");
                BufferedReader vaccine = new BufferedReader(appointment_file);
                //edit line
                 while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Appointnment_ID))) {
                        //Insert data
                        temp_data.add(Appointnment_ID + "//" 
                                + people_class.getPeople_ID()  + "//" 
                                + Vaccine_ID  + "//" 
                                + Appointment_Time  + "//" 
                                + Dose_Numeber   + "//" 
                                + Status   + "//");
                    } else {
                        temp_data.add(line);
                    }
                }
                appointment_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_appointment = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt")))) {
            for (String new_data : temp_data) {
                edit_appointment.println(new_data);
            }
            edit_appointment.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
        public void Update_Appointment_Status(String status) {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader appointment_file = new FileReader("Appointment.txt");
                BufferedReader vaccine = new BufferedReader(appointment_file);
                //edit line
                 while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Appointnment_ID))) {
                        
                        //Insert data
                        temp_data.add(Appointnment_ID + "//" 
                                + line_array[1]  + "//" 
                                + line_array[2]  + "//" 
                                + line_array[3]  + "//" 
                                + line_array[4]   + "//" 
                                + status   + "//");
                    } else {
                        temp_data.add(line);
                    }
                }
                appointment_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_appointment = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt")))) {
            for (String new_data : temp_data) {
                edit_appointment.println(new_data);
            }
            edit_appointment.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

