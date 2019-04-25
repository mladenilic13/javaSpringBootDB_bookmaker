package kladionicaii.kladionica.daoClasses;

import org.springframework.data.jpa.repository.JpaRepository;

import kladionicaii.kladionica.pojoClasses.Game;

public interface GameDao extends JpaRepository<Game, Integer>{
}
