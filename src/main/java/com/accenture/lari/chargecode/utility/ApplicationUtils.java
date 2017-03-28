/**
 * 
 */
package com.accenture.lari.chargecode.utility;

import java.util.ArrayList;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accenture.lari.chargecode.domain.ChargeCodeEntity;
import com.accenture.lari.chargecode.resources.dto.ChargeCodeDTO;

/**
 * @author j.venugopalan
 *
 */

@SpringBootApplication

public class ApplicationUtils {
	
	@Autowired
	ModelMapper modelMapper;
	
	public ChargeCodeDTO convertChargeCodeEntityToDto(ChargeCodeEntity chargeEntity) {
		ChargeCodeDTO chargeDTO = modelMapper.map(chargeEntity, ChargeCodeDTO.class);

		return chargeDTO;
	}
	
	public Collection<ChargeCodeDTO> convertChargeCodeEntityListToDtoList(Collection<ChargeCodeEntity> chargeEntity) {
		Collection<ChargeCodeDTO> chargeDTOList = new ArrayList<>();
		ChargeCodeDTO chargeDTO = new ChargeCodeDTO();
		for (ChargeCodeEntity che : chargeEntity) {
			chargeDTO = modelMapper.map(che, ChargeCodeDTO.class);
			chargeDTOList.add(chargeDTO);
		}
		return chargeDTOList;
	}

}
