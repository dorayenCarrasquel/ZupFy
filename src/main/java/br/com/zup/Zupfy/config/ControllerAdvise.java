package br.com.zup.Zupfy.config;

import br.com.zup.Zupfy.musica.exceptions.MusicaNaoEcontradaExeception;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(MusicaNaoEcontradaExeception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularMusicaNaoEncontrada(MusicaNaoEcontradaExeception exeception) {
        return new MensagemDeErro(exeception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        List<MensagemDeErro> listamensagen = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()){
            listamensagen.add(new MensagemDeErro(fieldError.getDefaultMessage()));
        }

        return listamensagen;
    }

}
