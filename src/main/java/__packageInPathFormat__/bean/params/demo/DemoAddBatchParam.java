package __packageInPathFormat__.bean.params.demo;

import cn.sec.core.model.base.InputConverter;
import __packageInPathFormat__.bean.entity.DemoEntity;
import io.swagger.annotations.ApiModel;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;


@ApiModel("demo批量添加接口参数")
public class DemoAddBatchParam implements InputConverter<DemoEntity>
{

    @Size(min = 1, max = 10, message = "数据必须大于0或小于10")
    @Valid
    private List<DemoAddParam> datas;

    public List<DemoAddParam> getDatas()
    {
        return datas;
    }

    public void setDatas(List<DemoAddParam> datas)
    {
        this.datas = datas;
    }
}
