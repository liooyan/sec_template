package __packageInPathFormat__.service;

import __packageInPathFormat__.bean.dto.FileDTO;
import __packageInPathFormat__.bean.params.file.FileSearchParam;
import cn.sec.core.model.base.page.PageData;
import com.sec.autoconfigure.file.FileInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService
{

    void inputDoc(MultipartFile upload);

    PageData<FileDTO> findAll(FileSearchParam fileSearchParam);

    FileInfo getFile(Long id);

    void delete(Long id);
}
