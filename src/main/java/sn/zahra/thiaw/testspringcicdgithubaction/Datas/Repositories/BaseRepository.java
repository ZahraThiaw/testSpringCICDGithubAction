package sn.zahra.thiaw.testspringcicdgithubaction.Datas.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository <T,ID> extends JpaRepository<T, ID> {
    List<T> findByDeletedFalse();
    Optional<T> findByIdAndDeletedFalse(ID id);
}
