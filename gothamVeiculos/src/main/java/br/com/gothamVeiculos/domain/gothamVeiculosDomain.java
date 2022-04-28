package br.com.gothamVeiculos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Table(name = "gotham")
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class gothamVeiculosDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idVendedor;

	private String veiculo;
	private String montadora;
	private String cambio;
	private String combustivel;
	private String valor;
	private Boolean vendido;

}
