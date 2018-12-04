package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {
 
    private List<String> list;
            
    public MailListReader() throws FileNotFoundException, IOException{
        list = new ArrayList<String>();
        
        File file = new File("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\Kata4\\src\\view\\email.txt");
        BufferedReader bf;
        bf = new BufferedReader(new FileReader(file));
        
        String s;
        while((s = bf.readLine()) != null){
            if(s.contains("@")) list.add(new Mail().getMail(s));
        }
                
        
    }

    public List<String> getList() {
        return list;
    }
        
}
