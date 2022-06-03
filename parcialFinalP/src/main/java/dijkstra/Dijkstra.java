/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.ArrayList;

/**
 *
 * @author vh36
 */
 
public class Dijkstra {
 
   public static void main(String[] args) {
      ArrayList<Vertice> vertices = new ArrayList<>();
      ArrayList<Arista> bordes = new ArrayList<>();
      ArrayList<String> caminho = new ArrayList<>();
      Leitor l = new Leitor("teste.txt", vertices, bordes, caminho);
      String inicio = caminho.get(0);
      String fim = caminho.get(1);
      Grafo g = new Grafo(bordes);
      System.out.println("Algoritmo de Dijkstra");
  
      g.dijkstra(inicio);
      g.printCaminhoFinal(fim);
    
   }
}