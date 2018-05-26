package qanairy.orientdb_ferma;

import org.apache.tinkerpop.gremlin.orientdb.OrientGraph;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.syncleus.ferma.DelegatingFramedGraph;


/**
 * Produces connections to the OrientDB instance
 *
 */
public class OrientConnectionFactory {
    @SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(OrientConnectionFactory.class);
        
    DelegatingFramedGraph<OrientGraph> current_tx = null;
	
	public OrientConnectionFactory(){
		this.current_tx = getConnection();
	}
	
	/**
	 * Opens connection to database
	 * @return
	 */
	private DelegatingFramedGraph<OrientGraph> getConnection(){

		OrientGraphFactory graphFactory = new OrientGraphFactory("plocal:127.0.0.1/ferma-demo", "admin", "admin").setupPool(10, 1000);
		return new DelegatingFramedGraph<OrientGraph>(graphFactory.getNoTx(), true, true);	
	}

	
	/**
	 * Commits transaction
	 * 
	 * @param persistable_obj
	 * @return if save was successful
	 */
	public void save(){
		current_tx.tx().commit();
	}
	
	public void close(){
		current_tx.tx().close();
	}
	
	/**
	 * @return current graph database transaction
	 */
	public DelegatingFramedGraph<OrientGraph> tx(){
		return this.current_tx;
	}
}

