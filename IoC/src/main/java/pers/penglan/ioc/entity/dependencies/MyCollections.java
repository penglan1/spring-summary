package pers.penglan.ioc.entity.dependencies;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class MyCollections {
    private Map<String, String> map = null;
    private List<String> list = null;
    private Set<String> set = null;
    private Properties properties = null;

    public MyCollections() {
    }

    public MyCollections(Map<String, String> map, List<String> list, Set<String> set, Properties properties) {
        this.map = map;
        this.list = list;
        this.set = set;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MyCollections{" +
                "map=" + map +
                ", list=" + list +
                ", set=" + set +
                ", properties=" + properties +
                '}';
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
