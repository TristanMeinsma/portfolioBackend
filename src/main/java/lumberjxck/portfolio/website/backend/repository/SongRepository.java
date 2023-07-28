package lumberjxck.portfolio.website.backend.repository;

import lumberjxck.portfolio.website.backend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Tristan Meinsma
 */
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findSongById(Long id);
}
