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

import com.example.Temporary.dao.RealPizzaDao;
import com.example.Temporary.dto.RealPizzaDTO;
import com.example.Temporary.dto.SizesDTO;
import com.example.Temporary.models.RealPizza;
import com.example.Temporary.models.Sizes;
import com.example.Temporary.service_impl.RealPizzaimpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RealPizzaTests {
	
	@Mock
	private RealPizzaDao realPizzaDao;

	@InjectMocks
	private RealPizzaimpl realPizzaimpl;

	@Test
	public void getAllRealPizzaTest() throws Exception {
		List<RealPizza> expectedRealPizzaList = new ArrayList<>();

		RealPizza expectedRealPizza = new RealPizza();
		expectedRealPizza.setRealPizzaId(1L);
		expectedRealPizza.setRealPizzaName("VegPizza");
		expectedRealPizza.setBasePizzaPrice(100D);
		expectedRealPizzaList.add(expectedRealPizza);
		when(realPizzaDao.findAll()).thenReturn(expectedRealPizzaList);
		// List<Composer> actualComposerList = composerServiceImpl.getAllComposer();
		List<RealPizza> actualRealPizzaList = realPizzaimpl.getAll();
		System.out.println(actualRealPizzaList.toString());
		assertEquals(actualRealPizzaList, expectedRealPizzaList);

	}

	// --------------------POST METHOD----------------------------
			@Test
			public void createRealPizzaTest() /* throws Exception */ {
				RealPizzaDTO actualRealPizzaDTO = new RealPizzaDTO();
				// actualSizes.setSizeId(1L);
				actualRealPizzaDTO.setRealPizzaName("VegPizza");
				actualRealPizzaDTO.setBasePizzaPrice(100D);
				RealPizza realPizzaActuall = new RealPizza();
				realPizzaActuall.setRealPizzaName(actualRealPizzaDTO.getRealPizzaName());
				realPizzaActuall.setBasePizzaPrice(actualRealPizzaDTO.getBasePizzaPrice());
				when(realPizzaDao.save(Mockito.any())).thenReturn(realPizzaActuall);
				RealPizza expectedRealPizza = new RealPizza();
				expectedRealPizza = realPizzaimpl.createRealPizza(actualRealPizzaDTO);
				System.out.println("actualSizes" + realPizzaActuall.toString());
				System.out.println("expectedSizes---------------" + expectedRealPizza.toString());
				assertEquals(expectedRealPizza, realPizzaActuall);

			}
			// --------------------PUT METHOD----------------------------
			@Test
			public void updateRealPizzaTest() /* throws Exception */ {
				RealPizzaDTO actualRealPizzaDTO = new RealPizzaDTO();

				actualRealPizzaDTO.setRealPizzaName("VEGPIZZA");
				actualRealPizzaDTO.setBasePizzaPrice(100D);
				RealPizza realPizzaActuall = new RealPizza();
				realPizzaActuall.setRealPizzaId(1L);
				realPizzaActuall.setRealPizzaName(actualRealPizzaDTO.getRealPizzaName());
				realPizzaActuall.setBasePizzaPrice(actualRealPizzaDTO.getBasePizzaPrice());
				when(realPizzaDao.getOne(Mockito.anyLong())).thenReturn(realPizzaActuall);
				when(realPizzaDao.save(Mockito.any())).thenReturn(realPizzaActuall);

				RealPizza expectedSizes = realPizzaimpl.updateRealPizza(realPizzaActuall.getRealPizzaId(), actualRealPizzaDTO);
				System.out.println("realPizzaActuall-------" + realPizzaActuall.toString());
				System.out.println("expectedSizes=====" + expectedSizes.toString());

				assertEquals(expectedSizes, realPizzaActuall);

			}
			// --------------------GETBYID METHOD----------------------------

//			@Test
//			public void getSizesTest() throws Exception {
//
//				Sizes expectedSizes = new Sizes();
//				expectedSizes.setSizeId(1000L);
//				expectedSizes.setSizeName("medium");
//				expectedSizes.setSizePrice(100.0D);
//				//when(sizesDao.getOne(1L)).thenReturn(expectedSizes); //----> Failure Case
//				when(sizesDao.getOne(Mockito.anyLong())).thenReturn(expectedSizes);
//				Sizes actuaSizes = sizesImpl.getOne(100L);
//				System.out.println(actuaSizes.toString());
//				assertEquals(actuaSizes, expectedSizes);
//
//			}

	

}
