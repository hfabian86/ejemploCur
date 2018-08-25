package co.educur;

import java.util.List;

public class DataResponse {

    public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> data) {
		this.personas = data;
	}

	private List<Persona> personas;

   
}