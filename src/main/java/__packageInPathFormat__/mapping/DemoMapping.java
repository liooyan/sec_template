package __packageInPathFormat__.mapping;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sec.autoconfigure.data.mybaits.BaseMapping;
import __packageInPathFormat__.bean.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DemoMapping extends BaseMapping<DemoEntity> {

    @Select("SELECT * FROM search_policy WHERE name LIKE concat('%',#{name},'%')")
    IPage<DemoEntity>  selectByName(IPage<DemoEntity> iPage,@Param("name") String name);




}
