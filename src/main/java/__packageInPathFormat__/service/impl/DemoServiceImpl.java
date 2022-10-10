package __packageInPathFormat__.service.impl;

import __packageInPathFormat__.bean.entity.DemoEntity;
import __packageInPathFormat__.bean.params.demo.*;
import __packageInPathFormat__.bean.struct.DemoStruct;
import __packageInPathFormat__.mapping.DemoMapping;
import __packageInPathFormat__.service.DemoService;
import cn.sec.core.model.base.page.PageData;
import com.sec.autoconfigure.data.AbstractCrudService;
import com.sec.autoconfigure.data.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DemoServiceImpl extends AbstractCrudService<DemoEntity> implements DemoService
{

    private final DemoMapping demoMapping;

    private final DemoStruct demoStruct;

    protected DemoServiceImpl(BaseRepository<DemoEntity> repository, DemoMapping demoMapping,
                              DemoStruct demoStruct)
    {
        super(repository);
        this.demoMapping = demoMapping;
        this.demoStruct = demoStruct;
    }

    @Override
    public PageData<DemoEntity> findAll(DemoSearchParam searchParam)
    {
       return   super.listAll(searchParam);
    }

    @Override
    public DemoEntity install(DemoAddParam addParam)
    {
        DemoEntity entity =demoStruct.addParamsToEntity(addParam);
        super.create(entity);
        return entity;
    }

    @Override
    public List<DemoEntity> installBatch(List<DemoAddParam> addParams)
    {
        List<DemoEntity> entityList = addParams.stream().map(demoStruct::addParamsToEntity).collect(
            Collectors.toList());
        super.createInBatch(entityList);
        return entityList;
    }

    @Override
    public DemoEntity getOne(Long id)
    {
        return super.getById(id);
    }

    @Override
    public DemoEntity update(DemoUpdateParam updateParam)
    {
        DemoEntity entity = demoStruct.updateParamsToEntity(updateParam);
        missThrowException(entity.getId());
        return super.update(entity);
    }

    @Override
    public void delete(Long id)
    {
        super.removeById(id);
    }

}
