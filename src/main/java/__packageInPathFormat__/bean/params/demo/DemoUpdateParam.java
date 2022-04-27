package __packageInPathFormat__.bean.params.demo;

import cn.sec.core.model.base.InputConverter;
import __packageInPathFormat__.bean.entity.DemoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("demo修改接口参数")
public  class DemoUpdateParam implements InputConverter<DemoEntity> {
    @NotNull(message = "id不可为空")
    @ApiModelProperty("id")
    private Long id;


    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("配置")
    private String configuration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
