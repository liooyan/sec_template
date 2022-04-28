package __packageInPathFormat__.mapping;

import __packageInPathFormat__.bean.entity.DemoEntity;
import __packageInPathFormat__.bean.entity.FileEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sec.autoconfigure.data.mybaits.BaseMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapping extends BaseMapping<FileEntity> {

    @Select("SELECT * FROM table_file WHERE name LIKE concat('%',#{name},'%')")
    IPage<FileEntity>  selectByName(IPage<FileEntity> iPage,@Param("name") String name);




}
