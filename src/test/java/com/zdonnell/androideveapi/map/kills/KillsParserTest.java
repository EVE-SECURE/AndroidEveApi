package com.zdonnell.androideveapi.map.kills;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;


import com.zdonnell.androideveapi.core.ApiPage;
import com.zdonnell.androideveapi.core.ApiPath;
import com.zdonnell.androideveapi.exception.ApiException;
import com.zdonnell.androideveapi.map.kills.KillsParser;
import com.zdonnell.androideveapi.map.kills.KillsResponse;
import com.zdonnell.androideveapi.utils.NoAuthParserTest;

public class KillsParserTest extends NoAuthParserTest {
	public KillsParserTest() {
		super(ApiPath.MAP, ApiPage.KILLS);
	}

	@Test
	public void getResponse() throws ApiException {
		KillsParser parser = KillsParser.getInstance();
		KillsResponse response = parser.getResponse();
		assertNotNull(response);
		Map<Integer, Integer> shipKills = response.getShipKills();
		assertNotNull(shipKills);
		assertEquals(2603, shipKills.size());
		Map<Integer, Integer> factionKills = response.getFactionKills();
		assertNotNull(factionKills);
		assertEquals(2603, factionKills.size());
		Map<Integer, Integer> podKills = response.getPodKills();
		assertNotNull(podKills);
		assertEquals(2603, podKills.size());
		assertEquals(3, shipKills.get(30001001).longValue());
		assertEquals(203, factionKills.get(30001001).longValue());
		assertEquals(5, podKills.get(30001001).longValue());
		assertEquals(0, shipKills.get(30001039).longValue());
		assertEquals(40, factionKills.get(30001039).longValue());
		assertEquals(0, podKills.get(30001039).longValue());
	}
}