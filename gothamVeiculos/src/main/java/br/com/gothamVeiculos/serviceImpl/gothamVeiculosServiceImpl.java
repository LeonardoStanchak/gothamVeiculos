package br.com.gothamVeiculos.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gothamVeiculos.Dto.gothamVeiculosDto;
import br.com.gothamVeiculos.domain.gothamVeiculosDomain;
import br.com.gothamVeiculos.mapper.gothamVeiculosMapper;
import br.com.gothamVeiculos.repository.gothamVeiculosRepository;
import br.com.gothamVeiculos.service.gothamGarageService;

@Service
public class gothamVeiculosServiceImpl implements gothamGarageService {

	@Autowired
	private gothamVeiculosRepository gotRepos;

	@Autowired
	private gothamVeiculosMapper gotMapper;

	@Transactional
	public gothamVeiculosDomain fiindVeiculoById(Long id) {
		return gotRepos.findById(id).orElseThrow();
	}

	@Transactional
	public List<gothamVeiculosDto> TrazTodosVeiculos() {
		List<gothamVeiculosDomain> gotList = gotRepos.findAll();
		return gotList.stream().map(x -> gotMapper.toDto(x)).collect(Collectors.toList());
	}

	@Override
	public gothamVeiculosDto novoVeiculo(gothamVeiculosDto gothDto) {
		if (gothDto.getId() == null) {
			return chegouNovoVeiculo(gothDto);
		} else {
			return atualizaStatus(gothDto);
		}
	}

	private gothamVeiculosDto atualizaStatus(gothamVeiculosDto gothDto) {
		gothamVeiculosDomain gts = fiindVeiculoById(gothDto.getId());
		gts.setVendido(gothDto.getVendido());
		gts = addCarroNovo(gts);
		return gotMapper.toDto(gts);
	}

	private gothamVeiculosDto chegouNovoVeiculo(gothamVeiculosDto gothDto) {
		gothamVeiculosDomain gt = gotMapper.toEntity(gothDto);
		try {
		gt.setVeiculo(gothDto.getVeiculo());
		gt.setCambio(gothDto.getCambio());
		gt.setCombustivel(gothDto.getCombustivel());
		gt.setMontadora(gothDto.getMontadora());
		gt.setValor(gothDto.getValor());
		gt = addCarroNovo(gt);
		
			
		} catch (Exception e) {
			System.out.println("Para adicionar um novo veiculo é nesscessario preencher todos os dados");
		}
		return gotMapper.toDto(gt);
	}

	private gothamVeiculosDomain addCarroNovo(gothamVeiculosDomain gt) {
		return gotRepos.save(gt);
	}

	@Override
	public gothamVeiculosDomain vendeu(Long id) {
		gothamVeiculosDomain got = fiindVeiculoById(id);
		gotRepos.delete(got);
		return got;
	}

}
