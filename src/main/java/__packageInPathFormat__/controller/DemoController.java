package __packageInPathFormat__.controller;

import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.entity.DemoEntity;
import __packageInPathFormat__.bean.params.demo.*;
import __packageInPathFormat__.bean.struct.DemoStruct;
import __packageInPathFormat__.service.DemoService;
import cn.sec.core.model.base.page.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/demo")
@Api(tags = "演示模块api")
@Validated
public class DemoController {

    private final  static Logger logger = LoggerFactory.getLogger(DemoController.class);


    private final  DemoService demoService;
    private final DemoStruct demoStruct;

    public DemoController(DemoService demoService, DemoStruct demoStruct)
    {
        this.demoService = demoService;
        this.demoStruct = demoStruct;
    }

    @ResponseBody
    @PostMapping(value = "/get/list")
    @ApiOperation("根据条件查询")
    public PageData<DemoDTO> findAll(@RequestBody DemoSearchParam policySearchParam) {

        PageData<DemoEntity> pageData = demoService.findAll(policySearchParam);
        return new PageData<>(demoStruct.entityToDTO(pageData.getData()), pageData.getCount());
    }

    @ResponseBody
    @GetMapping(value = "/")
    @ApiOperation("根据id查询")
    public DemoDTO getOne(@RequestParam Long id) {

        return demoStruct.entityToDTO(demoService.getOne(id));
    }


    @ResponseBody
    @PutMapping(value = "/")
    @ApiOperation("添加")
    public DemoDTO install(@RequestBody @Validated DemoAddParam policyAddParam) {

        return demoStruct.entityToDTO(demoService.install(policyAddParam));
    }

    @ResponseBody
    @PutMapping(value = "/batch")
    @ApiOperation("批量添加")
    public List<DemoDTO> installBatch(@RequestBody @Validated DemoAddBatchParam policyAddBatchParam) {

        List<DemoEntity> data = demoService.installBatch(policyAddBatchParam.getDatas());
        return demoStruct.entityToDTO(data);
    }


    @ResponseBody
    @PostMapping(value = "/update")
    @ApiOperation("修改")
    public DemoDTO update(@RequestBody @Validated DemoUpdateParam policyUpdateParam) {

        return demoStruct.entityToDTO(demoService.update(policyUpdateParam));
    }

    @ResponseBody
    @DeleteMapping(value = "/")
    @ApiOperation("删除")
    public void delete(@RequestParam @Validated Long id) {
        demoService.delete(id);
    }


}
