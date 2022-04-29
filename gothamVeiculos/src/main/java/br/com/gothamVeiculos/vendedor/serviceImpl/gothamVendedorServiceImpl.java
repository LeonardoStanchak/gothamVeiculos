package br.com.gothamVeiculos.vendedor.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gothamVeiculos.vendedor.Dto.gothamVendedorDto;
import br.com.gothamVeiculos.vendedor.domain.gothamVendedorDomain;
import br.com.gothamVeiculos.vendedor.mapper.gothamVendedorMapper;
import br.com.gothamVeiculos.vendedor.repository.gothamVendedorRepository;
import br.com.gothamVeiculos.vendedor.service.gothamVendedorService;
@Service
public class gothamVendedorServiceImpl implements gothamVendedorService{

	@Autowired
	private gothamVendedorRepository gotRepos;
	
	@Autowired
	private gothamVendedorMapper gotMapper;
	
	@Transactional
	public List<gothamVendedorDto> listAll() {
		List<gothamVendedorDomain>gotList = gotRepos.findAll();
		return gotList.stream().map(x -> gotMapper.toDto(x)).collect(Collectors.toList());
	}

	@Transactional
	public gothamVendedorDomain findByVendedorId(Long id) {
		return gotRepos.findById(id).orElseThrow();
	}

}
