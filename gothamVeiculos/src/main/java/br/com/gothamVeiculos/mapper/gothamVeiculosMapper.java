package br.com.gothamVeiculos.mapper;

import org.springframework.stereotype.Component;

import br.com.gothamVeiculos.Dto.gothamVeiculosDto;
import br.com.gothamVeiculos.domain.gothamVeiculosDomain;
@Component
public class gothamVeiculosMapper {
	public gothamVeiculosDto toDto(gothamVeiculosDomain got) {
		if(got == null)return null;
		
		return gothamVeiculosDto.builder()
				.id(got.getId())
				.veiculo(got.getVeiculo())
				.montadora(got.getMontadora())
				.cambio(got.getCambio())
				.combustivel(got.getCombustivel())
				.valor(got.getValor())
				.vendido(got.getVendido())
				.build();
	}
	
	public gothamVeiculosDomain toEntity(gothamVeiculosDto dto) {
		if(dto == null)return null;
		
		return gothamVeiculosDomain.builder()
				.id(dto.getId())
				.veiculo(dto.getVeiculo())
				.montadora(dto.getMontadora())
				.cambio(dto.getCambio())
				.combustivel(dto.getCombustivel())
				.valor(dto.getValor())
				.vendido(dto.getVendido())
				.build();
	}

}
