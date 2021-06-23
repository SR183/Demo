package com.mocketo.mocketo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BusinesServiceMockTest {
	
	@InjectMocks
	private BusinessService bService;
	
	@Mock
	private DataService serviceMock;
	
	/*@BeforeEach
	public void setDataService() {
		// injected dependecy with InjectMock
		bService.setService(serviceMock);
	}*/
	
	@Test
	public void testGretest() {
		
		when(serviceMock.retreiveAllData()).thenReturn(new int[] {1,2,3}).thenReturn(new int[] {4,5,8});
		assertEquals(3,bService.findGreatest());
		assertEquals(8,bService.findGreatest());
		
	}
	
	@Test
	public void testOne() {
		when(serviceMock.retreiveAllData()).thenReturn(new int[] {1,2,6});
		assertEquals(6, bService.findGreatest());
		
		//verify(serviceMock,times(1)).retreiveAllData();
		
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(serviceMock).addItem(captor.capture());
		
		System.out.println(captor.getValue());
		assertEquals(6, captor.getValue());
	}

	
}

