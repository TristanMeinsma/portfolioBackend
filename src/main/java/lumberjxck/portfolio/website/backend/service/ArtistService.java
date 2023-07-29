package lumberjxck.portfolio.website.backend.service;

import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.exception.SongNotFoundException;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tristan Meinsma
 * Handles interaction with the repository
 */
@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<Artist> findALlArtists () {
        return artistRepository.findAll();
    }

    public Artist addArtist (Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist (Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist findArtistById (Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song by id " + id + " not found."));
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}