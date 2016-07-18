package com.gav;

import java.util.ArrayList;

/**
 * Created by Gav on 18-Apr-16.
 */
public class MobilePhone {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            System.out.println("Contact is already on file.");
            return false;
        }

        contacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition <0){
            System.out.println("Contact not found.");
            return false;
        }
        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " has been removed.");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition <0){
            System.out.println("Contact not found. mobile class5");
            return false;
        }
        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    private int findContact(Contact contact){
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i =0; i < this.contacts.size(); i++){
            Contact contact = this.contacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }

        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >=0){
            return contact.getName();
        }

        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >=0){
            return this.contacts.get(position);
        }

        return null;
    }

    public void printContacts(){
        for(int i =0; i < this.contacts.size();i++){
            System.out.println("Contact " + (i+1) + " - name is " + this.contacts.get(i).getName() + " and number is " +
            this.contacts.get(i).getPhoneNumber());
        }
    }

}
