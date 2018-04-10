package org.geogebra.common.properties.impl.graphics;

import org.geogebra.common.main.Localization;
import org.geogebra.common.main.settings.EuclidianSettings;
import org.geogebra.common.properties.AbstractProperty;
import org.geogebra.common.properties.BooleanProperty;

/**
 * This property controls the visibility of the axis labels.
 */
public class AxesLabelsVisibilityProperty extends AbstractProperty implements BooleanProperty {

    private EuclidianSettings euclidianSettings;

    /**
     * Constructs an Axes visibility property.
     *
     * @param localization      localization for the title
     * @param euclidianSettings euclidian settings
     */
    public AxesLabelsVisibilityProperty(Localization localization, EuclidianSettings euclidianSettings) {
        super(localization, "Show");
        this.euclidianSettings = euclidianSettings;
    }

    @Override
    public boolean getValue() {
        boolean[] axisNumbers = euclidianSettings.getShowAxisNumbers();
        boolean value = false;
        for (boolean axisNumber : axisNumbers) {
            value |= axisNumber;
        }
        return value;
    }

    @Override
    public void setValue(boolean value) {
        int length = euclidianSettings.getShowAxisNumbers().length;
        for (int i = 0; i < length; i++) {
            euclidianSettings.setShowAxisNumbers(i, value);
        }
    }
}
