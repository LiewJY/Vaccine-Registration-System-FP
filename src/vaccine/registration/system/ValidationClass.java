
package vaccine.registration.system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationClass {
    // validation
    private String Message = "";
    private boolean Validate = false;
    public boolean validateName(String name) {
        // Name input validation
        String name_pattern_type = "^[a-zA-Z. ]{1,50}$";
        Pattern name_pattern = Pattern.compile(name_pattern_type);
        Matcher name_matcher = name_pattern.matcher(name);
        if(!name_matcher.matches()){
            Validate = true;
        } else {
            Validate = false;
        }
        return Validate;
    }
    public boolean validatePhoneNumber(String phone_number) {
        // Phone number input validation
        String phone_number_pattern_type = "^[0-9]{10,11}$";
        Pattern phone_number_pattern = Pattern.compile(phone_number_pattern_type);
        Matcher phone_number_matcher = phone_number_pattern.matcher(phone_number);
        
        if(!phone_number_matcher.matches()){
            Validate = true;
        } else {
            Validate = false;
        }
        return Validate;
    }
    public boolean validateICPassportNumber(String ic_passport_number) {
        // Phone number input validation
        String ic_passport_number_pattern_type = "^[A-Z0-9]{1,50}$";
        Pattern ic_passport_number_pattern = Pattern.compile(ic_passport_number_pattern_type);
        Matcher ic_passport_number_matcher = ic_passport_number_pattern.matcher(ic_passport_number);
        
        if(!ic_passport_number_matcher.matches()){
            Validate = true;
        } else {
            Validate = false;
        }
        return Validate;
    }
    public boolean validateVaccineBatchID(String vaccine_batch_id) {
            // Batch ID input validation
            String vaccine_batch_id_pattern_type = "^[0-9A-Z]{6,6}$";
            Pattern vaccine_batch_id_pattern = Pattern.compile(vaccine_batch_id_pattern_type);
            Matcher vaccine_batch_id_matcher = vaccine_batch_id_pattern.matcher(vaccine_batch_id);
        
        if(!vaccine_batch_id_matcher.matches()){
            Validate = true;
        } else {
            Validate = false;
        }
        return Validate;
    }
    public boolean validateVaccineAmount(String vaccine_amount) {
            // Amount input validation
            String vaccine_amount_pattern_type = "^[0-9]{1,5}$";
            Pattern vaccine_amount_pattern = Pattern.compile(vaccine_amount_pattern_type);
            Matcher vaccine_amount_matcher = vaccine_amount_pattern.matcher(vaccine_amount);
        
        if(!vaccine_amount_matcher.matches()){
            Validate = true;
        } else {
            Validate = false;
        }
        return Validate;
    }
    public String validationMessage(String type) {
        Message = switch (type) {
            case "name" -> "Please fill in alphabet only with length \nnot more than 50 for Name!";
            case "phone_number" -> "Please fill in number only with \nlength 10 to 11 for Phone Number!";
            case "ic_passport_number" -> "Please fill in alphabet and \nnumbers only for IC / Passport Number!";
            case "vaccine_batch_id"-> "Please fill in alphabet and number only with length \n of 6 for Vaccine Batch ID!";
            case "vaccine_amount"->"Please fill in number only with \nlength 1 to 5 for Vaccine Type!";
            case "date"->"Please select a date that is today or after today!";
            case "center"->"Please select a center or select another date as date selected has no avaliable center.";
            default -> "";
        };
        return Message;
    }
    
}
