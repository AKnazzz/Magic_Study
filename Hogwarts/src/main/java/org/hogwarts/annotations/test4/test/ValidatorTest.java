package org.hogwarts.annotations.test4.test;

import org.hogwarts.annotations.test4.annotations.Email;
import org.hogwarts.annotations.test4.annotations.MaxLength;
import org.hogwarts.annotations.test4.annotations.MinLength;
import org.hogwarts.annotations.test4.annotations.NotEmpty;
import org.hogwarts.annotations.test4.entity.Address;
import org.hogwarts.annotations.test4.entity.Person;
import org.hogwarts.annotations.test4.impl.AnnotationBasedBeanValidator;
import org.hogwarts.annotations.test4.impl.EmailFieldValidator;
import org.hogwarts.annotations.test4.impl.MaxLengthFieldValidator;
import org.hogwarts.annotations.test4.impl.MinLengthFieldValidator;
import org.hogwarts.annotations.test4.impl.NotEmptyFieldValidator;
import org.hogwarts.annotations.test4.valid_clases.BrokenField;
import org.hogwarts.annotations.test4.valid_clases.ValidationResult;
import org.hogwarts.annotations.test4.valid_interfaces.BeanValidator;
import org.hogwarts.annotations.test4.valid_interfaces.FieldValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class ValidatorTest {

    private BeanValidator beanValidator;

    @Before
    public void initValidator() {

        Map<Class<? extends Annotation>, FieldValidator> validatorMap = new HashMap<>();
        validatorMap.put(MaxLength.class, new MaxLengthFieldValidator());
        validatorMap.put(MinLength.class, new MinLengthFieldValidator());
        validatorMap.put(NotEmpty.class, new NotEmptyFieldValidator());
        validatorMap.put(Email.class, new EmailFieldValidator());
        beanValidator = new AnnotationBasedBeanValidator(validatorMap);
    }

    @Test
    public void shouldFailValidationOnEmailField() {

        Person person = new Person();
        person.setFirstName("Beverlee");
        person.setLastName("Skahill");
        person.setLogin("secret_login");
        person.setPassword("secret_password");
        person.setEmail("Beverlee@.com");

        ValidationResult result = beanValidator.validate(person);
        Assert.assertNotNull(result);
        List<BrokenField> brokenFields = result.getBrokenFields();
        Assert.assertEquals(1, brokenFields.size());

        BrokenField brokenField = brokenFields.get(0);
        Assert.assertEquals("email", brokenField.getViolatedRule());
        Assert.assertEquals("Beverlee@.com", brokenField.getFieldValue());
        Assert.assertEquals("email", brokenField.getFieldName());
    }

    @Test
    public void shouldFailValidationOnLoginField() {

        Person person = new Person();
        person.setFirstName("Beverlee");
        person.setLastName("Skahill");
        person.setLogin("123");
        person.setPassword("secretsecret");

        ValidationResult result = beanValidator.validate(person);
        Assert.assertNotNull(result);
        List<BrokenField> brokenFields = result.getBrokenFields();
        Assert.assertEquals(1, brokenFields.size());

        BrokenField brokenField = brokenFields.get(0);
        Assert.assertEquals("minLength", brokenField.getViolatedRule());
        Assert.assertEquals("123", brokenField.getFieldValue());
        Assert.assertEquals("login", brokenField.getFieldName());
    }

    @Test
    public void shouldFailOnEmptyZipCodeField() {

        Address address = new Address();
        address.setAddressLine("672 Bayside Street");
        address.setZip(null);
        address.setCountry("US");

        ValidationResult result = beanValidator.validate(address);
        Assert.assertNotNull(result);
        List<BrokenField> brokenFields = result.getBrokenFields();
        Assert.assertEquals(1, brokenFields.size());
        BrokenField brokenField = brokenFields.get(0);
        Assert.assertEquals("notEmpty", brokenField.getViolatedRule());
        Assert.assertNull(brokenField.getFieldValue());
        Assert.assertEquals("zip", brokenField.getFieldName());
    }

    @Test
    public void shouldFailOnLongZipCodeField() {

        Address address = new Address();
        address.setAddressLine("672 Bayside Street");
        address.setZip("952-1203 594");
        address.setCountry("US");

        ValidationResult result = beanValidator.validate(address);
        Assert.assertNotNull(result);
        List<BrokenField> brokenFields = result.getBrokenFields();
        Assert.assertEquals(1, brokenFields.size());
        BrokenField brokenField = brokenFields.get(0);
        Assert.assertEquals("maxLength", brokenField.getViolatedRule());
        Assert.assertEquals("952-1203 594", brokenField.getFieldValue());
        Assert.assertEquals("zip", brokenField.getFieldName());
    }
}
