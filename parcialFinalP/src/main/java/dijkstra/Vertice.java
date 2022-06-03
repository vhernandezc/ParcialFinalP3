/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vh36
 */

public class Vertice implements Comparable<Vertice>{
	private final String nombre;
	public int distancia = Integer.MAX_VALUE;
	public Vertice Padre = null;
        //almacena el vertice y la clave
	public final Map<Vertice, Integer> vecinos = new HashMap<>();
 
        //constructor que retorna el nombre
	public Vertice(String name)
	{
		this.nombre = name;
	}

        
        
	public void imprimeCamino()
	{
            //referenciamos la variable de objeto padre
            
		if (this == this.Padre)//si el objeto apunta a él mismo
		{
			System.out.printf("%s", this.getNome());
		}
		else if (this.Padre == null)//si no hay relación
		{
			System.out.printf("%s(no hay relación)", this.getNome());
		}
		else
		{
			this.Padre.imprimeCamino();//en caso contrario imprimirá el siguiente formato
			System.out.printf(" -> %s(%d)", this.getNome(), this.distancia);
		}
	}
 
        //compara la distancia del vertice entrante
	public int compareTo(Vertice otroVertice)
	{
             
		if (distancia == otroVertice.distancia)
			return getNome().compareTo(otroVertice.getNome());
 
		return Integer.compare(distancia, otroVertice.distancia);
	}
 
        
        //usamos un método de la clase principal
	@Override public String toString()
	{
		return "(" + getNome() + ", " + distancia + ")";
	}

    /**
     * @return the nome
     */
    public String getNome() {
        return nombre;
    }
    }
