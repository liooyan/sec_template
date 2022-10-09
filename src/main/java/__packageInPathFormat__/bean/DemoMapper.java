package __packageInPathFormat__.bean;

import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * {@link DemoMapper}
 *
 * @author com.lioyan
 * @date 2022/10/8  15:11
 */

@Mapper(componentModel = "spring")
public interface DemoMapper
{
    DemoDTO carToDemoDTO(DemoEntity car);
}
