/*
 * All content copyright (c) 2003-2006 Terracotta, Inc., except as may otherwise be noted in a separate copyright
 * notice. All rights reserved.
 */
package com.tc.object.cache;

import com.tc.properties.TCProperties;
import com.tc.util.Assert;

public class LFUConfigImpl implements LFUConfig {

  private final float   agingFactor;
  private final int     ignorePercentage;
  private final boolean debug;

  public LFUConfigImpl(TCProperties lfuProperties) {
    agingFactor = lfuProperties.getFloat("agingFactor");
    Assert.assertTrue("Invalid agingFactor in properties file", agingFactor >= 0.0 && agingFactor <= 1.0);
    ignorePercentage = lfuProperties.getInt("recentlyAccessedIgnorePercentage");
    Assert.assertTrue("Invalid recentlyAccessedIgnorePercentage in properties file", ignorePercentage >= 0
                                                                                     && ignorePercentage <= 100);
    debug = lfuProperties.getBoolean("debug.enabled");
  }

  public float getAgingFactor() {
    return agingFactor;
  }

  public int getRecentlyAccessedIgnorePercentage() {
    return ignorePercentage;
  }

  public boolean isDebugEnabled() {
    return debug;
  }

}
