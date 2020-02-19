package ie.ucd.noteit.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NoteRepository extends JpaRepository<Note, Long> {}
