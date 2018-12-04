package model;

import java.io.BufferedReader;
import java.io.File;

public class Mail {

    public String getMail(String email) {        
        return email.substring(email.lastIndexOf("@")+1,email.length()-1);
    }
    
}
