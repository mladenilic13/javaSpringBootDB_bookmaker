package kladionicaii.kladionica.serviceImplementationClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.OperaterDao;
import kladionicaii.kladionica.pojoClasses.Operater;
import kladionicaii.kladionica.serviceClasses.OperaterService;

@Service
public class OperaterServiceImpl implements OperaterService {

	// can be single field autowired
	private OperaterDao operaterRepository;
	
	// use constructor autowireing for more complex constructors
	@Autowired
	public OperaterServiceImpl(OperaterDao operaterRepository) {
		this.operaterRepository = operaterRepository;
	}

	@Override
//	@Transactional put transactional if needed
	public List<Operater> findAll() {
		return operaterRepository.findAll();
	}

	@Override
	public Operater findById(Integer id) {
		Optional<Operater> result = operaterRepository.findById(id);
		Operater operater = null;
		if (result.isPresent()) {
			operater = result.get();
		} else {
			System.out.println("no result");
		}
		return operater;
	}
	
	@Override
	public Operater save(Operater operater) {
		operaterRepository.save(operater);
		// alternative
//		operaterRepository.saveAndFlush(operater);
		return operater;
	}

	@Override
	public Operater update1(Integer id, String name, String pass) {
		Optional<Operater> result = operaterRepository.findById(id);
		Operater updateOperater = null;
		if (result.isPresent()) {
			updateOperater = result.get();
			updateOperater.setName(name);
			updateOperater.setPass(pass);
			operaterRepository.save(updateOperater);
		} else {
			System.out.println("no result");
		}
		return updateOperater;
	}
	
	@Override
	public Operater update2(Operater operater) {
		Integer tempid = operater.getId();
		Optional<Operater> result = operaterRepository.findById(tempid);
		Operater updateOperater = null;
		if (result.isPresent()) {
			updateOperater = result.get();
			updateOperater.setName(operater.getName());
			updateOperater.setPass(operater.getPass());
			operaterRepository.save(updateOperater);
		} else {
			System.out.println("no result");
		}
		return updateOperater;
	}
	
	@Override
	public void deleteById(Integer id) {
		operaterRepository.deleteById(id);
	}

	@Override
	public void deleteByObject(Operater operater) {
		operaterRepository.delete(operater);
		
	}

}
