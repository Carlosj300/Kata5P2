package main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.MailHistogramBuilder;
import view.MailListReader;
import view.HistogramDisplay;
import view.MailListReaderBD;

public class Kata5P2 {
    
    private Histogram<String> histo;
    private List<String> list;
    
    public static void main(String[] args) throws IOException, SQLException{            
            Kata5P2 kata5 = new Kata5P2();
            kata5.execute();
    } 

    private void execute() throws IOException, SQLException {
        input();
        process();
        output();
    }

    private void input() throws IOException, SQLException {
        MailListReader mlr = new MailListReader();
        list  = new MailListReaderBD().read();
        
    }

    private void process() {
        MailHistogramBuilder builder = new MailHistogramBuilder();
        histo = builder.getHisto(list);
    }

    private void output() {
        HistogramDisplay histoD = new HistogramDisplay(histo);
        histoD.execute();
    }
}
