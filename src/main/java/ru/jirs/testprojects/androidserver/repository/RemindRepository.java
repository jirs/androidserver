package ru.jirs.testprojects.androidserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jirs.testprojects.androidserver.entity.Remind;

/**
 * Created by irs on 13.08.16.
 */
public interface RemindRepository extends JpaRepository<Remind, Long> {
}
