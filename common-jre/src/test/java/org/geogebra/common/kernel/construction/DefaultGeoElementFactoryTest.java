package org.geogebra.common.kernel.construction;

import org.geogebra.common.BaseUnitTest;
import org.geogebra.common.kernel.geos.GeoAngle;
import org.geogebra.common.kernel.geos.GeoNumeric;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultGeoElementFactoryTest extends BaseUnitTest {

	private GeoElementFactory geoElementFactory;

	@Before
	public void setUp() {
		geoElementFactory = new DefaultGeoElementFactory(getConstruction());
	}

	@Test
	public void createNumeric() {
		GeoNumeric numeric = geoElementFactory.createNumeric();
		assertThat(numeric.showInEuclidianView(), is(true));
	}

	@Test
	public void createAngle() {
		GeoAngle angle = geoElementFactory.createAngle();
		assertThat(angle.showInEuclidianView(), is(true));
	}
}