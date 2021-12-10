package br.com.zup.Zupfy.config;

import br.com.zup.Zupfy.musica.exceptions.MusicaNaoEcontradaExeception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(MusicaNaoEcontradaExeception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularMusicaNaoEncontrada(MusicaNaoEcontradaExeception exeception) {
        return new MensagemDeErro(exeception.getMessage());
    }

}
