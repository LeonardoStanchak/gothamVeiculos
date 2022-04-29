package br.com.gothamVeiculos.vendedor.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class gothamVendedorDto {
	private Long id;
	
	private String vendedor;
	private String unidade;

}
