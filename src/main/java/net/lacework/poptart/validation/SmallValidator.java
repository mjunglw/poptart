package net.lacework.poptart.validation;

public class SmallValidator {
    public boolean validate(String str) {
        if (str == null) return false;

        return str.contains("small");
    }
}
