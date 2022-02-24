package buscaminas.model;


import java.util.List;
//This class sets the list of mines and and what the user selects
public class Board {

	private  List<Mina> listaMina;
	
	private UserSelect miSelect = new UserSelect();
	
	

	public List<Mina> getListaMina() {
		return listaMina;
	}


	public void setListaMina(List<Mina> listaMina) {
		this.listaMina = listaMina;
	}


	public UserSelect getMiSelect() {
		return miSelect;
	}


	public void setMiSelect(UserSelect miSelect) {
		this.miSelect = miSelect;
	}
	
	
	
	
	
}
