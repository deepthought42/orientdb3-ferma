package qanairy.orientdb_ferma.graph;

import com.syncleus.ferma.AbstractVertexFrame;
import com.syncleus.ferma.annotations.GraphElement;
import com.syncleus.ferma.annotations.Property;

@GraphElement
public class Pet extends AbstractVertexFrame {
	
	private String name;
	
	public Pet(){}
	
	public Pet(String name){
		setName(name);
	}

	@Property("name")
	public void setName(String name){
		this.name = name;
	}
	
	@Property("name")
	public String getName(){
		return this.name;
	}
}
