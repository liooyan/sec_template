package __packageInPathFormat__.bean.params.demo;

import cn.sec.core.model.base.InputConverter;
import __packageInPathFormat__.bean.entity.DemoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel("demo添加接口参数")
public  class DemoAddParam implements InputConverter<DemoEntity> {

    @NotEmpty(message = "名称不可为空")
    @ApiModelProperty("名称")
    private String name;

    @NotEmpty(message = "配置不可为空")
    @ApiModelProperty("配置")
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
