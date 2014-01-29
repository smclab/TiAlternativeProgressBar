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

import android.app.Activity;

import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

/**
 * @author Pier Paolo Ramon
 */
@Kroll.proxy(creatableInModule=AlternativeProgressBarModule.class, propertyAccessors = {
        "min", "max",
        TiC.PROPERTY_VALUE,
        TiC.PROPERTY_MESSAGE,
        "indeterminate",
        "secondary"
})
public class ProgressBarProxy extends TiViewProxy {

    public ProgressBarProxy() {
        super();
    }

    public ProgressBarProxy(TiContext tiContext) {
        super();
    }

    @Override
    public TiUIView createView(Activity activity) {
        return new TiUIProgressBar(this);
    }

    @Override
    public String getApiName() {
        return "it.smc.alternativeprogressbar.ProgressBar";
    }
}
