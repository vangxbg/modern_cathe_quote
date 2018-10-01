package io.mctdlc.springbootstarter.directLaborCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectLaborCostService {
	
	
	@Autowired
	private DirectLaborCostRepository directLaborCostRepository;
	
	public List<DirectLaborCost> getAllDirectLaborCosts() {
		List<DirectLaborCost> directLaborCosts = new ArrayList<>();
		directLaborCostRepository.findAll()
		.forEach(directLaborCosts::add);
		return directLaborCosts;
	}
	
	public Optional<DirectLaborCost> getDirectLaborCost(Long id) {
		return directLaborCostRepository.findById(id);
	}

	public void addDirectLaborCost(DirectLaborCost directLaborCost) {
		directLaborCostRepository.save(directLaborCost);
	}

	public void updateDirectLaborCost(DirectLaborCost directLaborCost) {
		directLaborCostRepository.save(directLaborCost);
	}

	public void deleteDirectLaborCost(Long id) {
		directLaborCostRepository.deleteById(id);
	}

}
