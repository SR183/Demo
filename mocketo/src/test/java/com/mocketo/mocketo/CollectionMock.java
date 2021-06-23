package com.mocketo.mocketo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CollectionMock {

	@Mock
	List<String> list;
	
	@Test
	void test() {
		when(list.size()).thenReturn(6);
		assertEquals(6, list.size());
	}
	
	@Test
	void test1() {
		when(list.get(0)).thenReturn("hello").thenReturn("mockito");
		assertEquals("hello", list.get(0));
		assertEquals("mockito", list.get(0));
		assertEquals("mockito", list.get(0));
		assertNotNull(list.get(0));
		assertNull(list.get(1));
	}
	
	@Test
	void test2() {
		when(list.get(anyInt())).thenReturn("mockito");
		assertEquals("mockito", list.get(10));
		assertEquals("mockito", list.get(20));
	}
	
	@Test
	void test4() {
		String str = list.get(0);
		Mockito.verify(list).get(0);
		
	}

	@Test
	void test5() {
		list.add("a");
		list.add("b");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(list,times(2)).add(captor.capture());
		List<String> values = captor.getAllValues();
		assertEquals("a", values.get(0));
		assertEquals("b", values.get(1));
	}
	
}
