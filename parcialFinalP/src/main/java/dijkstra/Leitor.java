package dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vh36
 */
public class Leitor {
    //constructor con parametros para los vertices y aristas
    public Leitor(String s, ArrayList<Vertice> vertices, ArrayList<Arista> arestas, ArrayList<String> caminho) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(s));
            boolean edge = false;
            boolean path = false;
            //verifica si el bufer está listo para leerse o no
            while (in.ready()) {
                String str = in.readLine();
                //jala los datos despues del simbolo #
                if (str.equals("#")) 
                {
                    edge = true;
                }
                else if (str.equals("$"))
                {
                    edge = false;
                    path = true;
                }
                else 
                {
                    if (edge == false && path == false) 
                    {
                        Vertice v = new Vertice(str);
                        vertices.add(v);
                    } 
                    else if (edge == true && path == false) 
                    {
                        //dividimos el objeto String en un array por espacio
                        String[] b = str.split(" ");
                        String v = b[0];
                        String v2 = b[1];
                        int peso = Integer.parseInt(b[2]);
                        //mandamos los parametros al constructor aresta
                        Arista newedge = new Arista(v, v2, peso);
                        arestas.add(newedge);
                    }
                    else
                    {
                        //pedimos por teclado que ingrese la ruta que quiere saber
                        Scanner teclado=new Scanner(System.in);
                      
                        
                        String inicio;
                        String fim;
                        //nodo inicio
                        System.out.println("ingrese el municipio inicial");
                        inicio=teclado.nextLine();
                        //nodo final
                        System.out.println("ingrese el municipio final");
                        fim=teclado.nextLine();
                        caminho.add(inicio);
                        caminho.add(fim);
                    }
                }
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}