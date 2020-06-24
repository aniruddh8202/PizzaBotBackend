package com.example.Temporary;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Temporary.dao.SizesDao;
import com.example.Temporary.dto.SizesDTO;
import com.example.Temporary.models.Sizes;
import com.example.Temporary.service_impl.SizesImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class SizesTests {

	@Mock
	private SizesDao sizesDao;

	@InjectMocks
	private SizesImpl sizesImpl;

	@Test
	public void getAllSizesTest() throws Exception {
		List<Sizes> expectedSizesList = new ArrayList<>();

		Sizes expectedSizes = new Sizes();
		expectedSizes.setSizeId(1000L);
		expectedSizes.setSizeName("medium");
		expectedSizes.setSizePrice(0.0D);
		expectedSizesList.add(expectedSizes);
		when(sizesDao.findAll()).thenReturn(expectedSizesList);
		// List<Composer> actualComposerList = composerServiceImpl.getAllComposer();
		List<Sizes> actualSizesList = sizesImpl.getAll();
		System.out.println(actualSizesList.toString());
		assertEquals(actualSizesList, expectedSizesList);

	}

	// --------------------POST METHOD----------------------------
	@Test
	public void createSizesTest() /* throws Exception */ {
		SizesDTO actualSizesDTO = new SizesDTO();
		// actualSizes.setSizeId(1L);
		actualSizesDTO.setSizeName("small");
		actualSizesDTO.setSizePrice(100D);
		Sizes sizesActuall = new Sizes();
		sizesActuall.setSizeName(actualSizesDTO.getSizeName());
		sizesActuall.setSizePrice(actualSizesDTO.getSizePrice());
		when(sizesDao.save(Mockito.any())).thenReturn(sizesActuall);
		Sizes expectedSizes = new Sizes();
		expectedSizes = sizesImpl.createSize(actualSizesDTO);
		System.out.println("actualSizes" + sizesActuall.toString());
		System.out.println("expectedSizes---------------" + expectedSizes.toString());
		assertEquals(expectedSizes, sizesActuall);

	}

	// --------------------PUT METHOD----------------------------
	@Test
	public void updateSizesTest() /* throws Exception */ {
		SizesDTO actualSizesDTO = new SizesDTO();

		actualSizesDTO.setSizeName("small");
		actualSizesDTO.setSizePrice(100D);
		Sizes sizesActuall = new Sizes();
		sizesActuall.setSizeId(1L);
		sizesActuall.setSizeName(actualSizesDTO.getSizeName());
		sizesActuall.setSizePrice(actualSizesDTO.getSizePrice());
		when(sizesDao.getOne(Mockito.anyLong())).thenReturn(sizesActuall);
		when(sizesDao.save(Mockito.any())).thenReturn(sizesActuall);

		Sizes expectedSizes = sizesImpl.updateSize(sizesActuall.getSizeId(), actualSizesDTO);
		System.out.println("sizesActuall-------" + sizesActuall.toString());
		System.out.println("expectedSizes=====" + expectedSizes.toString());

		assertEquals(expectedSizes, sizesActuall);

	}
	// --------------------GETBYID METHOD----------------------------

	@Test
	public void getSizesTest() throws Exception {

		Sizes expectedSizes = new Sizes();
		expectedSizes.setSizeId(1000L);
		expectedSizes.setSizeName("medium");
		expectedSizes.setSizePrice(100.0D);
		//when(sizesDao.getOne(1L)).thenReturn(expectedSizes); //----> Failure Case
		when(sizesDao.getOne(Mockito.anyLong())).thenReturn(expectedSizes);
		Sizes actuaSizes = sizesImpl.getOne(100L);
		System.out.println(actuaSizes.toString());
		assertEquals(actuaSizes, expectedSizes);

	}

}
