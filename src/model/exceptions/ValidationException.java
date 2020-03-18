package model.exceptions;

import java.util.HashMap;
import java.util.Map;

//VALIDATION OF THE FIELDS THAT WILL BE FILLED IN - VALIDAÇÃO DOS CAMPOS QUE VÃO SER PREENCHIDOS
public class ValidationException extends RuntimeException{
    
    private Map<String, String> errors = new HashMap<>();
    
    public ValidationException(String msg) {
        super(msg);
    }
    
    public Map<String, String> getErrors() {
        return errors;
    }
    
    public void addError(String fieldName, String errorMassege) {
        errors.put(fieldName, errorMassege);
    }
}
