package br.com.zup.Zupfy.config;

import br.com.zup.Zupfy.musica.exceptions.MusicaNaoEcontradaExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularErroDeSintaxisDoCliente (HttpMessageNotReadableException exception){
        return new MensagemDeErro("Tem algumos erros de ESCRITA");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecaoEnumInvalido(HttpMessageNotReadableException exception){
        if(exception.getLocalizedMessage().contains("br.com.zup.Zupfy.enuns.Estilo")){
            return new MensagemDeErro("Opção não encontrada");
        }
        return new MensagemDeErro(exception.getLocalizedMessage());
    }

}
