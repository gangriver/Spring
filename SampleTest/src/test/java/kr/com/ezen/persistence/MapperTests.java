package kr.com.ezen.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testGetTime() {
		log.info("-----------------------------");
		log.info(memberMapper.getClass().getName());
		log.info(memberMapper.getTime());
		log.info("-----------------------------");
	}
	
	@Test
	public void testInsert() {
		
//		MemberVO vo = new MemberVO();
//		vo.setId(10);
//		vo.setName("�쑀鍮�");
//		vo.setPhone("010-0000-1111");
//		vo.setAddress("�꽌�슱�떆 �옣�븞�룞");
//		memberMapper.insertMember(vo);
		
		for(int i=0; i<10; i++) {
			MemberVO vo = MemberVO.builder()
					.id(10+i)
					.name("user"+i)
					.phone("010-0000-111"+i)
					.address("�꽌�슱�떆 �옣�븞援� " +i)
					.build();
			memberMapper.insertMember(vo);
		}				
	}
	
	@Test
	public void testUpdate() {
		
		MemberVO vo = MemberVO.builder()
				.id(19)
				.name("議곗슫")
				.phone("000-1111-2222")
				.address("寃쎄린�룄 �닔�썝�떆")
				.build();
		
		memberMapper.updateMember(vo);
						
	}
	
	@Test
	public void testDelete() {
		memberMapper.deleteMember(19);
	}
	
	@Test
	public void testSelectOne() {
		MemberVO vo = 
				memberMapper.selectOneMember(18);
		log.info(">>>>>> "+ vo);
	}
	
	
}




























