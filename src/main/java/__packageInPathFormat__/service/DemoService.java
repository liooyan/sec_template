package __packageInPathFormat__.service;

import __packageInPathFormat__.bean.entity.DemoEntity;
import cn.sec.core.model.base.page.PageData;
import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.params.demo.DemoAddParam;
import __packageInPathFormat__.bean.params.demo.DemoSearchParam;
import __packageInPathFormat__.bean.params.demo.DemoUpdateParam;

import java.util.List;

public interface DemoService
{
    void delete(Long id);

    DemoEntity update(DemoUpdateParam policyUpdateParam);

    List<DemoEntity> installBatch(List<DemoAddParam> datas);

    DemoEntity install(DemoAddParam policyAddParam);

    DemoEntity getOne(Long id);

    PageData<DemoEntity> findAll(DemoSearchParam policySearchParam);
}
