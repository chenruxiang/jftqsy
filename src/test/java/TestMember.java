import com.jftshop.dao.MemberRepository;
import com.jftshop.entity.Member;
import com.jftshop.util.JFTStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestMember {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    public void  save() throws Exception {

        Member member = new Member();
        member.setId( JFTStringUtils.get32UUID() );
        member.setUsername( "hello234" );
        member.setPassword( "setPassword" );
        member.setEmail("jjj@163.com");

        memberRepository.save( member );

        List<Member> list = memberRepository.findByUsername( "hello234" );

        System.out.println("---------------------->" + list.size() );

    }


}
