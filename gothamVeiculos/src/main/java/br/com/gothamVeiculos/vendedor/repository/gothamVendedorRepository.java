package br.com.gothamVeiculos.vendedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gothamVeiculos.vendedor.domain.gothamVendedorDomain;

public interface gothamVendedorRepository extends JpaRepository<gothamVendedorDomain, Long>{

}
