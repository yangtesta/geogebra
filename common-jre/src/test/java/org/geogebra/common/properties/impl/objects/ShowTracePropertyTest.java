package org.geogebra.common.properties.impl.objects;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.geogebra.common.BaseUnitTest;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoNumeric;
import org.geogebra.common.kernel.geos.GeoText;
import org.junit.Test;

public class ShowTracePropertyTest extends BaseUnitTest {

	@Test
	public void testConstructorForPoint() {
		GeoElement point = addAvInput("(1,2)");
		try {
			new ShowTraceProperty(point);
		} catch (NotApplicablePropertyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testConstructorForNumeric() {
		GeoNumeric slider = addAvInput("1");
		assertThrows(NotApplicablePropertyException.class, () -> new ShowTraceProperty(slider));
	}

	@Test
	public void testConstructorForText() {
		GeoText text = addAvInput("\"\"");
		assertThrows(NotApplicablePropertyException.class, () -> new ShowTraceProperty(text));
	}
}