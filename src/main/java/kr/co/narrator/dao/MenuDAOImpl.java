package kr.co.narrator.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.narrator.model.MenuVO;

@Repository
public class MenuDAOImpl implements MenuDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<MenuVO> getMenuList() throws Exception {
		return sqlSession.selectList("kr.co.narrator.menuMapper.getMenuList");
	}
	
	@Override
	public int saveMenu(MenuVO menuVO) throws Exception {
		return sqlSession.insert("kr.co.narrator.menuMapper.insertMenu", menuVO);
	}
	
	@Override
	public int updateMenu(MenuVO menuVO) throws Exception {
		return sqlSession.update("kr.co.narrator.menuMapper.updateMenu", menuVO);
	}
	
	@Override
	public int deleteMenu(String code) throws Exception {
		return sqlSession.delete("kr.co.narrator.menuMapper.deleteMenu", code);
	}

}
