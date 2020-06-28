package br.com.codenation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatisticUtilTest {

	@Test
	public void testAverage() {
		assertEquals(3, StatisticUtil.average(new int[] {1,2,3,4,5}));
	}

	@Test
	public void testMode() {
		assertEquals(3, StatisticUtil.mode(new int[] {1,2,3,3}));
	}
	
	@Test
	public void testMedian() {
		assertEquals(3, StatisticUtil.median(new int[] {1,2,3,4,5}));
	}

	@Test
	public void testMedian1() {
		assertEquals(-3, StatisticUtil.median(new int[] {1,2,-3,4,5}));
	}

	@Test
	public void testMedian2() {
		assertEquals(5, StatisticUtil.median(new int[] {1,2,7,3,4,5}));
	}

	@Test
	public void testMedian3() {
		assertEquals(-2, StatisticUtil.median(new int[] {1,2,-7,3,4,5}));
	}

	@Test
	public void testMedian4() {
		assertEquals(-5, StatisticUtil.median(new int[] {1,2,-7,-3,4,5}));
	}


}
