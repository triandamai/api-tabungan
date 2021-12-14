package app.trian.tabungan.services

import app.trian.tabungan.services.`interface`.FileService
import app.trian.tabungan.utils.FileServiceException
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Stream

@Service
class FileServiceImpl:FileService {
    val path = Paths.get("uploads")
    init {
        try {
            Files.createDirectory(path)
        }catch (e:Exception){
            throw FileServiceException(e.message)
        }
    }
    override fun save(file: MultipartFile) {
        try {
            Files.copy(file.inputStream,path.resolve(file.originalFilename))
        }catch (e:Exception){
            throw FileServiceException(e.message)
        }
    }

    override fun load(fileName: String): Resource {
       try {
           val file = path.resolve(fileName)
           val resource= UrlResource(file.toUri())

           if(resource.exists() || resource.isReadable){
               return resource
           }else{
               throw FileServiceException("cannot read file not exist or not readable")
           }
       }catch (e:Exception){
           throw FileServiceException(e.message)
       }
    }

    override fun deleteAll() {
        FileSystemUtils.deleteRecursively(path.toFile())
    }

    override fun loadAll(): Stream<Path> {
        try {
            return Files.walk(path,1).filter {
                path->
                !path.equals(path)
            }.map(path::relativize)
        }catch (e:Exception){
            throw FileServiceException(e.message)
        }
    }
}