package br.com.gothamVeiculos.vendedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gothamVeiculos.vendedor.Dto.gothamVendedorDto;
import br.com.gothamVeiculos.vendedor.domain.gothamVendedorDomain;
import br.com.gothamVeiculos.vendedor.service.gothamVendedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Gotham Veiculos Vendedores",tags ={"Gotham Veiculos Vendedor"})
@RequestMapping(path = "api/v1/Gotham Veiculos Vendedores", produces = MediaType.APPLICATION_JSON_VALUE  )
public class gothamVendedorController {
	
	@Autowired
	private gothamVendedorService gotService;
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Traz unico vendedor por ID")
	public ResponseEntity<gothamVendedorDomain>findByVendedorId(@PathVariable Long id){
		gothamVendedorDomain gotDom = gotService.findByVendedorId(id);
		return ResponseEntity.ok().body(gotDom);
	}
	
	
	
	@GetMapping
	@ApiOperation(value = "Traz todos os vendedores de todas unidades")
	public ResponseEntity<List<gothamVendedorDto>>listAll(){
		List<gothamVendedorDto>gotDto = gotService.listAll();
		return ResponseEntity.ok().body(gotDto);
	}

}
