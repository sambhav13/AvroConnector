package com.app.avro.producer;

/**
 * Created by samgupta0 on 3/26/2018.
 */

import java.util.StringTokenizer;

/**
 * Created by sunilpatil on 12/25/16.
 */
public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;

    public Contact() {

    }

    public Contact(int contactId, String firstName, String lastName) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void parseString(String csvStr) {
        StringTokenizer st = new StringTokenizer(csvStr, ",");
        contactId = Integer.parseInt(st.nextToken());
        firstName = st.nextToken();
        lastName = st.nextToken();
    }


    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
