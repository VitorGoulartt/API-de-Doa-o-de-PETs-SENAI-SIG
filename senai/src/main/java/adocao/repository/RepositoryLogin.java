package adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelLogin;

@Repository
public interface RepositoryLogin extends JpaRepository<ModelLogin, Integer> {
    ModelLogin  findByEmail(String email);

}
