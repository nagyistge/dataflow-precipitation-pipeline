package com.google.cloud.dataflow.samples.daily_precipitation_sample;

import com.google.gson.annotations.SerializedName;

/**
 * @author jsvangeffen
 *
 * Object representation of a single data point from precipitation data.
 * Created for GSON, matches JSON file representation.
 */
public class PrecipitationRow {
  public String type;
  public Prop properties;
  public Geo geometry;

  /**
   * Represents the properties of this row of precipitation data.
   */
  // NOTE: These names must be capitalized to match up correctly with JSON key names.
  // This will allow GSON to load the correct values into a PrecipitationRow object.
  public static class Prop {
    @SerializedName("Id")
    public double id; // unique point ID
    @SerializedName("Hrapx")
    public long hrapx; // x-coordinate, for graphing
    @SerializedName("Hrapy")
    public long hrapy; // y-coordinate, for graphing
    @SerializedName("Lat")
    public double lat; // latitude
    @SerializedName("Lon")
    public double lon; // longitude
    @SerializedName("Globvalue")
    public double globvalue; // 24-hr precipitation
    @SerializedName("Units")
    public String units; // always inches
  }

  /**
   * Represents the (x, y) coordinates of this row of data
   * relative to all other points.
   * Not used for this pipeline.
   */
  public static class Geo {
    public String type;
    public double[] coordinates; // size 2
  }
}
