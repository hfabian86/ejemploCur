package co.educur;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api")
public class MainController {
 
    @Autowired
    private PersonaDAO PersonaDAO;
 
  
    @GetMapping("/Personaas")
    public DataResponse getListaPersonas() {
        DataResponse dataResponse = new DataResponse();
        dataResponse.setPersonas(PersonaDAO.findAll());
    	return dataResponse										;
    
    }
    
    @PostMapping("/Personaas")
    public Persona createPersonaa(@Valid @RequestBody Persona Personaa) {
        return PersonaDAO.save(Personaa);
    }
    
    @PutMapping("/Personaas/{id}")
    	public Persona updatePesona(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody Persona PersonaaDetails) {

        Optional<Persona> PersonaaOptional = PersonaDAO.findById(id);
                
        Persona Personaa = PersonaaOptional.get();
        Personaa.setFullName(PersonaaDetails.getFullName());
        Personaa.setDateOfBirth(PersonaaDetails.getDateOfBirth());

        Persona updatedPersonaa = PersonaDAO.save(Personaa);
        return updatedPersonaa;
    }
    @DeleteMapping("/Personaas/{id}")
	public ResponseEntity<?>  BorrarPersonaa(@PathVariable(value = "id") Long id
                                        ) {

    Optional<Persona> PersonaaOptional = PersonaDAO.findById(id);
            
    Persona Personaa = PersonaaOptional.get();
   

   PersonaDAO.delete(Personaa);
    return ResponseEntity.ok().build();
}
 
}
