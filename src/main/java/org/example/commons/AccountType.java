package org.example.commons;

//Enums are user defined data types
public enum AccountType {

    SAVINGS_ACCOUNT("savings"), CURRENT_ACCOUNT("current");         //Instances of enum AccountType

    private final String type;

    private AccountType(String type) {
        this.type = type;
    };

    public String getType() {
        return type;
    }
}
