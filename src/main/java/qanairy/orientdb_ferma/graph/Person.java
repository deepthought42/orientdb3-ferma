package qanairy.orientdb_ferma.graph;

import java.util.List;

import com.syncleus.ferma.AbstractVertexFrame;
import com.syncleus.ferma.annotations.Adjacency;
import com.syncleus.ferma.annotations.GraphElement;

@GraphElement
public class Person extends AbstractVertexFrame  {
	private List<Pet> pets;
	
	public Person(){}
	
	public Person(List<Pet> pets){
		setPets(pets);
	}

	@Adjacency(label = "owns")
	public List<Pet> getPets(){
		return this.pets;
	}
	
	@Adjacency(label = "owns")
	public void setPets(List<Pet> pets){
		this.pets = pets;
	}
	
	@Adjacency(label = "owns")
	public void addPet(Pet pet){
		
	}
}
