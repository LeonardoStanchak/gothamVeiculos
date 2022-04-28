package br.com.gothamVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gothamVeiculos.domain.gothamVeiculosDomain;

public interface gothamVeiculosRepository extends JpaRepository<gothamVeiculosDomain, Long>{

}
