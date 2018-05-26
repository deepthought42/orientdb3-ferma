package qanairy.orientdb_ferma;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import qanairy.orientdb_ferma.graph.Person;
import qanairy.orientdb_ferma.graph.Pet;

public class TraversalTests {
	
	@Test
	public void traversalTest(){
		OrientConnectionFactory connection = new OrientConnectionFactory();

		List<Pet> pets = new ArrayList<Pet>();
		Pet pet1 = connection.tx().addFramedVertex(Pet.class);
		pet1.setName("fluffy");
		pets.add(pet1);
				
		Person person = connection.tx().addFramedVertex(Person.class);
		
		assert person != null;
		person.setPets(pets);
		connection.save();

		Assert.assertEquals(person.getPets().size(), 1);
		System.err.println("NAME :: "+person.getPets().get(0).getName());
		Assert.assertEquals(person.getPets().get(0).getName(),"fluffy");
		
	}
}
