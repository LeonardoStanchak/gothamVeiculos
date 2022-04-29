package br.com.gothamVeiculos.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class gothamVeiculosDto {

	private Long id;

	private String veiculo;
	private String montadora;
	private String cambio;
	private String combustivel;
	private String valor;
	private Boolean vendido;

}
