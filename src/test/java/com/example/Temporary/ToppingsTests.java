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

import com.example.Temporary.dao.ToppingsDao;
import com.example.Temporary.dto.SizesDTO;
import com.example.Temporary.dto.ToppingsDTO;
import com.example.Temporary.models.Sizes;
import com.example.Temporary.models.Toppings;
import com.example.Temporary.service_impl.ToppingsImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ToppingsTests {

	@Mock
	private ToppingsDao toppingsDao;

	@InjectMocks
	private ToppingsImpl toppingsImpl;

	@Test
	public void getAllToppingsTest() throws Exception {
		List<Toppings> expectedToppingsList = new ArrayList<>();

		Toppings expectedToppings = new Toppings();
		expectedToppings.setToppingsId(1000L);
		expectedToppings.setToppingsName("Cheese");
		expectedToppings.setToppingsPrice(10.0D);
		expectedToppingsList.add(expectedToppings);
		when(toppingsDao.findAll()).thenReturn(expectedToppingsList);
		// List<Composer> actualComposerList = composerServiceImpl.getAllComposer();
		List<Toppings> actualToppingsList = toppingsImpl.getAll();
		System.out.println(actualToppingsList.toString());
		assertEquals(actualToppingsList, expectedToppingsList);

	}
	// --------------------POST METHOD----------------------------
		@Test
		public void createToppingsTest() /* throws Exception */ {
			ToppingsDTO actualToppingsDTO = new ToppingsDTO();
			// actualSizes.setSizeId(1L);
			actualToppingsDTO.setToppingsName("Cheese");
			actualToppingsDTO.setToppingsPrice(10D);
			Toppings toppingsActuall = new Toppings();
			toppingsActuall.setToppingsName(actualToppingsDTO.getToppingsName());
			toppingsActuall.setToppingsPrice(actualToppingsDTO.getToppingsPrice());
			when(toppingsDao.save(Mockito.any())).thenReturn(toppingsActuall);
			Toppings expectedToppings = new Toppings();
			expectedToppings = toppingsImpl.createTopping(actualToppingsDTO);
			System.out.println("actualSizes" + toppingsActuall.toString());
			System.out.println("expectedSizes---------------" + expectedToppings.toString());
			assertEquals(expectedToppings, toppingsActuall);

		}
		
		// --------------------PUT METHOD----------------------------
		@Test
		public void updateToppingsTest() /* throws Exception */ {
			ToppingsDTO actualToppingsDTO = new ToppingsDTO();

			actualToppingsDTO.setToppingsName("Cheese");
			actualToppingsDTO.setToppingsPrice(10D);
			Toppings toppingsActuall = new Toppings();
			toppingsActuall.setToppingsId(1L);
			toppingsActuall.setToppingsName(actualToppingsDTO.getToppingsName());
			toppingsActuall.setToppingsPrice(actualToppingsDTO.getToppingsPrice());
			when(toppingsDao.getOne(Mockito.anyLong())).thenReturn(toppingsActuall);
			when(toppingsDao.save(Mockito.any())).thenReturn(toppingsActuall);

			Toppings expectedSizes = toppingsImpl.updateTopping(toppingsActuall.getToppingsId(), actualToppingsDTO);
			System.out.println("toppingsActuall-------" + toppingsActuall.toString());
			System.out.println("expectedSizes=====" + expectedSizes.toString());

			assertEquals(expectedSizes, toppingsActuall);

		}
		// --------------------GETBYID METHOD----------------------------

		@Test
		public void getSizesTest() throws Exception {

			Toppings expectedSizes = new Toppings();
			expectedSizes.setToppingsId(1000L);
			expectedSizes.setToppingsName("medium");
			expectedSizes.setToppingsPrice(100.0D);
			//when(sizesDao.getOne(1L)).thenReturn(expectedSizes); //----> Failure Case
			when(toppingsDao.getOne(Mockito.anyLong())).thenReturn(expectedSizes);
			Toppings actuaSizes = toppingsImpl.getOne(100L);
			System.out.println(actuaSizes.toString());
			assertEquals(actuaSizes, expectedSizes);

		}



}
