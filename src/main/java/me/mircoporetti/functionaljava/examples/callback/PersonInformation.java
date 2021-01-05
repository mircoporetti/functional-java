package me.mircoporetti.functionaljava.examples.callback;

import java.util.function.Function;
import java.util.function.Supplier;

public class PersonInformation {

    static Function<String,String> requestGreetFor = (name)-> printName(name, () -> "Hi, is your name a secret?");

    private static String printName(String name, Supplier<String> getUnknownNameMessage){
        if(name != null && !name.isEmpty()){
            return "Hi " + name + "!";
        }else{
            return getUnknownNameMessage.get();
        }
    }
}
