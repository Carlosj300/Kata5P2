package main;

import java.io.File;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.MailHistogramBuilder;
import view.MailListReader;
import view.HistogramDisplay;

public class Kata4 {
    
    private Histogram<String> histo;
    private List<String> list;
    
    public static void main(String[] args) throws IOException{            
            Kata4 kata4 = new Kata4();
            kata4.execute();
    } 

    private void execute() throws IOException {
        input();
        process();
        output();
    }

    private void input() throws IOException {
        MailListReader mlr = new MailListReader();
        list = mlr.getList();
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
