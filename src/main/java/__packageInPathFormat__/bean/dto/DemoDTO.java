package __packageInPathFormat__.bean.dto;

import cn.sec.core.model.base.OutputConverter;
import __packageInPathFormat__.bean.entity.DemoEntity;


public class DemoDTO extends DemoEntity  {

    private String name;


    private String configuration;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
