package com.yangzg.hibernate.model1.embeddable;

import com.yangzg.hibernate.model1.City;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/10/26.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
//@Embeddable
public class GPS implements Coordinates {
    private City city;
    private double latitude;
    private double longitude;

    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double x() {
        return latitude;
    }

    @Override
    public double y() {
        return longitude;
    }
}
