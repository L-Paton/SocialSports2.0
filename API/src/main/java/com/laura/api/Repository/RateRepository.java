package com.laura.api.Repository;

import java.util.Set;

import com.laura.api.model.RateUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<RateUser,Long>{
    
    Set<RateUser> findByRateIdVotedId(long id);

    Set<RateUser> findByRateIdVoterId(long id);

}