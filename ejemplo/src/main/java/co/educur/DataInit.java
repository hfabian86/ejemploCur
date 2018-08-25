package co.educur;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
 
@Component
public class DataInit implements ApplicationRunner {
 
    private PersonaDAO personDAO;
 
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 
    @Autowired
    public DataInit(PersonaDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = personDAO.count();
 
        if (count == 0) {
            Persona p1 = new Persona();
 
            p1.setFullName("Douglas");
 
            Date d1 = df.parse("1980-12-20");
            p1.setDateOfBirth(d1);
            //
            Persona p2 = new Persona();
 
            p2.setFullName("Fabian");
            Date d2 = df.parse("1985-11-11");
            p2.setDateOfBirth(d2);
 
            personDAO.save(p1);
            personDAO.save(p2);
        }
 
    }
     
}