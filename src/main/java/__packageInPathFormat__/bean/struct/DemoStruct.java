package __packageInPathFormat__.bean.struct;

import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.entity.DemoEntity;
import __packageInPathFormat__.bean.params.demo.*;
import __packageInPathFormat__.bean.params.demo.DemoSearchParam;
import __packageInPathFormat__.bean.params.demo.DemoUpdateParam;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * {@link DemoStruct}
 *
 * @author com.lioyan
 * @date 2022/10/8  15:11
 */

@Mapper(componentModel = "spring")
public interface DemoStruct
{
    DemoDTO entityToDTO(DemoEntity demoEntity);

    List<DemoDTO> entityToDTO(List<DemoEntity> demoEntity);

    DemoEntity addParamsToEntity(DemoAddParam demoAddParam);

    DemoEntity updateParamsToEntity(DemoUpdateParam demoUpdateParam);

    DemoEntity searchParamsToEntity(DemoSearchParam demoSearchParam);

}
