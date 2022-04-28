package __packageInPathFormat__.bean.params.file;

import cn.sec.core.model.base.page.PageSort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("文件查询接口参数")
public class FileSearchParam extends PageSort {

    @ApiModelProperty("按名称检索")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
