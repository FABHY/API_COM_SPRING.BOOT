package br.com.projeto.API.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.API.modelo.Cliente;
import br.com.projeto.API.modelo.Pessoa;
import br.com.projeto.API.repositorio.repositorio;
import br.com.projeto.API.servico.Servico;
import jakarta.validation.Valid;



@RestController
public class Controle {

    @Autowired
    private repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?>selecionar(){
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?>selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);

    }

    @DeleteMapping("/api/{}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
        
    }

    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNomeDesc();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("Patricia");
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("l");
    }

    

    @GetMapping("")
    public String mansagem(){
        return "Sistema Websis";

    }

    

    @GetMapping("/boasvindas")
    public String BoasVindas(){
        return "Sejam bem vindos(a)";

    }

    @GetMapping("/boasvindas/{nome}")
    public String BoasVindas(@PathVariable String nome){
        return "Sejam bem vindos(a)" + nome;

    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p ){
        return p;

    }

    @GetMapping("/status")
    public ResponseEntity<?>status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){

    }
    
}
