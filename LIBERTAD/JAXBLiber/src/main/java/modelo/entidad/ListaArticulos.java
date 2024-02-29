package modelo.entidad;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaArticulos {
	
	private List<Articulo> articulos;
	
	
	
	public ListaArticulos() {
		super();
	}

	@XmlElement(name="articulo")
	public List<Articulo> getArticulos(){
		return articulos;
	}
	
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

}
