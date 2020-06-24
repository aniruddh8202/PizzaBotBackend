package com.example.Temporary.service_impl;

import com.example.Temporary.dao.SizesDao;
import com.example.Temporary.dto.SizesDTO;
import com.example.Temporary.models.Sizes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizesImpl implements ISize {

	@Autowired
	SizesDao sizesDao;

	@Override
	public Sizes createSize(SizesDTO sizesDTO) {

		Sizes sizes = new Sizes();

		sizes.setSizeName(sizesDTO.getSizeName());

		sizes.setSizePrice(sizesDTO.getSizePrice());

		//Sizes sizeObjs = sizesDao.save(sizes);
		
		return sizesDao.save(sizes);
	}

	@Override
	public Sizes updateSize(Long id, SizesDTO sizesDTO) {

		Sizes sizes = sizesDao.getOne(id);

		sizes.setSizeName(sizesDTO.getSizeName());

		sizes.setSizePrice(sizesDTO.getSizePrice());

		return sizesDao.save(sizes);
	}

	@Override
	public String deleteSize(Long id) {

		sizesDao.deleteById(id);

		return "Successfully Deleted Size with id:" + id;
	}

	@Override
	public Sizes getOne(Long id) {
		return sizesDao.getOne(id);
	}

	@Override
	public List<Sizes> getAll() {
		return sizesDao.findAll();
	}

}
