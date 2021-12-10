package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.exceptions.MusicaNaoEcontradaExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public Musica cadastrarMusica(Musica musica){
    musica.setDataDeCadastro(LocalDate.now());
    musicaRepository.save(musica);
        return musica;
    }

    public void deletarMusica(int id){
        Optional<Musica> musicaOptional = musicaRepository.findById(id);
        if (musicaOptional.isEmpty()){
            throw new MusicaNaoEcontradaExeception("Musica não encontrada");
        }
        musicaRepository.delete(musicaOptional.get());

    }

    public Musica atualizarMusica(Musica musica){
        return musica;
    }

    public List<Musica> retornarTodasAsMusicas(){
        return null;
    }
}
