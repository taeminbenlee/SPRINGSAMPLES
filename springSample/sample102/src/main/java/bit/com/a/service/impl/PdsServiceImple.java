package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;
import bit.com.a.service.PdsService;
@Service
public class PdsServiceImple implements PdsService {
		@Autowired
		PdsDao dao;

		@Override
		public List<PdsDto> getPdsList() {
			return dao.getPdsList();
		}

		@Override
		public boolean uploadPds(PdsDto dto) {
			return dao.uploadPds(dto);
		}

		@Override
		public PdsDto getDetail(int seq) {
			return dao.getDetail(seq);
		}

		@Override
		public boolean deletePds(int seq) {
			return dao.deletePds(seq);
		}

		@Override
		public PdsDto downcount(int seq) {
			return dao.downcount(seq);
		}

		@Override
		public boolean updateAf(PdsDto pdsdto) {
			return dao.updateAf(pdsdto);
		}

		@Override
		public int getPdsCount(PdsParam param) {
			return dao.getPdsCount(param);
		}

		@Override
		public List<PdsDto> getPdslist(PdsParam param) {
			return dao.getPdslist(param);
		}
		
		
}
