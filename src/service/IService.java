package service;

import entite.Evenement;
import java.util.List;


public interface IService <T>{
     //void insert(T t);
     void delete(T t);
     void inserEvenementPst(T t);
     void update(T t);
     List<T>read();
     List<T>readById(int ID);
    
  
   // List<T> readAll(T t);
   }
