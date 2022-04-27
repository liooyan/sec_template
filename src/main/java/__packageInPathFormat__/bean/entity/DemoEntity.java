package __packageInPathFormat__.bean.entity;

import cn.sec.core.model.base.BaseBean;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("table_demo")
public class DemoEntity extends BaseBean
{

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
