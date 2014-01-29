/**
 * Copyright (c) 2014 SMC Treviso s.r.l. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * Appcelerator Titanium is Copyright (c) 2009-2010 by Appcelerator, Inc.
 * and licensed under the Apache Public License (version 2)
 */

package it.smc.alternative.progressbar;

import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.util.TiUIHelper;
import org.appcelerator.titanium.view.TiUIView;

/**
 * @author Pier Paolo Ramon
 */
public class TiUIProgressBar extends TiUIView {

    private TextView label;
    private ProgressBar progress;
    private LinearLayout view;

    public static final String TAG = "AltProgressBar";

    public TiUIProgressBar(final TiViewProxy proxy) {
        super(proxy);

        view = new LinearLayout(proxy.getActivity()) {
            @Override
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                TiUIHelper.firePostLayoutEvent(proxy);
            }
        };

        view.setOrientation(LinearLayout.VERTICAL);
        label = new TextView(proxy.getActivity());
        label.setGravity(Gravity.TOP | Gravity.LEFT);
        label.setPadding(0, 0, 0, 0);
        label.setSingleLine(false);

        progress = new ProgressBar(proxy.getActivity(), null, android.R.attr.progressBarStyleHorizontal);
        progress.setIndeterminate(false);
        progress.setMax(1000);

        view.addView(label);
        view.addView(progress);

        setNativeView(view);
    }

    @Override
    public void processProperties(KrollDict d) {
        super.processProperties(d);

        if (d.containsKey(TiC.PROPERTY_MESSAGE)) {
            handleSetMessage(TiConvert.toString(d, TiC.PROPERTY_MESSAGE));
        }

        if (d.containsKey("indeterminate")) {
            handleSetIndeterminate(TiConvert.toBoolean(d, "indeterminate", false));
        }

        updateProgress();
    }

    @Override
    public void propertyChanged(String key, Object oldValue, Object newValue, KrollProxy proxy) {
        super.propertyChanged(key, oldValue, newValue, proxy);

        if (key.equals("indeterminate")) {
            boolean indeterminate = TiConvert.toBoolean(newValue, false);
            handleSetIndeterminate(indeterminate);
        }
        else if (key.equals(TiC.PROPERTY_VALUE) || key.equals("min") || key.equals("max") ||
                key.equals("secondary")) {

            updateProgress();
        }
        else if (key.equals(TiC.PROPERTY_MESSAGE)) {
            String message = TiConvert.toString(newValue);
            if (message != null) {
                handleSetMessage(message);
            }
        }
    }

    private boolean getIndeterminate() {
        Object value = proxy.getProperty("indeterminate");
        if (value == null) {
            return false;
        }

        return TiConvert.toBoolean(value);
    }

    private double getMin() {
        Object value = proxy.getProperty("min");
        if (value == null) {
            return 0;
        }

        return TiConvert.toDouble(value);
    }

    private double getMax() {
        Object value = proxy.getProperty("max");
        if (value == null) {
            return 0;
        }

        return TiConvert.toDouble(value);
    }

    private double getSecondary() {
        Object value = proxy.getProperty("secondary");
        if (value == null) {
            return 0;
        }

        return TiConvert.toDouble(value);
    }

    private double getValue() {
        Object value = proxy.getProperty(TiC.PROPERTY_VALUE);
        if (value == null) {
            return 0;
        }

        return TiConvert.toDouble(value);
    }

    private int convertRange(double min, double max, double value, int base) {
        return (int)Math.floor((value/(max - min))*base);
    }

    public void updateProgress() {
        double min = getMin();
        double max = getMax();
        progress.setProgress(convertRange(min, max, getValue(), 1000));
        progress.setSecondaryProgress(convertRange(min, max, getSecondary(), 1000));
    }

    public void handleSetIndeterminate(boolean indeterminate) {
        progress.setIndeterminate(indeterminate);
    }

    public void handleSetMessage(String message) {
        label.setText(message);
        label.requestLayout();
    }
}
