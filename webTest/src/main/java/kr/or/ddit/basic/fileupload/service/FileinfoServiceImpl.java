package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import kr.or.ddit.basic.fileupload.dao.FileinfoDaoImpl;
import kr.or.ddit.vo.FileinfoVO;

public class FileinfoServiceImpl implements IFileinfoService {
	private static FileinfoServiceImpl service;
	private static FileinfoDaoImpl dao;
	
	private FileinfoServiceImpl() {
		dao = FileinfoDaoImpl.getInstance();
	}
	
	public static FileinfoServiceImpl getInstance() {
		if(service==null) {
			service = new FileinfoServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertFileinfo(FileinfoVO fileinfoVO) {
		// TODO Auto-generated method stub
		return dao.insertFileinfo(fileinfoVO);
	}

	@Override
	public List<FileinfoVO> getAllFileinfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileinfo();
	}

	@Override
	public FileinfoVO getFileinfo(Long fileNo) {
		// TODO Auto-generated method stub
		return dao.getFileinfo(fileNo);
	}

}
