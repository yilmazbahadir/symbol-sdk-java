/*
 *  Copyright 2019 NEM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.nem.sdk.infrastructure.vertx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.nem.sdk.model.transaction.JsonHelper;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests for {@link JsonHelperJackson2}
 *
 * @author Fernando Boucquez
 */
public class JsonHelperJackson2Test {


    private JsonHelper jsonHelper;

    @Before
    public void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        jsonHelper = new JsonHelperJackson2(mapper);
    }

    @Test
    public void shouldParsePrintedObject() {
        Car car = new Car("Renault", "Scenic", 2005);
        String json = jsonHelper.print(car);

        Assertions.assertNotNull(json);
        Assertions.assertTrue(json.contains("Renault"));

        Car parsedCar = jsonHelper.parse(json, Car.class);
        Assertions.assertEquals(car, parsedCar);
        Assertions.assertEquals(BigInteger.valueOf(2005), parsedCar.getYear());

    }

    @Test
    public void shouldParsePrintedConvertObject() {
        Car car = new Car("Renault", "Scenic", 2005);
        String json = jsonHelper.print(car);

        Assertions.assertNotNull(json);
        Assertions.assertTrue(json.contains("Renault"));

        Object genericType = jsonHelper.parse(json);

        Car convertedType = jsonHelper.convert(genericType, Car.class);

        Assertions.assertEquals(car, convertedType);
        Assertions.assertEquals(BigInteger.valueOf(2005), convertedType.getYear());

    }


    @Test
    public void shouldParseGenericNode() {
        Car car = new Car("Renault", "11", 1989);
        String json = jsonHelper.print(car);

        Assertions.assertNotNull(json);
        Assertions.assertTrue(json.contains("Renault"));

        Object parsedCar = jsonHelper.parse(json);
        Assertions.assertEquals(ObjectNode.class, parsedCar.getClass());

        Assert.assertEquals(json, jsonHelper.print(parsedCar));

    }

    @Test
    public void shouldReturnValues() {
        Car car = new Car("Renault", "11", 1989, 1L, 2L, 3L, 4L);
        Assertions.assertEquals(car.getBrand(), jsonHelper.getString(car, "brand"));
        Assertions.assertEquals(car.getModel(), jsonHelper.getString(car, "model"));
        Assertions
            .assertEquals(car.getYear().intValue(), jsonHelper.getInteger(car, "year").intValue());
        Assertions.assertEquals(car.getYear().longValue(),
            jsonHelper.getInteger(car, "year").longValue());

        Assertions.assertNull(jsonHelper.getBoolean(car, "invalidProp"));
        Assertions.assertNull(jsonHelper.getString(car, "invalidProp"));
        Assertions.assertNull(jsonHelper.getInteger(car, "invalidProp"));
        Assertions.assertNull(jsonHelper.getLongList(car, "invalidProp"));
        Assertions.assertNull(jsonHelper.getLong(car, "invalidProp"));

        Assertions.assertNull(jsonHelper.getInteger(car, "model", "notInnerProperty"));
        Assertions.assertEquals(car.getValues(), jsonHelper.getLongList(car, "values"));

    }

    @Test
    public void shouldRaiseErrorOnInvalidPath() {
        Car car = new Car("Renault", "11", 1989, 1L, 2L, 3L, 4L);

        Assertions.assertThrows(IllegalArgumentException.class, () -> jsonHelper.getInteger(car));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jsonHelper.getString(car));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jsonHelper.getBoolean(car));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jsonHelper.getLong(car));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jsonHelper.getLongList(car));
    }

    private static class Car {

        private String brand;

        private String model;

        private BigInteger year;

        private List<Long> values;


        public Car(String brand, String model, int year, Long... values) {
            this.brand = brand;
            this.model = model;
            this.year = BigInteger.valueOf(year);
            this.values = values == null ? null : Arrays.asList(values);
        }

        public Car() {
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public BigInteger getYear() {
            return year;
        }

        public void setYear(BigInteger year) {
            this.year = year;
        }

        public List<Long> getValues() {
            return values;
        }

        public void setValues(List<Long> values) {
            this.values = values;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Car car = (Car) o;
            return Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(year, car.year) &&
                Objects.equals(values, car.values);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, model, year, values);
        }
    }

}
