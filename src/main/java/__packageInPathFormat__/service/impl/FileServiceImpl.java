package __packageInPathFormat__.service.impl;

import __packageInPathFormat__.bean.dto.FileDTO;
import __packageInPathFormat__.bean.entity.FileEntity;
import __packageInPathFormat__.bean.params.file.FileSearchParam;
import __packageInPathFormat__.mapping.FileMapping;
import __packageInPathFormat__.service.FileService;
import cn.sec.core.exception.ServiceException;
import cn.sec.core.model.base.page.PageData;
import cn.sec.core.util.NullUtil;
import cn.sec.file.FileInfo;
import cn.sec.file.GeneralFileSystem;
import cn.sec.file.util.IOUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sec.autoconfigure.data.AbstractCrudService;
import com.sec.autoconfigure.data.mybaits.BaseMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * {@link FileServiceImpl}
 *
 * @author cn.lioyan
 * @since 2022/4/28 14:16
 */
@Service
public class FileServiceImpl extends AbstractCrudService<FileEntity> implements FileService {

    private final GeneralFileSystem generalFileSystem;
    private final FileMapping fileMapping;


    public FileServiceImpl(GeneralFileSystem generalFileSystem, FileMapping fileMapping) {
        super(fileMapping);
        this.generalFileSystem = generalFileSystem;
        this.fileMapping = fileMapping;
    }

    @Override
    public void inputDoc(MultipartFile upload) {
        String name = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        try (InputStream inputStream = upload.getInputStream();
             OutputStream outputStream = generalFileSystem.getOutputStream(uuid);) {

            IOUtils.copyBytes(inputStream, outputStream, 1024);
        } catch (IOException e) {
            throw ServiceException.newInstance("文件加载异常", e);
        }
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(name);
        fileEntity.setPath(uuid);
        super.create(fileEntity);

    }

    @Override
    public PageData<FileDTO> findAll(FileSearchParam fileSearchParam) {
        String name = fileSearchParam.getName();
        PageData<FileEntity> fileEntityPageData;
        if (NullUtil.isNull(name)) {
            fileEntityPageData = super.listAll(fileSearchParam);
        } else {
            IPage<FileEntity> ipage = BaseMapping.pageSort2IPage(fileSearchParam);
            IPage<FileEntity> policyMappingIPage = fileMapping.selectByName(ipage, name);
            fileEntityPageData = BaseMapping.page2PageData(policyMappingIPage);
        }
        return new PageData<>(fileEntityPageData.getData().stream().map(s -> new FileDTO().convertFrom(s)).collect(Collectors.toList()), fileEntityPageData.getCount());
    }

    @Override
    public FileInfo getFile(Long id) {
        FileEntity fileEntity = super.getById(id);

        try {
            FileInfo file = generalFileSystem.getFiles(fileEntity.getPath());
            file.setName(fileEntity.getName());
            return file;
        } catch (IOException e) {
            throw ServiceException.newInstance("文件加载异常", e);
        }
    }

    @Override
    public void delete(Long id) {
        FileEntity fileEntity = super.getById(id);
        try {
            generalFileSystem.deleteFile(fileEntity.getPath());
        } catch (IOException e) {
            throw ServiceException.newInstance("文件删除异常", e);
        }
    }
}
