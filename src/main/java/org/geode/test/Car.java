/** Rapresent the model */

package org.geode.test;

public class Car  {

    public Car() {}

    public String getIdTag()  {
        return idTag;
    }

    public String getManufacturer()  {
        return manufacturer;
    }

    public String getModel()  {
        return model;
    }

    public String getColour()  {
        return colour;
    }

    public String getDate()  {
        return date;
    }

    public void setIdTag(String idTag)  {
        this.idTag = idTag;
    }

    public void setManufacturer(String manufacturer)  {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model)  {
        this.model = model;
    }

    public void setColour(String colour)  {
        this.colour = colour;
    }

    public void setDate(String date)  {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car myCar = (Car) o;

        return getIdTag().equals(myCar.getIdTag());
    }

    @Override
    public int hashCode() {
        return getIdTag().hashCode();
    }

    private String idTag;
    private String manufacturer;
    private String model;
    private String colour;
    private String date;
}
