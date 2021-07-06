package net.lacework.poptart.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmallValidatorUnitTest {

    private SmallValidator smallValidator;

    @BeforeEach
    public void setup() {
        smallValidator = new SmallValidator();
    }

    @Test
    public void smallTest() {
        boolean actual = smallValidator.validate("small");

        assertTrue(actual);
    }
}
