package br.com.acsimoeschalegre.MeuCurriculo.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();
        var errosResposta = erros.stream()
                .map(DadosErroValidacao::new)
                .toList();
        return ResponseEntity.badRequest().body(errosResposta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity tratarErroRegraDeNegocios(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    private record  DadosErroValidacao(
            String campo,
            String mensagem
    ){
        public DadosErroValidacao(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
