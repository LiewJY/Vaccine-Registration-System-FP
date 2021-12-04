package vaccine.registration.system;

import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;


public class AppointmentClass {
    private String Appointment_Time, Status;
    private int Appointnment_ID, Dose_Number;
    
    // For add function
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
    
    public int getDose_Number() {
        return Dose_Number;
    }
    
    public void setDose_Number(int dose_number) {
        Dose_Number = dose_number;
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
    
    // For save (add and edit) function
    public boolean getSuccess_Save() {
        return Success_Save;
    }
    
    public boolean getExist() {
        return Exist;
    }
    
    public int getCount() {
        return count;
    }
    
    // Data passing
    public ArrayList<String> getAppointment_Data() {
        return Appointment_Data;
    }
    
    public ArrayList<String> getAvaliableLocation() {
        return avaliable_location;
    }
    
    
    // Calculate appointment ID
    public void calculateAppointnment_ID() {
        String line;
        String[] line_array;
        String lastLine;
        
        try {
            FileReader appointment_file = new FileReader("Appointment.txt");
            BufferedReader appointment = new BufferedReader(appointment_file);

            while ((line = appointment.readLine()) != null) {
                lastLine = line;
                line_array = lastLine.split("//");
                Appointnment_ID = Integer.parseInt(line_array[0]) + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    PeopleClass people_class = new PeopleClass();
    
    
    // View appointment
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Check IC or passport number exist
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
                }
            } 
        } catch (IOException c) {
            c.printStackTrace();
        }
    }
    
    
    // Add dose
    public void Add_Dose() {
        String line;
        String[] line_array;
        
        try { 
            FileReader vaccine_file = new FileReader("Appointment.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            
            // Check ID
            count = 1;
       
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");

                if (line_array[1].equals(String.valueOf(people_class.getPeople_ID())) ) {
                    count = count + 1;
                }
            }
            
            Dose_Number = count;
        } catch (IOException c) {
            c.printStackTrace();
        }
    }
    
    
    // Display location
    public void Show_Locations(String date) {
        String line;
        String[] line_array;
        avaliable_location = new ArrayList<>();
        
        try { 
            FileReader vaccine_file = new FileReader("Vaccine.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            
            // Edit line
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");

                if (line_array[3].equals(date)) {
                    avaliable_location.add(line);
                } else {
                    // Do nothing
                }
            }
            vaccine_file.close();
        } catch (IOException c) {
            c.printStackTrace();
        }                
    }
    
    
    // Add vaccine ID
    public void Add_Vaccine_Id(String date, String center_id) {
        String line;
        String[] line_array;
        avaliable_location = new ArrayList<>();
        
        try {
            FileReader vaccine_file = new FileReader("Vaccine.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            
            // Edit line
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[3].equals(date) && line_array[6].equals(center_id)) {
                    avaliable_location.add(line);
                    Vaccine_ID = line_array[0];
                } else {
                    // Do nothing
                }
            }
            vaccine_file.close();
        } catch (IOException c) {
            c.printStackTrace();
        }
    }
    
    
    // Add appointment
    public void Add_Appointment() {
        String line;
        String[] line_array;
        boolean data_exist = false;

        try (PrintWriter add_appointment = new PrintWriter(new BufferedWriter(new FileWriter("Appointment.txt", true)))) {
            try { 
                FileReader appointment_file = new FileReader("Appointment.txt");
                BufferedReader appointment = new BufferedReader(appointment_file);
                
                // Check ID
                while ((line = appointment.readLine()) != null) {
                    line_array = line.split("//");
                    
                    if (line_array[0].equals(String.valueOf(Appointnment_ID))){
                        Success_Save = false;
                        data_exist = true;
                        break;
                    } else {
                        Success_Save = true;
                        data_exist = false;
                    }
                }

                if (data_exist == false) {
                    if (Dose_Number > 2){
                        Success_Save = false;
                    } else {
                        // Insert data (not match)
                        add_appointment.append(Appointnment_ID + "//");
                        add_appointment.append(people_class.getPeople_ID() + "//");
                        add_appointment.append(Vaccine_ID + "//");
                        add_appointment.append(Appointment_Time + "//");
                        add_appointment.append(Dose_Number + "//");                   
                        add_appointment.append(Status + "//");
                        add_appointment.print("\n");
                        add_appointment.close();
                        Success_Save = true;
                    }
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Remove appointment
    public void Remove_Appointment() {
        String line;
        String[] line_array;
        ArrayList<String> temp_data = new ArrayList<>();
        
        try { 
            FileReader vaccine_file = new FileReader("Appointment.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);
            
            // Edit line
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(Appointnment_ID))) {
                    // Do nothing
                } else {
                    temp_data.add(line);
                }
            }
            vaccine_file.close();
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
    
    
    // Update appointment
    public void Update_Appointment() {
        String line;
        String[] line_array;
        ArrayList<String> temp_data = new ArrayList<>();
        
        try {
            FileReader appointment_file = new FileReader("Appointment.txt");
            BufferedReader vaccine = new BufferedReader(appointment_file);
            
            // Edit line
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(Appointnment_ID))) {
                    // Insert data
                    temp_data.add(Appointnment_ID + "//" 
                            + people_class.getPeople_ID()  + "//" 
                            + Vaccine_ID  + "//" 
                            + Appointment_Time  + "//" 
                            + line_array[4]   + "//" 
                            + line_array[5]   + "//");
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
    
    
    // Update appointment status
    public void Update_Appointment_Status(String status) {
        String line;
        String[] line_array;
        ArrayList<String> temp_data = new ArrayList<>();
        
        try { 
            FileReader appointment_file = new FileReader("Appointment.txt");
            BufferedReader vaccine = new BufferedReader(appointment_file);
            
            // Edit line
            while ((line = vaccine.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(Appointnment_ID))) {
                    // Insert data
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
