package lumberjxck.portfolio.website.backend.repository;

import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Tristan Meinsma
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findArtistByName(String name);
}
