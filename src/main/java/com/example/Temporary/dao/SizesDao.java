package com.example.Temporary.dao;

import com.example.Temporary.dto.SizesDTO;
import com.example.Temporary.models.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SizesDao extends JpaRepository<Sizes, Long> {

	//Sizes save(SizesDTO actualSizes);

	//SizesDTO save(SizesDTO actualSizes);


}
