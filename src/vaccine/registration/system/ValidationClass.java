
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
    public String validationMessage(String type) {
        Message = switch (type) {
            case "name" -> "Please fill in alphabet only with length \nnot more than 50 for Name!";
            case "phone_number" -> "Please fill in number only with \nlength 10 to 11 for Phone Number!";
            case "ic_passport_number" -> "Please fill in alphabet and \nnumbers onnly for IC / Passport Number!";
            default -> "";
        };
        return Message;
    }
    
}
