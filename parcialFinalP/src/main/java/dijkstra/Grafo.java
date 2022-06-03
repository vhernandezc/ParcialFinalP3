/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author vh36
 */
public class Grafo {
     private final Map<String, Vertice> grafo;

   public Grafo(ArrayList<Arista> edges) {//constructor que contendrá el arraylilst con las aristas como atributos
      grafo = new HashMap<>(edges.size());
 
      for (Arista e : edges) {
         if (!grafo.containsKey(e.getVertice1())) grafo.put(e.getVertice1(), new Vertice(e.getVertice1()));
         if (!grafo.containsKey(e.getVertice2())) grafo.put(e.getVertice2(), new Vertice(e.getVertice2()));
      }
 
      //si las aristas son vecinas las irá a recorrer
      for (Arista e : edges) {
         grafo.get(e.getVertice1()).vecinos.put(grafo.get(e.getVertice2()), e.getDistancia());
        
      }
   }
   
   
   //evaluamos primero si cumple con las condiciones para encontrar la ruta más corta
   public void dijkstra(String inicio) {
       //evalua si el grafo contiene vertice
      if (!grafo.containsKey(inicio)) {
         System.err.printf("el grafo no contiene vertice inicial \"%s\"\n", inicio);
         return;
      }
      //recorre cada vertice desde el grafo inicial
      final Vertice source = grafo.get(inicio);
      NavigableSet<Vertice> q = new TreeSet<>();
         
      for (Vertice v : grafo.values()) {
         v.Padre = v == source ? source : null;
         v.distancia = v == source ? 0 : Integer.MAX_VALUE;
         q.add(v);
      }
 
      dijkstra(q);
   }
 
   //si cumple las condiciones pasa a este método
   private void dijkstra(final NavigableSet<Vertice> q) {      
        Vertice u;
        Vertice v;
      while (!q.isEmpty()) {
 
         u = q.pollFirst();
         if (u.distancia == Integer.MAX_VALUE) break;

         for (Map.Entry<Vertice, Integer> a : u.vecinos.entrySet()) {
            v = a.getKey();
 
            //constante que contendrá la distancia menor en cada iteración
            final int alternateDist = u.distancia + a.getValue();
            
            //si la distancia alternativa es menor a distancia actual
            if (alternateDist < v.distancia) {//si se cumple
               q.remove(v);//remueve el valor de actual
               v.distancia = alternateDist;//y alternativa toma su lugar
               v.Padre = u;
               q.add(v);
            } 
         }
      }
   }
 
   //método para imprimir la ruta
   public void printCaminhoFinal(String fim) {
      if (!grafo.containsKey(fim)) {
         System.err.printf("no hay vertice inicial \"%s\"\n", fim);
         return;
      }
      System.out.println("Camino:");
      grafo.get(fim).imprimeCamino();
      System.out.println();
   }

}
