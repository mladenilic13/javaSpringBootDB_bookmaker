package kladionicaii.kladionica.serviceClasses;

import java.util.List;

import kladionicaii.kladionica.pojoClasses.Operater;

public interface OperaterService {
	
	public List<Operater> findAll();
	  
	public Operater findById(Integer id);

	public Operater save(Operater operater);
	
	public Operater update1(Integer id, String name, String pass);
	
	public Operater update2(Operater operater);  // id & string inside

	public void deleteById(Integer id);
	
	public void deleteByObject(Operater operater);

}
