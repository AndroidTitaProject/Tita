package com.example.data.mapper

import com.example.data.entity.school.search.*
import com.example.domain.entity.school.*


fun List<SchoolInfo>.toDomain(): List<SchoolInfoEntity> {

    return this.map {
        SchoolInfoEntity(it.head?.toDomain(),it.row?.toDomain())
    }
}

fun SearchSchoolResponse.toDomain(): SchoolResponseEntity {
    return SchoolResponseEntity(this.schoolInfo.toDomain())
}



@JvmName("toDomainHead")
fun List<Head>.toDomain(): List<HeadEntity> {
    return this.map {
        HeadEntity(
            it.listTotalCount,
            it.rESULT?.toDomain()
        )
    }
}

@JvmName("toDomainRow")
fun List<Row>.toDomain(): List<RowEntity> {
    return this.map {
        RowEntity(
            it.aTPTOFCDCSCCODE,
            it.aTPTOFCDCSCNM,
            it.cOEDUSCNM,
            it.dGHTSCNM,
            it.eNEBFESEHFSCNM,
            it.eNGSCHULNM,
            it.fOASMEMRD,
            it.fONDSCNM,
            it.fONDYMD,
            it.hMPGADRES,
            it.hSGNRLBUSNSSCNM,
            it.hSSCNM,
            it.iNDSTSPECLCCCCLEXSTYN,
            it.jUORGNM,
            it.lCTNSCNM,
            it.lOADDTM,
            it.oRGFAXNO,
            it.oRGRDNDA,
            it.oRGRDNMA,
            it.oRGRDNZC,
            it.oRGTELNO,
            it.sCHULKNDSCNM,
            it.sCHULNM,
            it.sDSCHULCODE,
            it.sPCLYPURPSHSORDNM,
        )
    }
}

fun RESULT.toDomain(): ResultEntity {
    return ResultEntity(
        this.cODE,
        this.mESSAGE
    )
}