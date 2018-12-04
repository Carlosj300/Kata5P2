package view;

import java.util.List;
import model.Histogram;

public class MailHistogramBuilder {
    
    
    public Histogram<String> getHisto(List<String> list) {
        Histogram histo = new Histogram();
        for(String i : list){
            histo.increment(i);
        }
        return histo;
    }
    
    
    
}
