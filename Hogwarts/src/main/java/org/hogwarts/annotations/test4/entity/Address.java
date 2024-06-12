package org.hogwarts.annotations.test4.entity;


import org.hogwarts.annotations.test4.annotations.MaxLength;
import org.hogwarts.annotations.test4.annotations.MinLength;
import org.hogwarts.annotations.test4.annotations.NotEmpty;
import org.hogwarts.annotations.test4.annotations.ValidBean;

// ХОТИМ ПРОВЕРЯТЬ ЗНАЧЕНИЕ НАШИХ ПОЛЕЙ БЕЗ ПРИВЯЗКИ К СТРУКТУРЕ КЛАССА
@ValidBean("address")
public class Address {

    @MinLength(3)
    @MaxLength(10)
    @NotEmpty
    private String zip;
    @NotEmpty
    private String country;
    @NotEmpty
    private String addressLine;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
}
