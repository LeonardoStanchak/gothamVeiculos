package br.com.gothamVeiculos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gothamVeiculos.Dto.gothamVeiculosDto;
import br.com.gothamVeiculos.domain.gothamVeiculosDomain;
import br.com.gothamVeiculos.service.gothamGarageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Gotham Veiculos uma concessionaria com diversos veiculos", tags = "gothamVeiculos")
@RequestMapping(value = "api/v1/GothamVeiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
public class gothamVeiculosController {

	@Autowired
	private gothamGarageService gotService;

	@GetMapping
	@ApiOperation("Ira trazer todos os veiculos que temos na loja a venda")
	public ResponseEntity<List<gothamVeiculosDto>> listall() {
		List<gothamVeiculosDto> goth = gotService.TrazTodosVeiculos();
		return ResponseEntity.ok(goth);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Ira trazer um veiculo exclusivo")
	public ResponseEntity<gothamVeiculosDomain> fiindVeiculoById(@PathVariable Long id) {
		try {
			gothamVeiculosDomain got = gotService.fiindVeiculoById(id);
			return ResponseEntity.ok().body(got);

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@PostMapping
	@ApiOperation(value = "Adiciona um novo veiculo")
	public ResponseEntity<gothamVeiculosDto> novoVeiculo(@Valid @RequestBody gothamVeiculosDto dto) {
		dto = gotService.novoVeiculo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@DeleteMapping
	@ApiOperation(value = "Um carro vendido sai do banco de dados ou seja deletado")
	public ResponseEntity<gothamVeiculosDomain> excluiVeiculoVendido(@PathVariable Long id) {
		return ResponseEntity.ok().body(gotService.vendeu(id));
	}

}
