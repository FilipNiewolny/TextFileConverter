package pl.SDA;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MyObject {
    private Map<String, String> map = new LinkedHashMap<>();

    @Override
    public String toString() {
        return map.values() + "";
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setKey(String key, String value) {
        map.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return Objects.equals(map, myObject.map);
    }

    @Override
    public int hashCode() {

        return Objects.hash(map);
    }
}
