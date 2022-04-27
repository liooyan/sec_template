package __packageInPathFormat__.service.impl;

import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.params.demo.DemoUpdateParam;
import __packageInPathFormat__.service.DemoService;
import cn.sec.core.model.base.page.PageData;
import cn.sec.core.util.NullUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sec.autoconfigure.data.AbstractCrudService;
import com.sec.autoconfigure.data.mybaits.BaseMapping;
import __packageInPathFormat__.bean.entity.DemoEntity;
import __packageInPathFormat__.bean.params.demo.DemoAddParam;
import __packageInPathFormat__.bean.params.demo.DemoSearchParam;
import __packageInPathFormat__.mapping.DemoMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoServiceImpl extends AbstractCrudService<DemoEntity> implements DemoService {

    private final DemoMapping demoMapping;

    protected DemoServiceImpl(DemoMapping demoMapping) {
        super(demoMapping);
        this.demoMapping = demoMapping;
    }

    @Override
    public PageData<DemoDTO> findAll(DemoSearchParam policySearchParam) {
        String name = policySearchParam.getName();
        PageData<DemoEntity> policyEntityPageData;
        if (NullUtil.isNull(name)) {
            policyEntityPageData = super.listAll(policySearchParam);
        } else {
            IPage<DemoEntity> ipage = BaseMapping.pageSort2IPage(policySearchParam);
            IPage<DemoEntity> policyMappingIPage = demoMapping.selectByName(ipage, name);
            policyEntityPageData = BaseMapping.page2PageData(policyMappingIPage);
        }
        return new PageData<>(policyEntityPageData.getData().stream().map(s -> new DemoDTO().convertFrom(s)).collect(Collectors.toList()), policyEntityPageData.getCount());

    }

    @Override
    public DemoDTO install(DemoAddParam policyParam) {
        DemoEntity policyEntity = policyParam.convertTo();
        super.create(policyEntity);
        return new DemoDTO().convertFrom(policyEntity);
    }

    @Override
    public List<DemoDTO> installBatch(List<DemoAddParam> policyParam) {

        List<DemoEntity> entityList = policyParam.stream().map(DemoAddParam::convertTo).collect(Collectors.toList());
        super.createInBatch(entityList);
        return entityList.stream().map(s -> new DemoDTO().convertFrom(s)).collect(Collectors.toList());
    }

    @Override
    public DemoDTO getOne(Long id) {
        DemoEntity policyEntity = super.getById(id);
        return new DemoDTO().convertFrom(policyEntity);
    }

    @Override
    public DemoDTO update(DemoUpdateParam policyUpdateParam) {
        DemoEntity policyEntity = policyUpdateParam.convertTo();
        missThrowException(policyEntity.getId());
        policyEntity = super.update(policyEntity);

        return new DemoDTO().convertFrom(policyEntity);
    }

    @Override
    public void delete(Long id) {
        super.removeById(id);
    }


}
