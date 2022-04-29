package br.com.gothamVeiculos.vendedor.mapper;

import org.springframework.stereotype.Component;

import br.com.gothamVeiculos.vendedor.Dto.gothamVendedorDto;
import br.com.gothamVeiculos.vendedor.domain.gothamVendedorDomain;
@Component
public class gothamVendedorMapper {
	
	public gothamVendedorDto toDto(gothamVendedorDomain got) {
		if(got==null)return null;
		return gothamVendedorDto.builder()
				.id(got.getId())
				.vendedor(got.getVendedor())
				.unidade(got.getUnidade())
				.build();
	}
	
	public gothamVendedorDomain toEntity(gothamVendedorDto dto) {
		if(dto==null)return null;
		return gothamVendedorDomain.builder()
				.id(dto.getId())
				.vendedor(dto.getVendedor())
				.unidade(dto.getUnidade())
				.build();
	}

}
