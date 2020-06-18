package org.geogebra.common.properties.factory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.geogebra.common.BaseUnitTest;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoPoint;
import org.geogebra.common.properties.Property;
import org.junit.Test;

public class GeoElementPropertiesFactoryTest extends BaseUnitTest {

	@Test
	public void testPoint() {
		GeoPoint zeroPoint = addAvInput("(0,0)");
		GeoPoint onePoint = addAvInput("(1,1)");
		List<GeoElement> points = new ArrayList<>();
		points.add(zeroPoint);
		points.add(onePoint);
		PropertiesArray propertiesArray = GeoElementPropertiesFactory
				.createGeoElementProperties(getApp().getLocalization(), points);
		Property[] pointProperties = propertiesArray.getProperties();

		assertThat(pointProperties[0].getName(), equalTo("Show"));
		assertThat(pointProperties[1].getName(), equalTo("stylebar.Color"));
		assertThat(pointProperties[2].getName(), equalTo("Properties.Style"));
		assertThat(pointProperties[3].getName(), equalTo("Size"));
		assertThat(pointProperties[4].getName(), equalTo("stylebar.Caption"));
		assertThat(pointProperties[5].getName(), equalTo("ShowTrace"));
		assertThat(pointProperties[6].getName(), equalTo("fixed"));
		assertThat(pointProperties[7].getName(), equalTo("ShowInAlgebraView"));
	}
}