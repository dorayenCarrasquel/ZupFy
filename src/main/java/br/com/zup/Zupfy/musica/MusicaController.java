package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.dtos.MusicaCadastroDTO;
import br.com.zup.Zupfy.musica.dtos.MusicaDetalhesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDetalhesDTO cadastrarMusica(@RequestBody @Valid MusicaCadastroDTO musicaCadastroDTO){
        Musica musica = modelMapper.map(musicaCadastroDTO, Musica.class);
        musicaService.cadastrarMusica(musica);


        return modelMapper.map(musica, MusicaDetalhesDTO.class);
    }



}
