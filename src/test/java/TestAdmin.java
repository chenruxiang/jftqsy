import com.jftshop.dao.AdminRepository;
import com.jftshop.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestAdmin {

    @Autowired
    private AdminRepository adminRepository;

/*    @Test
    public void  save() throws Exception {

        Admin admin = new Admin();
        admin.setId("ddd");
        admin.setUsername("hhhhh");
        admin.setPassword("ddd");
        admin.setLogin_failure_count(1);
        admin.setIs_enabled(false);
        admin.setIs_locked(false);
        admin.setCreate_date( new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01").getTime()) );
        admin.setEmail("sds");
        adminRepository.save(admin);
    }*/

    @Test
    @Transactional
    public void  find() throws Exception {

        Admin admin = adminRepository.getOne("ddd");
        System.out.println("admin---------------->"+admin.getEmail());

        List<Admin> list =  adminRepository.findAll();
        System.out.println("list---------------->"+list.size());

        List<Admin> list2 =  adminRepository.findByUsername("hh");
        System.out.println("list2---------------->"+list2.size());

        List<Admin> list3 =  adminRepository.findByUsernameOrEmailLike("hhhhh","sd");
        System.out.println("list3---------------->"+list3.size());

        Page<Admin> page = adminRepository.findByUsernameLike("%hh%", new PageRequest(0,20));
        System.out.println("page---------------->"+page.getTotalPages());
        System.out.println("page1---------------->"+page.getNumberOfElements());
        System.out.println("page2---------------->"+page.getTotalElements());

  /*      @Query(value = "SELECT * FROM admin WHERE LASTNAME = ?1",
                countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
                nativeQuery = true)
        List<Admin> list2 =  adminRepository.findByUsername("hhhhh");
        System.out.println("list2---------------->"+list2.size());
*/


    }


}