package __packageInPathFormat__.bean.entity;

import cn.sec.core.model.base.BaseBean;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("table_file")
public class FileEntity extends BaseBean
{

    private String name;


    private String path;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
