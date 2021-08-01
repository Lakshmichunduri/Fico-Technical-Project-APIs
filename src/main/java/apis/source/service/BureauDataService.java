package apis.source.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.BureauDataDao;
import apis.source.dto.BureauDataResponse;

@Service
@Transactional
public class BureauDataService {
	
	@Autowired
	private BureauDataDao bureauDataDao;
	
	public BureauDataResponse getDataBySSN(Integer id) {
		BureauDataResponse bureauDataResponse = new BureauDataResponse();
		bureauDataResponse.setBureauData(bureauDataDao.getDataBySSN(id));
		return bureauDataResponse;
	}

}
