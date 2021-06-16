package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.service.BbsService;

public class BbsServiceimpl implements BbsService {
	@Autowired
	BbsDao bbsdao;
	@Override
	public List<BbsDto> allBbs() {
		
		return bbsdao.allBbs();
	}

}
