package app.trian.tabungan.services

import app.trian.tabungan.model.request.WalletRequest
import app.trian.tabungan.model.request.toWallet
import app.trian.tabungan.model.response.*
import app.trian.tabungan.repository.WalletRepository
import app.trian.tabungan.services.`interface`.WalletService
import app.trian.tabungan.utils.DataNotFoundException
import app.trian.tabungan.utils.ValidationUtil
import org.joda.time.DateTime
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

/**
 * Service wallet
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 00.28
 */
@Service
class WalletServiceImpl(
private val walletRepository: WalletRepository,
private val validationUtil: ValidationUtil
):WalletService {
    override fun getWallet(pageable: Pageable): BaseResponse<BaseCollectionPageable<WalletResponse>> {
        val wallets = walletRepository.findAll(pageable)
        val transform = wallets.content.map {
            it.toResponse()
        }

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = BaseCollectionPageable(
                data = transform,
                page = wallets.number,
                totalELement = wallets.totalElements.toInt(),
                totalPage = wallets.totalPages,
                size = wallets.size
            ),
            message = "get wallet"
        )
    }

    override fun getDetailWallet(idWallet: Long): BaseResponse<WalletResponse> {
        val wallet = walletRepository.findById(idWallet)
        if(wallet.isEmpty){
            throw DataNotFoundException("No data found for wallet with ${idWallet}")
        }

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = wallet.get().toResponse(),
            message = "Detail wallet"
        )
    }

    override fun createWallet(idUser:Long,request: WalletRequest): BaseResponse<WalletResponse> {
        validationUtil.validate(request)
        val idWallet = DateTime().millis
        val prepareData = request.toWallet(
            idWallet=idWallet,
            idUser=idUser,
            createdAt = idWallet,
            updateAt = idWallet
        )

        val save = walletRepository.save(prepareData)
        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = ""
        )
    }

    override fun updateWallet(idWallet: Long, request: WalletRequest): BaseResponse<WalletResponse> {
        validationUtil.validate(request)

        val findWallet = walletRepository.findByIdOrNull(idWallet)
            ?: throw DataNotFoundException("Cannot edit wallet because ${idWallet} not match any wallet")
        val newDate = DateTime().millis
        val prepareData = request.toWallet(
            idWallet=findWallet.idWallet,
            updateAt = newDate,
            createdAt = findWallet.createdAt,
            idUser = findWallet.createdBy
        )

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = prepareData.toResponse(),
            message = "Success update wallet"
        )
    }
}