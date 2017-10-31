package co.edu.uniquindio.com;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa a la clase (Entidad) Compra_pelicula.
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = Compra_pelicula.GET_ALL, query = "SELECT compra_pelicula FROM Compra_pelicula compra_pelicula"),
		@NamedQuery(name = Compra_pelicula.COMPRADAS_2017, query = "SELECT CONCAT(p.nombre,'-', cp.f_compra) FROM Pelicula p, Compra_pelicula cp WHERE cp.f_compra BETWEEN '2017-01-01' AND '2017-12-31' AND cp.pelicula_ids=p.id_pelicula"),
		// Declare este nameQuery guia 9 punto 4
		@NamedQuery(name = Compra_pelicula.CLIENTE_COMPRA, query = "SELECT cp.cliente_id.nombre FROM Compra_pelicula cp where cp.id=:idCompra"),
		// named query guia 9 punto 5
		@NamedQuery(name = Compra_pelicula.GET_PELICULASENCOMPRA, query = "SELECT pelicula  FROM  Compra_pelicula compra, IN(compra.pelicula_ids) pelicula WHERE compra.id=:idCompra"),
		// named query guia 9 punto 6
		@NamedQuery(name = Compra_pelicula.GET_COMPRAPELICULAS, query = "SELECT Compra_pelicula  FROM Compra_pelicula Compra_pelicula INNER JOIN Compra_pelicula.pelicula_ids pelis WHERE Compra_pelicula.pelicula_ids=:idpelicula"), 
		//named query guia 11 EJB capa de negocio
		@NamedQuery(name = Compra_pelicula.GET_VENTA, query = "SELECT compra  FROM  Compra_pelicula compra WHERE compra.id=:idCompra"),
		//named query para obtener cantidad de compras en rango de fechas
		@NamedQuery(name = Compra_pelicula.GET_PELICULASRANGOFECHAS, query = "SELECT COUNT(cp.id) FROM Compra_pelicula cp WHERE cp.f_compra BETWEEN :desde AND :hasta"),
		
})
public class Compra_pelicula implements Serializable {

	@Id
	@Column(name = "id") // identificador de la clase compra_pelicula de tipo integer
	private int id;
	@Temporal(TemporalType.TIMESTAMP) // fecha_compra de la pelicula de tipo Timestamp
	private Date f_compra;
	@ElementCollection
	private List<String> pelicula_ids; // pelicula o peliculas que ser�n compradas
	@ManyToOne
	private Cliente cliente_id; // relaci�n muchos a uno con la clase(Entidad) Cliente
	private static final long serialVersionUID = 1L;

	public static final String GET_ALL = "comprapelicula_GetAll"; // named query
	public static final String COMPRADAS_2017 = "comprapelicula_2017"; // named query
	// Declare este nameQuery guia 9 punto 4
	public static final String CLIENTE_COMPRA = "comprapelicula_clientecompra"; // named query
	// named query guia 9 punto 6
	public static final String GET_PELICULASENCOMPRA = "comprapelicula_peliculasencompra";
	// named query guia 9 punto 5
	public static final String GET_COMPRAPELICULAS = "comprapelicula_comprapeliculas";
	//named query guia 11 EJB capa de negocio
	public static final String GET_VENTA = "comprapelicula_GETVENTA";
	//named query para obtener cantidad de compras en rango de fechas
		public static final String GET_PELICULASRANGOFECHAS = "comprapelicula_compradasentrefechas";
	/*
	 * Metodo constructor de la clase(Entidad) compra_pelicula
	 */
	public Compra_pelicula() {
		super();
	}

	/*
	 * Este metodo permite la comparacion de entidades por medio de su token hash
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * Este metodo permite la comparacion de entidades por su tipo y nombre
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra_pelicula other = (Compra_pelicula) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * Metodo get del atributo id, devuelve un entero
	 */
	public int getId() {
		return id;
	}

	/*
	 * Metodo set del atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Metodo get del atributo f_compra, devuelve un Timestamp
	 */
	public Date getF_compra() {
		return f_compra;
	}

	/*
	 * Metodo set del atributo f_compra
	 */
	public void setF_compra(Date f_compra) {
		this.f_compra = f_compra;
	}

	/*
	 * Metodo get del atributo Pelicula, devuelve un objeto de tipo Pelicula
	 */

	public List<String> getPelicula_ids() {
		return pelicula_ids;
	}

	/*
	 * Metodo set del atributo pelicula_id
	 */
	public void setPelicula_ids(List<String> pelicula_ids) {
		this.pelicula_ids = pelicula_ids;
	}

	/*
	 * Metodo get del atributo cliente_id, devuelve un objeto de tipo Cliente
	 */
	public Cliente getCliente_id() {
		return cliente_id;
	}

	/*
	 * Metodo set del atributo cliente_id
	 */
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

}
