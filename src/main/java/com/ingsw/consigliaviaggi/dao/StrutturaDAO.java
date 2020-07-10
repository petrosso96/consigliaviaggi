package com.ingsw.consigliaviaggi.dao;

import com.ingsw.consigliaviaggi.model.Struttura;
import com.ingsw.consigliaviaggi.model.TipoStruttura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

 public interface StrutturaDAO extends CrudRepository<Struttura, String> {

      List<Struttura> findByNome(String nome);

     @Query(value = "select * from STRUTTURA,INDIRIZZO where struttura.indirizzo_id = indirizzo.id AND INDIRIZZO.city like ?1", nativeQuery = true)
      List<Struttura> findByCity(String city);

      List<Struttura> findByCategoria(TipoStruttura categoria);

      List<Struttura> findByPrezzo(int prezzo);

     //--------------------------------------------------------------------------------------------------------------------------
     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND INDIRIZZO.CITY LIKE ?2 AND STRUTTURA.NOME LIKE ?1",nativeQuery=true)
      List<Struttura> findByNomeAndCity(String nome, String city);

      List<Struttura> findByNomeAndCategoria(String nome, TipoStruttura categoria);

      List<Struttura> findByNomeAndPrezzo(String nome, int prezzo);

     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND INDIRIZZO.CITY LIKE ?1 AND STRUTTURA.CATEGORIA LIKE ?2",nativeQuery=true)
      List<Struttura> findByCityAndCategoria(String city, String categoria);

     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND INDIRIZZO.CITY LIKE ?1 AND STRUTTURA.PREZZO = ?2",nativeQuery=true)
     List<Struttura> findByCityAndPrezzo(String city, int prezzo);

      List<Struttura> findByCategoriaAndPrezzo(TipoStruttura categoria, int prezzo);

     //---------------------------------------------------------------------------------------------------------------------------------

     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND STRUTTURA.NOME LIKE ?1 AND INDIRIZZO.CITY LIKE ?2 AND STRUTTURA.CATEGORIA LIKE ?3",nativeQuery=true)
      List<Struttura> findByNomeAndCityAndCategoria(String nome,String city, String categoria);


     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND STRUTTURA.NOME LIKE ?1 AND INDIRIZZO.CITY LIKE ?2 AND STRUTTURA.PREZZO = ?3",nativeQuery=true)
     List<Struttura> findByNomeAndCityAndPrezzo(String nome, String city, int prezzo);



     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND INDIRIZZO.CITY LIKE ?1 AND STRUTTURA.CATEGORIA LIKE ?2 AND STRUTTURA.PREZZO = ?3",nativeQuery=true)
     List<Struttura> findByCityAndCategoriaAndPrezzo(String city, String categoria, int prezzo);


      List<Struttura> findByCategoriaAndNomeAndPrezzo(TipoStruttura categoria, String nome, int prezzo);


     //---------------------------------------------------------------------------------------------------------------------------------


     @Query(value = "SELECT * FROM STRUTTURA,INDIRIZZO WHERE STRUTTURA.INDIRIZZO_ID = INDIRIZZO.ID AND STRUTTURA.NOME LIKE ?1 AND INDIRIZZO.CITY LIKE ?2 AND STRUTTURA.CATEGORIA LIKE ?3 AND STRUTTURA.PREZZO = ?4",nativeQuery=true)
      List<Struttura> findByNomeAndCityAndCategoriaAndPrezzo(String nome, String city, String categoria, int prezzo);


     // Metodi ausiliari

       boolean existsStrutturaByIdEquals(String id);


}
