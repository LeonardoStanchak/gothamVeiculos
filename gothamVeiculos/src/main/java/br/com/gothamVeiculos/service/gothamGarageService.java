package br.com.gothamVeiculos.service;

import java.util.List;

import br.com.gothamVeiculos.Dto.gothamVeiculosDto;
import br.com.gothamVeiculos.domain.gothamVeiculosDomain;

public interface gothamGarageService {
	gothamVeiculosDomain fiindVeiculoById(Long id);
	gothamVeiculosDto novoVeiculo(gothamVeiculosDto gothDto);
	List<gothamVeiculosDto> TrazTodosVeiculos();
	gothamVeiculosDomain vendeu(Long id);

}
