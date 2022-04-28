package __packageInPathFormat__.controller;

import __packageInPathFormat__.bean.dto.FileDTO;
import __packageInPathFormat__.bean.params.file.FileSearchParam;
import __packageInPathFormat__.service.FileService;
import cn.sec.core.model.base.page.PageData;
import com.sec.autoconfigure.record.Timing;
import com.sec.autoconfigure.web.response.ExcludeRestRespResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


@RestController
@RequestMapping(value = "/file")
@Api(tags = "文件操作演示模块api")
@Validated
public class FileController {

    final private static Logger logger = LoggerFactory.getLogger(FileController.class);


    final private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }


    @ResponseBody
    @PostMapping(value = "/")
    @Timing
    @ApiOperation("上传文件")
    public void inputDoc(@RequestParam("file") MultipartFile upload) {
        fileService.inputDoc(upload);
    }

    @ResponseBody
    @GetMapping(value = "/")
    @Timing
    @ApiOperation("下载文件")
    public @ExcludeRestRespResponse
    ResponseEntity<StreamingResponseBody> get(@RequestParam Long id) {

        return fileService.getFile(id);
    }

    @ResponseBody
    @PostMapping(value = "/get/list")
    @Timing
    @ApiOperation("根据条件查询检索策略")
    public PageData<FileDTO> findAll(@RequestBody FileSearchParam fileSearchParam) {

        return fileService.findAll(fileSearchParam);
    }

    @ResponseBody
    @DeleteMapping(value = "/")
    @Timing
    @ApiOperation("删除")
    public void delete(@RequestParam @Validated Long id) {
        fileService.delete(id);
    }


}
