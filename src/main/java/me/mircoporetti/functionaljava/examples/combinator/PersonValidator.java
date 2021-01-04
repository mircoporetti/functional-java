package me.mircoporetti.functionaljava.examples.combinator;

import java.util.function.Function;

import static me.mircoporetti.functionaljava.examples.combinator.PersonValidator.*;
import static me.mircoporetti.functionaljava.examples.combinator.PersonValidator.PersonValidationResult.*;

public interface PersonValidator extends Function<Person, PersonValidationResult> {

    static PersonValidator isNameValid(){
        return person -> person.getName() == null || person.getName().isEmpty()  ? NOT_VALID_NAME : SUCCESS;
    }

    static PersonValidator isMailValid(){
        return person -> !person.getEmail().contains("@") ? NOT_VALID_EMAIL : SUCCESS;
    }

    static PersonValidator isPhoneValid(){
        return person -> person.getPhoneNumber().length() != 11 ? NOT_VALID_PHONE : SUCCESS;
    }

    default PersonValidator and (PersonValidator other){
        return person -> {
            PersonValidationResult result = this.apply(person);
            return result.equals(SUCCESS) ? other.apply(person) : result;
        };
    }

    enum PersonValidationResult{
        SUCCESS,
        NOT_VALID_NAME,
        NOT_VALID_EMAIL,
        NOT_VALID_PHONE
    }

}
