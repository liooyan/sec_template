package __packageInPathFormat__.controller;

import cn.sec.core.model.base.page.PageData;
import com.sec.autoconfigure.record.Timing;
import __packageInPathFormat__.bean.dto.DemoDTO;
import __packageInPathFormat__.bean.params.demo.DemoAddBatchParam;
import __packageInPathFormat__.bean.params.demo.DemoAddParam;
import __packageInPathFormat__.bean.params.demo.DemoSearchParam;
import __packageInPathFormat__.bean.params.demo.DemoUpdateParam;
import __packageInPathFormat__.service.DemoService;
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

    final private static Logger logger = LoggerFactory.getLogger(DemoController.class);


    final private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    @ResponseBody
    @PostMapping(value = "/get/list")
    @Timing
    @ApiOperation("根据条件查询检索策略")
    public PageData<DemoDTO> findAll(@RequestBody DemoSearchParam policySearchParam) {

        return demoService.findAll(policySearchParam);
    }

    @ResponseBody
    @GetMapping(value = "/")
    @Timing
    @ApiOperation("根据id查询")
    public DemoDTO getOne(@RequestParam Long id) {

        return demoService.getOne(id);
    }


    @ResponseBody
    @PutMapping(value = "/")
    @Timing
    @ApiOperation("添加")
    public DemoDTO install(@RequestBody @Validated DemoAddParam policyAddParam) {

        return demoService.install(policyAddParam);
    }

    @ResponseBody
    @PutMapping(value = "/batch")
    @Timing
    @ApiOperation("批量添加")
    public List<DemoDTO> installBatch(@RequestBody @Validated DemoAddBatchParam policyAddBatchParam) {

        return demoService.installBatch(policyAddBatchParam.getDatas());
    }


    @ResponseBody
    @PostMapping(value = "/update")
    @Timing
    @ApiOperation("修改")
    public DemoDTO update(@RequestBody @Validated DemoUpdateParam policyUpdateParam) {

        return demoService.update(policyUpdateParam);
    }

    @ResponseBody
    @DeleteMapping(value = "/")
    @Timing
    @ApiOperation("删除")
    public void delete(@RequestParam @Validated Long id) {
        demoService.delete(id);
    }


}
