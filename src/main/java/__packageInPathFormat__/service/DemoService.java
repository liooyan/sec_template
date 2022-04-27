package __packageInPathFormat__.service;

import cn.sec.core.model.base.page.PageData;
import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.params.demo.DemoAddParam;
import __packageInPathFormat__.bean.params.demo.DemoSearchParam;
import __packageInPathFormat__.bean.params.demo.DemoUpdateParam;

import java.util.List;

public interface DemoService
{
    void delete(Long id);

    DemoDTO update(DemoUpdateParam policyUpdateParam);

    List<DemoDTO> installBatch(List<DemoAddParam> datas);

    DemoDTO install(DemoAddParam policyAddParam);

    DemoDTO getOne(Long id);

    PageData<DemoDTO> findAll(DemoSearchParam policySearchParam);
}
