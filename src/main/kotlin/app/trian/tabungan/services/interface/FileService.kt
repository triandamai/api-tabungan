package app.trian.tabungan.services.`interface`

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.util.stream.Stream

interface FileService {
    fun save(file:MultipartFile)
    fun load(fileName:String):Resource
    fun deleteAll()
    fun loadAll():Stream<Path>
}