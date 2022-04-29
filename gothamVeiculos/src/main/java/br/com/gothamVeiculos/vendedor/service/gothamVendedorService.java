package br.com.gothamVeiculos.vendedor.service;

import java.util.List;

import br.com.gothamVeiculos.vendedor.Dto.gothamVendedorDto;
import br.com.gothamVeiculos.vendedor.domain.gothamVendedorDomain;

public interface gothamVendedorService {
	List<gothamVendedorDto>listAll();
	gothamVendedorDomain findByVendedorId(Long id);

}
