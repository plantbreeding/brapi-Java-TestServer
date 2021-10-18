package org.brapi.test.BrAPITestServer;

import org.brapi.test.BrAPITestServer.service.germ.PurdyNode;
import org.brapi.test.BrAPITestServer.service.germ.PurdyNotationUtil;
import org.junit.Test;


public class UnitTests {


	
	@Test
	public void testPurdyParser() {
		String purdy = "ABC/DEF//ABC/DEF/3/GHI/DEF/3/XYZ";
		
		PurdyNode root = PurdyNotationUtil.parsePurdy(purdy);
		
	}

	
}
