package br.com.youngdevs.alemdopoteapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.youngdevs.alemdopoteapi.models.Pote;

public interface PoteRepository extends JpaRepository<Pote, Long>{

}
