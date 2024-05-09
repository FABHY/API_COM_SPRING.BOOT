package br.com.projeto.API.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.API.modelo.Pessoa;

@SuppressWarnings("unused")
@Repository
public interface repositorio extends CrudRepository<Pessoa,Integer> {

    
    @SuppressWarnings("null")
    List<Pessoa> findAll();

     Pessoa findByCodigo(int codigo);

     List<Pessoa> findByOrderByNomeDesc();

     List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

     List<Pessoa> findByNomeContaining(String termo);

     int countByCodigo(int codigo);
}
